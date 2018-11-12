package com.softtar.www.novalbar.testFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softtar.www.novalbar.R;
import com.softtar.www.novalbar.adapter.RecycleVerticalAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag2 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String []data = {"Oatmeal","Rice cereal","Wheat germ","corn flakes",
            "Peanuts","Cashews",
            "Pine","Almond",
            "Walnuts","Pecans",
            "Sunflower Seed","Oatmeal","Rice cereal","Wheat germ","corn flakes",
            "Peanuts","Cashews",
            "Pine","Almond",
            "Walnuts","Pecans",
            "Sunflower Seed",};

    public Frag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frag2, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_frag2);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecycleVerticalAdapter(getContext(), data);
        mRecyclerView.setAdapter(mAdapter);

        return view;

        }

}
