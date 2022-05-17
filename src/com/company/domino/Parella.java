package com.company.domino;

import java.util.ArrayList;

public class Parella {

    private int idParella;
    private Jugador[] jugadorsParella;
    private ArrayList<Fitxa> fitxesParella;

    public Parella (int idParella){
        this.idParella = idParella;
        this.jugadorsParella = new Jugador[2];
    }

    public Jugador[] getJugadorsParella() {
        return jugadorsParella;
    }
}
