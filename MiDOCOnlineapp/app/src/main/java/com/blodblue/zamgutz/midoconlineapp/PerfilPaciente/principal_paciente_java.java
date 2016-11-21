package com.blodblue.zamgutz.midoconlineapp.PerfilPaciente;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.blodblue.zamgutz.midoconlineapp.MenuPrincipal.menu_principal_java;
import com.blodblue.zamgutz.midoconlineapp.R;

public class principal_paciente_java extends AppCompatActivity implements View.OnClickListener{
    ImageButton btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_paciente);
        findViewById(R.id.btn_historial_pacientep).setOnClickListener(this);
        addListenerOnButton();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void addListenerOnButton() {

        btn1 = (ImageButton) findViewById(R.id.btn_perfil_pacientep);
        btn2 = (ImageButton) findViewById(R.id.btn_salir_pacientep);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent iExp = new Intent(principal_paciente_java.this, perfil_paciente_java.class);
                startActivity(iExp);

            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent iExp = new Intent(principal_paciente_java.this, menu_principal_java.class);
                startActivity(iExp);

            }

        });
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.btn_historial_pacientep:
                Intent iExp = new Intent(principal_paciente_java.this, historial_paciente_java.class);
                startActivity(iExp);
                break;
        }

    }
}