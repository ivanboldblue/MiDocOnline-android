package com.blodblue.zamgutz.midoconlineapp.PerfilDoctor;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.blodblue.zamgutz.midoconlineapp.MenuPrincipal.menu_principal_java;
import com.blodblue.zamgutz.midoconlineapp.R;

public class principal_medico_java extends AppCompatActivity implements View.OnClickListener{
    ImageButton btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_medico);
        findViewById(R.id.btn_historial_medicop).setOnClickListener(this);
        addListenerOnButton();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void addListenerOnButton() {

        btn1 = (ImageButton) findViewById(R.id.btn_perfil_medicop);
        btn2 = (ImageButton) findViewById(R.id.btn_salir_medicop);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent iExp = new Intent(principal_medico_java.this, perfil_doctor_java.class);
                startActivity(iExp);

            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent iExp = new Intent(principal_medico_java.this, menu_principal_java.class);
                startActivity(iExp);

            }

        });
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.btn_historial_medicop:
                Intent iExp = new Intent(principal_medico_java.this, historial_doctor_java.class);
                startActivity(iExp);
                break;
        }

    }
}