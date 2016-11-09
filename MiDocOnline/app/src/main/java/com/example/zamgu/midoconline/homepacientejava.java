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
public class homepacientejava extends AppCompatActivity implements View.OnClickListener{
    ImageButton btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepaciente);
        findViewById(R.id.btnhistorial).setOnClickListener(this);
        addListenerOnButton();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void addListenerOnButton() {

        btn1 = (ImageButton) findViewById(R.id.btnperfilpaciente);
        btn2 = (ImageButton) findViewById(R.id.btnsalirpaciente);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent iExp = new Intent(homepacientejava.this, perfilpacientejava.class);
                startActivity(iExp);

            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent iExp = new Intent(homepacientejava.this, menujava.class);
                startActivity(iExp);

            }

        });
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.btnhistorial:
                Intent iExp = new Intent(homepacientejava.this, historialjava.class);
                startActivity(iExp);
                break;
        }

    }
}