package com.company.domino.VariantsTorns;

import com.company.domino.*;

import java.util.ArrayList;

public class TornLat extends Torn {

    @Override
    public int jugadorInicial(ArrayList<Jugador> jugadors) {
        int indexJug = 0;

        for (Jugador jugador : jugadors){
            for (Fitxa fitxa : jugador.getFitxesJug()){
                if (fitxa.getCara1() == 6 && fitxa.getCara2() == 6){
                    indexJug = jugador.getIdJug();
                }
            }
        }
        return indexJug;
    }

    @Override
    public void torn(ArrayList<Jugador> jugadors, int tornInicial, Domino newGame, Tablero tablero, int tirades) {

    }
}
