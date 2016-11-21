package com.blodblue.zamgutz.midoconlineapp.Ingresar;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.blodblue.zamgutz.midoconlineapp.R;

public class ingresar_java extends Activity implements View.OnClickListener
{
    EditText txt_correo,txt_pass;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar);
        findViewById(R.id.btn_ingresar_ingresar).setOnClickListener(this);
        findViewById(R.id.btn_olvido_ingresar).setOnClickListener(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        txt_correo =(EditText) findViewById(R.id.txt_correo_ingresar);
        txt_pass=(EditText) findViewById(R.id.txt_pass_ingresar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ingresar_ingresar:
                datoscorrectos();
                break;
            case R.id.btn_olvido_ingresar:
                Toast toast1 =Toast.makeText(getApplicationContext(),"Correo Enviado", Toast.LENGTH_SHORT);
                toast1.show();
                break;
        }
    }
    public void datoscorrectos()
    {
        Toast toast1 =Toast.makeText(getApplicationContext(),"Ingreso Correcto", Toast.LENGTH_SHORT);
        toast1.show();
    }
}
