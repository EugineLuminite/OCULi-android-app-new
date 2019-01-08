package oculimobile.oculi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartingActivityWithoutUI extends AppCompatActivity {
    private SharedPrefFunctions prefFunctions;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_starting_without_ui);
        prefFunctions = new SharedPrefFunctions(this);
        boolean CREDETENTIAL = prefFunctions.CheckUser_LoadSharedPreferences();
        final Intent intent;
        boolean showAnimation = false;
//        if( showAnimation)
//        {
//            //intent= new Intent(StartingActivityWithoutUI.this, SplashActivity.class);
//
//        }
//        else
//        {
            if(CREDETENTIAL)
            {
                intent = new Intent(StartingActivityWithoutUI.this, MainActivity.class);
                //intent= new Intent(StartingActivityWithoutUI.this, ToDoActivity.class);
                //startActivity(intent);
            }
            else
            {
                intent = new Intent(StartingActivityWithoutUI.this, TestLoginActivity.class);

            }
        //}

        startActivity(intent);
        finish();
    }
}
