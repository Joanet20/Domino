package com.company.domino;

import java.util.ArrayList;

public class Torn {

    private int idJugador;

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int jugadorInicial (ArrayList<Jugador> jugadors){
        int indexJug = 0;

        for (int i = 6; i >= 0; i--){
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

    public void tornEsp (ArrayList<Jugador> jugadors, int tornInicial, Domino newGame, Tablero tablero, ArrayList<Fitxa> fitxesJug, int tirades){
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
