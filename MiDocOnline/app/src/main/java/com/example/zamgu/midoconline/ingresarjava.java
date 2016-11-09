package com.example.zamgu.midoconline;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

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
import java.util.ArrayList;

/**
 * Created by zamgu on 31/10/2016.
 */

public class ingresarjava extends Activity implements View.OnClickListener
{
    String url = "https://www.midoconline.com/tokens/get_key";
    EditText txt_correo,txt_pass;
    ImageButton btn1, btn2;
    ObtenerWebService hiloconexion;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar);
        findViewById(R.id.btningresaringresar).setOnClickListener(this);
        findViewById(R.id.btnolvido).setOnClickListener(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        txt_correo =(EditText) findViewById(R.id.txtcorreoelectronico);
        txt_pass=(EditText) findViewById(R.id.password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btningresaringresar:
                datoscorrectos();
                break;
            case R.id.btnolvido:
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Correo Enviado", Toast.LENGTH_SHORT);
                toast1.show();
                break;
        }
    }
    public void datoscorrectos()
    {
        String manufacturer = android.os.Build.MANUFACTURER;
        hiloconexion = new ObtenerWebService();
        hiloconexion.execute(url,txt_correo.getText().toString(),txt_pass.getText().toString());
        Toast.makeText(getApplicationContext(), ""+url+txt_correo.getText().toString()+txt_pass.getText().toString(), Toast.LENGTH_LONG).show();
    }
    public class ObtenerWebService extends AsyncTask<String,Void,String> {

        @Override

        protected String doInBackground(String... params) {

            String cadena = params[0];
            URL url = null; // Url de donde queremos obtener información
            String devuelve = "";

            Toast.makeText(getApplicationContext(), "Revisa si hay algo" + params[0], Toast.LENGTH_SHORT).show();

            try {
                Toast.makeText(getApplicationContext(), "Entra funcion....", Toast.LENGTH_SHORT).show();
                devuelve = "Entra Funcion";
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
                devuelve = "CreaJson";
                //Creo el Objeto JSON
                JSONObject jsonparam = new JSONObject();
                jsonparam.put("email", params[1]);
                jsonparam.put("password", params[2]);
                // Envio los parámetros post.
                devuelve = "Envia Funcion";
                OutputStream os = urlConn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(jsonparam.toString());
                writer.flush();
                writer.close();

                int respuesta = urlConn.getResponseCode();
                devuelve = "respuesta "+respuesta;

                StringBuilder result = new StringBuilder();

                if (respuesta == HttpURLConnection.HTTP_OK) {
                    Toast.makeText(getApplicationContext(), "Entra Servidor", Toast.LENGTH_SHORT).show();
                    devuelve = "Entra Servidor";
                    String line;
                    BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                    while ((line = br.readLine()) != null)
                    {
                        result.append(line);
                        //response+=line;
                    }

                    //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                    JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                    //Accedemos al vector de resultados
                    String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON
                    devuelve = resultJSON;

                    if (resultJSON == "1") {      // hay un alumno que mostrar
                        devuelve = "Login";

                    } else if (resultJSON == "2") {
                        devuelve = "No Login";
                    }

                }

            } catch (MalformedURLException e)
            {
                e.printStackTrace();
                devuelve = "Login1";

            } catch (IOException e) {
                e.printStackTrace();
                devuelve = "Login2";
            } catch (JSONException e) {
                e.printStackTrace();
                devuelve = ""+e.toString();
            }

            return devuelve;

        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }

        @Override
        protected void onPostExecute(String s) {
            //resultado.setText(s);
            if(s.toString().equals(""))
            {
                Toast.makeText(getApplicationContext(),"Vacio" + s,Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"" + s,Toast.LENGTH_SHORT).show();
            }


            //super.onPostExecute(s);
            //descargarImagen();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}
