package com.blodblue.zamgutz.midoconlineapp.Registro;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.blodblue.zamgutz.midoconlineapp.R;
import com.blodblue.zamgutz.midoconlineapp.Terminos.terminos_java;

public class registro_doctor_java extends AppCompatActivity implements View.OnClickListener {
    EditText txt_nombre,txt_correo,txt_pass,txt_pass2,txt_licencia,txt_ciudad,txt_numero;
    private CheckBox tyc;
    String especialidad, pais;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_doctor);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        findViewById(R.id.btn_activacion__medico).setOnClickListener(this);
        findViewById(R.id.btn_terminos_medico).setOnClickListener(this);
        txt_nombre = (EditText) findViewById(R.id.txt_nombre_medico);
        txt_correo =(EditText) findViewById(R.id.txt_correo_medico);
        txt_pass=(EditText) findViewById(R.id.txt_pass_medico);
        txt_pass2=(EditText)findViewById(R.id.txt_pass_confirmacion_medico);
        txt_licencia=(EditText) findViewById(R.id.txt_licencia_medico);
        txt_ciudad=(EditText)findViewById(R.id.txt_ciudad_medico);
        txt_numero=(EditText) findViewById(R.id.txt_numero_medico);
        tyc=(CheckBox)findViewById(R.id.box_terminos_medico);
        final Spinner spinneresp = (Spinner) findViewById(R.id.especialidad_medico);
        final Spinner spinnerpais = (Spinner) findViewById(R.id.pais_medico);
        final String[] especialidades = {"Alergólogo", "Cardiólogo", "Cirujano General", "Dermatólogo", "Dentista", "Endocrinólogo", "Gastroenterólogo", "Geriatra", "Ginecólogo", "Hematólogo", "Hepatólogo", "Medicina Interna", "Nefrólogo", "Neumólogo", "Neurólogo", "Nutriólogo", "Oftalmólogo", "Oncólogo", "Ortopedista", "Otorrinolaringólogo", "Pediatra", "Proctólogo", "Psicólogo", "Psiquiatra","Reumatólogo","Urólogo","Urgenciólogo"};
        final String[] paises = {"México", "Antigua y Barbuda", "Argentina", "Bahamas", "Barbados", "Belice", "Bolivia", "Brasil", "Canadá", "Chile", "Colombia", "Costa Rica", "Cuba", "Dominica", "Ecuador", "El Salvador", "Estados Unidos", "Granada", "Guatemala", "Guyana", "Haití", "Honduras", "Jamaica", "Nicaragua", "Panamá", "Paraguay", "Perú", "República Dominicana", "San Cristóbal y Nieves", "San Vicente y las Granadinas", "Santa Lucía", "Surinam", "Trinidad y Tobago", "Uruguay", "Venezuela"};
        spinneresp.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, especialidades));
        spinneresp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                especialidad = (String) spinneresp.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
        spinnerpais.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paises));
        spinnerpais.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                pais = (String) spinnerpais.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_activacion__medico:
                DoctorValidation();
                break;
            case R.id.btn_terminos_medico:
                Intent iExp2 = new Intent(registro_doctor_java.this, terminos_java.class);
                startActivity(iExp2);
                break;
        }
    }
    public void DoctorValidation()
    {
        if(txt_nombre.getText().toString().equals(""))
        {
            Toast.makeText(registro_doctor_java.this, "Ingrese Nombre", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(txt_correo.getText().toString().equals(""))
            {
                Toast.makeText(registro_doctor_java.this, "Ingrese Correo", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if(txt_pass.getText().toString().equals(""))
                {
                    Toast.makeText(registro_doctor_java.this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(txt_pass.getText().toString().length() <= 7)
                    {
                        Toast.makeText(registro_doctor_java.this, "La Contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(txt_pass2.getText().toString().equals(""))
                        {
                            Toast.makeText(registro_doctor_java.this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            if(txt_pass.getText().toString().equals(txt_pass2.getText().toString()))
                            {
                                if(txt_licencia.getText().toString().equals(""))
                                {
                                    Toast.makeText(registro_doctor_java.this, "Ingrese Licencia De Especialidad", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {

                                    if(txt_ciudad.getText().toString().equals(""))
                                    {
                                        Toast.makeText(registro_doctor_java.this, "Ingrese Ciudad", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        if(txt_numero.getText().toString().equals(""))
                                        {
                                            Toast.makeText(registro_doctor_java.this, "Ingrese Numero", Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            if(txt_numero.getText().toString().length() <= 9)
                                            {
                                                Toast.makeText(registro_doctor_java.this, "Ingrese Correctamente Su Numero Telefonico", Toast.LENGTH_SHORT).show();
                                            }
                                            else
                                            {
                                                if (tyc.isChecked()==true)
                                                {
                                                    datoscorrectos();
                                                }
                                                else
                                                {
                                                    Toast.makeText(registro_doctor_java.this, "Debes Aceptar Términos y Condiciones ", Toast.LENGTH_SHORT).show();
                                                }

                                            }
                                        }
                                    }

                                }
                            }
                            else
                            {
                                Toast.makeText(registro_doctor_java.this, "Las Contraseñas no son iguales", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        }
    }
    public void datoscorrectos() {
        Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_LONG).show();
    }
}