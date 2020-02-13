package com.sfit.torpid;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by admin on 3/15/2017.
 */

public class fragment_table1 extends Fragment {
    String b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_table1, container, false);
        Intent in = new Intent(getActivity().getIntent());
        b = in.getStringExtra("key");
        //Toast.makeText(getContext(),b,Toast.LENGTH_SHORT).show();
        Button button = (Button) rootView.findViewById(R.id.Bw);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplication(), western.class);
                i.putExtra("key", b);
                Toast.makeText(getContext(),b,Toast.LENGTH_SHORT);
                startActivity(i);
            }
        });
        Button button1 = (Button) rootView.findViewById(R.id.Bh);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplication(), harbour.class);
                i.putExtra("key", b);
                startActivity(i);
            }
        });
        Button button2 = (Button) rootView.findViewById(R.id.Bc);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplication(), central.class);
                i.putExtra("key", b);
                startActivity(i);
            }
        });
        return rootView;

    }
}