package com.softtar.www.novalbar.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.softtar.www.novalbar.R;

public class MyOrderClientDetailActivity extends AppCompatActivity {

    private static final String TAG = "HTAG";
    private Toolbar toolbar;
    private CardView cardViewFormulaDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order_client_detail);
        toolbar = findViewById(R.id.toolbar_my_order_client_detail_activity);
        toolbar.setTitle("Order Detail");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        cardViewFormulaDetail = findViewById(R.id.cardview_formula_detail_my_order_client_detail);
        cardViewFormulaDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //formulaDetailDialogue();
                startActivity(new Intent(MyOrderClientDetailActivity.this, SearchDetailActivity.class));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }

    private void formulaDetailDialogue() {
        final Dialog dialog = new Dialog(MyOrderClientDetailActivity.this);
        dialog.setContentView(R.layout.custom_formula_detail_scrollable_dialogue_box);

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
