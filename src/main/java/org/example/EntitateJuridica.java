package org.example;

import java.io.IOException;

public class EntitateJuridica extends Utilizator {
    String numeCompanie;
    String reprezentant;

    public EntitateJuridica(String numeCompanie, String reprezentant) {
        super(numeCompanie);
        this.numeCompanie = numeCompanie;
        this.reprezentant = reprezentant;
    }

    public String getNumeCompanie() {
        return numeCompanie;
    }

    public void setNumeCompanie(String numeCompanie) {
        this.numeCompanie = numeCompanie;
    }

    public String getReprezentant() {
        return reprezentant;
    }

    public void setReprezentant(String reprezentant) {
        this.reprezentant = reprezentant;
    }

    @Override
    public void adauga_utilizator() {

    }

    @Override
    public String textulCererii(Cerere cerere) {
        return (cerere.data() + " - Subsemnatul " + reprezentant + ", reprezentant legal al companiei " + numeCompanie + ", va rog sa-mi aprobati urmatoarea solicitare: " + cerere.tipCerere);
    }

    @Override
    public int exceptieCerere(Cerere cerere) throws IOException {

        String carnetElev = String.valueOf(Cerere.Tip_cerere.INLOCUIRE_CARNET_DE_ELEV);
        carnetElev = carnetElev.toLowerCase();
        carnetElev = carnetElev.replace("_", " ");

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

        String buletin = String.valueOf(Cerere.Tip_cerere.INLOCUIRE_BULETIN);
        buletin = buletin.toLowerCase();
        buletin = buletin.replace("_", " ");


        if (cerere.getTipCerere().compareTo(carnetElev) == 0) {
            try {
                throw new ExceptieCerere("Utilizatorul de tip entitate juridica nu poate inainta o cerere de tip inlocuire carnet de elev");
            } catch (ExceptieCerere e) {
                ManagementPrimarie.scrieFisier(e.text);
                return 0;
            }
        }
        if (cerere.getTipCerere().compareTo(venitSalarial) == 0) {
            try {
                throw new ExceptieCerere("Utilizatorul de tip entitate juridica nu poate inainta o cerere de tip inregistrare venit salarial");
            } catch (ExceptieCerere e) {
                ManagementPrimarie.scrieFisier(e.text);
                return 0;//return 0 daca a gasit exceptia
            }
        }
        if (cerere.getTipCerere().compareTo(cupoanePensie) == 0) {
            try {
                throw new ExceptieCerere("Utilizatorul de tip entitate juridica nu poate inainta o cerere de tip inregistrare cupoane de pensie");
            } catch (ExceptieCerere e) {
                ManagementPrimarie.scrieFisier(e.text);
                return 0;//return 0 daca a gasit exceptia
            }
        }
        if (cerere.getTipCerere().compareTo(carnetSofer) == 0) {
            try {
                throw new ExceptieCerere("Utilizatorul de tip entitate juridica nu poate inainta o cerere de tip inlocuire carnet de sofer");
            } catch (ExceptieCerere e) {
                ManagementPrimarie.scrieFisier(e.text);
                return 0;//return 0 daca a gasit exceptia
            }
        }
        if (cerere.getTipCerere().compareTo(buletin) == 0) {
            try {
                throw new ExceptieCerere("Utilizatorul de tip entitate juridica nu poate inainta o cerere de tip inlocuire buletin");
            } catch (ExceptieCerere e) {
                ManagementPrimarie.scrieFisier(e.text);
                return 0;//return 0 daca a gasit exceptia
            }
        }

        return 1;
    }
}

