package com.example.zamgu.midoconline;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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
                Intent intent2 = new Intent(getActivity().getApplication(), registropjava.class);
                startActivity(intent2);
                dismiss();
            }
        });

        builder.setNeutralButton("Medico", new DialogInterface.OnClickListener()
        {@Override
        public void onClick(DialogInterface dialog, int which)
        {
            Intent intent2 = new Intent(getActivity().getApplication(), registrojava.class);
            startActivity(intent2);
            dismiss();
        }
        });

        return builder.create();
    }
}
