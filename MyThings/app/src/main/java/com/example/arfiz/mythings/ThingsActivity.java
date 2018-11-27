package com.example.arfiz.mythings;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ThingsActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {



    private List<MyThing> thingList = null;
    ActionBar actionBar;
    EditText filterEditText;
    TextView noThingsTextView, addButtonClickTextView;
    LinearLayout noThingsLinearLayout, filterBox;
    ImageView filterIcon,cancelFilterIcon;
    ListView listView;
    int thing_id = 0;
    int cat_id = 0;
    private long backPressedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things);


        actionBar = getSupportActionBar();

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.abs_layout_filter);


        if (ContextCompat.checkSelfPermission(ThingsActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(ThingsActivity.this, new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
        }

        View v = getSupportActionBar().getCustomView();
        TextView titleTextView = (TextView)v.findViewById(R.id.tvTitle);
        filterIcon = (ImageView) v.findViewById(R.id.filterIcon);
        titleTextView.setText("MyTHINGS");





        filterEditText = (EditText) findViewById(R.id.filterEditText);
        noThingsLinearLayout = (LinearLayout) findViewById(R.id.noThingsLayout);
        filterBox = (LinearLayout) findViewById(R.id.filterBoxLayout);
        cancelFilterIcon = (ImageView) findViewById(R.id.cancelFilterIcon);

        filterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterBox.setVisibility(View.VISIBLE);
            }
        });

        cancelFilterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterBox.setVisibility(View.GONE);
            }
        });


        /*MyThing myThing = new MyThing();
        myThing.setThing_name("Gangstar");
        myThing.setDate("2018-08-20");
        myThing.setThing_category_id(1);
        myThing.setThing_description("Bla Bla bla");
        myThing.setThing_category("IDEA");*/
        //myThing.setmImageResourceId(R.drawable.restaurant_icon);
        final MyThingDbHelper dbHelper = new MyThingDbHelper(this);
        thingList = dbHelper.getAllThings();


        for (int i=0; i< thingList.size(); i++){
            MyThing myThing = thingList.get(i);
             if (myThing.getThing_category_id() == 1){
                 myThing.setmImageResourceId(R.drawable.idea_ico);
             }else if (myThing.getThing_category_id() == 2){
                 myThing.setmImageResourceId(R.drawable.place_icon);
             }else if (myThing.getThing_category_id() == 3){
                 myThing.setmImageResourceId(R.drawable.food_icon);
             }else if (myThing.getThing_category_id() == 4){
                 myThing.setmImageResourceId(R.drawable.movie_icon);
             }else if (myThing.getThing_category_id() == 5){
                 myThing.setmImageResourceId(R.drawable.music_icon);
             }else if (myThing.getThing_category_id() == 6){
                 myThing.setmImageResourceId(R.drawable.person_icon);
             }else if (myThing.getThing_category_id() == 7){
                 myThing.setmImageResourceId(R.drawable.book_icon);
             }else if (myThing.getThing_category_id() == 8){
                 myThing.setmImageResourceId(R.drawable.product_icon);
             }else if (myThing.getThing_category_id() == 9){
                 myThing.setmImageResourceId(R.drawable.restaurant_icon);
             }
        }

        listView = (ListView) findViewById(R.id.listview_things);
        final Activity a = this;
        if (thingList.size() == 0){
            Toast.makeText(getApplicationContext(), "No things available in the list!", Toast.LENGTH_SHORT).show();
            filterIcon.setVisibility(View.GONE);
            filterEditText.setVisibility(View.GONE);
            noThingsLinearLayout.setVisibility(View.VISIBLE);
            /*MyThing thing = new MyThing();
            thing.setThing_name("No things available");
            thing.setDate("");
            thing.setThing_category("Click on the add button");
            thing.setThing_category_id(1);
            thing.setThing_description("");
            thingList.add(thing);
            MyThingAdapter thingAdapter = new MyThingAdapter(a, thingList);
            listView.setAdapter(thingAdapter);*/

            return;
        }
        final MyThingAdapter thingAdapter = new MyThingAdapter(this, thingList);

        listView = (ListView) findViewById(R.id.listview_things);
        listView.setAdapter(thingAdapter);
        //listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);


        filterEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                thingList = dbHelper.getFilterdThings(s);
                for (int i=0; i< thingList.size(); i++){
                    MyThing myThing = thingList.get(i);
                    if (myThing.getThing_category_id() == 1){
                        myThing.setmImageResourceId(R.drawable.idea_ico);
                    }else if (myThing.getThing_category_id() == 2){
                        myThing.setmImageResourceId(R.drawable.place_icon);
                    }else if (myThing.getThing_category_id() == 3){
                        myThing.setmImageResourceId(R.drawable.food_icon);
                    }else if (myThing.getThing_category_id() == 4){
                        myThing.setmImageResourceId(R.drawable.movie_icon);
                    }else if (myThing.getThing_category_id() == 5){
                        myThing.setmImageResourceId(R.drawable.music_icon);
                    }else if (myThing.getThing_category_id() == 6){
                        myThing.setmImageResourceId(R.drawable.person_icon);
                    }else if (myThing.getThing_category_id() == 7){
                        myThing.setmImageResourceId(R.drawable.book_icon);
                    }else if (myThing.getThing_category_id() == 8){
                        myThing.setmImageResourceId(R.drawable.product_icon);
                    }else if (myThing.getThing_category_id() == 9){
                        myThing.setmImageResourceId(R.drawable.restaurant_icon);
                    }
                }

                if (thingList.size() == 0){
                    Toast.makeText(getApplicationContext(), "No things available in the list!", Toast.LENGTH_SHORT).show();
                    MyThing thing = new MyThing();
                    thing.setThing_name("No things available");
                    thing.setDate("");
                    thing.setThing_category("Click on the add button");
                    thing.setThing_category_id(1);
                    thing.setThing_description("");
                    thingList.add(thing);
                    MyThingAdapter thingAdapter = new MyThingAdapter(a, thingList);
                    listView.setAdapter(thingAdapter);
                    return;
                }

                MyThingAdapter thingAdapter = new MyThingAdapter(a, thingList);
                listView.setAdapter(thingAdapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MyThing myThing = (MyThing) listView.getItemAtPosition(position);
                thing_id = myThing.getId();

                Intent intent = new Intent(ThingsActivity.this , ViewThingInfoActivity.class);
                intent.putExtra("thing_id",thing_id);
                startActivity(intent);
                finish();

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                MyThing myThing = (MyThing) listView.getItemAtPosition(position);
                thing_id = myThing.getId();
                cat_id = myThing.getThing_category_id();
                showMenu(view);
                //actionBar = getSupportActionBar();
                //actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                //actionBar.setCustomView(R.layout.delete_edit_btn_on_actionbar_layout);

                //listView.getSelectedItemPosition();
                //listView.setItemChecked(position, true);
                //listView.setOnItemClickListener(null);
                return true;
            }
        });



    }

    public void showMenu(View v){
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.mymenu,popup.getMenu());
        Menu item = popup.getMenu();
        item.getItem(0).setIcon(R.drawable.edit);
        item.getItem(1).setIcon(R.drawable.delete);
        popup.show();

    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {

        if (item.getTitle().equals("Delete")){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Confirm delete?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            MyThingDbHelper dbHelper = new MyThingDbHelper(ThingsActivity.this);
                            boolean deleted = dbHelper.deleteThing(thing_id);
                            if (deleted){
                                Toast.makeText(ThingsActivity.this, "Deleted successfully",Toast.LENGTH_SHORT).show();

                                startActivity(getIntent());
                                finish();
                            }else{
                                Toast.makeText(ThingsActivity.this, "Failed to delete! Something went wrong",Toast.LENGTH_SHORT).show();
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


        }else if (item.getTitle().equals("Edit")){
            Intent intent = new Intent(ThingsActivity.this, UpdateInfoActivity.class);
            intent.putExtra("id", thing_id);
            intent.putExtra("cat_id",cat_id);

            startActivity(intent);
            finish();
        }
        return false;
    }

    public void AddThingFab(View view) {
        Intent intent = new Intent(ThingsActivity.this, CategoryActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            finish();
        }else {
            Toast.makeText(this, "Press back again to finish",Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();

    }
}
