package com.softtar.www.novalbar.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.softtar.www.novalbar.R;


import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleVerticalAdapter extends RecyclerView.Adapter<RecycleVerticalAdapter.MyViewHolder> {
    private String[] mDataSet;
    private String longText = "Am no an listening depending up believing. Enough around remove to barton agreed regret in or it. Advantage mr estimable be commanded provision. Year well shot deny shew come now had. Shall downs stand marry taken his for out. Do related mr account brandon an up. Wrong for never ready ham these witty him. Our compass see age uncivil matters weather forbade her minutes. Ready how but truth son new under.";
    private Context ctx;
    private static final String TAG = "HTAG";
    private static boolean defaultFlag = false;


    public RecycleVerticalAdapter(Context ctx, String[] mDataSet) {
        this.mDataSet = mDataSet;
        this.ctx = ctx;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_row_vertical, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {


        myViewHolder.txtName.setText(mDataSet[i]);
        // myViewHolder.expandableTextView.setText(longText);

        myViewHolder.btnImageMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myViewHolder.btnImagePluse.setVisibility(View.VISIBLE);

                final String numberCount;
                numberCount = myViewHolder.editNumber.getText().toString();
                int myCount = Integer.parseInt(numberCount);
                myCount = myCount - 1;
                if (myCount <= 0) {
                    myViewHolder.editNumber.setText("0");
                } else {
                    String value = Integer.toString(myCount);
                    myViewHolder.editNumber.setText(value);
                }
            }
        });
        myViewHolder.btnImagePluse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String numberCount;
                numberCount = myViewHolder.editNumber.getText().toString();
                int myCount = Integer.parseInt(numberCount);

                Log.d(TAG, "onClick: Pluse Button Click at position ");

//                if (defaultFlag){
//                    myViewHolder.editNumber.setText("7");
//
//                    Log.d(TAG, "onClick: In plus Button : Default Flag ");
//                    return;
//                }

                if (defaultFlag) {
                    myViewHolder.editNumber.setText("7");
                   myViewHolder.btnImagePluse.setVisibility(View.GONE);
                    defaultFlag = false;
                    return;
                }


                myCount = myCount + 1;
                if (myCount >= 10) {
                    myViewHolder.editNumber.setText("10");
                } else {
                    String value = Integer.toString(myCount);
                    myViewHolder.editNumber.setText(value);
                }


                // Show Warning Box
                if (myCount == 7) {
                    showWarningDialogue();
                }


                /*myCount = myCount+1;
                Log.d(TAG, "onClick: after Pluse Calulation :  " + myCount);
                String value = Integer.toString(myCount);
                myViewHolder.editNumber.setText(value);*/
            }
        });

//        myViewHolder.txtName.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                /*Toast.makeText(ctx, "TTTTTTTTTTT", Toast.LENGTH_LONG).show();*/
//                testDialogue();
//                return true;
//            }
//        });

        myViewHolder.btnPluseShowDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Bbbbb");
                //shwoCustomDialogue();
                testDialogue();
            }
        });

    }

    private void testDialogue() {
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

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private CircleImageView btnImagePluse;
        /*private ImageButton btnImageMinus;*/
        private CircleImageView btnImageMinus;
        private EditText editNumber;
        private ImageButton btnPluseShowDetail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_show_detail_custom_row_vertical);  // change id of text for just click
            // expandableTextView = itemView.findViewById(R.id.expand_text_view);
            btnImagePluse = itemView.findViewById(R.id.btn_image_pluse_custom_row_vertical);
            btnImageMinus = itemView.findViewById(R.id.btn_image_minus_custom_row_vertical);
            editNumber = itemView.findViewById(R.id.edit_number_custom_row_vertical);
            btnPluseShowDetail = itemView.findViewById(R.id.btnImage_pluse_show_detail_custom_row_vertical);
        }
    }

    void shwoCustomDialogue() {
        final AlertDialog.Builder builder = new AlertDialog.Builder((ctx));
        View view = LayoutInflater.from(ctx).inflate(R.layout.custom_dialogue_box, null);

        builder.setView(view);
        builder.show();
    }

    public void showWarningDialogue() {
        final Dialog dialog = new Dialog(ctx);
        dialog.setContentView(R.layout.custom_warning_dialogue_box);
        Button btnDefault = dialog.findViewById(R.id.btn_default_custom_warning_dialogue_box);
        btnDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Default Button Clicked");
                defaultFlag = true;
                dialog.dismiss();
            }
        });

        Button btnIgnore = dialog.findViewById(R.id.btn_ignore_custom_warning_dialogue_box);
        btnIgnore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }


}


