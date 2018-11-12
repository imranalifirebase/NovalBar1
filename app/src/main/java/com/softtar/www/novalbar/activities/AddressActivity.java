package com.softtar.www.novalbar.activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.softtar.www.novalbar.MainActivity;
import com.softtar.www.novalbar.R;

public class AddressActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button btn30Bar;
    private Button btn60Bar;
    private TextView txtTotalAmount;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        toolbar = findViewById(R.id.toolbar_separate_address_main_activity);
        toolbar.setTitle("Address");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnSubmit = findViewById(R.id.btn_submit_address_activity);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thankYou();
            }
        });

        btn30Bar = findViewById(R.id.btn_30_bar_separaet_address_main_activity);
        btn60Bar = findViewById(R.id.btn_60_bar_separaet_address_main_activity);
        txtTotalAmount = findViewById(R.id.txt_total_amount_separate_address_main_activity);

        btn30Bar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                btn30Bar.setBackgroundColor(getResources().getColor(R.color.orange));
                btn30Bar.setTextSize(18);
                btn30Bar.setTextColor(getResources().getColor(R.color.white));

                btn60Bar.setBackgroundColor(getResources().getColor(R.color.lightGray));
                btn60Bar.setTextColor(getResources().getColor(R.color.black));
                btn60Bar.setTextSize(10);
                txtTotalAmount.setText("Total: $85");
            }
        });

        btn60Bar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                btn60Bar.setBackgroundColor(getResources().getColor(R.color.orange));
                btn60Bar.setTextSize(18);
                btn60Bar.setTextColor(getResources().getColor(R.color.white));

                btn30Bar.setBackgroundColor(getResources().getColor(R.color.lightGray));
                btn30Bar.setTextColor(getResources().getColor(R.color.black));
                btn30Bar.setTextSize(10);
                txtTotalAmount.setText("Total: $120");
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

    public void thankYou(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.thankyou_dialogue_box);
        dialog.setCancelable(false);

        Button btnThankYou = dialog.findViewById(R.id.btn_confirm_thankyou_dialoge_box);
        btnThankYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddressActivity.this, MainActivity.class));
            }
        });

//        ImageButton btnCross = dialog.findViewById(R.id.btn_iamge_cross_dialogue_custom_dialogue_box);
//        btnCross.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}
