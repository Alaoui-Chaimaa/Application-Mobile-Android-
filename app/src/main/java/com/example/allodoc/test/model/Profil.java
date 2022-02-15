package com.example.allodoc.test.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Profil implements Parcelable {
    private String nom_medecin;
    private String specialite;
    private String adresse;
    private String tel;
    public Profil(String nm,String s) {
        this.nom_medecin = nm;
        this.specialite=s;

    }

    public Profil(String nm,String s,String a,String t) {
        this.nom_medecin = nm;
        this.specialite=s;
        this.adresse=a;
        this.tel=t;
    }

    protected Profil(Parcel in) {
        nom_medecin = in.readString();
        specialite = in.readString();
        adresse=in.readString();
        tel=in.readString();
    }

    public static final Creator<Profil> CREATOR = new Creator<Profil>() {
        @Override
        public Profil createFromParcel(Parcel in) {
            return new Profil(in);
        }

        @Override
        public Profil[] newArray(int size) {
            return new Profil[size];
        }
    };

    public String getNom_medecin() {
        return nom_medecin;
    }

    public void setNom_medecin(String nom_medecin) {
        this.nom_medecin = nom_medecin;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom_medecin);
        dest.writeString(specialite);
        dest.writeString(adresse);
        dest.writeString(tel);

    }
}
