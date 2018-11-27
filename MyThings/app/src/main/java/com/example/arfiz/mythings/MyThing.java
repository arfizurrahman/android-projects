package com.example.arfiz.mythings;

public class MyThing {
    private String thing_name;
    private String thing_description;
    private int thing_category_id;
    private String added_on_date;
    private String thing_category;
    private int id;
    private int mImageResourceId;
    private byte[] imagebyte;


    public MyThing() {}

    public MyThing(String thing_name, String thing_description, int thing_category_id, String added_on_date, byte[] imagebyte) {
        this.thing_name = thing_name;
        this.thing_description = thing_description;
        this.thing_category_id = thing_category_id;
        this.added_on_date = added_on_date;
        this.imagebyte = imagebyte;
    }


    public String getThing_name() {
        return thing_name;
    }

    public void setThing_name(String thing_name) {
        this.thing_name = thing_name;
    }

    public String getThing_description() {
        return thing_description;
    }

    public void setThing_description(String thing_description) {
        this.thing_description = thing_description;
    }

    public String getDate() {
        return added_on_date;
    }

    public void setDate(String added_on_date) {
        this.added_on_date = added_on_date;
    }

    public int getThing_category_id() {
        return thing_category_id;
    }

    public void setThing_category_id(int thing_category_id) {
        this.thing_category_id = thing_category_id;
    }

    public String getThing_category() {
        return thing_category;
    }

    public void setThing_category(String thing_category) {
        this.thing_category = thing_category;
    }

    public int getId(){ return id; }
    public void setId (int id){
        this.id = id;
    }

    public int getmImageResourceId(){ return mImageResourceId; }
    public void setmImageResourceId (int mImageResourceId){
        this.mImageResourceId = mImageResourceId;
    }

    public byte[] getImagebyte(){
        return imagebyte;
    }
    public void setImagebyte(byte[] imagebyte){
        this.imagebyte = imagebyte;
    }


}
