package com.example.allodoc.test.model;

import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.allodoc.R;
import com.example.allodoc.test.controller.ModifierRdv;
import com.example.allodoc.test.controller.ModifierRdvSecretaire;

import java.util.List;

public class AdapterRdvSecretaire extends BaseAdapter {
    private Context contexte;
    private List<Rdv> list;
    private AccesLocal acces;
    private int id;
    public AdapterRdvSecretaire(Context contexte,List<Rdv> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent)  {
        acces=new AccesLocal(contexte);
        LayoutInflater inflater = (LayoutInflater) contexte.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_rdv_secretaire, null);
        TextView t1 = (TextView) convertView.findViewById(R.id.nom_p);
        TextView t2 = (TextView) convertView.findViewById(R.id.tel_p);
        TextView t3 = (TextView) convertView.findViewById(R.id.b_c);
        TextView t4 = (TextView) convertView.findViewById(R.id.d_c);
        TextView t5=(TextView) convertView.findViewById(R.id.h_c) ;
        TextView t6=(TextView) convertView.findViewById(R.id.accord_refus) ;
        final Button btn_accepter=(Button)convertView.findViewById(R.id.btn_accepter);
        final Button btn_refuser=(Button)convertView.findViewById(R.id.btn_refuser);
        Button btn_modifier=(Button)convertView.findViewById(R.id.btn_modifier_secretaire);


        final Rdv rdv = list.get(position);
        t1.setText("Nom du Patient: "+rdv.getNom_patient());
        t2.setText("Tel Patient: "+rdv.getTel_patient());
        t3.setText("But De Consultation: "+rdv.getBut_consultation());
        t4.setText("Date De Consultation: "+rdv.getDate());
        t5.setText("Heure De Consultation: "+rdv.getHeure());
        t6.setText(rdv.getReponse());


       btn_accepter.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String message="Votre rendez-vous  Avec Le Docteur "+list.get(position).getNom_docteur()
                    +" Le "+list.get(position).getDate()+" A "+list.get(position).getHeure()+" a été accepté" +
                    " Lieu De Consultation est: "+list.get(position).getLieu_consultation();
            SmsManager.getDefault().sendTextMessage(list.get(position).getTel_patient(),"AlloDoc",message,null,null);
             id=list.get(position).getId();
             acces.UpdateRdvRep("Rendez-vous accepté",id);

        }
        });

       btn_refuser.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String message="Votre rendez-vous  Avec Le Docteur "+list.get(position).getNom_docteur()
                       +" Le "+list.get(position).getDate()+" A "+list.get(position).getHeure()+" a été refusé";
               SmsManager.getDefault().sendTextMessage(list.get(position).getTel_patient(),"AlloDoc",message,null,null);
               acces.DeleteRdv(list.get(position).getId());
               list.remove(list.get(position));
               notifyDataSetChanged();

           }
       });
       btn_modifier.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(contexte, ModifierRdvSecretaire.class);
               intent.putExtra("rdv_secretaire",list.get(position));
               contexte.startActivity(intent);
           }
       });

 return  convertView;
    }

}
