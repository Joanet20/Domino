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
        for (Jugador player : jugadors){
            if (tornInicial == player.getIdJug()){
                if (tirades > 0){
                    newGame.fitxesJugables(tablero, player.getFitxesJug());
                }
                int fitxaTriada = Input.triaFitxa(player.getFitxesJug(), player, tirades);

                if (tirades == 0){
                    colocarPrimeraTirada(tablero, player, fitxaTriada);
                } else if (newGame.teFitxesJugables(player.getFitxesJug()) && tirades > 0){
                    comprobarJugableSeguentsTirades(player, fitxaTriada, tablero, newGame, tirades);

                } else if (!newGame.teFitxesJugables(player.getFitxesJug())){
                    Output.pasarTorn(player);
                } else if (newGame.isTranca(jugadors, newGame)){
                    Output.hasGuanyat(newGame.guanyadorTranca(jugadors));
                }
                //Output.imprimirTablero(tablero, player.getFitxesJug().get(fitxaTriada));
            }
        }
        seguentTorn(tornInicial, newGame.numeroJugadors(jugadors));
    }

    public void colocarPrimeraTirada (Tablero tablero, Jugador player, int fitxaTriada){
        tablero.getFitxesTab().add(player.getFitxesJug().get(fitxaTriada));
        tablero.setExtrem1(player.getFitxesJug().get(fitxaTriada).getCara1());
        tablero.setExtrem2(player.getFitxesJug().get(fitxaTriada).getCara2());
        player.getFitxesJug().remove(fitxaTriada);
    }

    public void comprobarJugableSeguentsTirades (Jugador player, int fitxaTriada, Tablero tablero, Domino newGame, int tirades){
        while (!player.getFitxesJug().get(fitxaTriada).isJugable()){
            Output.fitxaNoJugable();
            fitxaTriada = Input.triaFitxa(player.getFitxesJug(), player, tirades);
        }

        tablero.getFitxesTab().add(player.getFitxesJug().get(fitxaTriada));
        newGame.posarExtremsTablero(tablero, player, fitxaTriada);
    }
}
