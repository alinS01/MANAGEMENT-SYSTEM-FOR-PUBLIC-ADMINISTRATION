package org.example;

import java.io.IOException;

public class Angajat extends Utilizator {
    String companie;

    public Angajat(String nume, String companie) {
        super(nume);
        this.companie = companie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCompanie() {
        return companie;
    }

    public void setCompanie(String companie) {
        this.companie = companie;
    }

    @Override
    public void adauga_utilizator() {

    }

    @Override
    public String textulCererii(Cerere cerere) {
        return (cerere.data() + " - Subsemnatul " + cerere.nume + ", angajat la compania " + companie + ", va rog sa-mi aprobati urmatoarea solicitare: " + cerere.tipCerere);
    }

    @Override
    public int exceptieCerere(Cerere cerere) throws IOException {//aici am facut un nou string egal cu valorile din enumeratie si am facut doua operatii pe stringuri
        String autorizatie = String.valueOf(Cerere.Tip_cerere.REINNOIRE_AUTORIZATIE);
        autorizatie = autorizatie.toLowerCase();
        autorizatie = autorizatie.replace("_", " ");

        String carnetElev = String.valueOf(Cerere.Tip_cerere.INLOCUIRE_CARNET_DE_ELEV);
        carnetElev = carnetElev.toLowerCase();
        carnetElev = carnetElev.replace("_", " ");

        String actConstitutiv = String.valueOf(Cerere.Tip_cerere.CREARE_ACT_CONSTITUTIV);
        actConstitutiv = actConstitutiv.toLowerCase();
        actConstitutiv = actConstitutiv.replace("_", " ");

        String cupoanePensie = String.valueOf(Cerere.Tip_cerere.INREGISTRARE_CUPOANE_DE_PENSIE);
        cupoanePensie = cupoanePensie.toLowerCase();
        cupoanePensie = cupoanePensie.replace("_", " ");

        if (cerere.getTipCerere().compareTo(autorizatie) == 0) {
            try {
                throw new ExceptieCerere("Utilizatorul de tip angajat nu poate inainta o cerere de tip reinnoire autorizatie");
            } catch (ExceptieCerere e) {
                ManagementPrimarie.scrieFisier(e.text);
                return 0;
            }
        }
        if (cerere.getTipCerere().compareTo(carnetElev) == 0) {
            try {
                throw new ExceptieCerere("Utilizatorul de tip angajat nu poate inainta o cerere de tip inlocuire carnet de elev");
            } catch (ExceptieCerere e) {
                ManagementPrimarie.scrieFisier(e.text);
                return 0;
            }
        }
        if (cerere.getTipCerere().compareTo(actConstitutiv) == 0) {
            try {
                throw new ExceptieCerere("Utilizatorul de tip angajat nu poate inainta o cerere de tip creare act constitutiv");
            } catch (ExceptieCerere e) {
                ManagementPrimarie.scrieFisier(e.text);
                return 0;
            }
        }
        if (cerere.getTipCerere().compareTo(cupoanePensie) == 0) {
            try {
                throw new ExceptieCerere("Utilizatorul de tip angajat nu poate inainta o cerere de tip inregistrare cupoane de pensie");
            } catch (ExceptieCerere e) {
                ManagementPrimarie.scrieFisier(e.text);
                return 0;//return 0 daca a gasit exceptia
            }
        }

        return 1;
    }
}
