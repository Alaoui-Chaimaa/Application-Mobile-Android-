package com.example.allodoc.test.model;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.allodoc.test.controller.AcceuilSecretaire;
import com.example.allodoc.test.controller.AjouterNvRdv;
import com.example.allodoc.test.controller.Recherche;

public class BoiteDeDialogue1  extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setMessage("Ce rendez-vous a été enregistré")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                        Intent intent=new Intent(getActivity(), AjouterNvRdv.class);
                        startActivity(intent);
                    }
                });
        return builder.create();
    }
}
