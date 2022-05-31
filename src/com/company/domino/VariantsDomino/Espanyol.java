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
                iniciEspInd(newGame, tablero, 7);

        }
    }

    public void iniciEspInd (Domino newGame, Tablero tablero, int fitxesPerJug){
        this.jugadors.add(new Jugador(1));
        this.jugadors.add(new Jugador(2));
        newGame.assignarFitxesJug(newGame.getFitxesJoc(), this.jugadors, fitxesPerJug);
    }

    public void jocInd (Domino newGame, Tablero tablero){
        int tirades = 0;
        boolean begin = false;

        while (this.jugadors.get(0).getPuntucaioJug() < this.getPuntuacio() ||
                this.jugadors.get(1).getPuntucaioJug() < this.getPuntuacio()){
            if (!begin){
                begin = true;
            } else {

            }
        }
    }
}
