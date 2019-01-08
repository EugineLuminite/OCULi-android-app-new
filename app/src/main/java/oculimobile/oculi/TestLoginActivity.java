package oculimobile.oculi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.util.EntityUtils;

import static android.Manifest.permission.READ_CONTACTS;

public class TestLoginActivity  extends AppCompatActivity
{


    private SharedPrefFunctions prefFunctions;

    private AsyncTask  LoginTask = null;

    private Context mcontext ;
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private View mLodingText;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_login);
        mcontext = this;
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        //populateAutoComplete();
        prefFunctions = new SharedPrefFunctions(this);
        mPasswordView = (EditText) findViewById(R.id.password);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        mLodingText = findViewById(R.id.txtloading);


        //showProgress(true);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_btn);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                boolean attempt = attemptLogin();
                if(attempt!=true)
                {
                    return;
                }
                String email = mEmailView.getText().toString();
                String password = mPasswordView.getText().toString();
                Log.d("btnLogin","Press btnLogin");
                final String x= "";

                if(LoginTask!=null)
                {
                    //boolean taskCanceled = LoginTask.isCancelled();
                    if(LoginTask.isCancelled())
                    {
                        showProgress(true);


                        LoginTask = null;
                        LoginTask = new TestTask(email,password).execute();
                    }
                    else
                    {
                        ShowBackgroundToast("Something went wrong. Please Contact Luminite Electronics. Code error 1.");
                    }
                }
                else
                {
                    showProgress(true);
                    LoginTask = new TestTask(email,password).execute();
                }

            }
        });
    }
    private boolean isEmailValid(String email) {

        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {

        return password.length() > 4;
    }
    private boolean attemptLogin()
    {

        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
            return false;
        }
        else
        {
            return true;
//            showProgress(true);
//            mAuthTask = new LoginActivity.UserLoginTask(email, password);
//            mAuthTask.execute((Void) null);
        }
    }
    private AsyncTask<Void, Void, Void> runAsyncTask(AsyncTask<Void, Void, Void> task) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            return task.execute();
        }
    }
    private boolean CustomLoginRequestConnect(String user, String password)
    {
        String otvet = "";
//        nameValuePairs.add(new BasicNameValuePair("username","WorkerRole"));
//        nameValuePairs.add(new BasicNameValuePair("password","WorkerRole"));
        //https://azure.microsoft.com/en-gb/documentation/articles/app-service-mobile-android-get-started-users/
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
        nameValuePairs.add(new BasicNameValuePair("log", "CaW%wDDJC23@L&W8-x.BW;Yq8zSYrR>u"));
        nameValuePairs.add(new BasicNameValuePair("username", user));
        nameValuePairs.add(new BasicNameValuePair("password", password));
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://oculimobile.azurewebsites.net/api/Auth");
        httpPost.addHeader("ZUMO-API-VERSION", "2.0.0");
        httpPost.setHeader("ZUMO-API-VERSION", "2.0.0");

        //Encoding POST data
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        } catch (UnsupportedEncodingException e)
        {
            // log exception
            // progressDialog.dismiss();
            e.printStackTrace();
            return false;
        }
        try {
            HttpResponse response = client.execute(httpPost);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
            String responsestring = EntityUtils.toString(response.getEntity());
            String INvalid = "\"Invalid username or password\"";
            // int compare = responsestring.compareTo(INvalid);


            if (responsestring.contains(INvalid))
            {
                //HTTPRESPONSE = "Invalid username or password";

                //progressDialog.dismiss();
                ShowBackgroundToast("Invalid username or password");
                return false;
            }
            try
            {
                JSONObject json = new JSONObject(responsestring);
                final String _userId = json.getString("userId");
                final String _mobileServiceAuthenticationToken = json.getString("mobileServiceAuthenticationToken");
                final String _tokenRefreshSecret = json.getString("tokenRefreshSecret");
                final String _tokenValidDate = json.getString("tokenValidDate");
//                customLoginResult.setUserId(key);
//                customLoginResult.setMobileServiceAuthenticationToken(key2);
//                SetSharedPreferences(key, key2);
                if(_userId.contains("Invalid username or password"))
                {
                    return false;
                }
                prefFunctions.SetSharedPreferences(_userId,_mobileServiceAuthenticationToken,_tokenRefreshSecret,_tokenValidDate);

                return true;
            }
            catch (JSONException ex)
            {
                ShowBackgroundToast("Ex: "+ex.getMessage());

                // HTTPRESPONSE = "NO";
                return false;

            }
            //Log.d("Http Post Response:", response.toString());
        }
        catch (ClientProtocolException e)
        {
            //HTTPRESPONSE = "NO";
            // Log exception
            e.printStackTrace();


            return false;
        }
        catch (IOException e)
        {
            // Log exception
            e.printStackTrace();

            return false;
        }

    }

    private void ChangeScreenToMainScreen(Context mcontext)
    {
        //final Intent intent = new Intent(mcontext , ToDoActivity.class);
        final Intent intent = new Intent(mcontext , MainActivity.class);
        startActivity(intent);
        finish();

    }
    public void ShowBackgroundToast(final String message)
    {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {

                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {


                            Toast.makeText(TestLoginActivity.this,message ,
                                    Toast.LENGTH_LONG).show();

                        }
                    });
                } catch (Exception exception) {
                    createAndShowDialog(exception, "Error");
                }
                return null;
            }
        }.execute();
    }
    private void createAndShowDialog(Exception exception, String title) {
        Throwable ex = exception;
        if(exception.getCause() != null){
            ex = exception.getCause();
        }
        createAndShowDialog(ex.getMessage(), title);
    }
    private void createAndShowDialog(final String message, final String title) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(message);
        builder.setTitle(title);
        builder.create().show();
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2)
        {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter()
            {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

            mLodingText.setVisibility(show ? View.VISIBLE : View.GONE);
            mLodingText.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter()
            {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLodingText.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLodingText.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
    private class TestTask extends AsyncTask<String, Void, String> {

        private final String mEmail;
        private final String mPassword;

        TestTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected String doInBackground(String... params)
        {
            //CustomLoginRequestConnect("luminitetest@gmail.com","Demo12");
            Boolean response = CustomLoginRequestConnect(mEmail,mPassword);
            if(response)
            {
               return "TRUE" ;
            }
            return "FALSE";
        }


        protected void onPostExecute(String result)
        {
            showProgress(false);
            LoginTask = null;

            //DestroyProgressDialogWithTitle();
            //ShowBackgroundToast("Success");
            cancel(true);
            //onDestroy();
            if(result.contains("TRUE"))
            {
                ChangeScreenToMainScreen(TestLoginActivity.this);
            }
            else
            {
                ShowBackgroundToast("Authorization was unsuccessful. Please try again");
            }
            showProgress(false);
            //after back method finish
        }
        @Override
        protected void onPreExecute()
        {
            //before back method starts
            //showProgressDialogWithTitle();
            showProgress(true);
            super.onPreExecute();

        }

        @Override
        protected void onCancelled()
        {
            showProgress(false);
            LoginTask = null;
            //DestroyProgressDialogWithTitle();
        }



    };

}
