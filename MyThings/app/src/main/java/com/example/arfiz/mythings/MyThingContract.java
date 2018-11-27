package com.example.arfiz.mythings;

import android.provider.BaseColumns;

public final class MyThingContract {

    private MyThingContract(){};

    public final class ThingsTable implements BaseColumns{
        public static final String TABLE_NAME = "things";
        public static final String COLUMN_THING_NAME = "thing_name";
        public static final String COLUMN_THING_DESCRIPTION = "thing_description";
        public static final String COLUMN_THING_CATEGORY_ID = "thing_category_id";
        public static final String COLUMN_DATE= "date";
        public static final String COLUMN_IMAGE= "image";
    }
}
