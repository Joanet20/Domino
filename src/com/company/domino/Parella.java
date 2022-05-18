package com.company.domino;

import java.util.ArrayList;

public class Parella {

    private int idParella;
    private int puntacioParella;
    private Jugador[] jugadorsParella;
    private ArrayList<Fitxa> fitxesParella;

    public Parella (int idParella){
        this.idParella = idParella;
        this.jugadorsParella = new Jugador[2];
    }

    public Jugador[] getJugadorsParella() {
        return jugadorsParella;
    }

    public int getPuntacioParella() {
        return puntacioParella;
    }
}
