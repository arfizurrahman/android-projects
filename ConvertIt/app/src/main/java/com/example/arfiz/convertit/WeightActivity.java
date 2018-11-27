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
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class WeightActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView fromET;
    TextView toET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);


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
        categories.add("Kilogram");
        categories.add("Gram");
        categories.add("Milligram");
        categories.add("Metric Ton");
        /*categories.add("Long Ton");
        categories.add("Short Ton");*/
        categories.add("Pound");
        categories.add("Ounce");
        categories.add("Carrat");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        fromSpinner.setAdapter(dataAdapter);
        toSpinner.setAdapter(dataAdapter);



        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String item = parent.getItemAtPosition(position).toString();

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
                        double gram = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*1000000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String ml = String.valueOf(df.format(mgram));
                        toET.setText(ml);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String mt = String.valueOf(df.format(metricTon));
                        toET.setText(mt);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*2.2046244202;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*35.273990723;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*5000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(fromId == 1){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.#####");
                        String ml = String.valueOf(df.format(mgram));
                        toET.setText(ml);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*0.000001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String mt = String.valueOf(df.format(metricTon));
                        toET.setText(mt);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*0.0022046244;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*0.0352739907;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*5;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(fromId == 2){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*Math.pow(10,-6);
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.######");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*(Math.pow(10,-9));
                        String mt = String.valueOf(metricTon);
                        toET.setText(mt);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*(2.205*Math.pow(10,-6));
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*0.000035274;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*0.005;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(fromId == 3){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*1000000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*1000000000;
                        DecimalFormat df = new DecimalFormat("#.#####");
                        String ml = String.valueOf(df.format(mgram));
                        toET.setText(ml);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*2204.6244202;
                        DecimalFormat df = new DecimalFormat("#.#######");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*35273.990723;
                        DecimalFormat df = new DecimalFormat("#.######");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*5000000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(fromId == 4){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*0.453592;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*453.592;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*453592;
                        DecimalFormat df = new DecimalFormat("#.#####");
                        String ml = String.valueOf(df.format(mgram));
                        toET.setText(ml);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*0.000453592;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String mt = String.valueOf(df.format(metricTon));
                        toET.setText(mt);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*16;
                        DecimalFormat df = new DecimalFormat("#.######");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*2267.96;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(fromId == 5){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*0.0283495;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*28.3495;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*28349.5;
                        DecimalFormat df = new DecimalFormat("#.#####");
                        String ml = String.valueOf(df.format(mgram));
                        toET.setText(ml);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*0.0000283495;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String mt = String.valueOf(df.format(metricTon));
                        toET.setText(mt);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*0.0625;
                        DecimalFormat df = new DecimalFormat("#.#######");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*141.7475;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(fromId == 6){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*0.0002;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*0.2;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*200;
                        DecimalFormat df = new DecimalFormat("#.#####");
                        String ml = String.valueOf(df.format(mgram));
                        toET.setText(ml);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*(2*Math.pow(10,-7));
                        DecimalFormat df = new DecimalFormat("#.########");
                        String mt = String.valueOf(df.format(metricTon));
                        toET.setText(mt);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*0.0004409249;
                        DecimalFormat df = new DecimalFormat("#.#######");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*0.0070547981;
                        DecimalFormat df = new DecimalFormat("#.######");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String item = parent.getItemAtPosition(position).toString();

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
                }else if(toId == 0){
                    if (fromId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*(Math.pow(10,-6));
                        String ml = String.valueOf(mgram);
                        toET.setText(ml);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String mt = String.valueOf(df.format(metricTon));
                        toET.setText(mt);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*0.453592;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (fromId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*0.0283495;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }else if (fromId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*0.0002;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(toId == 1){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.#####");
                        String ml = String.valueOf(df.format(mgram));
                        toET.setText(ml);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*1000000;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String mt = String.valueOf(df.format(metricTon));
                        toET.setText(mt);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*453.592;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (fromId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*28.3495;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }else if (fromId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*0.2;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(toId == 2){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*1000000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*1000000000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String mt = String.valueOf(df.format(metricTon));
                        toET.setText(mt);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*453592;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (fromId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*28349.5;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }else if (fromId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*200;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(toId == 3){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*0.000001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*(Math.pow(10,-9));
                        //DecimalFormat df = new DecimalFormat("#.############");
                        //String ml = String.valueOf(df.format(mgram));
                        String ml = String.valueOf(mgram);
                        toET.setText(ml);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*0.000453592;
                        DecimalFormat df = new DecimalFormat("#.#######");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (fromId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*0.0000283495;
                        DecimalFormat df = new DecimalFormat("#.######");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }else if (fromId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*(2*Math.pow(10,-7));
                        String o = String.valueOf(carrat);
                        toET.setText(o);
                    }
                }else if(toId == 4){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*2.2046244202;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*0.0022046244;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*(2.205*Math.pow(10,-6));
                        String ml = String.valueOf(mgram);
                        toET.setText(ml);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*2204.6244202;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String mt = String.valueOf(df.format(metricTon));
                        toET.setText(mt);
                    }else if (fromId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*0.0625;
                        DecimalFormat df = new DecimalFormat("#.######");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }else if (fromId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*0.0004409249;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(toId == 5){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*35.273990723;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*0.0352739907;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*0.000035274;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String ml = String.valueOf(df.format(mgram));
                        toET.setText(ml);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*35273.990723;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String mt = String.valueOf(df.format(metricTon));
                        toET.setText(mt);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*16;
                        DecimalFormat df = new DecimalFormat("#.#######");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (fromId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*0.0070547981;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(toId == 6){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*5000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*5;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*0.005;
                        DecimalFormat df = new DecimalFormat("#.#####");
                        String ml = String.valueOf(df.format(mgram));
                        toET.setText(ml);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*5000000;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String mt = String.valueOf(df.format(metricTon));
                        toET.setText(mt);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*2267.96;
                        DecimalFormat df = new DecimalFormat("#.#######");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (fromId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*141.7475;
                        DecimalFormat df = new DecimalFormat("#.######");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
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
                        double gram = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*1000000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String ml = String.valueOf(df.format(mgram));
                        toET.setText(ml);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String mt = String.valueOf(df.format(metricTon));
                        toET.setText(mt);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*2.2046244202;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*35.273990723;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*5000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(fromId == 1){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.#####");
                        String ml = String.valueOf(df.format(mgram));
                        toET.setText(ml);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*0.000001;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String mt = String.valueOf(df.format(metricTon));
                        toET.setText(mt);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*0.0022046244;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*0.0352739907;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*5;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(fromId == 2){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*0.000001;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*0.001;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*Math.pow(10,-9);
                        String mt = String.valueOf(metricTon);
                        toET.setText(mt);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*0.0000022046;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*0.000035274;
                        DecimalFormat df = new DecimalFormat("#.##########");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*0.005;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(fromId == 3){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*1000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*1000000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*1000000000;
                        DecimalFormat df = new DecimalFormat("#.#####");
                        String ml = String.valueOf(df.format(mgram));
                        toET.setText(ml);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*2204.6244202;
                        DecimalFormat df = new DecimalFormat("#.#######");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*35273.990723;
                        DecimalFormat df = new DecimalFormat("#.######");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*5000000;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(fromId == 4){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*0.453592;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*453.592;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*453592;
                        DecimalFormat df = new DecimalFormat("#.#####");
                        String ml = String.valueOf(df.format(mgram));
                        toET.setText(ml);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*0.000453592;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String mt = String.valueOf(df.format(metricTon));
                        toET.setText(mt);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*16;
                        DecimalFormat df = new DecimalFormat("#.######");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*2267.96;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(fromId == 5){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*0.0283495;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*28.3495;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*28349.5;
                        DecimalFormat df = new DecimalFormat("#.#####");
                        String ml = String.valueOf(df.format(mgram));
                        toET.setText(ml);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*0.0000283495;
                        DecimalFormat df = new DecimalFormat("#.########");
                        String mt = String.valueOf(df.format(metricTon));
                        toET.setText(mt);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*0.0625;
                        DecimalFormat df = new DecimalFormat("#.#######");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (toId == 6){
                        String from = fromET.getText().toString();
                        double carrat = Double.parseDouble(from)*141.7475;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String o = String.valueOf(df.format(carrat));
                        toET.setText(o);
                    }
                }else if(fromId == 6){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double kgram = Double.parseDouble(from)*0.0002;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String kg = String.valueOf(df.format(kgram));
                        toET.setText(kg);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double gram = Double.parseDouble(from)*0.2;
                        DecimalFormat df = new DecimalFormat("#.####");
                        String gr = String.valueOf(df.format(gram));
                        toET.setText(gr);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double mgram = Double.parseDouble(from)*200;
                        DecimalFormat df = new DecimalFormat("#.#####");
                        String ml = String.valueOf(df.format(mgram));
                        toET.setText(ml);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double metricTon = Double.parseDouble(from)*(2*Math.pow(10,-7));
                        String mt = String.valueOf(metricTon);
                        toET.setText(mt);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double pound = Double.parseDouble(from)*0.0004409249;
                        DecimalFormat df = new DecimalFormat("#.#######");
                        String p = String.valueOf(df.format(pound));
                        toET.setText(p);
                    }else if (toId == 5){
                        String from = fromET.getText().toString();
                        double ounce = Double.parseDouble(from)*0.0070547981;
                        DecimalFormat df = new DecimalFormat("#.######");
                        String o = String.valueOf(df.format(ounce));
                        toET.setText(o);
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
