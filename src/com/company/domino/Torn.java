package com.company.domino;

import java.util.ArrayList;

public abstract class Torn {

    private int idJugador;

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public abstract int jugadorInicial (ArrayList<Jugador> jugadors);

    public abstract void torn (ArrayList<Jugador> jugadors, int tornInicial, Domino newGame, Tablero tablero, int tirades);


    public int seguentTorn (int torn, int numJugadors){
        int next = torn;

        if (torn < numJugadors){
            next++;
        } else {
            next = 1;
        }
        return next;
    }
}
