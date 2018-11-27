package com.example.arfiz.notificationservicetestapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Telephony;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

public class NotificationListenerExampleService extends NotificationListenerService {


    Preference preference;
    /*
        These are the package names of the apps. for which we want to
        listen the notifications
     */
    private static final class ApplicationPackageNames {
        public static final String FACEBOOK_PACK_NAME = "com.facebook.katana";
        public static final String FACEBOOK_MESSENGER_PACK_NAME = "com.facebook.orca";
        public static final String WHATSAPP_PACK_NAME = "com.whatsapp";
        public static final String VIBER_PACK_NAME = "com.viber.voip";
        public static final String IMO_PACK_NAME = "com.imo.android.imoim";
        public static final String INSTAGRAM_PACK_NAME = "com.instagram.android";
        public static final String GMAIL_PACK_NAME = "com.google.android.gm";
        public static final String SMS_PACK_NAME = "com.android.mms";
    }

    /*
        These are the return codes we use in the method which intercepts
        the notifications, to decide whether we should do something or not
     */
    public static final class InterceptedNotificationCode {
        public static final int FACEBOOK_CODE = 1;
        public static final int WHATSAPP_CODE = 2;
        public static final int INSTAGRAM_CODE = 3;
        public static final int MESSENGER_CODE = 4;
        public static final int IMO_CODE = 5;
        public static final int GMAIL_CODE = 7;
        public static final int VIBER_CODE = 8;
        public static final int SMS_CODE = 9;
        public static final int OTHER_NOTIFICATIONS_CODE = 10; // We ignore all notification with code == 10
    }

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn){

        int notificationCode =  matchNotificationCode(sbn);

        Bundle extras = sbn.getNotification().extras;

        String title = sbn.getNotification().extras.getString("android.title");
        String text = extras.getCharSequence("android.text").toString();

        String txt;

        if ((notificationCode != InterceptedNotificationCode.MESSENGER_CODE) || (notificationCode != InterceptedNotificationCode.FACEBOOK_CODE)){
            txt = title + " sent "+ text;
        }else {
            txt = "";
        }

        if(notificationCode != InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE){
            Intent intent = new  Intent("com.example.arfiz.notificationservicetestapp");
            intent.putExtra("Notification Code", notificationCode);
            intent.putExtra("text",txt);
            sendBroadcast(intent);
        }
    }

//    @Override
//    public void onNotificationRemoved(StatusBarNotification sbn){
//        int notificationCode = matchNotificationCode(sbn);
//
//
//        Bundle extras = sbn.getNotification().extras;
//
//        String title = sbn.getNotification().extras.getString("android.title");
//        String text = extras.getCharSequence("android.text").toString();
//        String txt;
//
//        if ((notificationCode != InterceptedNotificationCode.MESSENGER_CODE) || (notificationCode != InterceptedNotificationCode.FACEBOOK_CODE)){
//            txt = title + " sent "+ text;
//        }else {
//            txt = "";
//        }
//
//        if(notificationCode != InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE) {
//
//            StatusBarNotification[] activeNotifications = this.getActiveNotifications();
//
//            if(activeNotifications != null && activeNotifications.length > 0) {
//                for (int i = 0; i < activeNotifications.length; i++) {
//                    if (notificationCode == matchNotificationCode(activeNotifications[i])) {
//                        Intent intent = new  Intent("com.example.arfiz.notificationservicetestapp");
//                        intent.putExtra("Notification Code", notificationCode);
//                        intent.putExtra("text",txt);
//                        sendBroadcast(intent);
//                        break;
//                    }
//                }
//            }
//        }
//    }


    private int matchNotificationCode(StatusBarNotification sbn) {
        preference = new Preference(this);
        String packageName = sbn.getPackageName();


        if((preference.retrieveFacebookCode() != InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE ) &&
                (packageName.equals(ApplicationPackageNames.FACEBOOK_PACK_NAME))){
            return(InterceptedNotificationCode.FACEBOOK_CODE);
        }
        else if((preference.retrieveInstagramCode() != InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE)&&
                (packageName.equals(ApplicationPackageNames.INSTAGRAM_PACK_NAME))){
            return(InterceptedNotificationCode.INSTAGRAM_CODE);
        }
        else if((preference.retrieveWhatsappCode() != InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE)&&
                (packageName.equals(ApplicationPackageNames.WHATSAPP_PACK_NAME))){

            return(InterceptedNotificationCode.WHATSAPP_CODE);
        }
        else if((preference.retrieveMessengerCode() != InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE)&&
                (packageName.equals(ApplicationPackageNames.FACEBOOK_MESSENGER_PACK_NAME))){
            return(InterceptedNotificationCode.MESSENGER_CODE);
        }
        else if((preference.retrieveImoCode() != InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE)&&
                (packageName.equals(ApplicationPackageNames.IMO_PACK_NAME))){
            return(InterceptedNotificationCode.IMO_CODE);
        }
        else if((preference.retrieveGmailCode() != InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE)&&
                (packageName.equals(ApplicationPackageNames.GMAIL_PACK_NAME))){
            return(InterceptedNotificationCode.GMAIL_CODE);
        }
        else if((preference.retrieveViberCode() != InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE)&&
                (packageName.equals(ApplicationPackageNames.VIBER_PACK_NAME))){
            return(InterceptedNotificationCode.VIBER_CODE);
        }
        else if((preference.retrieveSmsCode() != InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE)&&
                (packageName.equals(ApplicationPackageNames.SMS_PACK_NAME))){
            return(InterceptedNotificationCode.SMS_CODE);
        }
        else{
            return(InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
        }
    }

}
