package com.example.allodoc.test.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.allodoc.R;
import com.example.allodoc.test.controller.ProfilMedecin;

import java.util.List;

public class AdapterDoctorModify extends BaseAdapter {
    private Context mContext;
    private List<Profil> List;

    public AdapterDoctorModify(Context context,List<Profil> list) {
        this.mContext=context;
        this.List = list;
    }

    @Override
    public int getCount() {
        return List.size();
    }

    @Override
    public Object getItem(int position) {
        return List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_doctors_modify, null);
        TextView t1 = (TextView) convertView.findViewById(R.id.nom_medecin_modify);
        TextView t2 = (TextView) convertView.findViewById(R.id.specialite_medecin_modify);
        TextView t3 = (TextView) convertView.findViewById(R.id.adresse_medecin_modify);
        Profil doctor = List.get(position);
        t1.setText(doctor.getNom_medecin());
        t2.setText(doctor.getSpecialite());
        t3.setText(doctor.getAdresse());

        return convertView;
    }
}
