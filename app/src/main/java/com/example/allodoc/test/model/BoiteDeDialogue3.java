package com.example.allodoc.test.model;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.allodoc.test.controller.ListRdv;
import com.example.allodoc.test.controller.ListeSpecialites;
import com.example.allodoc.test.controller.Recherche;
import com.example.allodoc.test.controller.SearchingMedecin;

public class BoiteDeDialogue3 extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setMessage("Votre rendez-vous  a été enregistré")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                        Intent intent=new Intent(getActivity(), ListeSpecialites.class);
                        startActivity(intent);
                    }
                });
        return builder.create();
    }
}
