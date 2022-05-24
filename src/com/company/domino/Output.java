package com.company.domino;

import java.util.ArrayList;

public class Output {

    public static void opcioNoCorrecte (){
        System.out.println("No és una opció vàlida");
    }

    public static void triarModMex (){
        System.out.println("Tria una modalitat 0-Individual, 1-Parelles, 2-Equips");
    }

    public static void triarClase (){
        System.out.println("Tria una classe 0-Mexicà, 1-Chileno, 2-Colombiano, 3-Latino, 4-Venezolano");
    }

    public static void classeTriada (String name){
        System.out.println("Has triat el dominó " + name);
    }

    public static void mostrarFitxesJugables (ArrayList<Fitxa> fitxesJug, Jugador jugador, int tirada){
        for (Fitxa fitxa : fitxesJug){
            System.out.println("Torn del jugador " + jugador.getIdJug());
            if (tirada == 0){
                System.out.print("F" + fitxesJug.indexOf(fitxa) + " " + fitxa.getCara1() + "|" + fitxa.getCara2());
            } else {
                if (fitxa.isJugable()){
                    System.out.println("F" + fitxesJug.indexOf(fitxa) + " " + fitxa.getCara1() + "|" + fitxa.getCara2());
                } else {
                    System.err.println("F" + fitxesJug.indexOf(fitxa) + " " + fitxa.getCara1() + "|" + fitxa.getCara2());
                }
            }
            System.out.println("10-Pasar");
        }
    }

    public static void pasarTorn (Jugador jugador){
        System.out.println("El jugador " + jugador.getIdJug() + " ha passat el seu torn");
    }
}
