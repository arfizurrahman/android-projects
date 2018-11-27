package com.example.arfiz.mythings;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {

    ActionBar actionBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        actionBar = getSupportActionBar();

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.abs_layout_with_cancel);

        View v = getSupportActionBar().getCustomView();
        TextView titleTextView = (TextView)v.findViewById(R.id.tvTitle);
        titleTextView.setText("Add Thing");
        ImageView cancelImageView = (ImageView) v.findViewById(R.id.cancelImageView);

        cancelImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }


    public void Idea(View view) {

        Intent intent = new Intent(CategoryActivity.this, InformationEntryActivity.class);
        intent.putExtra("Category_id", 1);
        startActivity(intent);
        finish();
    }

    public void Place(View view) {

        Intent intent = new Intent(CategoryActivity.this, InformationEntryActivity.class);
        intent.putExtra("Category_id", 2);
        startActivity(intent);
        finish();
    }

    public void Food(View view) {

        Intent intent = new Intent(CategoryActivity.this, InformationEntryActivity.class);
        intent.putExtra("Category_id", 3);
        startActivity(intent);
        finish();
    }

    public void Movie(View view) {

        Intent intent = new Intent(CategoryActivity.this, InformationEntryActivity.class);
        intent.putExtra("Category_id", 4);
        startActivity(intent);
        finish();
    }

    public void Music(View view) {

        Intent intent = new Intent(CategoryActivity.this, InformationEntryActivity.class);
        intent.putExtra("Category_id", 5);
        startActivity(intent);
        finish();
    }

    public void Person(View view) {

        Intent intent = new Intent(CategoryActivity.this, InformationEntryActivity.class);
        intent.putExtra("Category_id", 6);
        startActivity(intent);
        finish();
    }

    public void Book(View view) {

        Intent intent = new Intent(CategoryActivity.this, InformationEntryActivity.class);
        intent.putExtra("Category_id", 7);
        startActivity(intent);
        finish();
    }

    public void Product(View view) {

        Intent intent = new Intent(CategoryActivity.this, InformationEntryActivity.class);
        intent.putExtra("Category_id", 8);
        startActivity(intent);
        finish();
    }

    public void Restaurant(View view) {

        Intent intent = new Intent(CategoryActivity.this, InformationEntryActivity.class);
        intent.putExtra("Category_id", 9);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(CategoryActivity.this, ThingsActivity.class));
        finish();
    }
}
