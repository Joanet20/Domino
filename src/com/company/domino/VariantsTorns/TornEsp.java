package com.company.domino.VariantsTorns;

import com.company.domino.*;

import java.util.ArrayList;

public class TornEsp extends Torn {

    @Override
    public void torn(ArrayList<Jugador> jugadors, int tornInicial, Domino newGame, Tablero tablero, ArrayList<Fitxa> fitxesJug, int tirades) {
        for (Jugador player : jugadors){
            if (tornInicial == player.getIdJug()){
                newGame.fitxesJugables(tablero, fitxesJug);
                int fitxaTriada = Input.triaFitxa(fitxesJug, player, tirades);
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

    public void tornIndividual (ArrayList<Jugador> jugadors, int tornInicial, Domino newGame, Tablero tablero, ArrayList<Fitxa> fitxesJug, int tirades){
        torn(jugadors, tornInicial, newGame, tablero, fitxesJug, tirades);
    }

    public void tornParella (ArrayList<Jugador> jugadors, int tornInicial, Domino newGame, Tablero tablero, ArrayList<Fitxa> fitxesJug, int tirades){
        ArrayList<Jugador> parelles = newGame.assignarParelles(jugadors);
        torn(parelles, tornInicial, newGame, tablero, fitxesJug, tirades);
    }
}
