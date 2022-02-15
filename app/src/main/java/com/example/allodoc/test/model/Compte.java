package com.example.allodoc.test.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Compte {
    private int code;
    private String nom;
    private String tel;
    private String email;
    private String motdepasse;

    public Compte(int c,String n,String t,String e,String m) {
        this.code=c;
        this.nom=n;
        this.tel = t;
        this.email=e;
        this.motdepasse=m;
    }





    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }


}
