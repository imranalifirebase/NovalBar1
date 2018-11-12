package com.softtar.www.novalbar.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.softtar.www.novalbar.R;
import com.softtar.www.novalbar.adapter.SearchDetailAdapter;
import com.softtar.www.novalbar.testFragments.Frag1;
import com.softtar.www.novalbar.testFragments.Frag2;

public class DetailOrderActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String []data = {"Cube SandWithch","Spaghetti Bologinaise","Cube SandWithch","Spaghetti Bologinaise",
            "Cube SandWithch","Spaghetti Bologinaise",
            "Cube SandWithch","Spaghetti Bologinaise",
            "Cube SandWithch","Spaghetti Bologinaise",};
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        toolbar = findViewById(R.id.toolbar_detail_order_activity);
        toolbar.setTitle("Detail Order");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
//        mViewPager = (ViewPager) findViewById(R.id.viewpager_detail_order_activity);
//        mViewPager.setAdapter(mSectionsPagerAdapter);

        // recyclerVeiw For ?Details
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_detail_order_activity);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new SearchDetailAdapter(this);
        mRecyclerView.setAdapter(mAdapter);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // for Next Page
        int id = item.getItemId();
        if (id == R.id.next_arrow_main) {
            Intent intent = new Intent(DetailOrderActivity.this, AddressActivity.class);
            startActivity(intent);
            return true;
        }

        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }






    /////////////////////////////////////////////////////////////////////////
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
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
}
