package com.sfit.torpid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.sfit.torpid.R;

public class western extends AppCompatActivity {

    CharSequence[] station_s = {"Churchgate", "Marine Lines", "Charni Road", "Grant Road", "Mumbai Central", "Mahalaxmi", "Lowerparel", "Elphiston Road","Dadar", "Matunga Road", "Mahim Junction", "Bandra", "Khar Road", "Santacruz", "Vile Parle","Andheri", "Jogeshwari", "Goregaon", "Malad", "Kandivali", "Borivali", "Dahisar", "Mira Road", "Bhayander", "Naigaon", "Vasai","Nalasopara","Virar"};
    CharSequence[] station_d = {"Churchgate", "Marine Lines", "Charni Road", "Grant Road", "Mumbai Central", "Mahalaxmi", "Lowerparel", "Elphiston Road","Dadar", "Matunga Road", "Mahim Junction", "Bandra", "Khar Road", "Santacruz", "Vile Parle","Andheri", "Jogeshwari", "Goregaon", "Malad", "Kandivali", "Borivali", "Dahisar", "Mira Road", "Bhayander", "Naigaon", "Vasai","Nalasopara","Virar"};
    String abc, source1,dest1,tick1;
    int p1,p2,p3 = 1;
    int flag1=0, flag2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_western);


        //station=getResources().getStringArray(R.array.station);
        final AutoCompleteTextView source = (AutoCompleteTextView) findViewById(R.id.west_sp1);
        final AutoCompleteTextView destination = (AutoCompleteTextView) findViewById(R.id.west_sp2);
        ArrayAdapter<CharSequence> adapter1 = new
                ArrayAdapter<CharSequence>(this, android.R.layout.simple_dropdown_item_1line, station_s);
        ArrayAdapter<CharSequence> adapter2 = new
                ArrayAdapter<CharSequence>(this, android.R.layout.simple_dropdown_item_1line, station_d);
        source.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                source.showDropDown();
                return false;

            }
        });

        destination.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                destination.showDropDown();
                return false;
            }
        });

        source.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                flag1 = 1;
                InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                in.hideSoftInputFromWindow(arg1.getApplicationWindowToken(), 0);
                //abc = Long.toString(arg3);
                //showToast("LONG "+abc);
                //showToast(arg0.getItemAtPosition(arg2).toString());
                source1 = arg0.getItemAtPosition(arg2).toString();
            }

        });

        destination.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                flag2 = 1;
                InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                in.hideSoftInputFromWindow(arg1.getApplicationWindowToken(), 0);
                dest1 = arg0.getItemAtPosition(arg2).toString();

                p2 = arg2;
            }

        });


        source.setThreshold(0);         //So that when u type the first letter itself, the dropdown option will begin.
        source.setAdapter(adapter1);     //To start the dropdown thing.
        destination.setThreshold(0);    //So that when u type the first letter itself, the dropdown option will begin.
        destination.setAdapter(adapter2);


        NumberPicker np = (NumberPicker) findViewById(R.id.west_sp3);
        np.setMinValue(1);
        np.setMaxValue(6);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener(){
            @Override
            public void onValueChange(NumberPicker np, int oldv, int newv)
            {
                tick1 = Integer.toString(newv);
                p3 = newv;
            }
        });



        //TODO THIS ISN'T WORKING PLEASE CHECK. UPDATE : NOW IT IS.


        Button btnStart = (Button) findViewById(R.id.button3);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag1==0 && flag2==0){showToast("Please select source and destination.");}
                else if(flag1==0){showToast("Please select source");}
                else if(flag2==0){showToast("Please select destination.");}
                else if(source1.equals(dest1))
                {showToast("Please select different source and destination.");}
                else
                {
                    String z = "Source: "+source1+ " \nDest: "+dest1+"\nNo. of ticks: "+p3;
                    Intent s = new Intent(western.this, QRCode.class);
                    Intent in = getIntent();
                    String abc = in.getStringExtra("key");
                    z = abc+"\n"+z;
                    s.putExtra("KEWIN",z);
                    startActivity(s);
                }
                //showToast(z);
                /*Intent s = new Intent(western.this, QRCode.class);
                s.putExtra("KEWIN",z);
                startActivity(s);*/
            }
        });
    }

    void showToast(CharSequence msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if( v != null) v.setGravity(Gravity.CENTER);
        toast.show();
    }
}