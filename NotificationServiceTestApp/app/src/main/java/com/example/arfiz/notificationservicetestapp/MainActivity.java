package com.example.arfiz.notificationservicetestapp;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Telephony;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech textToSpeech;
    TextView textView;

    Preference preference;

    private static final int READ_SMS_PERMISSIONS_REQUEST = 1;

    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final String ACTION_NOTIFICATION_LISTENER_SETTINGS = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS";
    private String text;

    private ImageView interceptedNotificationImageView;
    private NotificationReadBroadcastReceiver notificationReadBroadcastReceiver;
    private AlertDialog enableNotificationListenerAlertDialog;

    Switch whatsappSwitch, fbSwitch, messSwitch, instaSwitch, imoSwitch, gmailSwitch, smsSwitch, viberSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Notification Reader");


        preference = new Preference(this);

        initializeSwitches();

        checkOrUncheckSwitches();

        setSwitchOnCheckedChangeActions();

        checkForSMSPermission();

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if(status!= TextToSpeech.ERROR)
                {
                    textToSpeech.setLanguage(Locale.UK);
                }

            }

        });


        if(!isNotificationServiceEnabled()){
            enableNotificationListenerAlertDialog = buildNotificationServiceAlertDialog();
            enableNotificationListenerAlertDialog.show();
        }

        // Finally we register a receiver to tell the MainActivity when a notification has been received
        notificationReadBroadcastReceiver = new NotificationReadBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.arfiz.notificationservicetestapp");
        registerReceiver(notificationReadBroadcastReceiver,intentFilter);

    }

    private void checkForSMSPermission(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            getPermissionToReadSMS();
        }
    }

    public void getPermissionToReadSMS() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (shouldShowRequestPermissionRationale(
                        Manifest.permission.READ_SMS)) {
                    Toast.makeText(this, "Please allow permission!", Toast.LENGTH_SHORT).show();
                }
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.READ_SMS}, READ_SMS_PERMISSIONS_REQUEST);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(notificationReadBroadcastReceiver);
    }


    private void checkOrUncheckSwitches(){

        if (preference.retrieveFacebookCode() == NotificationListenerExampleService.InterceptedNotificationCode.FACEBOOK_CODE ){
            fbSwitch.setChecked(true);
        }
        if (preference.retrieveWhatsappCode() == NotificationListenerExampleService.InterceptedNotificationCode.WHATSAPP_CODE ){
            whatsappSwitch.setChecked(true);
        }
        if (preference.retrieveMessengerCode() == NotificationListenerExampleService.InterceptedNotificationCode.MESSENGER_CODE ){
            messSwitch.setChecked(true);
        }
        if (preference.retrieveImoCode() == NotificationListenerExampleService.InterceptedNotificationCode.IMO_CODE ){
            imoSwitch.setChecked(true);
        }
        if (preference.retrieveInstagramCode() == NotificationListenerExampleService.InterceptedNotificationCode.INSTAGRAM_CODE ){
            instaSwitch.setChecked(true);
        }
        if (preference.retrieveGmailCode() == NotificationListenerExampleService.InterceptedNotificationCode.GMAIL_CODE ){
            gmailSwitch.setChecked(true);
        }
        if (preference.retrieveSmsCode() == NotificationListenerExampleService.InterceptedNotificationCode.SMS_CODE ){
            smsSwitch.setChecked(true);
        }
        if (preference.retrieveViberCode() == NotificationListenerExampleService.InterceptedNotificationCode.VIBER_CODE ){
            viberSwitch.setChecked(true);
        }


    }

    private void setSwitchOnCheckedChangeActions(){

        whatsappSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (whatsappSwitch.isChecked()){
                    preference.saveWhatsappCode(NotificationListenerExampleService.InterceptedNotificationCode.WHATSAPP_CODE);
                }else {
                    preference.saveWhatsappCode(NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
                }

            }
        });
        fbSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (fbSwitch.isChecked()){
                    preference.saveFacebookCode(NotificationListenerExampleService.InterceptedNotificationCode.FACEBOOK_CODE);
                }else {
                    preference.saveFacebookCode(NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
                }

            }
        });
        messSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (messSwitch.isChecked()){
                    preference.saveMessengerCode(NotificationListenerExampleService.InterceptedNotificationCode.MESSENGER_CODE);
                }else {
                    preference.saveMessengerCode(NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
                }

            }
        });

        instaSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (instaSwitch.isChecked()){
                    preference.saveInstagramCode(NotificationListenerExampleService.InterceptedNotificationCode.INSTAGRAM_CODE);
                }else {
                    preference.saveInstagramCode(NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
                }
            }
        });

        imoSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (imoSwitch.isChecked()){
                    preference.saveImoCode(NotificationListenerExampleService.InterceptedNotificationCode.IMO_CODE);
                }else {
                    preference.saveImoCode(NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
                }

            }
        });
        gmailSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (gmailSwitch.isChecked()){
                    preference.saveGmailCode(NotificationListenerExampleService.InterceptedNotificationCode.GMAIL_CODE);
                }else {
                    preference.saveGmailCode(NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
                }

            }
        });
        viberSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (viberSwitch.isChecked()){
                    preference.saveViberCode(NotificationListenerExampleService.InterceptedNotificationCode.VIBER_CODE);
                }else {
                    preference.saveViberCode(NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
                }

            }
        });
        smsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (smsSwitch.isChecked()){
                    preference.saveSmsCode(NotificationListenerExampleService.InterceptedNotificationCode.SMS_CODE);
                }else {
                    preference.saveSmsCode(NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
                }

            }
        });
    }
    /**
     * Is Notification Service Enabled.
     * Verifies if the notification listener service is enabled.
     * Got it from: https://github.com/kpbird/NotificationListenerService-Example/blob/master/NLSExample/src/main/java/com/kpbird/nlsexample/NLService.java
     * @return True if eanbled, false otherwise.
     */
    private boolean isNotificationServiceEnabled(){
        String pkgName = getPackageName();
        final String flat = Settings.Secure.getString(getContentResolver(),
                ENABLED_NOTIFICATION_LISTENERS);
        if (!TextUtils.isEmpty(flat)) {
            final String[] names = flat.split(":");
            for (int i = 0; i < names.length; i++) {
                final ComponentName cn = ComponentName.unflattenFromString(names[i]);
                if (cn != null) {
                    if (TextUtils.equals(pkgName, cn.getPackageName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }



//    public void speackBtn(View view) {
//        String inputText = textView.getText().toString();
//        textToSpeech.speak(inputText, TextToSpeech.QUEUE_FLUSH,null);
//    }

    /**
     * Notification Read Broadcast Receiver.
     * We use this Broadcast Receiver to notify the Main Activity when
     * a new notification has arrived,
     * */
    public class NotificationReadBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {


            int receivedNotificationCode = intent.getIntExtra("Notification Code",
                        NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);

            text = intent.getStringExtra("text");


            setTextToSpeech(receivedNotificationCode,text);


        }
    }



    private void initializeSwitches(){

        whatsappSwitch = findViewById(R.id.whatsappSwitch);
        fbSwitch = findViewById(R.id.faceboookSwitch);
        messSwitch = findViewById(R.id.messengerSwitch);
        instaSwitch = findViewById(R.id.instagramSwitch);
        imoSwitch = findViewById(R.id.imoSwitch);
        gmailSwitch = findViewById(R.id.gmailSwitch);
        viberSwitch = findViewById(R.id.viberSwitch);
        smsSwitch = findViewById(R.id.smsSwitch);
    }

    public void setTextToSpeech(int notificationCode,String text){
        String preText = "You have a new message";
        switch(notificationCode){
            case NotificationListenerExampleService.InterceptedNotificationCode.FACEBOOK_CODE:
                textToSpeech.speak(preText + " in facebook. "+ text, TextToSpeech.QUEUE_FLUSH,null);
                break;
            case NotificationListenerExampleService.InterceptedNotificationCode.INSTAGRAM_CODE:
                textToSpeech.speak(preText + " in instagram. "+ text, TextToSpeech.QUEUE_FLUSH,null);
                break;
            case NotificationListenerExampleService.InterceptedNotificationCode.WHATSAPP_CODE:
                textToSpeech.speak(preText + " in whatsapp. "+ text, TextToSpeech.QUEUE_FLUSH,null);
                break;
            case NotificationListenerExampleService.InterceptedNotificationCode.MESSENGER_CODE:
                textToSpeech.speak(preText + " in messenger. "+ text, TextToSpeech.QUEUE_FLUSH,null);
                break;
            case NotificationListenerExampleService.InterceptedNotificationCode.IMO_CODE:
                textToSpeech.speak(preText + " in imo. "+ text, TextToSpeech.QUEUE_FLUSH,null);
                break;
            case NotificationListenerExampleService.InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE:
                textToSpeech.speak(preText + " in other. "+ text , TextToSpeech.QUEUE_FLUSH,null);
                break;
            case NotificationListenerExampleService.InterceptedNotificationCode.GMAIL_CODE:
                textToSpeech.speak(preText + " in gmail. "+ text , TextToSpeech.QUEUE_FLUSH,null);
                break;
            case NotificationListenerExampleService.InterceptedNotificationCode.VIBER_CODE:
                textToSpeech.speak(preText + " in viber. "+ text , TextToSpeech.QUEUE_FLUSH,null);
                break;
            case NotificationListenerExampleService.InterceptedNotificationCode.SMS_CODE:
                textToSpeech.speak(preText + " . "+ text , TextToSpeech.QUEUE_FLUSH,null);
                break;



        }
    }

    /**
     * Build Notification Listener Alert Dialog.
     * Builds the alert dialog that pops up if the user has not turned
     * the Notification Listener Service on yet.
     * @return An alert dialog which leads to the notification enabling screen
     */
    private AlertDialog buildNotificationServiceAlertDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(R.string.notification_listener_service);
        alertDialogBuilder.setMessage(R.string.notification_listener_service_explanation);
        alertDialogBuilder.setPositiveButton(R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(ACTION_NOTIFICATION_LISTENER_SETTINGS));
                    }
                });
        alertDialogBuilder.setNegativeButton(R.string.no,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // If you choose to not enable the notification listener
                        // the app. will not work as expected
                    }
                });
        return(alertDialogBuilder.create());
    }
}
