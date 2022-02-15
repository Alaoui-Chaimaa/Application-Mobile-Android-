package com.example.allodoc.test.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.allodoc.R;
import com.example.allodoc.test.controller.ProfilMedecin;
import com.example.allodoc.test.controller.SearchingMedecin;
import com.example.allodoc.test.model.Profil;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends BaseAdapter  {
    private Context mContext;
    private java.util.List<Profil> List;
    private String tel;
    public static List<Profil> temporaryList;
    public static Button btn_prise_rdv;


    public Adapter(Context mContext,String tel, List<Profil> List) {
        this.mContext = mContext;
        this.List = List;
        this.tel=tel;
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
        convertView = inflater.inflate(R.layout.list_item, null);
        TextView t1 = (TextView) convertView.findViewById(R.id.nom_medecin);

        btn_prise_rdv=(Button) convertView.findViewById(R.id.btn_prise_rdv);
        Profil doctor = List.get(position);
        t1.setText(doctor.getNom_medecin());
        btn_prise_rdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,ProfilMedecin.class);
                intent.putExtra("Item",List.get(position));
                intent.putExtra("tel",tel);
                mContext.startActivity(intent);

            }
        });


        return convertView;
    }
    public void update(List<Profil> results)
    {
        List=new ArrayList<>();
        List.addAll(results);
        notifyDataSetChanged();
    }



}


