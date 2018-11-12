package com.softtar.www.novalbar.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softtar.www.novalbar.R;
import com.softtar.www.novalbar.activities.SearchDetailActivity;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    private String []data;
    private Context ctx;
    private String []dataType = {"Sweety", "Saulty", "Sour",
            "Sweety", "Saulty", "Sour",
            "Sweety", "Saulty", "Sour",
            "Sweety", "Saulty", "Sour",};
    private static final String TAG = "HTAG";
    public SearchAdapter(Context ctx, String []data) {
        this.ctx = ctx;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_custom_row, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.txtSeractText.setText(data[i]);
        myViewHolder.txtType.setText(dataType[i]);
        myViewHolder.txtSeractText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, SearchDetailActivity.class);
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView txtSeractText;
        private TextView txtType;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSeractText = itemView.findViewById(R.id.txt_search_custom_search_row);
            txtType = itemView.findViewById(R.id.txt_formula_type_search_custom_row);
        }
    }
}

