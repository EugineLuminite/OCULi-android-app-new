package oculimobile.oculi.ViewModels;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.authentication.MobileServiceUser;
import com.microsoft.windowsazure.mobileservices.http.NextServiceFilterCallback;
import com.microsoft.windowsazure.mobileservices.http.OkHttpClientFactory;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilter;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterRequest;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.query.Query;
import com.microsoft.windowsazure.mobileservices.table.query.QueryOperations;
import com.microsoft.windowsazure.mobileservices.table.query.QueryOrder;
import com.microsoft.windowsazure.mobileservices.table.sync.MobileServiceSyncContext;
import com.microsoft.windowsazure.mobileservices.table.sync.MobileServiceSyncTable;
import com.microsoft.windowsazure.mobileservices.table.sync.localstore.ColumnDataType;
import com.microsoft.windowsazure.mobileservices.table.sync.localstore.MobileServiceLocalStoreException;
import com.microsoft.windowsazure.mobileservices.table.sync.localstore.SQLiteLocalStore;
import com.microsoft.windowsazure.mobileservices.table.sync.synchandler.SimpleSyncHandler;
import com.squareup.okhttp.OkHttpClient;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import oculimobile.oculi.Adaptors.ToDoItemAdapter;
import oculimobile.oculi.ObjectsToUse.CustomLoginResult;
import oculimobile.oculi.ObjectsToUse.ToDoItem;
import oculimobile.oculi.R;
import oculimobile.oculi.SharedPrefFunctions;

import static com.microsoft.windowsazure.mobileservices.table.query.QueryOperations.val;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EventsViewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventsViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventsViewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public ListView ItemsListView;
    private MobileServiceUser MainmobileServiceUser;
    private ToDoItemAdapter mAdapter;
    public MobileServiceClient mClient;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View mEventsView;
    private OnFragmentInteractionListener mListener;
    private SharedPrefFunctions mSharedPrefFunctions;
    private Context mcontext;
    private ProgressBar mProgressBar;
    private MobileServiceSyncTable<ToDoItem> mToDoTable;
    public EventsViewFragment()
    {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventsViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventsViewFragment newInstance(String param1, String param2) {
        EventsViewFragment fragment = new EventsViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
        Log.d("EventsViewFragment", "onCreate()");
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events_view, container, false);

        mEventsView = view;
        Log.d("EventsViewFragment", "onCreateView()");
        return view;//inflater.inflate(R.layout.fragment_events_view, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {


            mcontext = context;
            mListener = (OnFragmentInteractionListener) context;

        }
        else
            {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        Log.d("EventsViewFragment", "onAttach()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        Log.d("EventsViewFragment", "onDetach()");
    }

    @Override
    public void onStart() {
        super.onStart();
        try
        {
            if(getActivity() == null)
                return;

            mProgressBar = (ProgressBar)getActivity(). findViewById(R.id.loadingProgressBar);

            // Initialize the progress bar
            mProgressBar.setVisibility(ProgressBar.GONE);

            mSharedPrefFunctions = new SharedPrefFunctions(mcontext);

            CustomLoginResult customLoginResult  = mSharedPrefFunctions.LoadSharedPreferences();


            MobileServiceUser userrr ;
            // Mobile Service URL and key
            mClient = new MobileServiceClient(
                    "https://oculimobile.azurewebsites.net",
                    mcontext).withFilter(new ProgressFilter());
            userrr=new MobileServiceUser("custom:luminitetest@gmail.com");

            userrr.setAuthenticationToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsdW1pbml0ZXRlc3RAZ21haWwuY29tIiwidmVyIjoiMyIsImlzcyI6Imh0dHBzOi8vb2N1bGltb2JpbGUuYXp1cmV3ZWJzaXRlcy5uZXQvIiwiYXVkIjoiaHR0cHM6Ly9vY3VsaW1vYmlsZS5henVyZXdlYnNpdGVzLm5ldC8iLCJleHAiOjE1NTA0NDUzNjAsIm5iZiI6MTU0NTI2MTM2MH0.fTaVHCSa6gnUYXorls5E53k_qDwFWEbbBlyyDfWhfcs");
            userrr.setUserId("custom:luminitetest@gmail.com");
            mClient.setCurrentUser(userrr);
            // Extend timeout from default of 10s to 20s
            mClient.setAndroidHttpClientFactory(new OkHttpClientFactory() {
                @Override
                public OkHttpClient createOkHttpClient() {
                    OkHttpClient client = new OkHttpClient();
                    client.setReadTimeout(20, TimeUnit.SECONDS);
                    client.setWriteTimeout(20, TimeUnit.SECONDS);
                    return client;
                }
            });



            // Offline Sync
            mToDoTable = mClient.getSyncTable("ToDoItem", ToDoItem.class);

            //Init local storage
            initLocalStore().get();
            mAdapter = new ToDoItemAdapter(mcontext, R.layout.oculi_event_item2,mListener);

            ItemsListView =(ListView)mEventsView.findViewById(R.id.MobileEventsList);
            ItemsListView.setAdapter(mAdapter);

            refreshItemsFromTable();

        }
        catch (MalformedURLException e) {
            createAndShowDialog(new Exception("There was an error creating the Mobile Service. Verify the URL"), "Error");
        } catch (Exception e){
            createAndShowDialog(e, "Error");
        }
        Log.d("EventsViewFragment", "onStart()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("EventsViewFragment", "onPause()");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("EventsViewFragment", "onStop()");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("EventsViewFragment", "onDestroyView()");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("EventsViewFragment", "onDestroy()");

    }



    private AsyncTask<Void, Void, Void> initLocalStore() throws MobileServiceLocalStoreException, ExecutionException, InterruptedException {

        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {

                    MobileServiceSyncContext syncContext = mClient.getSyncContext();

                    if (syncContext.isInitialized())
                        return null;

                    SQLiteLocalStore localStore = new SQLiteLocalStore(mClient.getContext(), "OfflineStore", null, 1);

                    Map<String, ColumnDataType> tableDefinition = new HashMap<String, ColumnDataType>();
                    tableDefinition.put("id", ColumnDataType.String);
                    tableDefinition.put("text", ColumnDataType.String);
                    tableDefinition.put("complete", ColumnDataType.Boolean);
                    //new
                    tableDefinition.put("evtMinute",ColumnDataType.Integer);
                    tableDefinition.put("cameraName",ColumnDataType.String);
                    tableDefinition.put("updateDate",ColumnDataType.String);
                    tableDefinition.put("username",ColumnDataType.String);
                    //old
                    localStore.defineTable("ToDoItem", tableDefinition);

                    SimpleSyncHandler handler = new SimpleSyncHandler();

                    syncContext.initialize(localStore, handler).get();

                } catch (final Exception e) {
                    createAndShowDialogFromTask(e, "Error");
                }

                return null;
            }
        };

        return runAsyncTask(task);
    }
    private List<ToDoItem> refreshItemsFromMobileServiceTableSyncTable() throws ExecutionException, InterruptedException {
        //sync the data
        sync().get();
//        Query query = QueryOperations.field("complete").
//                eq(val(false));


        Query query = QueryOperations.field("complete").
                eq(val(false)).orderBy("evtMinute", QueryOrder.Descending).top(100);
//
////        mToDoTable.where().field("complete").
////                eq(val(false)).orderBy("evtMinute", QueryOrder.Descending).top(100).execute().get();

        return mToDoTable.read(query).get();
    }
    private AsyncTask<Void, Void, Void> sync() {
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    MobileServiceSyncContext syncContext = mClient.getSyncContext();
                    syncContext.push().get();
                    mToDoTable.pull(null).get();
                } catch (final Exception e) {
                    createAndShowDialogFromTask(e, "Error");
                }
                return null;
            }
        };
        return runAsyncTask(task);
    }
    private void refreshItemsFromTable() {

        // Get the items that weren't marked as completed and add them in the
        // adapter

        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTable();

                    //Offline Sync
                    final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();
                    if(getActivity() == null)
                        return null;

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.clear();

                            for (ToDoItem item : results) {
                                mAdapter.add(item);
                            }
                        }
                    });
                } catch (final Exception e){
                    createAndShowDialogFromTask(e, "Error");
                }

                return null;
            }
        };

        runAsyncTask(task);
    }
    private AsyncTask<Void, Void, Void> runAsyncTask(AsyncTask<Void, Void, Void> task) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            return task.execute();
        }
    }
    private void createAndShowDialogFromTask(final Exception exception, String title)
    {
        if(getActivity() == null)
            return;
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                createAndShowDialog(exception, "Error");
            }
        });
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    private void createAndShowDialog(Exception exception, String title) {
        Throwable ex = exception;
        if(exception.getCause() != null){
            ex = exception.getCause();
        }
        createAndShowDialog(ex.getMessage(), title);
    }
    private void createAndShowDialog(final String message, final String title) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setMessage(message);
        builder.setTitle(title);
        builder.create().show();
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private class ProgressFilter implements ServiceFilter {

        @Override
        public ListenableFuture<ServiceFilterResponse> handleRequest(ServiceFilterRequest request, NextServiceFilterCallback nextServiceFilterCallback) {

            final SettableFuture<ServiceFilterResponse> resultFuture = SettableFuture.create();

            
            if(getActivity() != null)
              getActivity().runOnUiThread(new Runnable()
              {

                @Override
                public void run() {
                    if (mProgressBar != null) mProgressBar.setVisibility(ProgressBar.VISIBLE);
                }
              });

            ListenableFuture<ServiceFilterResponse> future = nextServiceFilterCallback.onNext(request);

            Futures.addCallback(future, new FutureCallback<ServiceFilterResponse>() {
                @Override
                public void onFailure(Throwable e) {
                    resultFuture.setException(e);
                }

                @Override
                public void onSuccess(ServiceFilterResponse response)
                {
                    if(getActivity() != null)
                    getActivity().runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            if (mProgressBar != null) mProgressBar.setVisibility(ProgressBar.GONE);
                        }
                    });

                    resultFuture.set(response);
                }
            });

            return resultFuture;
        }
    }
}
