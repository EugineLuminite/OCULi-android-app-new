package oculimobile.oculi;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by sexelby on 10/11/2015.
 */

public class MyHandler extends com.microsoft.windowsazure.notifications.NotificationsHandler {

    public static final int NOTIFICATION_ID = 1;
    private NotificationManager mNotificationManager;
    NotificationCompat.Builder builder;
    Context ctx;
    Context a;
    public boolean vibration=true;
    public boolean SOUND=true;


    @Override
    public void onRegistered(final Context context, final String gcmRegistrationId) {
        super.onRegistered(context, gcmRegistrationId);

        new AsyncTask<Void, Void, Void>() {

            protected Void doInBackground(Void... params) {
                try {


                    String TAG ="";// MainActivity.mClient.getCurrentUser().getUserId();
                    Log.d("TAG: ",TAG);
                    String [] ar = new String[]{TAG};


                   // MainActivity.mClient.getPush().register(gcmRegistrationId, ar);

                    return null;
                }
                catch(Exception e) {
                    // handle error return null;
                }
                return null;
            }
        }.execute();
    }

    @Override
    public void onReceive(Context context, Bundle bundle) {

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(context);
        boolean vibration_ofNut = SP.getBoolean("AppModeNotVibration",true);
        boolean sound_ofNut = SP.getBoolean("AppModeNotSound",true);
        SOUND = sound_ofNut;
        vibration = vibration_ofNut;
        ctx = context;
        String nhMessage = bundle.getString("message");

//        final MediaPlayer ZVUCEK = MediaPlayer.create(this,R.raw.microbubbles);
//        ZVUCEK.start();

        sendNotification(nhMessage);
//        try
//        {
//            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            Calendar cal = Calendar.getInstance();
//            System.out.println(dateFormat.format(cal.getTime()));
//            String s = nhMessage+dateFormat.format(cal.getTime());
//            //Set<String> defVal = new HashSet<String>();
//            Set<String> defVal = new LinkedHashSet<String>();
//            SharedPreferences pref = context.getSharedPreferences("MyPref", 0);
//            Set mySetBack = pref.getStringSet("MySet", null);
//             //mySetBack.clear();
//            if(mySetBack!=null)
//            {
//                Object[] a = mySetBack.toArray();
//                if(mySetBack.size()==10)
//                {
//                    mySetBack.remove(a[9]);
//                }
//
//                defVal.add(s);
//                 int i = 0;
//
//                for (Object item : mySetBack)
//                {
//                    defVal.add(item.toString());
//
//                }
//
//
//            }
//            else
//            {
//                defVal.add(s);
//            }
//
//            SharedPreferences.Editor editor = pref.edit();
//            editor.putStringSet("MySet", defVal);
//            //editor.putStringSet("MySet", null);
//            editor.commit();
//            //do10(context,nhMessage);
//            //loadD10(context);
//            //getDataFromSharedPreferences(context);
////            List<String> animals = new ArrayList<String>();
////            animals.add(s);
////            animals.add("bear");
////            animals.add("dog");
////
////            writeList(context, animals, "animal");
////
////            List<String> animal1= readList (context, "animal");
////            List<String> animal2= readList (context, "animals");
//
//        }
//        catch (Exception ex)
//        {
//            ex.toString();
//        }

    }

    private void sendNotification(String msg) {

        Log.d("", "Preparing to send notification...: " + msg);

        mNotificationManager = (NotificationManager)
                ctx.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0,
                new Intent(ctx, MainActivity.class), 0);


//

        long[] vibrate = new long[] { 1000, 1000, 1000, 1000, 1000 };
        long[] novibrate = new long[] { 0,0,0,0,0};
        if(vibration)
        {
        }
        else
        {
            //false vibration is disabled
            vibrate= novibrate;
        }
        if(SOUND)
        {
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(ctx)
                            .setSmallIcon(R.drawable.notif)
                            .setTicker("OCULI")
                            .setContentTitle("OCULi")
                            .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                            .setVibrate(vibrate)
                            .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                            .setLights(Color.GREEN,3000,3000)
                            .setContentText(msg);

            mBuilder.setContentIntent(contentIntent);


            mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
            Log.d("", "Notification sent successfully.");
        }
        else
        {
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(ctx)
                            .setSmallIcon(R.drawable.notif)
                            .setTicker("OCULI")
                            .setContentTitle("OCULi")
                            .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                            .setVibrate(vibrate)
                            //.setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                            .setLights(Color.GREEN,3000,3000)
                            .setContentText(msg);

            mBuilder.setContentIntent(contentIntent);


            mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
            Log.d("", "Notification sent successfully.");
        }



    }
//    private void save10messages(String incoming_message,Context context)
//    {
//        http://blog.nkdroidsolutions.com/arraylist-in-sharedpreferences/
//        SharedPreferences settings;
//        Editor editor;
//        settings = context.getSharedPreferences("PREFS_NAME",Context.MODE_PRIVATE);
//        editor = settings.edit();
//        Gson gson = new Gson();
//        String jsonFavorites = gson.toJson(favorites);
//        editor.putString(FAVORITES, jsonFavorites);
//        editor.commit();
//    }


//    private void do10(Context context, String msg)
//    {
//
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Calendar cal = Calendar.getInstance();
//        System.out.println(dateFormat.format(cal.getTime()));
//        Nclass obj= new Nclass();
//        obj.setDate(dateFormat.format(cal.getTime()));
//        obj.setText(msg);
//        Editor editor;
//        SharedPreferences prefs;
//        prefs = context.getSharedPreferences("PREFS_NAME",Context.MODE_PRIVATE);
//        editor = prefs.edit();
//        Gson gson = new Gson();
//        String jsonFavorites = gson.toJson(obj);
//        editor.putString("PREFS_NAME", jsonFavorites);
//        editor.commit();
//
//    }
//    private void loadD10(Context context)
//    {
//        SharedPreferences settings;
//        ArrayList List =new ArrayList<Nclass>();
//        java.util.ArrayList Listik = new ArrayList<Nclass>();
//        settings = context.getSharedPreferences("PREFS_NAME",Context.MODE_PRIVATE);
//        if(settings.contains("PRESS_NAME"))
//        {
//            String jsonFavorites = settings.getString("PREFS_NAME", null);
//            Gson gson = new Gson();
//            List = (ArrayList)(gson.fromJson(jsonFavorites,null));
//        }
//    }
//    private void getDataFromSharedPreferences(Context context){
//        Gson gson = new Gson();
//
//        List<Nclass> productFromShared = new ArrayList<>();
//        SharedPreferences sharedPref = context.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
//
//        String jsonPreferences = sharedPref.getString("PREFS_NAME", "");
//
//        //Type type = new TypeToken<List<Nclass>>() {}.getType();
//        //productFromShared = gson.fromJson(jsonPreferences, type);
//        String s = "";
//
//    }


    public static void writeList(Context context, List<String> list, String prefix)
    {
        SharedPreferences prefs = context.getSharedPreferences("YourApp", Context.MODE_PRIVATE);
        Editor editor = prefs.edit();

        int size = prefs.getInt(prefix+"_size", 0);

        // clear the previous data if exists
        for(int i=0; i<size; i++)
            editor.remove(prefix+"_"+i);

        // write the current list
        for(int i=0; i<list.size(); i++)
            editor.putString(prefix+"_"+i, list.get(i));

        editor.putInt(prefix+"_size", list.size());
        editor.commit();
    }

    public static List<String> readList (Context context, String prefix)
    {
        SharedPreferences prefs = context.getSharedPreferences("YourApp", Context.MODE_PRIVATE);

        int size = prefs.getInt(prefix+"_size", 0);

        List<String> data = new ArrayList<String>(size);
        for(int i=0; i<size; i++)
            data.add(prefs.getString(prefix+"_"+i, null));

        return data;
    }



    class Nclass
    {
        private String date;
        private String text;

        public String getDate() {
            return date;
        }
        public void setDate(String name) {
            this.date = name;
        }
        public String getText() {
            return text;
        }
        public void setText(String name) {
            this.text = name;
        }
    }
}
