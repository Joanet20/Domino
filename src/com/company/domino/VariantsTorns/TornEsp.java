package com.company.domino.VariantsTorns;

import com.company.domino.*;

import java.util.ArrayList;

public class TornEsp extends Torn {

    @Override
    public void torn(ArrayList<Jugador> jugadors, int tornInicial, Domino newGame, Tablero tablero, int tirades) {
        for (Jugador player : jugadors){
            if (tornInicial == player.getIdJug()){
                newGame.fitxesJugables(tablero, player.getFitxesJug());
                int fitxaTriada = Input.triaFitxa(player.getFitxesJug(), player, tirades);
                if (newGame.teFitxesJugables(player.getFitxesJug())){
                    tablero.getFitxesTab().add(player.getFitxesJug().get(fitxaTriada));
                    player.getFitxesJug().remove(fitxaTriada);
                    tablero.setExtrem1(player.getFitxesJug().get(fitxaTriada).getCara1());
                    tablero.setExtrem2(player.getFitxesJug().get(fitxaTriada).getCara2());
                } else {
                    Output.pasarTorn(player);
                }
            }
        }
        seguentTorn(tornInicial, newGame.numeroJugadors(jugadors));
    }
}
