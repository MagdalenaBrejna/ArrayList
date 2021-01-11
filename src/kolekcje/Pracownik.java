package kolekcje;

public abstract class Pracownik implements Comparable<Pracownik> {

    String nazwisko;
    String imie;
    int wiek;
    double etat;

    public Pracownik(){
        nazwisko = "";
        imie = "";
        wiek = 0;
        etat = 0;
    }

    public Pracownik(String nazwisko, String imie, int wiek, double etat){
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.wiek = wiek;
        this.etat = etat;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public double getEtat() {
        return etat;
    }

    public void setEtat(double etat) {
        this.etat = etat;
    }

    public abstract double policzPlace();

    public String toString(){
        return nazwisko + " " + imie +" " + wiek + " " + etat;
    }

    public abstract void podajDanePracownika();

    public int compareTo(Pracownik pracownik){
        return (this.toString()).compareTo(pracownik.toString());
    }


}
