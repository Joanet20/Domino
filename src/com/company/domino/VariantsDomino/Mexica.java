package com.company.domino.VariantsDomino;

import com.company.domino.Domino;
import com.company.domino.Input;

public class Mexica extends Domino {

    public Mexica() {
        super(200, "Mexicà");
    }

    @Override
    public void jugar(Domino newGame) {
        super.jugar(newGame);

        switch (Input.triarModMex()){
            case INDIVIDUAL:

        }
    }
}
