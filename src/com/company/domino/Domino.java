package com.company.domino;

import java.util.ArrayList;

public class Domino {

    private int puntuacio;
    private String name;
    private ArrayList<Fitxa> fitxesJoc;

    public Domino (int puntuacio, String name){
        this.puntuacio = puntuacio;
        this.name = name;
        this.fitxesJoc = new ArrayList<>();
    }

    public static void inici (){
        Output.triarClase();
        Domino newGame = Input.triarClasse();
        Tablero tab = new Tablero();

        newGame.jugar(newGame, tab);
    }

    public String getName (){
        return name;
    }

    public int getPuntuacio (){
        return puntuacio;
    }

    public ArrayList<Fitxa> getFitxesJoc (){
        return fitxesJoc;
    }

    public void jugar (Domino newGame, Tablero tablero){
        Output.classeTriada(newGame.getName());
        newGame.crearFitxes(fitxesJoc);
    }

    public void crearFitxes (ArrayList<Fitxa> fitxesJoc){
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                if (j <= i){
                    Fitxa fitxaNova = new Fitxa(i, j);
                    fitxesJoc.add(fitxaNova);
                    this.fitxesJoc = fitxesJoc;
                }
            }
        }
    }

    public void assignarFitxesJug (ArrayList<Fitxa> fitxesJoc, ArrayList<Jugador> jugadors, int fitxesPerJug){
        for (Jugador jug : jugadors){
            int count = 0;
            while (count < fitxesPerJug){
                int rand = (int) Math.floor(Math.random()*fitxesJoc.size());

                if (!fitxesJoc.get(rand).isAssignada()){
                    jug.getFitxesJug().add(fitxesJoc.get(rand));
                    fitxesJoc.get(rand).setAssignada(true);
                    count++;
                }
            }
        }
    }

    public void fitxesJugables (Tablero tablero, Fitxa fitxa, int fitxesAMa){
        for (int i = 0; i < fitxesAMa; i++){
            if (fitxa.getCara1() == tablero.getExtrem1() ||
                    fitxa.getCara2() == tablero.getExtrem1() ||
                    fitxa.getCara1() == tablero.getExtrem2() ||
                    fitxa.getCara2() == tablero.getExtrem2()) {
                fitxa.setJugable(true);
            } else {
                fitxa.setJugable(false);
            }
        }
    }

}
