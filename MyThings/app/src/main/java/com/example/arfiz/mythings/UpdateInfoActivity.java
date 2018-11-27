package com.example.arfiz.mythings;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class UpdateInfoActivity extends AppCompatActivity {

    private EditText nameEditText, desEditText;
    private TextView idTextView,nameTextView;
    private int id = 0;
    private int cat_id = 0;
    private int caller;
    Intent intent;
    private ImageView savedPhotoImageView;
    private static final int SELECT_PHOTO = 1;
    private static final int CAPTURE_PHOTO = 2;

    private ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarbHandler = new Handler();
    private boolean hasImageChanged = false;

    Bitmap thumbnail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.abs_layout);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        desEditText = (EditText) findViewById(R.id.descriptionEditText);
        idTextView = (TextView) findViewById(R.id.idTextView);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        intent = getIntent();
        id = intent.getIntExtra("id",0);
        cat_id = intent.getIntExtra("cat_id",0);

        idTextView.setText(id+"");

        savedPhotoImageView = findViewById(R.id.savedPhotoImageView);

        //String caller = getIntent().getStringExtra("caller");
//        try {
//            Class callerClass = Class.forName(caller);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


        setEditTextHint(cat_id);

        MyThingDbHelper dbHelper = new MyThingDbHelper(this);
        MyThing myThing = dbHelper.getThingInfoById(id);
        nameEditText.setText(myThing.getThing_name());
        desEditText.setText(myThing.getThing_description());
        Bitmap bitmap = BitmapFactory.decodeByteArray(myThing.getImagebyte(), 0, myThing.getImagebyte().length);

        savedPhotoImageView.setImageBitmap(bitmap);

        String category = dbHelper.getThingCategory(cat_id);
        setActonBarTitle("Update " +category+ " Details");



    }

    public void setActonBarTitle(String title){
        View v = getSupportActionBar().getCustomView();
        TextView titleTextView = (TextView)v.findViewById(R.id.tvTitle);
        titleTextView.setText(title);
    }


    public void Update(View view) {

        if (nameEditText.getText().toString().equals("") || desEditText.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Field cannot be empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (nameEditText.getText().toString().length() > 40){
            Toast.makeText(getApplicationContext(), "Title/Name Length Cannot Exceed 40 characters", Toast.LENGTH_SHORT).show();
            return;
        }

        savedPhotoImageView.setDrawingCacheEnabled(true);
        savedPhotoImageView.buildDrawingCache();
        Bitmap bitmap = savedPhotoImageView.getDrawingCache();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        MyThingDbHelper dbHelper = new MyThingDbHelper(this);
        MyThing thing = new MyThing();
        thing.setThing_name(nameEditText.getText().toString().trim());
        thing.setThing_description(desEditText.getText().toString());
        thing.setId(id);
        thing.setThing_category_id(cat_id);
        thing.setImagebyte(data);
        String category = dbHelper.getThingCategory(cat_id);

        boolean dataExists = dbHelper.checkIfDataExists(thing);
        if (dataExists){
            Toast.makeText(getApplicationContext(), category + " already exists.", Toast.LENGTH_SHORT).show();
            return;
        }

        long rowUpdated = dbHelper.updateInfo(thing);

        if (rowUpdated != -1){
            Toast.makeText(getApplicationContext(), "Updated successfully " , Toast.LENGTH_SHORT).show();
            finish();
            if (intent.hasExtra("caller")){
                Intent intent = new Intent(UpdateInfoActivity.this, ViewThingInfoActivity.class);
                intent.putExtra("thing_id",id);
                startActivity(intent);
            }else {
                startActivity(new Intent(UpdateInfoActivity.this, ThingsActivity.class));
            }
            //Intent intent = new Intent(getApplicationContext(), ThingsActivity.class );


            //startActivity(intent);
        }else {
            Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void Clear(View view) {
        if (!nameEditText.getText().toString().equals("") || !desEditText.getText().toString().equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            nameEditText.setText("");
                            desEditText.setText("");
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

    }

    public void setEditTextHint(int cat_id) {
        if (cat_id == 1){
            nameTextView.setText("Title");
            nameEditText.setHint("Title for your idea!");
        }else if (cat_id == 2){
            nameEditText.setHint("Name of the place!");
        }else if (cat_id == 3){
            nameEditText.setHint("Name of the food!");
        }else if (cat_id == 4){
            nameEditText.setHint("Name of the movie!");
        }else if (cat_id == 5){
            nameTextView.setText("Title");
            nameEditText.setHint("Title of the music!");
        }else if (cat_id == 6){
            nameEditText.setHint("Name of the person!");
        }else if (cat_id == 7){
            nameTextView.setText("Title");
            nameEditText.setHint("Title of the book!");
        }else if (cat_id == 8){
            nameEditText.setHint("Name of the product!");
        }else if (cat_id == 9){
            nameEditText.setHint("Name of the restaurant!");
        }

    }

    @Override
    public void onBackPressed() {

        if (intent.hasExtra("caller")){
            Intent intent = new Intent(UpdateInfoActivity.this, ViewThingInfoActivity.class);
            intent.putExtra("thing_id",id);
            startActivity(intent);
        }else {
            startActivity(new Intent(UpdateInfoActivity.this, ThingsActivity.class));
        }
        finish();

    }

    public void selectImage(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, SELECT_PHOTO);
    }

    public void setProgressBar(){
        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage("Please wait...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();
        progressBarStatus = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressBarStatus < 100){
                    progressBarStatus += 30;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    progressBarbHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressBarStatus);
                        }
                    });
                }
                if (progressBarStatus >= 100) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBar.dismiss();
                }

            }
        }).start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SELECT_PHOTO){
            if(resultCode == RESULT_OK) {
                try {
                    final Uri imageUri = data.getData();
                    final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                    //set Progress Bar
                    setProgressBar();
                    //set profile picture form gallery
                    savedPhotoImageView.setImageBitmap(selectedImage);
                    savedPhotoImageView.setVisibility(View.VISIBLE);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }else if(requestCode == CAPTURE_PHOTO){
            if(resultCode == RESULT_OK) {
                onCaptureImageResult(data);
            }
        }
    }

    private void onCaptureImageResult(Intent data) {
        thumbnail = (Bitmap) data.getExtras().get("data");

        //set Progress Bar
        setProgressBar();
        //set profile picture form camera
        savedPhotoImageView.setMaxWidth(200);
        savedPhotoImageView.setImageBitmap(thumbnail);
        savedPhotoImageView.setVisibility(View.VISIBLE);

    }

    public void captureImage(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAPTURE_PHOTO);
    }
}
