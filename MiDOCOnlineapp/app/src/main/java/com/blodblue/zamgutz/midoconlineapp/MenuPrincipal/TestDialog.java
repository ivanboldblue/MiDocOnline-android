package com.blodblue.zamgutz.midoconlineapp.MenuPrincipal;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.blodblue.zamgutz.midoconlineapp.Registro.registro_doctor_java;
import com.blodblue.zamgutz.midoconlineapp.Registro.registro_paciente_java;

public class TestDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Aviso");
        builder.setMessage("¿Como desea Registrarse?");

        builder.setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dismiss();
            }
        });

        builder.setNegativeButton("Paciente", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent intent2 = new Intent(getActivity().getApplication(), registro_paciente_java.class);
                startActivity(intent2);
                dismiss();
            }
        });

        builder.setNeutralButton("Medico", new DialogInterface.OnClickListener()
        {@Override
        public void onClick(DialogInterface dialog, int which)
        {
            Intent intent2 = new Intent(getActivity().getApplication(), registro_doctor_java.class);
            startActivity(intent2);
            dismiss();
        }
        });

        return builder.create();
    }
}
