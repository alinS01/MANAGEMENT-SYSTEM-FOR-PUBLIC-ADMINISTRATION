package org.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public abstract class Utilizator {
    public Utilizator(String nume) {
        this.nume = nume;
        this.cereri = new TreeSet<>();
    }

    String nume;

    public abstract void adauga_utilizator();

    public abstract String textulCererii(Cerere cerere);//textul care trebuie scris in fiecare fisier,prezent in fiecare clasa care mosteneste Utilizator


    TreeSet<Cerere> cereri = new TreeSet<Cerere>();

    public abstract int exceptieCerere(Cerere cerere) throws IOException;//exceptiile prezente in toate  clasele care mostenesc Utilizator


}
