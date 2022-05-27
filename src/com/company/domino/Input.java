package com.company.domino;

import com.company.domino.VariantsDomino.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    public static ModalitatsMexica triarModMex (){

        ModalitatsMexica modMex = ModalitatsMexica.DEFECTE;
        Scanner sc = new Scanner(System.in);

        switch (sc.nextInt()){
            case 0:
                modMex = ModalitatsMexica.INDIVIDUAL;
                break;

            case 1:
                modMex = ModalitatsMexica.PARELLES;
                break;

            default:
                Output.opcioNoCorrecte();
                break;
        }
        return modMex;
    }

    public static Domino triarClasse (){

        Domino newGame = new Domino(0, "");
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

    public static int triaFitxa (ArrayList<Fitxa> fitxesJug, Jugador jugador, int tirada){

        Scanner sc = new Scanner(System.in);
        System.out.println("Tria una fitxa jugable");
        Output.mostrarFitxesJugables(fitxesJug, jugador, tirada);

        return sc.nextInt();
    }
}
