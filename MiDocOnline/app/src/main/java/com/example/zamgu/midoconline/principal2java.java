package com.example.zamgu.midoconline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by zamgu on 31/10/2016.
 */

public class principal2java extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal2);
        findViewById(R.id.btningresar).setOnClickListener(this);
        findViewById(R.id.btnterminos).setOnClickListener(this);
        findViewById(R.id.btnregistrar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
        case R.id.btningresar:
        Intent iExp = new Intent(principal2java.this, ingresarjava.class);
        startActivity(iExp);
        break;
        case R.id.btnterminos:
        Intent iExp2 = new Intent(principal2java.this, terminos.class);
        startActivity(iExp2);
        break;
            case R.id.btnregistrar:
                Intent iExp3 = new Intent(principal2java.this, registrojava.class);
                startActivity(iExp3);
                break;
        }
    }
}
