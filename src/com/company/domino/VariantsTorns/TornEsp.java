package com.company.domino.VariantsTorns;

import com.company.domino.*;

import java.util.ArrayList;

public class TornEsp extends Torn {

    @Override
    public void torn(ArrayList<Jugador> jugadors, int tornInicial, Domino newGame, Tablero tablero, int tirades) {
        for (Jugador player : jugadors){
            if (tornInicial == player.getIdJug()){
                if (tirades > 0){
                    newGame.fitxesJugables(tablero, player.getFitxesJug());
                }
                int fitxaTriada = Input.triaFitxa(player.getFitxesJug(), player, tirades);
                if (/*newGame.teFitxesJugables(player.getFitxesJug()) &&*/ tirades == 0){
                    while (!player.getFitxesJug().get(fitxaTriada).isJugable() && tirades > 0){
                        fitxaTriada = Input.triaFitxa(player.getFitxesJug(), player, tirades);
                    }
                    tablero.getFitxesTab().add(player.getFitxesJug().get(fitxaTriada));
                    tablero.setExtrem1(player.getFitxesJug().get(fitxaTriada).getCara1());
                    tablero.setExtrem2(player.getFitxesJug().get(fitxaTriada).getCara2());
                    player.getFitxesJug().remove(fitxaTriada);
                } else if (newGame.teFitxesJugables(player.getFitxesJug()) && tirades > 0){
                    tablero.getFitxesTab().add(player.getFitxesJug().get(fitxaTriada));

                    if (tablero.getExtrem1() == player.getFitxesJug().get(fitxaTriada).getCara1()) {
                        tablero.setExtrem1(player.getFitxesJug().get(fitxaTriada).getCara2());
                    } else if (tablero.getExtrem1() == player.getFitxesJug().get(fitxaTriada).getCara2()){
                        tablero.setExtrem1(player.getFitxesJug().get(fitxaTriada).getCara1());
                    } else if (tablero.getExtrem2() == player.getFitxesJug().get(fitxaTriada).getCara1()){
                        tablero.setExtrem2(player.getFitxesJug().get(fitxaTriada).getCara2());
                    } else if (tablero.getExtrem2() == player.getFitxesJug().get(fitxaTriada).getCara2()){
                        tablero.setExtrem2(player.getFitxesJug().get(fitxaTriada).getCara1());
                    }

                } else {
                    Output.pasarTorn(player);
                }
            }
        }
        seguentTorn(tornInicial, newGame.numeroJugadors(jugadors));
    }
}
