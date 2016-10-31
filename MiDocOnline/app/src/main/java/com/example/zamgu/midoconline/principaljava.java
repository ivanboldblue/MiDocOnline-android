package com.example.zamgu.midoconline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by zamgu on 30/10/2016.
 */

public class principaljava extends Fragment implements View.OnClickListener {
    Button btn;
    Button btn2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.principal, container, false);
        btn = (Button) rootView.findViewById(R.id.btningresar);
        btn = (Button) rootView.findViewById(R.id.btnterminos);
        btn.setOnClickListener(this);
        return rootView;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btningresar:
                Intent intent = new Intent(getActivity().getApplication(), ingresarjava.class);
                startActivity(intent);
                break;
            case R.id.btnterminos:
                Intent intent2 = new Intent(getActivity().getApplication(), terminos.class);
                startActivity(intent2);
                break;
        }
    }
}