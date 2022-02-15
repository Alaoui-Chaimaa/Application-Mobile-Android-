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
import com.example.allodoc.test.controller.ModifierRdv;

import java.util.List;

public class AdapterRdv extends BaseAdapter {
    private Context contexte;
    private List<Rdv> list;
    private AccesLocal acces;
    public AdapterRdv(Context contexte,List<Rdv> list) {
        this.contexte = contexte;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        acces=new AccesLocal(contexte);
        LayoutInflater inflater = (LayoutInflater) contexte.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_rdv, null);
        TextView t1 = (TextView) convertView.findViewById(R.id.date);
        TextView t2 = (TextView) convertView.findViewById(R.id.heure);
        TextView t3 = (TextView) convertView.findViewById(R.id.nom_docteur);
        TextView t4 = (TextView) convertView.findViewById(R.id.lieu_consultation);
        Button btn_annuler=(Button)convertView.findViewById(R.id.btn_annuler);
        Button btn_modifier=(Button)convertView.findViewById(R.id.btn_modifier);


        final Rdv rdv = list.get(position);
       t1.setText("Date: "+rdv.getDate());
       t2.setText("Heure: "+rdv.getHeure());
       t3.setText("Avec DR. "+rdv.getNom_docteur());
       t4.setText("Lieu De Consultation: "+rdv.getLieu_consultation());

       btn_annuler.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               acces.DeleteRdv(list.get(position).getId());
               list.remove(list.get(position));
               notifyDataSetChanged();
           }
       });
       btn_modifier.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(contexte, ModifierRdv.class);
               intent.putExtra("rdv",list.get(position));
               contexte.startActivity(intent);
               notifyDataSetChanged();

           }
       });

        return convertView;
    }

}
