package com.company.domino;

import java.net.PortUnreachableException;
import java.util.ArrayList;

public class Output {

    public static void opcioNoCorrecte (){
        System.out.println("No és una opció vàlida");
    }

    public static void triarModMex (){
        System.out.println("Tria una modalitat 0-Individual, 1-Parelles");
    }

    public static void triarModEsp (){
        System.out.println("Tria una modalitat 0-Individual, 1-Parelles");
    }

    public static void triarModCla (){
        System.out.println("Tria una modalitat 0-Individual, 1-Parelles");
    }

    public static void triarClase (){
        System.out.println("Tria una classe 0-Clásico, 1-Espanyol, 2-Colombiano, 3-Latino, 4-Venezolano");
    }

    public static void classeTriada (String name){
        System.out.println("Has triat el dominó " + name);
    }

    public static void mostrarFitxesJugables (ArrayList<Fitxa> fitxesJug, Jugador jugador, int tirada){
        System.out.println("Torn del jugador " + jugador.getIdJug());
        System.out.println("S-F (Jugable), N-F (No jugable)");
        for (Fitxa fitxa : fitxesJug){
            if (tirada == 0){
                System.out.print("F" + fitxesJug.indexOf(fitxa) + " " + fitxa.getCara1() + "|" + fitxa.getCara2() + " ");
            } else {
                if (fitxa.isJugable()){
                    System.out.print("S-F" + fitxesJug.indexOf(fitxa) + " [" + fitxa.getCara1() + "|" + fitxa.getCara2() + "] ");
                } else {
                    System.out.print("N-F" + fitxesJug.indexOf(fitxa) + " [" + fitxa.getCara1() + "|" + fitxa.getCara2() + "] ");
                }
            }
        }
        /*System.out.println();
        System.out.println("10-Pasar");*/
    }

    public static void pasarTorn (Jugador jugador){
        System.out.println("El jugador " + jugador.getIdJug() + " ha passat el seu torn");
    }

    public static void agafaFitxa (Jugador jugador){
        System.out.println("El jugador " + jugador.getIdJug() + " ha agafat fitxa");
    }

    public static void imprimirTablero (Tablero tablero, Fitxa fitxaTriada){

        System.out.println();
        System.out.println("Tablero");
        for (Fitxa fitxa : tablero.getFitxesTab()){
            if (fitxa.getCara1() == fitxa.getCara2()){
                System.out.println(" * * * * *");
                System.out.println(" * " + fitxa.getCara1() + " | " + fitxa.getCara2() + " *");
                System.out.println(" * * * * *");
            } else {
                    System.out.println("   * * * ");
                    System.out.println("   * " + fitxa.getCara1() + " *");
                    System.out.println("   * - *");
                    System.out.println("   * " + fitxa.getCara2() + " *");
                    System.out.println("   * * * ");
            }

        }
        System.out.println();
    }

    public static void fitxaNoJugable (){
        System.out.println("La fitxa triada no es jugable, torna tirar!!");
    }

    public static void hasGuanyat (Jugador player){
        System.out.println("El jugador " + player.getIdJug() + " ha guanyat!");
        System.exit(1);
    }

    public static void hasGuanyat (int parellaGuanyadora){
        System.out.println("La parella " + parellaGuanyadora + " ha guanyat!");
        System.exit(1);
    }
}
