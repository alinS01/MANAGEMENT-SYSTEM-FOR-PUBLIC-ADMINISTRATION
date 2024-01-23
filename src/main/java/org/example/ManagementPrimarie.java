package org.example;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ManagementPrimarie {
    public ManagementPrimarie() {
        utilizator = new ArrayList<>();
    }

    static String cale;
    static ArrayList<Utilizator> utilizator = new ArrayList<Utilizator>();//am folosit ArrayList pentru a stoca utilizatorii

    public static void scrieFisier(String text) throws IOException {
        try {
            FileWriter fw = new FileWriter("src/main/resources/output/" + cale, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            //  bw.write(text + "\n");
            out.println(text);


            out.close();
            bw.close();
            fw.close();


        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public void citesteFisier() {
        String companie = "";
        try {
            File myObj = new File("src/main/resources/input/" + cale);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] linie = myReader.nextLine().split("; ");

                if (linie[0].equals("adauga_utilizator")) {//cand prima comanda din fisier este adauga_utilizator , in fiecare caz se instantiaza un nou obiect de tipul respectiv si se adauga in ArrayList
                    if (linie[1].equals("persoana")) {
                        Persoana persoana = new Persoana(linie[2]);
                        utilizator.add(persoana);

                    }
                    if (linie[1].equals("angajat")) {
                        companie = linie[3];
                        Angajat angajat = new Angajat(linie[2], linie[3]);
                        utilizator.add(angajat);
                    }
                    if (linie[1].equals("entitate juridica")) {
                        EntitateJuridica entitateJuridica = new EntitateJuridica(linie[2], linie[3]);
                        utilizator.add(entitateJuridica);
                    }
                    if (linie[1].equals("pensionar")) {
                        Pensionar pensionar = new Pensionar(linie[2]);
                        utilizator.add(pensionar);
                        System.out.println(linie[2]);
                        System.out.println(pensionar.nume);
                    }
                    if (linie[1].equals("elev")) {
                        Elev elev = new Elev(linie[2], linie[3]);
                        utilizator.add(elev);
                    }
                }

                if (linie[0].equals("cerere_noua")) {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
                    try {
                        Date data = formatter.parse(linie[3]);
                        Cerere cerere = new Cerere(linie[1], linie[2], data, linie[4]);
                        for (Utilizator valoare : utilizator) {
                            if (valoare.nume.equals(linie[1])) {
                                if (valoare.exceptieCerere(cerere) == 1) {//parcurg cererile si in cazul in care nu se gaseste nicio exceptie cererea se adauga in treeset
                                    valoare.cereri.add(cerere);
                                }
                            }
                        }

                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }


                if (linie[0].equals("afiseaza_cereri_in_asteptare")) {
                    scrieFisier(linie[1].trim() + " - cereri in asteptare:");

                    for (Utilizator valoare : utilizator) {
                        if (valoare.nume.equals(linie[1])) {
                            for (Cerere cerere : valoare.cereri) {
                                scrieFisier(valoare.textulCererii(cerere));
                            }
                        }
                    }
                }

                if (linie[0].equals("retrage_cerere")) {//cand data mentionata in retragerea cererei este egala cu o data din cererile in asteptare, cererea este inlaturata din treeset
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
                    Date data = formatter.parse(linie[2]);
                    Cerere cerere2 = null;

                    for (Utilizator valoare : utilizator) {
                        for (Cerere cerere : valoare.cereri) {
                            if (cerere.data.equals(data)) {
                                cerere2 = cerere;
                                break;
                            }
                        }
                        if (cerere2 != null) {
                            valoare.cereri.remove(cerere2);
                            break;
                        }
                    }
                }


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        cale = args[0]; //am egalat calea cu numele fisierului primit in fiecare caz
        ManagementPrimarie primarie = new ManagementPrimarie();
        primarie.citesteFisier();


    }
}