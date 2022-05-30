package com.company.domino.VariantsDomino;

import com.company.domino.Domino;
import com.company.domino.Jugador;
import com.company.domino.Tablero;

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


    }
}
