package com.company.domino.VariantsTorns;

import com.company.domino.*;

import java.util.ArrayList;

public class TornChi extends Torn{

    @Override
    public int jugadorInicial(ArrayList<Jugador> jugadors) {
        int indexJug = 0;

        for (int i = 1; i < 7; i++){
            for (Jugador player : jugadors){
                for (Fitxa fitxa : player.getFitxesJug()){
                    if (fitxa.getCara1() == i && fitxa.getCara2() == i){
                        indexJug = player.getIdJug();
                    }
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
                    tablero.getFitxesTab().add(player.getFitxesJug().get(fitxaTriada));
                    tablero.setExtrem1(player.getFitxesJug().get(fitxaTriada).getCara1());
                    tablero.setExtrem2(player.getFitxesJug().get(fitxaTriada).getCara2());
                    player.getFitxesJug().remove(fitxaTriada);
                } else if (newGame.teFitxesJugables(player.getFitxesJug()) && tirades > 0){
                    while (!player.getFitxesJug().get(fitxaTriada).isJugable() && !newGame.getFitxesJoc().isEmpty()){
                        Output.fitxaNoJugable();
                        fitxaTriada = Input.triaFitxa(player.getFitxesJug(), player, tirades);
                    }

                    tablero.getFitxesTab().add(player.getFitxesJug().get(fitxaTriada));
                    newGame.posarExtremsTablero(tablero, player, fitxaTriada);

                } else if (!newGame.teFitxesJugables(player.getFitxesJug())){
                    if (!newGame.getFitxesJoc().isEmpty()){
                        while (!newGame.teFitxesJugables(player.getFitxesJug())){
                            newGame.robarFitxa(newGame.getFitxesJoc(), player);
                            Output.agafaFitxa(player);
                        }
                        tablero.getFitxesTab().add(player.getFitxesJug().get(player.getFitxesJug().size()-1));
                        newGame.posarExtremsTablero(tablero, player, player.getFitxesJug().size()-1);
                    }
                }
                Output.imprimirTablero(tablero, player.getFitxesJug().get(fitxaTriada));
            }
        }
        seguentTorn(tornInicial, newGame.numeroJugadors(jugadors));
    }
}
