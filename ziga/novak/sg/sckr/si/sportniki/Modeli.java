package ziga.novak.sg.sckr.si.sportniki;

public class Modeli {
    

    private Integer stDresa;
    private String pozicija;
    private String ime;
    private String tekme;
    private String goli;
    private String asistence;
    private String klub;
    private String stanje;


    public Modeli(Integer stDresa, String pozicija, String ime, String tekme, String goli, String asistence, String klub, String stanje){
        this.stDresa = stDresa;
        this.pozicija = pozicija;
        this.ime = ime;
        this.tekme = tekme; 
        this.goli = goli;
        this.asistence = asistence; 
        this.klub = klub;
        this.stanje = stanje;
    }

    public String getPozicija(){
        return pozicija;
    }

    public int getStDresa(){
        return stDresa;
    }

    public String getIme(){
        return ime;
    }

    public String getKlub(){
        return klub;
    }

    public String toString(){
        return getIme() +" "+ getPozicija() + " " + getKlub();
    }

}
