package com.sfit.torpid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

public class Train extends AppCompatActivity {
    String b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);
        Intent in = getIntent();
        b = in.getStringExtra("key");
        //Toast.makeText(this, b, Toast.LENGTH_SHORT).show();
    }

    public void onButtonClick(View v) {
        if ((v.getId() == R.id.Bw)) {
            Intent i = new Intent(this, western.class);
            i.putExtra("key",b);
            startActivity(i);
        }
        else  if ((v.getId() == R.id.Bc)) {
            Intent i = new Intent(this, central.class);
            i.putExtra("key",b);
            startActivity(i);
        }
        else  if ((v.getId() == R.id.Bh)) {
            Intent i = new Intent(this, harbour.class);
            i.putExtra("key",b);
            startActivity(i);
        }
    }
}