package org.example;

import javax.management.MalformedObjectNameException;
import java.io.IOException;

public class Elev extends Utilizator {
    String scoala;

    public Elev(String nume, String scoala) {
        super(nume);
        this.scoala = scoala;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getScoala() {
        return scoala;
    }

    public void setScoala(String scoala) {
        this.scoala = scoala;
    }

    @Override
    public void adauga_utilizator() {

    }

    @Override
    public String textulCererii(Cerere cerere) {
        return (cerere.data() + " - Subsemnatul " + cerere.nume + ", elev la scoala " + scoala + ", va rog sa-mi aprobati urmatoarea solicitare: " + cerere.tipCerere);
    }

    @Override
    public int exceptieCerere(Cerere cerere) throws IOException {
        String autorizatie = String.valueOf(Cerere.Tip_cerere.REINNOIRE_AUTORIZATIE);
        autorizatie = autorizatie.toLowerCase();
        autorizatie = autorizatie.replace("_", " ");

        String carnetSofer = String.valueOf(Cerere.Tip_cerere.INLOCUIRE_CARNET_DE_SOFER);
        carnetSofer = carnetSofer.toLowerCase();
        carnetSofer = carnetSofer.replace("_", " ");

        String actConstitutiv = String.valueOf(Cerere.Tip_cerere.CREARE_ACT_CONSTITUTIV);
        actConstitutiv = actConstitutiv.toLowerCase();
        actConstitutiv = actConstitutiv.replace("_", " ");

        String cupoanePensie = String.valueOf(Cerere.Tip_cerere.INREGISTRARE_CUPOANE_DE_PENSIE);
        cupoanePensie = cupoanePensie.toLowerCase();
        cupoanePensie = cupoanePensie.replace("_", " ");

        String venitSalarial = String.valueOf(Cerere.Tip_cerere.INREGISTRARE_VENIT_SALARIAL);
        venitSalarial = venitSalarial.toLowerCase();
        venitSalarial = venitSalarial.replace("_", " ");

        if (cerere.getTipCerere().compareTo(autorizatie) == 0) {
            try {
                throw new ExceptieCerere("Utilizatorul de tip elev nu poate inainta o cerere de tip reinnoire autorizatie");
            } catch (ExceptieCerere e) {
                ManagementPrimarie.scrieFisier(e.text);
                return 0;
            }
        }
        if (cerere.getTipCerere().compareTo(venitSalarial) == 0) {
            try {
                throw new ExceptieCerere("Utilizatorul de tip elev nu poate inainta o cerere de tip inregistrare venit salarial");
            } catch (ExceptieCerere e) {
                ManagementPrimarie.scrieFisier(e.text);
                return 0;
            }
        }
        if (cerere.getTipCerere().compareTo(actConstitutiv) == 0) {
            try {
                throw new ExceptieCerere("Utilizatorul de tip elev nu poate inainta o cerere de tip creare act constitutiv");
            } catch (ExceptieCerere e) {
                ManagementPrimarie.scrieFisier(e.text);
                return 0;
            }
        }
        if (cerere.getTipCerere().compareTo(carnetSofer) == 0) {
            try {
                throw new ExceptieCerere("Utilizatorul de tip elev nu poate inainta o cerere de tip inlocuire carnet de sofer");
            } catch (ExceptieCerere e) {
                ManagementPrimarie.scrieFisier(e.text);
                return 0;
            }
        }
        if (cerere.getTipCerere().compareTo(cupoanePensie) == 0) {
            try {
                throw new ExceptieCerere("Utilizatorul de tip elev nu poate inainta o cerere de tip inregistrare cupoane de pensie");
            } catch (ExceptieCerere e) {
                ManagementPrimarie.scrieFisier(e.text);
                return 0;//return 0 daca a gasit exceptia
            }
        }
        return 1;//returneaza 1 daca nu a gasit nimic
    }
}
