package com.example.arfiz.mythings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewThingInfoActivity extends AppCompatActivity {

    private TextView nameTextView, descTextView, categoryTextView, dateTextView, nameLabelTextView;
    private ImageView editImageView, deleteImageView, showImageView;
    Dialog myDialog;
    int thing_id;
    int cat_id;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_thing_info);
        myDialog = new Dialog(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.abs_layout);


        nameTextView = (TextView) findViewById(R.id.nameTextView);
        descTextView = (TextView) findViewById(R.id.descriptionTextView);
        //categoryTextView = (TextView) findViewById(R.id.categoryTextView);
        dateTextView = (TextView) findViewById(R.id.dateTextView);
        nameLabelTextView = (TextView) findViewById(R.id.nameLabelTextView);

        descTextView.setMovementMethod(new ScrollingMovementMethod());

        editImageView = (ImageView) findViewById(R.id.edit_icon);
        deleteImageView = (ImageView) findViewById(R.id.delete_icon);
        showImageView = (ImageView) findViewById(R.id.showImageView);

        Intent intent = getIntent();
        thing_id = intent.getIntExtra("thing_id",0);

        MyThingDbHelper dbHelper = new MyThingDbHelper(this);
        MyThing thing = dbHelper.getThingInfoById(thing_id);
        cat_id = thing.getThing_category_id();

        setActonBarTitle(dbHelper.getThingCategory(cat_id) + " Details");
        setLabelTextView(cat_id);

        nameTextView.setText(thing.getThing_name());
        descTextView.setText(thing.getThing_description());
        nameTextView.setTag(Integer.valueOf(thing.getId()));
        bitmap = BitmapFactory.decodeByteArray(thing.getImagebyte(), 0, thing.getImagebyte().length);

        showImageView.setImageBitmap(bitmap);


        //categoryTextView.setText(thing.getThing_category());
        dateTextView.setText(thing.getDate());


        deleteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ViewThingInfoActivity.this);
                builder.setMessage("Confirm delete?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MyThingDbHelper dbHelper = new MyThingDbHelper(ViewThingInfoActivity.this);
                                //int id = Integer.parseInt(nameTextView.getTag(Integer.valueOf(thing.getId())).toString());
                                boolean deleted = dbHelper.deleteThing(thing_id);
                                if (deleted){
                                    Toast.makeText(ViewThingInfoActivity.this, "Deleted successfully",Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(ViewThingInfoActivity.this, ThingsActivity.class);
                                    startActivity(intent);
                                    finish();
                                }else{
                                    Toast.makeText(ViewThingInfoActivity.this, "Failed to delete! Something went wrong",Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        editImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ViewThingInfoActivity.this, UpdateInfoActivity.class);
                intent.putExtra("id", thing_id);
                intent.putExtra("cat_id",cat_id);
                intent.putExtra("caller",1);
                startActivity(intent);
                finish();
            }
        });
    }

    public void setActonBarTitle(String title){
        View v = getSupportActionBar().getCustomView();
        TextView titleTextView = (TextView)v.findViewById(R.id.tvTitle);
        titleTextView.setText(title);
    }

    public void setLabelTextView(int cat_id) {
        if (cat_id == 1){
            nameLabelTextView.setText("Title");
        }else if (cat_id == 5){
            nameLabelTextView.setText("Title");
        }else if (cat_id == 7){
            nameLabelTextView.setText("Title");
        }

    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(ViewThingInfoActivity.this, ThingsActivity.class));
        finish();
    }

    public void ShowPopup() {
        TextView txtclose;
        myDialog.setContentView(R.layout.custompopup);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        ImageView showImage = (ImageView) myDialog.findViewById(R.id.showImage);
       showImage.setImageBitmap(bitmap);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void showSavedImage(View view) {
        ShowPopup();
    }
}
