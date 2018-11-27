package com.example.arfiz.convertit;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class LaunchActivity extends AppCompatActivity {

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);


        progressBar = findViewById(R.id.progressBar);

        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setIndeterminate(true);
            progressBar.getIndeterminateDrawable().setColorFilter(0xFFFFFFFF, android.graphics.PorterDuff.Mode.MULTIPLY);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                loadProgressBar();
                startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                finish();

            }
        }).start();
        /*int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                finish();
            }
        }, secondsDelayed * 1500);*/
    }

    public void loadProgressBar(){
        for (int progress=0; progress<100; progress+=30){
            try{
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
