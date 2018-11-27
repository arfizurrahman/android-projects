package com.example.arfiz.notificationservicetestapp;


import android.content.Context;
import android.content.SharedPreferences;

public class Preference {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    String PREFERENCE_NAME = "db_application_code";
    String WHATSAPP_CODE = "whatsapp";
    String FACEBOOK_CODE = "facebook";
    String MESSENGER_CODE = "messenger";
    String INSTAGRAM_CODE = "instagram";
    String GMAIL_CODE = "gmail";
    String VIBER_CODE = "viber";
    String SMS_CODE = "sms";
    String IMO_CODE = "imo";

    public Preference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveFacebookCode(int facebook_code){
        editor.putInt(FACEBOOK_CODE,facebook_code);
        editor.commit();
    }
    public void saveWhatsappCode(int whatsapp_code){
        editor.putInt(WHATSAPP_CODE,whatsapp_code);
        editor.commit();
    }
    public void saveMessengerCode(int messenger_code){
        editor.putInt(MESSENGER_CODE,messenger_code);
        editor.commit();
    }
    public void saveInstagramCode(int insta_code){
        editor.putInt(INSTAGRAM_CODE,insta_code);
        editor.commit();
    }

    public void saveImoCode(int imo_code){
        editor.putInt(IMO_CODE,imo_code);
        editor.commit();
    }
    public void saveGmailCode(int gmail_code){
        editor.putInt(GMAIL_CODE,gmail_code);
        editor.commit();
    }
    public void saveViberCode(int viber_code){
        editor.putInt(VIBER_CODE,viber_code);
        editor.commit();
    }
    public void saveSmsCode(int sms_code){
        editor.putInt(SMS_CODE,sms_code);
        editor.commit();
    }


    public int retrieveFacebookCode(){
        int fb_code = sharedPreferences.getInt(FACEBOOK_CODE,NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
        return fb_code;
    }
    public int retrieveMessengerCode(){
        int messenger_code = sharedPreferences.getInt(MESSENGER_CODE,NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
        return messenger_code;
    }
    public int retrieveWhatsappCode(){
        int whatsapp_code = sharedPreferences.getInt(WHATSAPP_CODE,NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
        return whatsapp_code;
    }
    public int retrieveInstagramCode(){
        int instagram_code = sharedPreferences.getInt(INSTAGRAM_CODE,NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
        return instagram_code;
    }
    public int retrieveImoCode(){
        int imo_code = sharedPreferences.getInt(IMO_CODE,NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
        return imo_code;
    }
    public int retrieveGmailCode(){
        int gmail_code = sharedPreferences.getInt(GMAIL_CODE,NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
        return gmail_code;
    }
    public int retrieveViberCode(){
        int viber_code = sharedPreferences.getInt(VIBER_CODE,NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
        return viber_code;
    }
    public int retrieveSmsCode(){
        int sms_code = sharedPreferences.getInt(SMS_CODE,NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
        return sms_code;
    }


}
