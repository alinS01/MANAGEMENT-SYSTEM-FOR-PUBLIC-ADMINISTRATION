in clasa ManagementPrimarie:

aici am declarat un ArrayList utilizator.
in functia de citire fisier am facut String[] linie care imparte linia in mai multe bucati,delimitate de " ; "
in cazul in care primeam comanda adauga_utilizator pentru fiecare caz se instantia un nou obiect de tipul angajat/elev..etc si se adauga in arraylist
am folosit o variabila "cale " pe care o egalez cu numele fisierului ,o folosesc la functiile de citire si scriere pentru path
cand primesc comanda cerere_noua, instantiez un nou obiect de tip cerere,aici pentru data am folosit un formatter gasit pe net
verific daca numele utilizatorului e acelasi cu numele celui care depune cererea ,verific daca exista exceptii si in caz contrar adaug cererile in treeset
cand primesc afiseaza_cereri_in_asteptare apelez functia de scriere in fisier prezenta in fiecare clasa care mosteneste Utilizator
la retragere_cerere verific daca data dintr-o cerere in asteptare este egala cu data primita in urma comenzii, si folosind functia remove() din treeset o elimin

in clasa Utilizator :

am facut un TreeSet pentru cereri
am declarat doua functii abstracte care sunt prezente in toate clasele care mostenesc aceasta clasa.

in clasa Cerere:

aici am facut enumerarea tipurilor
am facut o functie care sa imi returneze data ca String si inca o functie care sorteaza cererile in functie de data si prioritate

in clasele Elev,Angajat,Persoana,Pensionar,EntitateJuridica

aceste clase mostenesc clasa Utilizator
toate aceste clase au functia "textul cererii" care returneaza tot mesajul care trebuie scris in fisier,in functie de tipul fiecaruia
aici am facut if-uri pentru exceptii,verificand daca tipul cererii este egal cu tipul din enumeratie, insa nu am reusit sa accesez in mod direct elementele enumeratiei
am cautat pe net cum sa convertesc enum -> string si am vazut ca pot face o variabila de tip string egala cu String.valueOf(Clasa.enum.elemente_din_enum)
pentru fiecare variabila egalata cu elementele din enumeratie am facut doua operatii pe string, una dintre ele fiind toLowerCase si cealalta sa inlocuiasca "_" cu " " (un spatiu gol)
nu stiu cat de estetica este aceasta metoda insa nu mi am dat seama cum pot accesa altcumva elementele din enum.

in final cred ca trebuia sa folosesc mai multe metode pe care sa le apelez in ManagementPrimarie,dar sper ca nu e gresit cum am facut
am reusit sa fac tot in afara de cele 5 teste cu birou_cereri.



