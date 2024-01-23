package org.example;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

public class Cerere implements Comparable {

    String nume;
    String text;

    public void setText(String text) {
        this.text = text;
    }

    String tipCerere;
    //  String pattern = "dd-MMM-yyyy HH:mm:ss";

    public String getTipCerere() {
        return tipCerere;
    }

    public void setTipCerere(String tipCerere) {
        this.tipCerere = tipCerere;
    }

    Date data;

    String prioritate;

    public Cerere(String nume, String tipCerere, Date data, String prioritate) {
        this.nume = nume;
        this.tipCerere = tipCerere;
        this.data = data;
        this.prioritate = prioritate;
    }

    public String data() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        return formatter.format(this.data);
    }

    @Override
    public int compareTo(Object o) {
        Cerere c = (Cerere) o;
        if (this.data.compareTo(c.data) != 0) {
            return this.data.compareTo(c.data);
        }
        return this.prioritate.compareTo(c.prioritate);
    }

    enum Tip_cerere {
        INLOCUIRE_BULETIN,
        INREGISTRARE_VENIT_SALARIAL,
        INLOCUIRE_CARNET_DE_SOFER,
        INLOCUIRE_CARNET_DE_ELEV,
        CREARE_ACT_CONSTITUTIV,
        REINNOIRE_AUTORIZATIE,
        INREGISTRARE_CUPOANE_DE_PENSIE
    }

}

