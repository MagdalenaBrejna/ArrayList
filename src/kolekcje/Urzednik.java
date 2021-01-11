package kolekcje;

public class Urzednik extends Pracownik{

    double premia;
    double placa;

    public Urzednik(){
        super("", "", 0, 0);
        premia = 0;
        placa = 0;
    }

    public Urzednik(String nazwisko, String imie, int wiek, double etat,  double premia, double placa){
        super(nazwisko, imie, wiek, etat);
        this.premia = premia;
        this.placa = placa;
    }

    public double getPremia() {
        return premia;
    }

    public void setPremia(double premia) {
        this.premia = premia;
    }

    public double getPlaca() {
        return placa;
    }

    public void setPlaca(double placa) {
        this.placa = placa;
    }

    public double policzPlace(){
        return (placa * etat + placa * premia / 100);
    }

    public void podajDanePracownika(){
        System.out.println(super.toString());
    }

    public String toString(){
        return super.toString() + " " + premia + " " + placa;
    }
}
