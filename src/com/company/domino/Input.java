package com.company.domino;

import com.company.domino.VariantsDomino.*;

import java.util.Scanner;

public class Input {

    public static int triarModMex (){

        int opcio = 0;
        Scanner sc = new Scanner(System.in);

        switch (sc.nextInt()){
            case 0:
                opcio = 0;
                break;

            case 1:
                opcio = 1;
                break;

            case 2:
                opcio = 2;
                break;

            default:
                Output.opcioNoCorrecte();
                break;
        }
        return opcio;
    }

    public static Domino triarClasse (){

        Domino newGame = new Domino(0);
        Scanner sc = new Scanner(System.in);

        switch (sc.nextInt()){
            case 0:
                newGame = new Mexica();
                break;

            case 1:
                newGame = new Chileno();
                break;

            case 2:
                newGame = new Colombiano();
                break;

            case 3:
                newGame = new Latino();
                break;

            case 4:
                newGame = new Venezolano();
                break;

            default:
                Output.opcioNoCorrecte();
                break;
        }
        return newGame;
    }
}
