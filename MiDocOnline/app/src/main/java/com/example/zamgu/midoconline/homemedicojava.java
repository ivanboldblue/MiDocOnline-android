package com.example.zamgu.midoconline;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by zamgu on 01/11/2016.
 */

public class homemedicojava extends AppCompatActivity implements View.OnClickListener{
    ImageButton btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homemedico);
        findViewById(R.id.btnhistorialmedico).setOnClickListener(this);
        addListenerOnButton();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void addListenerOnButton() {

        btn1 = (ImageButton) findViewById(R.id.btnperfilmedico);
        btn2 = (ImageButton) findViewById(R.id.btnsalirmedico);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent iExp = new Intent(homemedicojava.this, perfilmedicojava.class);
                startActivity(iExp);

            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent iExp = new Intent(homemedicojava.this, menujava.class);
                startActivity(iExp);

            }

        });
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.btnhistorialmedico:
                Intent iExp = new Intent(homemedicojava.this, historialjava.class);
                startActivity(iExp);
                break;
        }

    }
}