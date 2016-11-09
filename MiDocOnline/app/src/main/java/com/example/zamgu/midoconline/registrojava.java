package com.example.zamgu.midoconline;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zamgu on 31/10/2016.
 */

public class registrojava extends AppCompatActivity implements View.OnClickListener {
    EditText txt_nombre,txt_correo,txt_pass,txt_pass2,txt_licencia,txt_especialidad,txt_pais,txt_ciudad,txt_numero;
    private CheckBox tyc;
    ObtenerWebService hiloconexion;
    String especialidad, pais;
    ProgressDialog ringProgressDialog;
    String UPDATE = "https://www.midoconline.com/tokens/doctor_sign_up?";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        findViewById(R.id.btnactivacion).setOnClickListener(this);
        findViewById(R.id.btnterminosmedico).setOnClickListener(this);
        txt_nombre = (EditText) findViewById(R.id.txtnombrerd);
        txt_correo =(EditText) findViewById(R.id.txtcorreoelectronicord);
        txt_pass=(EditText) findViewById(R.id.passwordrd);
        txt_pass2=(EditText)findViewById(R.id.passwordcrd);
        txt_licencia=(EditText) findViewById(R.id.txtlicenciard);
        txt_ciudad=(EditText)findViewById(R.id.txtciudadrd);
        txt_numero=(EditText) findViewById(R.id.txtnumerord);
        tyc=(CheckBox)findViewById(R.id.box_tycrd);
        final Spinner spinneresp = (Spinner) findViewById(R.id.spinneresp);
        final Spinner spinnerpais = (Spinner) findViewById(R.id.spinnerpais);
        final String[] especialidades = {"Alergólogo", "Cardiólogo", "Cirujano General", "Dermatólogo", "Dentista", "Endocrinólogo", "Gastroenterólogo", "Geriatra", "Ginecólogo", "Hematólogo", "Hepatólogo", "Medicina Interna", "Nefrólogo", "Neumólogo", "Neurólogo", "Nutriólogo", "Oftalmólogo", "Oncólogo", "Ortopedista", "Otorrinolaringólogo", "Pediatra", "Proctólogo", "Psicólogo", "Psiquiatra","Reumatólogo","Urólogo","Urgenciólogo"};
        final String[] paises = {"México", "Antigua y Barbuda", "Argentina", "Bahamas", "Barbados", "Belice", "Bolivia", "Brasil", "Canadá", "Chile", "Colombia", "Costa Rica", "Cuba", "Dominica", "Ecuador", "El Salvador", "Estados Unidos", "Granada", "Guatemala", "Guyana", "Haití", "Honduras", "Jamaica", "Nicaragua", "Panamá", "Paraguay", "Perú", "República Dominicana", "San Cristóbal y Nieves", "San Vicente y las Granadinas", "Santa Lucía", "Surinam", "Trinidad y Tobago", "Uruguay", "Venezuela"};
        spinneresp.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, especialidades));
        spinneresp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                // Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                especialidad = (String) spinneresp.getSelectedItem();
                //Toast.makeText(registrojava.this, ""+selState, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio

            }
        });
        spinnerpais.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paises));
        spinnerpais.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                // Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                pais = (String) spinnerpais.getSelectedItem();
                //Toast.makeText(registrojava.this, ""+selState, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnactivacion:
                DoctorValidation();
                break;
            case R.id.btnterminosmedico:
                Intent iExp2 = new Intent(registrojava.this, terminos.class);
                startActivity(iExp2);
                break;
        }
    }

    public void DoctorValidation()
    {
        if(txt_nombre.getText().toString().equals(""))
        {
            Toast.makeText(registrojava.this, "Ingrese Nombre", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(txt_correo.getText().toString().equals(""))
            {
                Toast.makeText(registrojava.this, "Ingrese Correo", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if(txt_pass.getText().toString().equals(""))
                {
                    Toast.makeText(registrojava.this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(txt_pass.getText().toString().length() <= 7)
                    {
                        Toast.makeText(registrojava.this, "La Contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(txt_pass2.getText().toString().equals(""))
                        {
                            Toast.makeText(registrojava.this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            if(txt_pass.getText().toString().equals(txt_pass2.getText().toString()))
                            {
                                if(txt_licencia.getText().toString().equals(""))
                                {
                                    Toast.makeText(registrojava.this, "Ingrese Licencia De Especialidad", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {

                                            if(txt_ciudad.getText().toString().equals(""))
                                            {
                                                Toast.makeText(registrojava.this, "Ingrese Ciudad", Toast.LENGTH_SHORT).show();
                                            }
                                            else
                                            {
                                                if(txt_numero.getText().toString().equals(""))
                                                {
                                                    Toast.makeText(registrojava.this, "Ingrese Numero", Toast.LENGTH_SHORT).show();
                                                }
                                                else
                                                {
                                                    if(txt_numero.getText().toString().length() <= 9)
                                                    {
                                                        Toast.makeText(registrojava.this, "Ingrese Correctamente Su Numero Telefonico", Toast.LENGTH_SHORT).show();
                                                    }
                                                    else
                                                    {
                                                        if (tyc.isChecked()==true)
                                                        {
                                                            datoscorrectos();
                                                        }
                                                        else
                                                        {
                                                            Toast.makeText(registrojava.this, "Debes Aceptar Términos y Condiciones ", Toast.LENGTH_SHORT).show();
                                                        }

                                                    }
                                                }
                                            }

                                }
                            }
                            else
                            {
                                Toast.makeText(registrojava.this, "Las Contraseñas no son iguales", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        }
    }
    public void datoscorrectos() {

        String manufacturer = android.os.Build.MANUFACTURER;
        hiloconexion = new ObtenerWebService();
        hiloconexion.execute(UPDATE, "3",txt_nombre.getText().toString() , txt_correo.getText().toString() , txt_pass.getText().toString() , txt_ciudad.getText().toString()
                , pais , txt_numero.getText().toString() ,  txt_licencia.getText().toString() ,manufacturer.toString() , especialidad);
        Toast.makeText(getApplicationContext(), "" + UPDATE + txt_nombre.getText().toString() + txt_correo.getText().toString() + txt_pass.getText().toString() + txt_numero.getText().toString() + manufacturer.toString() + manufacturer.toString() + especialidad + txt_ciudad.getText().toString() + pais + txt_licencia.getText().toString(), Toast.LENGTH_LONG).show();
    }

    public class ObtenerWebService extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... params) {

            String cadena = params[0];
            URL url = null; // Url de donde queremos obtener información
            String devuelve ="";

            if(params[1]=="3"){    // insert

                try {
                    HttpURLConnection urlConn;

                    DataOutputStream printout;
                    DataInputStream input;
                    url = new URL(cadena);
                    urlConn = (HttpURLConnection) url.openConnection();
                    urlConn.setDoInput(true);
                    urlConn.setDoOutput(true);
                    urlConn.setUseCaches(false);
                    urlConn.setRequestProperty("Content-Type", "application/json");
                    urlConn.setRequestProperty("Accept", "application/json");
                    urlConn.connect();
                    //Creo el Objeto JSON
                    JSONObject jsonParam = new JSONObject();
                    jsonParam.put("username", params[2]);
                    jsonParam.put("email", params[3]);
                    jsonParam.put("password", params[4]);
                    jsonParam.put("city", params[5]);
                    jsonParam.put("country", params[6]);
                    jsonParam.put("mobile_no", params[7]);
                    jsonParam.put("licence", params[8]);
                    jsonParam.put("device_token", params[9]);
                    jsonParam.put("especialize", params[10]);
                    // Envio los parámetros post.
                    OutputStream os = urlConn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(jsonParam.toString());
                    writer.flush();
                    writer.close();

                    int respuesta = urlConn.getResponseCode();


                    StringBuilder result = new StringBuilder();

                    if (respuesta == HttpURLConnection.HTTP_OK) {

                        String line;
                        BufferedReader br=new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                        while ((line=br.readLine()) != null) {
                            result.append(line);
                            //response+=line;
                        }

                        //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                        JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                        //Accedemos al vector de resultados

                        String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON
devuelve=resultJSON;
                        if (resultJSON == "1") {      // hay un alumno que mostrar
                            devuelve = "Doctor Registrado Correctamente";

                        } else if (resultJSON == "2") {
                            devuelve = "Error";
                        }

                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    devuelve = "Error MalformedURLException--->"+e.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                    devuelve = "Error De Conexión--->"+ e.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    devuelve ="Error De JSON--->-"+ e.toString();
                }

                return devuelve;
            }
            return null;
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }

        @Override
        protected void onPostExecute(String s)
        {

            ringProgressDialog.dismiss();
            Toast.makeText(registrojava.this, "Resultado-->"+s, Toast.LENGTH_LONG).show();
            //super.onPostExecute(s);
        }

        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(registrojava.this, "Espere Por Favor ...", "Registrando Doctor", true);
            ringProgressDialog.setCancelable(true);

            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

}