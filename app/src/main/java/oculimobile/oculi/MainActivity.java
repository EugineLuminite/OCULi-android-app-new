package oculimobile.oculi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import oculimobile.oculi.ActivitiesViewModels.EventsHistory;
import oculimobile.oculi.ViewModels.AboutFragment;
import oculimobile.oculi.ViewModels.AccountFragment;
import oculimobile.oculi.ViewModels.BluetoothFragment;
import oculimobile.oculi.ViewModels.EventsViewFragment;
import oculimobile.oculi.ViewModels.HelpFragment;
import oculimobile.oculi.ViewModels.SettingsFragment;
import oculimobile.oculi.ViewModels.SimCardFragment;
import oculimobile.oculi.ViewModels.SitesFragment;
import oculimobile.oculi.ViewModels.UnitsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        EventsViewFragment.OnFragmentInteractionListener,
        UnitsFragment.OnFragmentInteractionListener,
        SitesFragment.OnFragmentInteractionListener,
        HelpFragment.OnFragmentInteractionListener,
        SimCardFragment.OnFragmentInteractionListener,
        SettingsFragment.OnFragmentInteractionListener,
        AccountFragment.OnFragmentInteractionListener,
        BluetoothFragment.OnFragmentInteractionListener,
        AboutFragment.OnFragmentInteractionListener

{


    private EventsViewFragment eventsViewFragment =null;
    private SitesFragment sitesFragment = null;
    private UnitsFragment unitsFragment = null ;//new UnitsFragment();
    private AccountFragment accountFragment = null;//new AccountFragment();
    private SettingsFragment settingsFragment = null;//new SettingsFragment();
    private AboutFragment aboutFragment = null;//new AboutFragment();
    private HelpFragment helpFragment = null;//new HelpFragment();
    private BluetoothFragment bluetoothFragment = null;//new BluetoothFragment();
    private SimCardFragment simCardFragment = null;//new SimCardFragment();
    private android.support.v4.app.Fragment currentFrag ;



    private Toolbar toolbar;
    private Context mMainContext;
    private int FragMentContainter= R.id.fragment_container;
    NavigationView navigationView;
    private SharedPrefFunctions prefFunctions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainContext = this;
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        prefFunctions = new SharedPrefFunctions(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        this.setTitle("Events");

        if (savedInstanceState == null)
        {
            if(eventsViewFragment== null)
            {
                eventsViewFragment =new EventsViewFragment();
            }
            eventsViewFragment =new EventsViewFragment();
            toolbar.setTitle("Events");
            currentFrag = eventsViewFragment;

            getSupportFragmentManager().beginTransaction().replace
                    (
                            FragMentContainter,
                            eventsViewFragment
                            // fragment.getTag()
                    ).commit();
            navigationView.setCheckedItem(R.id.nav_events);

        }

//        sitesFragment = new SitesFragment();
//        unitsFragment = new UnitsFragment();
//        accountFragment = new AccountFragment();
//        settingsFragment = new SettingsFragment();
//        aboutFragment = new AboutFragment();
//        helpFragment = new HelpFragment();
//        bluetoothFragment = new BluetoothFragment();
//        simCardFragment = new SimCardFragment();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    Object fragment ;

    private void changeFrag(int layout,android.support.v4.app.Fragment newFrag){

        getSupportFragmentManager() // gets the FragmentManager of the Activity, no need to hold a reference
                .beginTransaction()
                .replace(layout, newFrag)
                .remove(currentFrag)// use the layout and the fragment, no need for a cast
                .commit();

    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        //android.support.v4.app.FragmentManager manager = getSupportFragmentManager();

        int id = item.getItemId();

        if (id == R.id.nav_events)
        {

            if(eventsViewFragment== null)
            {
                eventsViewFragment =new EventsViewFragment();
            }
            //fragment =eventsViewFragment;

            changeFrag(R.id.fragment_container,eventsViewFragment);
//            manager.beginTransaction().replace
//                    (
//                            R.id.fragment_container,
//                            fragment,
//                            (EventsViewFragment)fragment.getTag()
//                    ).commit();
            toolbar.setTitle("Events");
            currentFrag = eventsViewFragment;
        }
        if (id == R.id.nav_events_history)
        {

            startActivity(new Intent(this, EventsHistory.class));

        }
        else if (id == R.id.nav_sites)
        {
            if(sitesFragment==null)
            {
                sitesFragment = new SitesFragment();
            }

            changeFrag(R.id.fragment_container,sitesFragment);
//            manager.beginTransaction().replace
//                    (
//                            R.id.fragment_container,
//                            fragment,
//                            fragment.getTag()
//                    ).commit();
            toolbar.setTitle("Sites");
            currentFrag = sitesFragment;
        }
        else if (id == R.id.nav_units)
        {
            if(unitsFragment==null)
            {
                unitsFragment = new UnitsFragment();
            }
            changeFrag(R.id.fragment_container,unitsFragment);
//            manager.beginTransaction().replace
//                    (
//                            R.id.fragment_container,
//                            fragment,
//                            fragment.getTag()
//                    ).commit();

            toolbar.setTitle("Units");
            currentFrag = unitsFragment;
        }
        else if (id == R.id.nav_simcard)
        {
            if(simCardFragment==null)
            {
                simCardFragment = new SimCardFragment();
            }
            changeFrag(R.id.fragment_container,simCardFragment);

//            manager.beginTransaction().replace
//                    (
//                            R.id.fragment_container,
//                            fragment,
//                            fragment.getTag()
//                    ).commit();
            toolbar.setTitle("Sims");
            currentFrag = simCardFragment;
        }
        else if (id == R.id.nav_bluetooth)
        {
            if(bluetoothFragment==null)
            {
                bluetoothFragment = new BluetoothFragment();
            }
            changeFrag(R.id.fragment_container,bluetoothFragment);

//            manager.beginTransaction().replace
//                    (
//                            R.id.fragment_container,
//                            fragment,
//                            fragment.getTag()
//                    ).commit();

            toolbar.setTitle("Bluetooth");
            currentFrag = bluetoothFragment;
        }
        else if (id == R.id.nav_help)
        {


            if(helpFragment==null)
            {
                helpFragment = new HelpFragment();
            }
            changeFrag(R.id.fragment_container,helpFragment);
//            manager.beginTransaction().replace
//                    (
//                            R.id.fragment_container,
//                            fragment,
//                            fragment.getTag()
//                    ).commit();
            toolbar.setTitle("Help");
            currentFrag = helpFragment;
        }
        else if (id == R.id.nav_about)
        {
            if(aboutFragment==null)
            {
                aboutFragment = new AboutFragment();
            }
            changeFrag(R.id.fragment_container,aboutFragment);

//            manager.beginTransaction().replace
//                    (
//                            R.id.fragment_container,
//                            fragment,
//                            fragment.getTag()
//                    ).commit();
            toolbar.setTitle("About");
            currentFrag = aboutFragment;
        }
        else if (id == R.id.nav_settings)
        {

            if(settingsFragment==null)
            {
                settingsFragment = new SettingsFragment();
            }
            changeFrag(R.id.fragment_container,settingsFragment);
//            manager.beginTransaction().replace
//                    (
//                            R.id.fragment_container,
//                            fragment,
//                            fragment.getTag()
//                    ).commit();

            toolbar.setTitle("Settings");
            currentFrag = settingsFragment;
        }
        else if (id == R.id.nav_user_details)
        {
            if(accountFragment==null)
            {
                accountFragment = new AccountFragment();
            }
            changeFrag(R.id.fragment_container,accountFragment);
//            manager.beginTransaction().replace
//                    (
//                            R.id.fragment_container,
//                            fragment,
//                            fragment.getTag()
//                    ).commit();
            toolbar.setTitle("Account");
            currentFrag = accountFragment;
        }
        else if (id == R.id.nav_logout)
        {
            CreateAndShowLogOutDialog(this);
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void CreateAndShowLogOutDialog(final Context mcontent)
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?");
        builder.setTitle("OCULi");
        builder.setCancelable(false);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                prefFunctions.DeleteUser();
                ChangeScreenToLoginScreen(mcontent);

            }
        });
        builder.setNegativeButton("NO?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void ChangeScreenToLoginScreen(Context mcontext)
    {
        //final Intent intent = new Intent(mcontext , ToDoActivity.class);
        final Intent intent = new Intent(mcontext , TestLoginActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
