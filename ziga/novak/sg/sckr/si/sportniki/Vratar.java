package ziga.novak.sg.sckr.si.sportniki;

public class Vratar extends Modeli {
    


    private int podaje;

    public Vratar(int stDresa, String pozicija, String ime, int tekme, int goli, int asistence, String klub, String stanje, int podaje){

        super(stDresa, pozicija, ime, tekme, goli, asistence, klub, stanje);
        this.podaje = podaje;

    }


}
