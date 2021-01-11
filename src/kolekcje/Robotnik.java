package kolekcje;

public class Robotnik extends Pracownik{

    final static double limit = 168;
    double liczbaGodzin;
    double stawkaGodzinowa;

    public Robotnik(){
        super("","",0,0);
        liczbaGodzin = 0;
        stawkaGodzinowa = 0;
    }

    public Robotnik(String nazwisko, String imie, int wiek, double etat, double liczbaGodzin, double stawkaGodzinowa){
        super(nazwisko, imie, wiek, etat);
        this.liczbaGodzin = liczbaGodzin;
        this.stawkaGodzinowa = stawkaGodzinowa;
    }

    public double getLiczbaGodzin() {
        return liczbaGodzin;
    }

    public void setLiczbaGodzin(double liczbaGodzin) {
        this.liczbaGodzin = liczbaGodzin;
    }

    public double getStawkaGodzinowa() {
        return stawkaGodzinowa;
    }

    public void setStawkaGodzinowa(double stawkaGodzinowa) {
        this.stawkaGodzinowa = stawkaGodzinowa;
    }

    public double policzPlace(){
        if(liczbaGodzin >= limit)
            return ((liczbaGodzin + (limit - liczbaGodzin) * 1.5) * stawkaGodzinowa);
        return (liczbaGodzin * stawkaGodzinowa);
    }

    public void podajDanePracownika(){
        System.out.println(super.toString());
    }

    public String toString(){
        return super.toString() + " " + liczbaGodzin + " " + stawkaGodzinowa;
    }

}
