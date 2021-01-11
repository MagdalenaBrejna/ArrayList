package kolekcje;

import java.util.*;

public class Firma {

    private ArrayList<Pracownik> listaPracownikow;
    private PracownikCompareNazwisko ComparatorNazwisko;
    private PracownikCompareImie ComparatorImie;
    private PracownikCompareWiek ComparatorWiek;

    public Firma(){
        listaPracownikow = new ArrayList<Pracownik>();
    }

    public void zatrudnijPracownika(String rodzaj, String nazwisko, String imie, int wiek, double etat){
        Random los = new Random();

        if(podajPozycjePracownika(nazwisko) == -1)
            if(rodzaj.equals("urzednik"))
                listaPracownikow.add(new Urzednik(nazwisko, imie, wiek, etat, los.nextInt(100), los.nextInt(2000)+1000));
            else if(rodzaj.equals("robotnik"))
                listaPracownikow.add(new Robotnik(nazwisko, imie, wiek, etat, los.nextInt(200), los.nextInt(20) + 10));
            else
                System.out.print("Firma nie zatrudnia osób o podanym zawodzie");
    }

    public void zwolnijPracownika(String nazwisko){
        if(podajPozycjePracownika(nazwisko) != -1 )
            listaPracownikow.remove(podajPozycjePracownika(nazwisko));
    }

    public int podajPozycjePracownika(String nazwisko){
        for(int i = 0; i < listaPracownikow.size(); i++)
            if((listaPracownikow.get(i).getNazwisko()).equals(nazwisko))
                return i;
        return -1;
    }

    public int policzRodzajPracownika(String rodzaj){
        int liczba = 0;
        if(rodzaj.equals("urzednik")) {
            for(Pracownik pracownik : listaPracownikow)
                if (pracownik instanceof Urzednik)
                    liczba++;
        }else if(rodzaj.equals("robotnik")){
            for(Pracownik pracownik : listaPracownikow)
                if(pracownik instanceof Robotnik)
                    liczba++;
        }
        return liczba;
    }

    public double sumaWyplat(String rodzaj){
        double liczba = 0;
        Iterator<Pracownik> it = listaPracownikow.iterator();

        if(rodzaj.equals("urzednik")) {
            while(it.hasNext()) {
                Pracownik nastepny = it.next();
                if (nastepny instanceof Urzednik)
                    liczba += nastepny.policzPlace();
            }
        }else if (rodzaj.equals("robotnik")) {
            while(it.hasNext()) {
                Pracownik nastepny = it.next();
                if (nastepny instanceof Robotnik)
                    liczba += nastepny.policzPlace();
            }
        }
        return liczba;
    }

    public void podajListePracownikow(){
        for(Pracownik pracownik : listaPracownikow)
            pracownik.podajDanePracownika();
    }

    public void podajListePlac(){
        for(int i = 0; i < listaPracownikow.size(); i++)
            System.out.println(listaPracownikow.get(i));
    }

    public ArrayList<Pracownik> getListaPracownikow(){
        return listaPracownikow;
    }

    public static void main(String[] args) {

        Firma firma = new Firma();
        firma.zatrudnijPracownika("urzednik", "Nowak", "Andrzej", 20, 1);
        firma.zatrudnijPracownika("robotnik", "Kowalski", "Piotr", 48, 1.5);
        firma.zatrudnijPracownika("urzednik", "Wojcik", "Adam", 40, 0.75);
        firma.zatrudnijPracownika("robotnik", "Iwan", "Jacek", 62, 0.5);
        firma.zatrudnijPracownika("robotnik", "Ato", "Jan", 33, 1);
        firma.podajListePracownikow();
        System.out.print("\n");

        firma.zwolnijPracownika("Iwan");
        firma.podajListePracownikow();

        System.out.print("\nLiczba urzędników: " + firma.policzRodzajPracownika("urzednik"));
        System.out.print("\nLiczba robotników: " + firma.policzRodzajPracownika("robotnik"));
        System.out.print("\nSuma wypłat urzędników: " + firma.sumaWyplat("urzednik"));
        System.out.print("\nSuma wypłat robotników: " + firma.sumaWyplat("robotnik"));
        System.out.print("\n\n");

        firma.podajListePlac();
        System.out.print("\n");

        Collections.sort(firma.getListaPracownikow());
        firma.podajListePracownikow();
        System.out.print("\n");

        //
        firma.createComparators();
        Collections.sort(firma.getListaPracownikow(), firma.getComparatorNazwisko());
        firma.podajListePracownikow();
        System.out.print("\n");
        Collections.sort(firma.getListaPracownikow(), firma.getComparatorImie());
        firma.podajListePracownikow();
        System.out.print("\n");
        Collections.sort(firma.getListaPracownikow(), firma.getComparatorWiek());
        firma.podajListePracownikow();
        System.out.print("\n");

    }
    //
    class PracownikCompareNazwisko implements Comparator<Pracownik>{
        public int compare(Pracownik pracownik1, Pracownik pracownik2){
            return pracownik1.getNazwisko().compareTo(pracownik2.getNazwisko());
        }
    }

    class PracownikCompareImie implements Comparator<Pracownik>{
        public int compare(Pracownik pracownik1, Pracownik pracownik2){
            return pracownik1.getImie().compareTo(pracownik2.getImie());
        }
    }

    class PracownikCompareWiek implements Comparator<Pracownik>{
        public int compare(Pracownik pracownik1, Pracownik pracownik2){
            if(pracownik1.getWiek() < pracownik2.getWiek())
                return -1;
            if(pracownik1.getWiek() > pracownik2.getWiek())
                return 1;
            return 0;
        }
    }

    public void createComparators() {
        ComparatorNazwisko = new PracownikCompareNazwisko();
        ComparatorImie = new PracownikCompareImie();
        ComparatorWiek = new PracownikCompareWiek();
    }

    public PracownikCompareNazwisko getComparatorNazwisko() {
        return ComparatorNazwisko;
    }

    public PracownikCompareImie getComparatorImie() {
        return ComparatorImie;
    }

    public PracownikCompareWiek getComparatorWiek() {
        return ComparatorWiek;
    }
}
