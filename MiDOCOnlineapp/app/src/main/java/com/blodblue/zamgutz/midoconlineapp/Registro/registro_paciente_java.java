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

public class registro_paciente_java extends AppCompatActivity implements View.OnClickListener{
    EditText txt_nombre,txt_apellido,txt_correo,txt_pass,txt_pass2,txt_telefono,txt_fecha;
    String txt_genero, sdia, smes,syear;
    private CheckBox tyc;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_paciente);
        findViewById(R.id.btn_registrar_paciente).setOnClickListener(this);
        findViewById(R.id.btn_terminos_paciente).setOnClickListener(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        txt_nombre = (EditText) findViewById(R.id.txt_nombre_paciente);
        txt_correo =(EditText) findViewById(R.id.txt_correo_paciente);
        txt_pass=(EditText) findViewById(R.id.txt_pass_paciente);
        txt_pass2=(EditText)findViewById(R.id.txt_pass_confirmacion_paciente);
        txt_apellido=(EditText) findViewById(R.id.txt_apellido_paciente);
        txt_telefono=(EditText) findViewById(R.id.txt_apellido_paciente);
        final Spinner spinner = (Spinner) findViewById(R.id.genero_paciente);
        final Spinner spinnerdia = (Spinner) findViewById(R.id.dias_paciente);
        final Spinner spinnermes = (Spinner) findViewById(R.id.mes_paciente);
        final Spinner spinneryear = (Spinner) findViewById(R.id.year_paciente);
        tyc=(CheckBox)findViewById(R.id.box_terminos_paciente);
        String[] valores = {"Hombre","Mujer"};
        String[] dia = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String[] me = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Dicembre"};
        String[] ye = {"1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990"
                ,"1991","1992","1993","1994","1995","1996","1997","1998","1999"
                ,"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009"
                ,"2010","2011","2012","2013","2014","2015","2016","2017","2018","2019"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                txt_genero= (String) spinner.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
        spinnerdia.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dia));
        spinnerdia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                sdia = (String) spinnerdia.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
        spinnermes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, me));
        spinnermes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                smes= (String) spinnermes.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
        spinneryear.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ye));
        spinneryear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                syear = (String) spinneryear.getSelectedItem();
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
            case R.id.btn_registrar_paciente:
                PacienteValidation();
                break;
            case R.id.btn_terminos_paciente:
                Intent iExp2 = new Intent(registro_paciente_java.this, terminos_java.class);
                startActivity(iExp2);
                break;
        }
    }
    public void PacienteValidation()
    {
        if(txt_nombre.getText().toString().equals(""))
        {
            Toast.makeText(registro_paciente_java.this, "Ingrese Nombre", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(txt_apellido.getText().toString().equals(""))
            {
                Toast.makeText(registro_paciente_java.this, "Ingrese Apellido", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if(txt_correo.getText().toString().equals(""))
                {
                    Toast.makeText(registro_paciente_java.this, "Ingrese Correo", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(txt_pass.getText().toString().equals(""))
                    {
                        Toast.makeText(registro_paciente_java.this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(txt_pass.getText().toString().length() <= 7)
                        {
                            Toast.makeText(registro_paciente_java.this, "La Contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            if(txt_pass2.getText().toString().equals(""))
                            {
                                Toast.makeText(registro_paciente_java.this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                if(txt_pass.getText().toString().equals(txt_pass2.getText().toString()))
                                {
                                    if(txt_telefono.getText().toString().equals(""))
                                    {
                                        Toast.makeText(registro_paciente_java.this, "Ingrese Telefono", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {

                                        if (tyc.isChecked()==true)
                                        {
                                            datoscorrectos();
                                        }
                                        else
                                        {
                                            Toast.makeText(registro_paciente_java.this, "Debes Aceptar Términos y Condiciones ", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else
                                {
                                    Toast.makeText(registro_paciente_java.this, "Las Contraseñas no son iguales", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void datoscorrectos()
    {
        Toast.makeText(registro_paciente_java.this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
    }
}
