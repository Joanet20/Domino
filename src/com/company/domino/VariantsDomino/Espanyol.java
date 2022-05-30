package com.company.domino.VariantsDomino;

import com.company.domino.*;

import java.util.ArrayList;

public class Espanyol extends Domino {

    private ArrayList<Jugador> jugadors;

    public Espanyol (){
        super(100, "Espanyol");
        this.jugadors = new ArrayList<>();
    }

    @Override
    public void jugar(Domino newGame, Tablero tablero){
        super.jugar(newGame, tablero);

        Output.triarModEsp();

        switch (Input.triarModEsp()){
            case INDIVIDUAL:


        }
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

    public void iniciEspInd (Domino newGame, Tablero tablero, int fitxesPerJug){
        this.jugadors.add(new Jugador(1));
        this.jugadors.add(new Jugador(2));
        newGame.assignarFitxesJug(newGame.getFitxesJoc(), this.jugadors, fitxesPerJug);
    }

    public void jocInd (Domino newGame, Tablero tablero){
        int tirades = 0;
        boolean begin = false;
        int torn = jugadorInicial(this.jugadors);


    }
}
