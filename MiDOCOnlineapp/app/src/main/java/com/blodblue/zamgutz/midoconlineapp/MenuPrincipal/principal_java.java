package com.blodblue.zamgutz.midoconlineapp.MenuPrincipal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import com.blodblue.zamgutz.midoconlineapp.Ingresar.ingresar_java;
import com.blodblue.zamgutz.midoconlineapp.IoCard.iocard_java;
import com.blodblue.zamgutz.midoconlineapp.R;
import com.blodblue.zamgutz.midoconlineapp.Sich.LoginActivity;
import com.blodblue.zamgutz.midoconlineapp.Terminos.terminos_java;

public class principal_java extends Fragment implements View.OnClickListener {
    Button btn1, btn2, btn3,btn4;
    ImageButton btncall;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.principal, container, false);
        btn1 = (Button) rootView.findViewById(R.id.btn_ingresar_principal);
        btn1.setOnClickListener(this);
        btn2 = (Button) rootView.findViewById(R.id.btn_terminos_principal);
        btn2.setOnClickListener(this);
        btn3 = (Button) rootView.findViewById(R.id.btn_registrar_principal);
        btn3.setOnClickListener(this);
        btn4 = (Button) rootView.findViewById(R.id.btn_emergencia_principal);
        btn4.setOnClickListener(this);
        ImageButton camBt = (ImageButton)rootView.findViewById(R.id.btn_llamar_principal);


        ImageButton.OnClickListener listener = new ImageButton.OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                Intent intent = new Intent(getActivity().getApplication(), iocard_java.class);
                startActivity(intent);
            }
        };
        camBt.setOnClickListener(listener);
        return rootView;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ingresar_principal:
                Intent intent = new Intent(getActivity().getApplication(), ingresar_java.class);
                startActivity(intent);
                break;
            case R.id.btn_terminos_principal:
                Intent intent2 = new Intent(getActivity().getApplication(), terminos_java.class);
                startActivity(intent2);
                break;
            case R.id.btn_registrar_principal:
                FragmentManager fm = getFragmentManager();
                TestDialog dialogFragment = new TestDialog ();
                dialogFragment.show(fm, "Sample Fragment");
                break;
            case R.id.btn_emergencia_principal:
                Intent intent3 = new Intent(getActivity().getApplication(), LoginActivity.class);
                intent3.putExtra("nombreUsuario", "paco");
                startActivity(intent3);
                break;
        }
    }
}
