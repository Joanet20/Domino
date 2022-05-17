package com.company.domino.VariantsDomino;

import com.company.domino.Domino;
import com.company.domino.Input;
import com.company.domino.Jugador;
import com.company.domino.Parella;

public class Mexica extends Domino {

    public Mexica() {
        super(200, "Mexicà");
    }

    @Override
    public void jugar(Domino newGame) {
        super.jugar(newGame);

        switch (Input.triarModMex()){
            case INDIVIDUAL:
                Parella p1 = new Parella(1);
                Parella p2 = new Parella(2);

                for (int i = 0; i < 4; i++){
                    if (i < 4/2){
                        p1.getJugadorsParella()[i] = new Jugador(i+1);
                    } else {
                        p2.getJugadorsParella()[i] = new Jugador(i+1);
                    }
                }


        }
    }
}
