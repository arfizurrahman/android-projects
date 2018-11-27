package com.example.arfiz.convertit;

import android.app.ActionBar;
import android.app.Activity;
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

public class CurrencyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    TextView fromET;
    TextView toET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);



        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.fromSpinner);
        final Spinner spinner2 = (Spinner) findViewById(R.id.toSpinner);

        //EditText
        fromET = (TextView) findViewById(R.id.fromEditText);
        toET = (TextView) findViewById(R.id.toTextView);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("BDT-Bangladeshi Taka");
        categories.add("USD-US Dollar");
        categories.add("EUR-Euro");
        categories.add("GBP-British Pound");
        categories.add("OMR-Omani Riyal");
        /*categories.add("QAR-Qatari Riyal");
        categories.add("SAR-Saudi Arabian Riyal");
        categories.add("INR-Indian Rupee");
        categories.add("AUD-Australian Dollar");
        categories.add("CAD-Canadian Dollar");
        categories.add("CNY-Chinese Yaun Renminbi");*/

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();

                long fromId = spinner.getSelectedItemId();
                long toId = spinner2.getSelectedItemId();

                String fromText = fromET.getText().toString();
                String toText = toET.getText().toString();
                if (fromText.matches("")){
                    return;
                }
                //for the first element
                if (fromId == 0){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        toET.setText(from);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double usd = Double.parseDouble(from)*0.012;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        toET.setText(u);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double eur = Double.parseDouble(from)*0.010;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        toET.setText(e);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double gbp = Double.parseDouble(from)*0.0089;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        toET.setText(g);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double omr = Double.parseDouble(from)*0.0046;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        toET.setText(o);
                    }

                }else if (fromId == 1){ //for usd to bdt
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double bdt = Double.parseDouble(from)*84.55;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(bdt));
                        toET.setText(u);
                    }else if (toId == 1){//for usd to usd
                        String from = fromET.getText().toString();
                        toET.setText(from);
                    }else if (toId == 2){ //for usd to gbp
                        String from = fromET.getText().toString();
                        double eur = Double.parseDouble(from)*0.85;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        toET.setText(e);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double gbp = Double.parseDouble(from)*0.75;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        toET.setText(g);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double omr = Double.parseDouble(from)*0.38;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        toET.setText(o);
                    }
                }else if (fromId == 2){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double bdt = Double.parseDouble(from)*99.20;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String b = String.valueOf(df.format(bdt));
                        toET.setText(b);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double usd = Double.parseDouble(from)*1.17;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        toET.setText(u);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        toET.setText(from);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double gbp = Double.parseDouble(from)*0.89;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        toET.setText(g);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double omr = Double.parseDouble(from)*0.45;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        toET.setText(o);
                    }
                }else if (fromId == 3){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double bdt = Double.parseDouble(from)*111.95;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String b = String.valueOf(df.format(bdt));
                        toET.setText(b);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double usd = Double.parseDouble(from)*1.32;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        toET.setText(u);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double eur = Double.parseDouble(from)*1.13;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        toET.setText(e);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        toET.setText(from);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double omr = Double.parseDouble(from)*0.51;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        toET.setText(o);
                    }
                }else if (fromId == 4){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double bdt = Double.parseDouble(from)*219.66;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String b = String.valueOf(df.format(bdt));
                        toET.setText(b);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double usd = Double.parseDouble(from)*2.60;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        toET.setText(u);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double eur = Double.parseDouble(from)*2.21;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        toET.setText(e);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double gbp = Double.parseDouble(from)*1.96;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        toET.setText(g);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        toET.setText(from);
                    }
                }

                // Showing selected spinner item
                //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();

                long fromId = spinner.getSelectedItemId();
                long toId = spinner2.getSelectedItemId();
                String fromText = fromET.getText().toString();
                String toText = toET.getText().toString();
                if (fromText.matches("")){
                   return;
                }

                if (toId == 0){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        toET.setText(from);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double usd = Double.parseDouble(from)*84.55;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        toET.setText(u);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double eur = Double.parseDouble(from)*99.27;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        toET.setText(e);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double gbp = Double.parseDouble(from)*112.18;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        toET.setText(g);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double omr = Double.parseDouble(from)*219.66;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        toET.setText(o);
                    }

                }else if (toId == 1){ //for usd to bdt
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double bdt = Double.parseDouble(from)*0.012;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(bdt));
                        toET.setText(u);
                    }else if (fromId == 1){//for usd to usd
                        String from = fromET.getText().toString();
                        toET.setText(from);
                    }else if (fromId == 2){ //for usd to gbp
                        String from = fromET.getText().toString();
                        double eur = Double.parseDouble(from)*1.17;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        toET.setText(e);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double gbp = Double.parseDouble(from)*1.33;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        toET.setText(g);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double omr = Double.parseDouble(from)*2.60;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        toET.setText(o);
                    }
                }else if (toId == 2){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double bdt = Double.parseDouble(from)*0.010;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String b = String.valueOf(df.format(bdt));
                        toET.setText(b);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double usd = Double.parseDouble(from)*0.85;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        toET.setText(u);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        toET.setText(from);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double gbp = Double.parseDouble(from)*1.13;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        toET.setText(g);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double omr = Double.parseDouble(from)*2.21;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        toET.setText(o);
                    }
                }else if (toId == 3){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double bdt = Double.parseDouble(from)*0.0089;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String b = String.valueOf(df.format(bdt));
                        toET.setText(b);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double usd = Double.parseDouble(from)*0.75;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        toET.setText(u);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double eur = Double.parseDouble(from)*0.88;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        toET.setText(e);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        toET.setText(from);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        double omr = Double.parseDouble(from)*1.96;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        toET.setText(o);
                    }
                }else if (toId == 4){
                    if (fromId == 0){
                        String from = fromET.getText().toString();
                        double bdt = Double.parseDouble(from)*0.0046;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String b = String.valueOf(df.format(bdt));
                        toET.setText(b);
                    }else if (fromId == 1){
                        String from = fromET.getText().toString();
                        double usd = Double.parseDouble(from)*0.38;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        toET.setText(u);
                    }else if (fromId == 2){
                        String from = fromET.getText().toString();
                        double eur = Double.parseDouble(from)*0.45;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        toET.setText(e);
                    }else if (fromId == 3){
                        String from = fromET.getText().toString();
                        double gbp = Double.parseDouble(from)*0.51;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        toET.setText(g);
                    }else if (fromId == 4){
                        String from = fromET.getText().toString();
                        toET.setText(from);
                    }
                }

                // Showing selected spinner item
                //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
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

                String fromText = fromET.getText().toString();
                String toText = toET.getText().toString();
                if (fromText.matches("")){
                    toET.setText("");
                    return;
                }

                long fromId = spinner.getSelectedItemId();
                long toId = spinner2.getSelectedItemId();
                if (fromId == toId){
                    String from = fromET.getText().toString();
                    toET.setText(from);
                }else if (fromId == 0){
                    if (toId == 1){
                        String from = fromET.getText().toString();
                        double usd = Double.parseDouble(from)*0.012;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        toET.setText(u);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double eur = Double.parseDouble(from)*0.010;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        toET.setText(e);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double gbp = Double.parseDouble(from)*0.0089;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        toET.setText(g);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double omr = Double.parseDouble(from)*0.0046;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        toET.setText(o);
                    }
                }else if(fromId == 1){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double bdt = Double.parseDouble(from)*84.55;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(bdt));
                        toET.setText(u);
                    }else if (toId == 2){ //for usd to gbp
                        String from = fromET.getText().toString();
                        double eur = Double.parseDouble(from)*0.85;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        toET.setText(e);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double gbp = Double.parseDouble(from)*0.75;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        toET.setText(g);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double omr = Double.parseDouble(from)*0.38;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        toET.setText(o);
                    }
                }else if (fromId == 2){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double bdt = Double.parseDouble(from)*99.20;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String b = String.valueOf(df.format(bdt));
                        toET.setText(b);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double usd = Double.parseDouble(from)*1.17;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        toET.setText(u);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double gbp = Double.parseDouble(from)*0.89;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        toET.setText(g);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double omr = Double.parseDouble(from)*0.45;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        toET.setText(o);
                    }
                }else if (fromId == 3){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double bdt = Double.parseDouble(from)*111.95;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String b = String.valueOf(df.format(bdt));
                        toET.setText(b);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double usd = Double.parseDouble(from)*1.32;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        toET.setText(u);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double eur = Double.parseDouble(from)*1.13;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        toET.setText(e);
                    }else if (toId == 4){
                        String from = fromET.getText().toString();
                        double omr = Double.parseDouble(from)*0.51;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        toET.setText(o);
                    }
                }else if (fromId == 4){
                    if (toId == 0){
                        String from = fromET.getText().toString();
                        double bdt = Double.parseDouble(from)*219.66;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String b = String.valueOf(df.format(bdt));
                        toET.setText(b);
                    }else if (toId == 1){
                        String from = fromET.getText().toString();
                        double usd = Double.parseDouble(from)*2.60;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        toET.setText(u);
                    }else if (toId == 2){
                        String from = fromET.getText().toString();
                        double eur = Double.parseDouble(from)*2.21;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        toET.setText(e);
                    }else if (toId == 3){
                        String from = fromET.getText().toString();
                        double gbp = Double.parseDouble(from)*1.96;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        toET.setText(g);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
        /*toET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                String fromText = fromET.getText().toString();
                String toText = toET.getText().toString();
                if (fromText.isEmpty() || toText.isEmpty()){
                    fromET.setText("0");
                    toET.setText("0");
                }

                long fromId = spinner.getSelectedItemId();
                long toId = spinner2.getSelectedItemId();
                if (fromId == toId){
                    String to = toET.getText().toString();
                    fromET.setText(to);
                }else if (fromId == 0){
                    if (toId == 1){
                        String to = toET.getText().toString();
                        double usd = Double.parseDouble(to)*84.55;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        fromET.setText(u);
                    }else if (toId == 2){
                        String to = toET.getText().toString();
                        double eur = Double.parseDouble(to)*99.08;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        fromET.setText(e);
                    }else if (toId == 3){
                        String to = toET.getText().toString();
                        double gbp = Double.parseDouble(to)*111.91;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        fromET.setText(g);
                    }else if (toId == 4){
                        String to = toET.getText().toString();
                        double omr = Double.parseDouble(to)*219.66;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        fromET.setText(o);
                    }
                }else if(fromId == 1){
                    if (toId == 0){
                        String to = toET.getText().toString();
                        double bdt = Double.parseDouble(to)*0.012;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(bdt));
                        fromET.setText(u);
                    }else if (toId == 2){ //for usd to gbp
                        String to = toET.getText().toString();
                        double eur = Double.parseDouble(to)*1.17;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        fromET.setText(e);
                    }else if (toId == 3){
                        String to = toET.getText().toString();
                        double gbp = Double.parseDouble(to)*1.32;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        fromET.setText(g);
                    }else if (toId == 4){
                        String to = toET.getText().toString();
                        double omr = Double.parseDouble(to)*2.60;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        fromET.setText(o);
                    }
                }else if (fromId == 2){
                    if (toId == 0){
                        String to = toET.getText().toString();
                        double bdt = Double.parseDouble(to)*0.010;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(bdt));
                        fromET.setText(u);
                    }else if (toId == 1){
                        String to = toET.getText().toString();
                        double usd = Double.parseDouble(to)*0.85;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        fromET.setText(u);
                    }else if (toId == 3){
                        String to = toET.getText().toString();
                        double gbp = Double.parseDouble(to)*1.13;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        fromET.setText(g);
                    }else if (toId == 4){
                        String to = toET.getText().toString();
                        double omr = Double.parseDouble(to)*2.22;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        fromET.setText(o);
                    }
                }else if (fromId == 3){
                    if (toId == 0){
                        String to = toET.getText().toString();
                        double bdt = Double.parseDouble(to)*0.0090;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String b = String.valueOf(df.format(bdt));
                        fromET.setText(b);
                    }else if (toId == 1){
                        String to = toET.getText().toString();
                        double usd = Double.parseDouble(to)*0.76;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        fromET.setText(u);
                    }else if (toId == 2){
                        String to = toET.getText().toString();
                        double eur = Double.parseDouble(to)*0.89;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        fromET.setText(e);
                    }else if (toId == 4){
                        String to = toET.getText().toString();
                        double omr = Double.parseDouble(to)*1.96;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String o = String.valueOf(df.format(omr));
                        fromET.setText(o);
                    }
                }else if (fromId == 4){
                    if (toId == 0){
                        String to = toET.getText().toString();
                        double bdt = Double.parseDouble(to)*0.0046;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String b = String.valueOf(df.format(bdt));
                        fromET.setText(b);
                    }else if (toId == 1){
                        String to = toET.getText().toString();
                        double usd = Double.parseDouble(to)*0.38;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String u = String.valueOf(df.format(usd));
                        fromET.setText(u);
                    }else if (toId == 2){
                        String to = toET.getText().toString();
                        double eur = Double.parseDouble(to)*0.45;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String e = String.valueOf(df.format(eur));
                        fromET.setText(e);
                    }else if (toId == 3){
                        String to = toET.getText().toString();
                        double gbp = Double.parseDouble(to)*0.51;
                        DecimalFormat df = new DecimalFormat("#.###");
                        String g = String.valueOf(df.format(gbp));
                        fromET.setText(g);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String fromText = fromET.getText().toString();
                String toText = toET.getText().toString();
                if (fromText.isEmpty() || toText.isEmpty()){
                    fromET.setText("0");
                    toET.setText("0");
                }
            }
        });*/

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
