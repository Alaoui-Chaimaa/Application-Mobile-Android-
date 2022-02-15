package com.example.allodoc.test.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Rdv implements Parcelable {
    private int id;
   private String date;
   private String heure;
   private String nom_docteur;
   private String lieu_consultation;
   private String but_consultation;
   private String nom_patient;
   private String tel_patient;
   private String reponse;

    public Rdv(int id,String d,String h,String n_d,String l_c,String b_c,String t) {
        this.id=id;
        this.date = d;
        this.heure=h;
        this.nom_docteur=n_d;
        this.lieu_consultation=l_c;
        this.but_consultation=b_c;
        this.tel_patient=t;
    }
    public Rdv(String n,String t,String b_c,String d_c,String h_c,int id,String nom_docteur,String lieu_consultation,String rep) {
        this.id=id;
       this.nom_patient=n;
       this.tel_patient=t;
       this.but_consultation=b_c;
       this.date=d_c;
       this.heure=h_c;
       this.nom_docteur=nom_docteur;
       this.lieu_consultation=lieu_consultation;
       this.reponse=rep;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getNom_patient() {
        return nom_patient;
    }

    public void setNom_patient(String nom_patient) {
        this.nom_patient = nom_patient;
    }

    protected Rdv(Parcel in) {
        id = in.readInt();
        date = in.readString();
        heure = in.readString();
        nom_docteur = in.readString();
        lieu_consultation = in.readString();
        but_consultation=in.readString();
    }

    public static final Creator<Rdv> CREATOR = new Creator<Rdv>() {
        @Override
        public Rdv createFromParcel(Parcel in) {
            return new Rdv(in);
        }

        @Override
        public Rdv[] newArray(int size) {
            return new Rdv[size];
        }
    };

    public String getBut_consultation() {
        return but_consultation;
    }

    public void setBut_consultation(String but_consultation) {
        this.but_consultation = but_consultation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTel_patient() {
        return tel_patient;
    }

    public void setTel_patient(String tel_patient) {
        this.tel_patient = tel_patient;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getLieu_consultation() {
        return lieu_consultation;
    }

    public void setLieu_consultation(String lieu_consultation) {
        this.lieu_consultation = lieu_consultation;
    }

    public String getNom_docteur() {
        return nom_docteur;
    }

    public void setNom_docteur(String nom_docteur) {
        this.nom_docteur = nom_docteur;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(date);
        dest.writeString(heure);
        dest.writeString(nom_docteur);
        dest.writeString(lieu_consultation);
        dest.writeString(but_consultation);
    }
}
