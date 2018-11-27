package com.example.arfiz.mythings;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.arfiz.mythings.MyThingContract.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class MyThingDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyThings.db";

    public static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public MyThingDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_THINGS_TABLE = "CREATE TABLE "+
                ThingsTable.TABLE_NAME + "(" +
                ThingsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ThingsTable.COLUMN_THING_NAME + " TEXT UNIQUE, "+
                ThingsTable.COLUMN_THING_DESCRIPTION + " TEXT, "+
                ThingsTable.COLUMN_THING_CATEGORY_ID + " INTEGER, "+
                ThingsTable.COLUMN_DATE + " TEXT, "+
                ThingsTable.COLUMN_IMAGE + " BLOB "+
                ")";
        db.execSQL(SQL_CREATE_THINGS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertThings(MyThing myThing){

        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ThingsTable.COLUMN_THING_NAME, myThing.getThing_name());
        cv.put(ThingsTable.COLUMN_THING_DESCRIPTION, myThing.getThing_description());
        cv.put(ThingsTable.COLUMN_THING_CATEGORY_ID, myThing.getThing_category_id());
        cv.put(ThingsTable.COLUMN_IMAGE, myThing.getImagebyte());
        cv.put(ThingsTable.COLUMN_DATE, myThing.getDate());
        long rowInserted = db.insert(ThingsTable.TABLE_NAME, null,cv);
        long a = rowInserted;
        return rowInserted;
    }

    public List<MyThing> getAllThings() {

        List<MyThing> thingList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + ThingsTable.TABLE_NAME + " ORDER BY _id DESC", null);

        if (c.moveToFirst()){
            do {
                MyThing myThing = new MyThing();
                myThing.setThing_name(c.getString(c.getColumnIndex(ThingsTable.COLUMN_THING_NAME)));
                myThing.setThing_description(c.getString(c.getColumnIndex(ThingsTable.COLUMN_THING_DESCRIPTION)));
                myThing.setThing_category_id(c.getInt(c.getColumnIndex(ThingsTable.COLUMN_THING_CATEGORY_ID)));
                myThing.setDate(c.getString(c.getColumnIndex(ThingsTable.COLUMN_DATE)));
                int cat_id = myThing.getThing_category_id();
                myThing.setThing_category(getThingCategory(cat_id).toUpperCase());
                myThing.setId(c.getInt(c.getColumnIndex("_id")));
                thingList.add(myThing);
            } while (c.moveToNext());
        }

        c.close();
        return thingList;
    }



    public String getThingCategory (int category_id) {
        String category = "";
        switch (category_id){
            case 1:
                category = "Idea";
                break;
            case 2:
                category = "Place";
                break;
            case 3:
                category = "Food";
                break;
            case 4:
                category = "Movie";
                break;
            case 5:
                category = "Music";
                break;
            case 6:
                category = "Person";
                break;
            case 7:
                category = "Product";
                break;
            case 8:
                category = "Product";
                break;
            case 9:
                category = "Restaurant";
                break;
        }
        return category;
    }

    public List<MyThing> getFilterdThings(CharSequence param) {
        int category_id = getCategoryIdByCatSequence(param);

        List<MyThing> filterdThingList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + ThingsTable.TABLE_NAME + " WHERE " + ThingsTable.COLUMN_THING_NAME + " LIKE '%"+param+"%' OR "+ ThingsTable.COLUMN_THING_CATEGORY_ID + " = " + category_id + " ORDER BY _id DESC", null);

        if (c.moveToFirst()){
            do {
                MyThing myThing = new MyThing();
                myThing.setThing_name(c.getString(c.getColumnIndex(ThingsTable.COLUMN_THING_NAME)));
                myThing.setThing_description(c.getString(c.getColumnIndex(ThingsTable.COLUMN_THING_DESCRIPTION)));
                myThing.setThing_category_id(c.getInt(c.getColumnIndex(ThingsTable.COLUMN_THING_CATEGORY_ID)));
                myThing.setDate(c.getString(c.getColumnIndex(ThingsTable.COLUMN_DATE)));
                int cat_id = myThing.getThing_category_id();
                myThing.setThing_category(getThingCategory(cat_id).toUpperCase());
                myThing.setId(c.getInt(c.getColumnIndex("_id")));
                filterdThingList.add(myThing);
            } while (c.moveToNext());
        }

        c.close();
        return filterdThingList;
    }

    public int getCategoryIdByCatSequence(CharSequence param) {
        int id = 0;
        if ("idea".contains(param)){
            id = 1;
        }else if ("place".contains(param)){
            id = 2;
        }else if ("food".contains(param)){
            id = 3;
        }else if ("movie".contains(param)){
            id = 4;
        }else if ("music".contains(param)){
            id = 5;
        }else if ("person".contains(param)){
            id = 6;
        }else if ("book".contains(param)){
            id = 7;
        }else if ("product".contains(param)){
            id = 8;
        }else if ("restaurant".contains(param)){
            id = 9;
        }
        return id;
    }

    public boolean deleteThing(int thing_id) {
        db = getWritableDatabase();
        return db.delete(ThingsTable.TABLE_NAME,ThingsTable._ID + " =?" ,new String[]{String.valueOf(thing_id)}) > 0;
    }


    public MyThing getThingInfoById(int thing_id){
        MyThing myThing = new MyThing();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + ThingsTable.TABLE_NAME + " WHERE " + ThingsTable._ID + " = " +thing_id, null);

        if (c.moveToFirst()){
            do {
                myThing.setThing_name(c.getString(c.getColumnIndex(ThingsTable.COLUMN_THING_NAME)));
                myThing.setThing_description(c.getString(c.getColumnIndex(ThingsTable.COLUMN_THING_DESCRIPTION)));
                myThing.setThing_category_id(c.getInt(c.getColumnIndex(ThingsTable.COLUMN_THING_CATEGORY_ID)));
                myThing.setDate(c.getString(c.getColumnIndex(ThingsTable.COLUMN_DATE)));
                //Blob blob = c.getBlob(c.getColumnIndex(ThingsTable.COLUMN_IMAGE));

                //int blobLength = (int) blob.length();
               // byte[] blobAsBytes = blob.getBytes(1, blobLength);

//release the blob and free up memory. (since JDBC 4.0)
                //blob.free();
                myThing.setImagebyte(c.getBlob(c.getColumnIndex(ThingsTable.COLUMN_IMAGE)));
                int cat_id = myThing.getThing_category_id();
                myThing.setThing_category(getThingCategory(cat_id).toUpperCase());
                myThing.setId(c.getInt(c.getColumnIndex("_id")));
            } while (c.moveToNext());
        }
        c.close();
        return myThing;

    }

    public long updateInfo(MyThing myThing){
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        int id = myThing.getId();
        cv.put(ThingsTable.COLUMN_THING_NAME, myThing.getThing_name());
        cv.put(ThingsTable.COLUMN_THING_DESCRIPTION, myThing.getThing_description());
        cv.put(ThingsTable.COLUMN_IMAGE, myThing.getImagebyte());
        long rowUpdated = db.update(ThingsTable.TABLE_NAME,cv,ThingsTable._ID + " = " + id,null);
        return rowUpdated;
    }

    public boolean checkIfInfoExists(MyThing thing) {
        Cursor c = null;
        String name = thing.getThing_name();
        int cat_id = thing.getThing_category_id();
        db = getReadableDatabase();
        String sql = "SELECT * FROM " + ThingsTable.TABLE_NAME + " WHERE " + ThingsTable.COLUMN_THING_NAME + " = '" +name+"' AND "+ThingsTable.COLUMN_THING_CATEGORY_ID+" = "+ cat_id;
        c = db.rawQuery(sql, null);

        if (c.getCount() <= 0){
            c.close();
            return false;
        }
        c.close();
        return true;
    }

    public boolean checkIfDataExists(MyThing thing) {
        Cursor c = null;
        String name = thing.getThing_name();
        int cat_id = thing.getThing_category_id();
        db = getReadableDatabase();
        String sql = "SELECT * FROM " + ThingsTable.TABLE_NAME + " WHERE " + ThingsTable.COLUMN_THING_NAME + " = '" +name+"' AND "+ThingsTable.COLUMN_THING_CATEGORY_ID+" = "+ cat_id + " AND "+ThingsTable._ID+" != "+ thing.getId();
        c = db.rawQuery(sql, null);

        if (c.getCount() <= 0){
            c.close();
            return false;
        }
        c.close();
        return true;
    }
}
