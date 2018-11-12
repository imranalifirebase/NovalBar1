package com.softtar.www.novalbar.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.softtar.www.novalbar.R;

import org.w3c.dom.Text;

public class SearchDetailAdapter extends RecyclerView.Adapter<SearchDetailAdapter.MyViewHolder> {


    private Context ctx;
    private String [] categoriesName = {"Nuts", "Dried Fruit", "Veggies", "Protein"};

    private String [] nutration1 = {"Peanuts", "Cashews", "Pine","Pine"};
    private String [] nutration2 = {"Dates", "Apricots", "Banana chips","Blueberries"};
    private String [] nutration3 = {"Carrots", "dehydrated chips", "dry","Celery"};
    private String [] nutration4 = {"Whey powder", "egg whites", "Pea, powder","Soy, powder"};

    public SearchDetailAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_detail_search_single, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.imgButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailDialogue();
            }
        });
        myViewHolder.imgButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailDialogue();
            }
        });
        myViewHolder.imgButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailDialogue();
            }
        });
        myViewHolder.imgButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailDialogue();
            }
        });

        myViewHolder.txtCategoryName.setText(categoriesName[i]);

        myViewHolder.txtNutration1.setText(nutration1[i]);
        myViewHolder.txtNutration2.setText(nutration2[i]);
        myViewHolder.txtNutration3.setText(nutration3[i]);
        myViewHolder.txtNutration4.setText(nutration4[i]);

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageButton imgButton1;
        private ImageButton imgButton2;
        private ImageButton imgButton3;
        private ImageButton imgButton4;
        private TextView txtCategoryName;
        private TextView txtNutration1;
        private TextView txtNutration2;
        private TextView txtNutration3;
        private TextView txtNutration4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNutration1 = itemView.findViewById(R.id.txt_nutration_name_custom_drtail_search_single1);
            txtNutration2 = itemView.findViewById(R.id.txt_nutration_name_custom_drtail_search_single2);
            txtNutration3 = itemView.findViewById(R.id.txt_nutration_name_custom_drtail_search_single3);
            txtNutration4 = itemView.findViewById(R.id.txt_nutration_name_custom_drtail_search_single4);

            txtCategoryName = itemView.findViewById(R.id.txt_category_name_custom_drtail_search_single);
            imgButton1 = itemView.findViewById(R.id.btnImage_green_plus_custom_detail_search_single1);
            imgButton2 = itemView.findViewById(R.id.btnImage_green_plus_custom_detail_search_single2);
            imgButton3 = itemView.findViewById(R.id.btnImage_green_plus_custom_detail_search_single3);
            imgButton4 = itemView.findViewById(R.id.btnImage_green_plus_custom_detail_search_single4);
        }
    }

    private void detailDialogue() {
        final Dialog dialog = new Dialog(ctx);
        dialog.setContentView(R.layout.custom_dialogue_box);

        ImageButton btnCross = dialog.findViewById(R.id.btn_iamge_cross_dialogue_custom_dialogue_box);
        btnCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}
