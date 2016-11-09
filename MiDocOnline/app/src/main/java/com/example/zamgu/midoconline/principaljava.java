package com.example.zamgu.midoconline;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by zamgu on 30/10/2016.
 */

public class principaljava extends Fragment implements View.OnClickListener {
    Button btn1, btn2, btn3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.principal, container, false);
        btn1 = (Button) rootView.findViewById(R.id.btningresarprincipal);
        btn1.setOnClickListener(this);
        btn2 = (Button) rootView.findViewById(R.id.btnterminosprincipal);
        btn2.setOnClickListener(this);
        btn3 = (Button) rootView.findViewById(R.id.btnregistrarprincipal);
        btn3.setOnClickListener(this);
        return rootView;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btningresarprincipal:
                Intent intent = new Intent(getActivity().getApplication(), ingresarjava.class);
                startActivity(intent);
                break;
            case R.id.btnterminosprincipal:
                Intent intent2 = new Intent(getActivity().getApplication(), terminos.class);
                startActivity(intent2);
                break;
            case R.id.btnregistrarprincipal:
                FragmentManager fm = getFragmentManager();
                TestDialog dialogFragment = new TestDialog ();
                dialogFragment.show(fm, "Sample Fragment");
                break;
        }
    }


}