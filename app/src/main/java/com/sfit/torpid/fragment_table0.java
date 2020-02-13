package com.sfit.torpid;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by admin on 3/15/2017.
 */

public class fragment_table0 extends Fragment {

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_table0, container, false);
        Button button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplication(), Bus.class);
                Intent in = new Intent(getActivity().getIntent());
                String b = in.getStringExtra("key");
                i.putExtra("key", b);
                Toast.makeText(getContext(),b,Toast.LENGTH_SHORT);
                startActivity(i);
            }
        });
        Button button1 = (Button) rootView.findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent i = new Intent(getActivity().getApplication(), Bus.class);
                Intent in = new Intent(getActivity().getIntent());
                String b = in.getStringExtra("key");
                i.putExtra("key", b);*/
                Toast.makeText(getContext(),"In progress.",Toast.LENGTH_SHORT);
                //startActivity(i);
            }
        });
    return rootView;

}
}
