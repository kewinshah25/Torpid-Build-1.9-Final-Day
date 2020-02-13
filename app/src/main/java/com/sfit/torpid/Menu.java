package com.sfit.torpid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //TODO: HERE ARE THE TWO IMP STRINGS TO BE PASSED.
        Intent i = getIntent();
        String a = i.getStringExtra("key1");
        //Toast.makeText(this, a, Toast.LENGTH_SHORT).show();
        //long start;
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH)+1;
        //String DATE = Integer.toString(cal.get(Calendar.DAY_OF_MONTH))+"/"+Integer.toString(month)+"/"+Integer.toString(cal.get(Calendar.YEAR));
        final String ad = "User ID: "+a;//+"\n"+"DATE: "+DATE+" ";
        //start = System.nanoTime();
        //Toast.makeText(this,ad,Toast.LENGTH_LONG).show();

        Button bus = (Button) findViewById(R.id.bus123);
        Button train = (Button) findViewById(R.id.train123);

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Bus.class);
                startActivity(intent);
            }
        });
        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSuc1 = new Intent(Menu.this, fragment_table1.class);
                //Toast.makeText(Menu.this,"HEY "+ad,Toast.LENGTH_LONG).show();
                toSuc1.putExtra("key",ad);
                startActivity(toSuc1);
            }

        });
        /*Button del = (Button) findViewById(R.id.deletedb);

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHandler db = new DatabaseHandler (view.getContext());
                db.deleteAll();
            }
        });*/

    }
}