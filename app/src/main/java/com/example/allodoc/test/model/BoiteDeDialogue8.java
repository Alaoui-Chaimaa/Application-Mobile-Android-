package com.example.allodoc.test.model;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import android.app.AlertDialog;

import com.example.allodoc.test.controller.AcceuilSecretaire;
import com.example.allodoc.test.controller.ListRdvSecretaire;
import com.example.allodoc.test.controller.SearchingMedecin;

public class BoiteDeDialogue8  extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Message")
                .setMessage("Ce rendez-vous a été modifié");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getActivity().finish();
                Intent intent=new Intent(getActivity(), AcceuilSecretaire.class);
                startActivity(intent);
            }
        });
        return builder.create();
    }
}
