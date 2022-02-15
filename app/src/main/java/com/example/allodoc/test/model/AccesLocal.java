package com.example.allodoc.test.model;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.widget.Toast;

import com.example.allodoc.test.outils.SQLiteDataBaseHelper;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AccesLocal {

//propriétés
    private SQLiteDataBaseHelper accesBD;
    private SQLiteDatabase bd;
    /*Constructeur
     */
    public AccesLocal(Context contexte)
    {
        accesBD=new SQLiteDataBaseHelper(contexte);
    }
    /*
    ajout d'un compte dans la base de données
     */
    public void ajoutCompte(Compte C)
    {
        bd=accesBD.getWritableDatabase();
        String req="insert into compte (code,nom,telephone,email,motdepasse) values";
        req+="("+C.getCode()+",'"+C.getNom()+"','"+C.getTel() +"','"+C.getEmail()+"','"+C.getMotdepasse()+"')";
        bd.execSQL(req);
    }
   public int num_existe(String num)
    {
        bd=accesBD.getReadableDatabase();
        String req="select * from compte ";
        Cursor result=bd.rawQuery(req,null);
        while (result.moveToNext())
        {
            if(result.getString(2).equals(num))
                return 1;
        }
        result.close();
        return 0;
    }
    public int compte_existe(String num,String password)
    {
        bd=accesBD.getReadableDatabase();
        String req="select * from compte ";
        Cursor resultat=bd.rawQuery(req,null);
        while(resultat.moveToNext())
        {
            if(resultat.getString(2).equals(num))
            {
                if(resultat.getString(4).equals(password)) {
                    return 1;
                } else
                {
                   return 0;
                }
            }
        }
        return -1;
    }
    public List<Profil> getListProduct() {
        Profil product = null;
        List<Profil> productList = new ArrayList<>();
        bd=accesBD.getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM medecin", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            product = new Profil(cursor.getString(0), cursor.getString(1),
                    cursor.getString(2),cursor.getString(3));
            productList.add(product);
            cursor.moveToNext();
        }
        cursor.close();
        accesBD.close();
        return productList;
    }
    public List<Profil> getListMedecin(String specialite) {
        Profil product = null;
        List<Profil> productList = new ArrayList<>();
        bd=accesBD.getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM medecin where specialite='"+specialite+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            product = new Profil(cursor.getString(0), cursor.getString(1),
                    cursor.getString(2),cursor.getString(3));
            productList.add(product);
            cursor.moveToNext();
        }
        cursor.close();
        accesBD.close();
        return productList;
    }
    public void ajoutRendezVous(String n_patient,String tel_patient,String n_medecin,String but_cons,
                                String date,String heure,String lieu)
    {
        bd=accesBD.getWritableDatabase();
        String req="INSERT INTO rendez_vous (nom_patient,tel_patient,nom_medecin,but_consultation,date,heure,lieu_consultation) VALUES";
        req+= "('"+n_patient+"','"+tel_patient+"','"+n_medecin+"','"+but_cons+"','"+date+"','"+heure+"','"+lieu+"')";
        bd.execSQL(req);

    }
    public int RendezVousExiste(String nom,String heure,String date)
    {
        bd=accesBD.getReadableDatabase();
        String req="select * from rendez_vous ";
        Cursor curseur=bd.rawQuery(req,null);
        while (curseur.moveToNext())
        {
           if(curseur.getString(3).equals(nom))
           {
               if(curseur.getString(5).equals(date))
               {
                   if(curseur.getString(6).equals(heure))
                       return 1;
               }
           }
        }
      return 0;
    }

public String getNomPatient(String num)
{
    String nom=null;
    bd=accesBD.getReadableDatabase();
    String req="select * from compte";
    Cursor res=bd.rawQuery(req,null);
    while (res.moveToNext())
    {
        if(res.getString(2).equals(num))
        {
            nom=res.getString(1);
        }
    }
    return nom;
}
    public String getEmailPatient(String num)
    {
        String email=null;
        bd=accesBD.getReadableDatabase();
        String req="select * from compte";
        Cursor res=bd.rawQuery(req,null);
        while (res.moveToNext())
        {
            if(res.getString(2).equals(num))
            {
                email=res.getString(3);
            }
        }
        return email;
    }
    public String getPassPatient(String num)
    {
        String password=null;
        bd=accesBD.getReadableDatabase();
        String req="select * from compte";
        Cursor res=bd.rawQuery(req,null);
        while (res.moveToNext())
        {
            if(res.getString(2).equals(num))
            {
                password=res.getString(4);
            }
        }
        return password;
    }
    public String getTelPatient(int id)
    {
        String tel=null;
        bd=accesBD.getReadableDatabase();
        String req="select * from rendez_vous";
        Cursor res=bd.rawQuery(req,null);
        while (res.moveToNext())
        {
            if(res.getInt(2)==id)
            {
                tel=res.getString(1);
            }
        }
        return tel;
    }
    public List<Rdv> getListRdv(String num) {
        Rdv rdv=null;
        List<Rdv> RdvList = new ArrayList<>();
        bd=accesBD.getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM rendez_vous", null);
        while (cursor.moveToNext())
        {
            if(cursor.getString(1).equals(num))
            {
              rdv=new Rdv(cursor.getInt(2),cursor.getString(5),cursor.getString(6),cursor.getString(3),cursor.getString(7),cursor.getString(4),cursor.getString(1));
              RdvList.add(rdv);
            }
        }
      cursor.close();
        accesBD.close();
        return RdvList;
    }
    public void DeleteRdv(int id)
    {
        bd=accesBD.getWritableDatabase();
        String req="delete from rendez_vous where id="+id+"";
        bd.execSQL(req);
    }
    public void UpdateRdv(String n_d,String b_c,String date,String heure,String l_c,int id)
    {
        bd=accesBD.getWritableDatabase();
        String req="update rendez_vous set nom_medecin='"+n_d+"',but_consultation='"+b_c+"',date='"+date+"'" +
                ",heure='"+heure+"',lieu_consultation='"+l_c+"' where id="+id+"";
        bd.execSQL(req);

    }
    public void UpdateRdvSecretaire(String date,String heure,int id)
    {
        bd=accesBD.getWritableDatabase();
        String req="update rendez_vous set date='"+date+"',heure='"+heure+"' where id="+id+"";
        bd.execSQL(req);

    }
    public int secretaire_existe(String nom,String identifiant)
    {
        bd=accesBD.getReadableDatabase();
        String req="select * from secretaire";
        Cursor resultat=bd.rawQuery(req,null);
        while(resultat.moveToNext())
        {
            if(resultat.getString(0).equals(nom))
            {
                if(resultat.getString(1).equals(identifiant)) {
                    return 1;
                } else
                {
                    return 0;
                }
            }
        }
        return -1;
    }
    public List<Rdv> getRdvSecretaire(String nom) {
        Rdv rdv=null;
        List<Rdv> RdvList = new ArrayList<>();
        bd=accesBD.getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM rendez_vous", null);
        while (cursor.moveToNext())
        {
            if(cursor.getString(3).equals(nom))
            {
                rdv=new Rdv(cursor.getString(0),cursor.getString(1),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getInt(2),cursor.getString(3),cursor.getString(7),cursor.getString(8));
                RdvList.add(rdv);
            }
        }
        cursor.close();
        accesBD.close();
        return RdvList;
    }
    public int RendezVousExisteJour(String tel_p,String nom_m,String date)
    {
        bd=accesBD.getReadableDatabase();
        String req="select * from rendez_vous ";
        Cursor curseur=bd.rawQuery(req,null);
        while (curseur.moveToNext())
        {
            if(curseur.getString(1).equals(tel_p))
            {
                if(curseur.getString(3).equals(nom_m))
                {
                    if(curseur.getString(5).equals(date))
                        return 1;
                }
            }
        }
        return 0;
    }
    public String getLieu(String nom_medecin)
    {
        String lieu=null;
        bd=accesBD.getReadableDatabase();
        String req="select * from medecin";
        Cursor res=bd.rawQuery(req,null);
        while (res.moveToNext())
        {
            if(res.getString(0).equals(nom_medecin))
            {
                lieu=res.getString(2);
            }
        }
        return lieu;
    }
    public void UpdateRdvRep(String rep,int id)
    {
        bd=accesBD.getWritableDatabase();
        String req="update rendez_vous set reponse='"+rep+"' where id="+id+"";
        bd.execSQL(req);

    }


}

