package com.softtar.www.novalbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.softtar.www.novalbar.activities.ClientFormulaActivity;
import com.softtar.www.novalbar.activities.DetailOrderActivity;
import com.softtar.www.novalbar.activities.MyOrderActivity;
import com.softtar.www.novalbar.activities.SearchActivity;
import com.softtar.www.novalbar.adapter.ScreenSlidePagerAdapter;
import com.softtar.www.novalbar.adapter.SearchAdapter;
import com.softtar.www.novalbar.shareprefer.SharePrefer;
import com.softtar.www.novalbar.testFragments.Frag1;
import com.softtar.www.novalbar.testFragments.Frag2;
import com.squareup.picasso.Picasso;

import java.io.File;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "HTAG";
    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String[] data = {"Cube SandWithch", "Spaghetti Bologinaise", "Cube SandWithch", "Spaghetti Bologinaise",
            "Cube SandWithch", "Spaghetti Bologinaise",
            "Cube SandWithch", "Spaghetti Bologinaise",
            "Cube SandWithch", "Spaghetti Bologinaise",};
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private SharePrefer userData;
    private TextView profileName;
    private TextView profileEmail;
    private ImageView profileImage;

    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_content_main);
        setSupportActionBar(toolbar);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        userData = new SharePrefer(this);

        Log.d(TAG, "onCreate: NAme : " + userData.getName());


        // mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.viewpager_detail_order_activity);
        mViewPager.setAdapter(mPagerAdapter);


//////////////////////////////////////////////////////////////////////////////////////////////////

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_content_main);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_order: {
                                /*Toast.makeText(MainActivity.this, "ORDERR", Toast.LENGTH_SHORT).show();*/
                                startActivity(new Intent(MainActivity.this, MyOrderActivity.class));
                                break;
                            }

                            case R.id.action_search: {
//                                Toast.makeText(MainActivity.this, "SEARCH", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this, SearchActivity.class));
                                break;
                            }

                        }
                        return true;
                    }
                });


////////////////////////////////////////////////////////////////////////////////////////////////////
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        View headerView = navigationView.getHeaderView(0);
        profileName = headerView.findViewById(R.id.txt_name_nav_header_main);
        profileEmail = headerView.findViewById(R.id.txt_email_nav_header_main);
        profileImage = headerView.findViewById(R.id.imageView_nav_header_main);
        profileName.setText(userData.getName());
        profileEmail.setText(userData.getEmail());
//        Uri myImgUri = Uri.parse(userData.getImageURL());
        //profileImage.setImageURI(myImgUri);
        Picasso.get()
                .load(userData.getImageURL()).into(profileImage);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
            moveTaskToBack(true);
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
        if (id == R.id.next_arrow_main) {
            Intent intent = new Intent(MainActivity.this, DetailOrderActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        }
        else if (id == R.id.nav_formula_main_drawer_activity) {
            startActivity(new Intent(MainActivity.this, ClientFormulaActivity.class));
        }
        else if (id == R.id.nav_log_out) {
            Log.d(TAG, "Log Out : ");
            // FirebaseAuth.getInstance().signOut();
            profileName.setText("No Name");
            profileEmail.setText("No Email");
            showDialogueMsg();
        } else if (id == R.id.nav_my_order) {
            startActivity(new Intent(MainActivity.this, MyOrderActivity.class));
        } else if (id == R.id.nav_search_main_drawer_activity) {
            startActivity(new Intent(MainActivity.this, SearchActivity.class));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    ///////////////////////////////////////////////////

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Frag1 frag1 = new Frag1();
                    return frag1;
                case 1:
                    Frag2 frag2 = new Frag2();
                    return frag2;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

    }


    private void signOut() {

        GoogleSignInClient mGoogleSignInClient;
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        FirebaseAuth.getInstance().signOut();
        // mAuth.signOut();
        mGoogleSignInClient.signOut().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
//                        Intent intent = new Intent(YourActivity.this, NextActivity.class);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        startActivity(intent);

                        Log.d(TAG, "onComplete: logut GoogleSign In Complete");
                    }
                });
    }

    ////////////////////////////////////////////////////////////////////////////////////

    public void showDialogueMsg() {


        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Sign Out")
                .setMessage("Are You Sure! You Wanna Sign Out?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete

                        signOut();
                        finish();
                        System.exit(0);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }
////////////////////////////////////////////////////////////////////////


}
