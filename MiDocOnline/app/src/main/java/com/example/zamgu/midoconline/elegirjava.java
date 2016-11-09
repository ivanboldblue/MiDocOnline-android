package com.example.zamgu.midoconline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by zamgu on 01/11/2016.
 */

public class elegirjava extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elegir);
        findViewById(R.id. btnpaciente).setOnClickListener(this);
        findViewById(R.id.btnmedico).setOnClickListener(this);
        findViewById(R.id.btncancelar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnpaciente:
                Intent iExp = new Intent(elegirjava.this, registropjava.class);
                startActivity(iExp);
                break;
            case R.id.btnmedico:
                Intent iExp2 = new Intent(elegirjava.this, registrojava.class);
                startActivity(iExp2);
                break;
            case R.id.btncancelar:
                Intent iExp3 = new Intent(elegirjava.this, menujava.class);
                startActivity(iExp3);
                break;
        }
    }
}
