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

public class LengthActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView fromET;
    TextView toET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

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
        categories.add("Meter");
        categories.add("Kilometer");
        categories.add("Centimeter");
        categories.add("Milimeter");
        categories.add("Micrometer");
        categories.add("Nanometer");
        categories.add("Mile");
        categories.add("Yard");
        categories.add("Foot");
        categories.add("Inch");

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
                }else if (fromId == 0){
                    if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*100;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0006213689;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1.0936132983;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*3.280839895;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*39.37007874;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 1){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*100000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000000000.0;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.6213688756;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1093.6132983;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*3280.839895;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*39370.07874;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 2){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.01;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.00001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*10;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*10000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*10000000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000062137;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.010936133;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.032808399;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.3937007874;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 3){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.000001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.1;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(6.2137 * Math.pow(10,-7));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0010936133;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0032808399;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0393700787;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 4){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.000001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.000000001;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(6.2137 * Math.pow(10,-10));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000010936;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000032808;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000393701;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 5){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*Math.pow(10,-9);
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*Math.pow(10,-12);
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*Math.pow(10,-7);
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.000001;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(6.2137 * Math.pow(10,-13));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(1.0937 * Math.pow(10,-9));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(3.28084 * Math.pow(10,-9));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(3.937 * Math.pow(10,-8));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 6){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1609.35;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1.60935;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*160935;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1609350;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1609350000;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1609350000000.0;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1760.0065617;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*5280.019685;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*63360.23622;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 7){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.9144;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0009144;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*91.44;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*914.4;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*914400;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*914400000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0005681797;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*3;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*36;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 8){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.3048;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0003048;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*30.48;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*304.8;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*304800;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*304800000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0001893932;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.3333333333;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*12;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 9){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0254;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000254;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*2.54;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*25.4;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*25400;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*25400000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000157828;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0277777778;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0833333333;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
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

                if (toId == fromId){
                    String from = fromET.getText().toString();
                    toET.setText(from);
                }else if (toId == 0){
                    if (fromId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.01;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.000001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*Math.pow(10,-9);
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1609.35;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.9144;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.3048;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0254;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (toId == 1){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.00001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.000001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*Math.pow(10,-9);
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*Math.pow(10,-12);
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1.60935;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0009144;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0003048;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000254;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (toId == 2){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*100;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*100000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.1;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0001;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*Math.pow(10,-7);
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*160935;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*91.44;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*30.48;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*2.54;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (toId == 3){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.######");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000;
                        DecimalFormat df = new DecimalFormat("#.#####");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*10;
                        DecimalFormat df = new DecimalFormat("#.######");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.000001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1609350;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*914.4;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*304.8;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*25.4;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (toId == 4){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000000;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*10000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.######");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.######");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1609350000;
                        DecimalFormat df = new DecimalFormat("#.#######");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*914400;
                        DecimalFormat df = new DecimalFormat("#.#######");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*304800;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*25400;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (toId == 5){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000000000.0;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*10000000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1609350000000.0;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*914400000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*304800000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*25400000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (toId == 6){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0006213689;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.6213688756;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000062137;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(6.2137*Math.pow(10,-7));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(6.2137*Math.pow(10,-10));
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(6.2137*Math.pow(10,-13));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0005681797;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0001893932;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000157828;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (toId == 7){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1.0936132983;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1093.6132983;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.010936133;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0010936133;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000010936;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(1.0936*Math.pow(10,-9));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1760.0065617;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.3333333333;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0277777778;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (toId == 8){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*3.280839895;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*3280.839895;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.032808399;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0032808399;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000032808;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(3.2808*Math.pow(10,-9));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*5280.019685;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*3;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0833333333;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (toId == 9){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*39.37007874;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*39370.07874;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.3937007874;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0393700787;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000393701;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(3.937007874*Math.pow(10,-8));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*63360.23622;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*36;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (fromId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*12;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
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
                }else if (fromId == 0){
                    if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*100;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0006213689;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1.0936132983;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*3.280839895;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*39.37007874;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 1){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*100000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000000000.0;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.6213688756;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1093.6132983;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*3280.839895;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*39370.07874;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 2){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.01;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.00001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*10;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*10000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*10000000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000062137;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.010936133;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.032808399;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.3937007874;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 3){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.000001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.1;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(6.2137 * Math.pow(10,-7));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0010936133;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0032808399;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0393700787;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 4){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.000001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.000000001;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(6.2137 * Math.pow(10,-10));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000010936;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000032808;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000393701;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 5){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*Math.pow(10,-9);
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*Math.pow(10,-12);
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*Math.pow(10,-7);
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.000001;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(6.2137 * Math.pow(10,-13));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(1.0937 * Math.pow(10,-9));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(3.28084 * Math.pow(10,-9));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*(3.937 * Math.pow(10,-8));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 6){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1609.35;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1.60935;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*160935;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1609350;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1609350000;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1609350000000.0;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*1760.0065617;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*5280.019685;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*63360.23622;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 7){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.9144;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0009144;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*91.44;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*914.4;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*914400;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*914400000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0005681797;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*3;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*36;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 8){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.3048;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0003048;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*30.48;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*304.8;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*304800;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*304800000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0001893932;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.3333333333;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 9){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*12;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }
                }else if (fromId == 9){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0254;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000254;
                        DecimalFormat df = new DecimalFormat("#.#########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*2.54;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*25.4;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*25400;
                        DecimalFormat df = new DecimalFormat("#.###########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*25400000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0000157828;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 7){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0277777778;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
                        toET.setText(kl);
                    }else if (toId == 8){
                        String from = fromET.getText().toString();
                        double km = Double.parseDouble(from)*0.0833333333;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kl = String.valueOf(df.format(km));
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
