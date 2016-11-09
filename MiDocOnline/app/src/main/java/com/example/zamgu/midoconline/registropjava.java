package com.example.zamgu.midoconline;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by zamgu on 31/10/2016.
 */

public class registropjava extends AppCompatActivity implements View.OnClickListener{
    EditText txt_nombre,txt_apellido,txt_correo,txt_pass,txt_pass2,txt_telefono,txt_fecha;
    String txt_genero, sdia, smes,syear;
    ObtenerWebService hiloconexion;
    ProgressDialog ringProgressDialog;
    String UPDATE = "https://midoconline.com/tokens/user_sign_up?";
    private CheckBox tyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registropaciente
        );
        findViewById(R.id.btnregistrarpac).setOnClickListener(this);
        findViewById(R.id.btntycp).setOnClickListener(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        txt_nombre = (EditText) findViewById(R.id.txtnombrerp);
        txt_correo =(EditText) findViewById(R.id.txtcorreorp);
        txt_pass=(EditText) findViewById(R.id.passwordrp);
        txt_pass2=(EditText)findViewById(R.id.passwordcrp);
        txt_apellido=(EditText) findViewById(R.id.txtapellidorp);
        txt_telefono=(EditText) findViewById(R.id.txtnumerorp);
        //txt_fecha=(EditText) findViewById(R.id.txtfecha);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final Spinner spinnerdia = (Spinner) findViewById(R.id.dias);
        final Spinner spinnermes = (Spinner) findViewById(R.id.mes);
        final Spinner spinneryear = (Spinner) findViewById(R.id.year);
        tyc=(CheckBox)findViewById(R.id.checkBox);
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
                // Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                txt_genero= (String) spinner.getSelectedItem();
                //Toast.makeText(registropjava.this, ""+selState, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio

            }
        });
        spinnerdia.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dia));

        spinnerdia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                // Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                sdia = (String) spinnerdia.getSelectedItem();
                //Toast.makeText(registropjava.this, ""+selState, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio

            }
        });
        spinnermes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, me));

        spinnermes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                // Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                smes= (String) spinnermes.getSelectedItem();
                //Toast.makeText(registropjava.this, ""+selState, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio

            }
        });
        spinneryear.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ye));

        spinneryear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                // Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                syear = (String) spinneryear.getSelectedItem();
                //Toast.makeText(registropjava.this, ""+selState, Toast.LENGTH_SHORT).show();

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
            case R.id.btnregistrarpac:
                PacienteValidation();
                break;
            case R.id.btntycp:
                Intent iExp2 = new Intent(registropjava.this, terminos.class);
                startActivity(iExp2);
                break;
        }
    }
    public void PacienteValidation()
    {
        if(txt_nombre.getText().toString().equals(""))
        {
            Toast.makeText(registropjava.this, "Ingrese Nombre", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(txt_apellido.getText().toString().equals(""))
            {
                Toast.makeText(registropjava.this, "Ingrese Apellido", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if(txt_correo.getText().toString().equals(""))
                {
                    Toast.makeText(registropjava.this, "Ingrese Correo", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(txt_pass.getText().toString().equals(""))
                    {
                        Toast.makeText(registropjava.this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(txt_pass.getText().toString().length() <= 7)
                        {
                            Toast.makeText(registropjava.this, "La Contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            if(txt_pass2.getText().toString().equals(""))
                            {
                                Toast.makeText(registropjava.this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                if(txt_pass.getText().toString().equals(txt_pass2.getText().toString()))
                                {
                                    if(txt_telefono.getText().toString().equals(""))
                                    {
                                        Toast.makeText(registropjava.this, "Ingrese Telefono", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {

                                            if (tyc.isChecked()==true)
                                            {
                                                datoscorrectos();
                                            }
                                            else
                                            {
                                                Toast.makeText(registropjava.this, "Debes Aceptar Términos y Condiciones ", Toast.LENGTH_SHORT).show();
                                            }
                                                                            }
                                }
                                else
                                {
                                    Toast.makeText(registropjava.this, "Las Contraseñas no son iguales", Toast.LENGTH_SHORT).show();
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

        String manufacturer = android.os.Build.MANUFACTURER;
        hiloconexion = new ObtenerWebService();
        hiloconexion.execute(UPDATE, "3",txt_nombre.getText().toString() , txt_correo.getText().toString() , txt_pass.getText().toString() , txt_apellido.getText().toString()
                , txt_genero , sdia+"/"+smes+"/"+syear ,  txt_telefono.getText().toString(),"true" ,manufacturer.toString());

    }
    public class ObtenerWebService extends AsyncTask<String,Void,String> {

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
                    jsonParam.put("surname", params[5]);
                    jsonParam.put("gender", params[6]);
                    jsonParam.put("dob", params[7]);
                    jsonParam.put("mobile_no", params[8]);
                    jsonParam.put("terms_and_condition", params[9]);
                    jsonParam.put("device_token", params[10]);
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
                            devuelve = "Paciente Registrado Correctamente";

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
        protected void onPostExecute(String s) {
            ringProgressDialog.dismiss();
            Toast.makeText(registropjava.this, "Resultado-->"+s, Toast.LENGTH_LONG).show();
            //super.onPostExecute(s);
        }

        @Override
        protected void onPreExecute() {

            ringProgressDialog = ProgressDialog.show(registropjava.this, "Espere Por Favor ...", "Registrando Paciente", true);
            ringProgressDialog.setCancelable(true);super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}