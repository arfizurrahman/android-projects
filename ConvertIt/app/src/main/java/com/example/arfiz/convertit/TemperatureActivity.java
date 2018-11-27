package com.example.arfiz.convertit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TemperatureActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView fromET;
    TextView toET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        // Spinner element
        final Spinner fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
        final Spinner toSpinner = (Spinner) findViewById(R.id.toSpinner);

        //EditText
        fromET = (TextView) findViewById(R.id.fromEditText);
        toET = (TextView) findViewById(R.id.toTextView);

        // Spinner click listener
        fromSpinner.setOnItemSelectedListener(this);
        toSpinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Celsius");
        categories.add("Kelvin");
        categories.add("Fahrenheit");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        fromSpinner.setAdapter(dataAdapter);
        toSpinner.setAdapter(dataAdapter);




        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                long fromId = fromSpinner.getSelectedItemId();
                long toId = toSpinner.getSelectedItemId();

                String fromText = fromET.getText().toString();
                String toText = toET.getText().toString();
                if (fromText.matches("")){
                    return;
                }

                if (fromId == toId){
                    String from = fromET.getText().toString();
                    toET.setText(from);
                }else if(fromId == 0){
                    if (toId == 1){
                        String from = fromET.getText().toString();
                        double kelvin = Double.parseDouble(from)+273.15;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(kelvin));
                        toET.setText(kl);
                    }else if(toId == 2){
                        String from = fromET.getText().toString();
                        double cel = Double.parseDouble(from);
                        double far = cel * 1.8 + 32;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String fr = String.valueOf(df.format(far));
                        toET.setText(fr);
                    }
                }else if(fromId == 1){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double celsius = Double.parseDouble(from)-273.15;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String cl = String.valueOf(df.format(celsius));
                        toET.setText(cl);
                    }else if(toId == 2){
                        String from = fromET.getText().toString();
                        double kel = Double.parseDouble(from);
                        double far = kel * 9/5 - 459.67;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String fr = String.valueOf(df.format(far));
                        toET.setText(fr);
                    }
                }else if(fromId == 2){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double far = Double.parseDouble(from);
                        double celsius = (far-32)/1.8;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String cl = String.valueOf(df.format(celsius));
                        toET.setText(cl);
                    }else if(toId == 1){
                        String from = fromET.getText().toString();
                        double far = Double.parseDouble(from);
                        double kelvin = (far + 459.67)* 5/9;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(kelvin));
                        toET.setText(kl);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                long fromId = fromSpinner.getSelectedItemId();
                long toId = toSpinner.getSelectedItemId();

                String fromText = fromET.getText().toString();
                String toText = toET.getText().toString();
                if (fromText.matches("")){
                    return;
                }

                if (fromId == toId){
                    String from = fromET.getText().toString();
                    toET.setText(from);
                }else if(toId == 0){
                    if (fromId == 1){
                        String from = fromET.getText().toString();
                        double kelvin = Double.parseDouble(from)-273.15;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(kelvin));
                        toET.setText(kl);
                    }else if(fromId == 2){
                        String from = fromET.getText().toString();
                        double far = Double.parseDouble(from);
                        double celsius = (far-32)/1.8;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String cl = String.valueOf(df.format(celsius));
                        toET.setText(cl);
                    }
                }else if(toId == 1){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double celsius = Double.parseDouble(from)+273.15;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String cl = String.valueOf(df.format(celsius));
                        toET.setText(cl);
                    }else if(fromId == 2){
                        String from = fromET.getText().toString();
                        double far = Double.parseDouble(from)+(-459.67);
                        DecimalFormat df = new DecimalFormat("#.########");
                        String fr = String.valueOf(df.format(far));
                        toET.setText(fr);
                    }
                }else if(toId == 2){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double celsius = Double.parseDouble(from);
                        double cel = celsius * 1.8 + 32;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String cl = String.valueOf(df.format(cel));
                        toET.setText(cl);
                    }else if(fromId == 1){
                        String from = fromET.getText().toString();
                        double far = Double.parseDouble(from);
                        double kelvin = (far + 459.67)* 5/9;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(kelvin));
                        toET.setText(kl);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        fromET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                long fromId = fromSpinner.getSelectedItemId();
                long toId = toSpinner.getSelectedItemId();

                String fromText = fromET.getText().toString();
                String toText = toET.getText().toString();
                if (fromText.matches("")){
                    toET.setText("");
                    return;
                }
                if (fromId == toId){
                    String from = fromET.getText().toString();
                    toET.setText(from);
                }else if(fromId == 0){
                    if (toId == 1){
                        String from = fromET.getText().toString();
                        double kelvin = Double.parseDouble(from)+273.15;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(kelvin));
                        toET.setText(kl);
                    }else if(toId == 2){
                        String from = fromET.getText().toString();
                        double cel = Double.parseDouble(from);
                        double far = cel * 1.8 + 32;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String fr = String.valueOf(df.format(far));
                        toET.setText(fr);
                    }
                }else if(fromId == 1){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double celsius = Double.parseDouble(from)-273.15;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String cl = String.valueOf(df.format(celsius));
                        toET.setText(cl);
                    }else if(toId == 2){
                        String from = fromET.getText().toString();
                        double kel = Double.parseDouble(from);
                        double far = kel * 9/5 - 459.67;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String fr = String.valueOf(df.format(far));
                        toET.setText(fr);
                    }
                }else if(fromId == 2){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double far = Double.parseDouble(from);
                        double celsius = (far-32)/1.8;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String cl = String.valueOf(df.format(celsius));
                        toET.setText(cl);
                    }else if(toId == 1){
                        String from = fromET.getText().toString();
                        double far = Double.parseDouble(from);
                        double kelvin = (far + 459.67)* 5/9;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(kelvin));
                        toET.setText(kl);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        // On selecting a spinner item
        //String item = parent.getItemAtPosition(position).toString();


        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void Zero(View view) {

        fromET.setText(fromET.getText()+"0");
    }
    public void One(View view) {
        fromET.setText(fromET.getText()+"1");
    }
    public void Two(View view) {
        fromET.setText(fromET.getText()+"2");
    }
    public void Three(View view) {
        fromET.setText(fromET.getText()+"3");
    }
    public void Four(View view) {
        fromET.setText(fromET.getText()+"4");
    }
    public void Five(View view) {
        fromET.setText(fromET.getText()+"5");
    }
    public void Six(View view) {
        fromET.setText(fromET.getText()+"6");
    }
    public void Seven(View view) {
        fromET.setText(fromET.getText()+"7");
    }
    public void Eight(View view) {
        fromET.setText(fromET.getText()+"8");
    }
    public void Nine(View view) {
        fromET.setText(fromET.getText()+"9");
    }
    public void Minus(View view) {
        String text = fromET.getText().toString();
        if (text.length()>0){
            return;
        }
        fromET.setText(fromET.getText()+"-");
    }
    public void Dot(View view) {
        String text = fromET.getText().toString();
        if (text.contains(".")){
            return;
        }
        fromET.setText(fromET.getText()+".");
    }
    public void Back(View view) {
        String text = fromET.getText().toString();
        if (!text.matches("") && text.length()>0){
            text = text.substring(0, text.length()-1);
            fromET.setText(text);
        }else {
            return;
        }

    }
    public void Clear(View view) {
        fromET.setText("");
    }
}
