package com.company.domino;

import java.util.ArrayList;

public class Domino {

    private int puntuacio;
    private String name;
    private ArrayList<Fitxa> fitxesJoc;

    public Domino (int puntuacio, String name){
        this.puntuacio = puntuacio;
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
        Output.classeTriada(newGame);
        newGame.crearFitxes(fitxesJoc);
    }

    public void crearFitxes (ArrayList<Fitxa> fitxesJoc){
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                if (j <= i){
                    Fitxa fitxaNova = new Fitxa(i, j);
                    fitxesJoc.add(fitxaNova);
                    this.fitxesJoc = fitxesJoc;
                }
            }
        }
    }

    public void assignarFitxesJug (ArrayList<Fitxa> fitxesJoc, ArrayList<Jugador> jugadors){
        for (int i = 0; i < jugadors.size(); i++){
            int count = 0;
            while (count < jugadors.get(i).getFitxesJug().size()){
                int rand = (int) Math.floor(Math.random()*fitxesJoc.size());

                if (!fitxesJoc.get(rand).isAssignada()){
                    jugadors.get(i).getFitxesJug().add(fitxesJoc.get(rand));
                    count++;
                    fitxesJoc.get(rand).setAssignada(true);
                }

            }
        }
    }

    public void fitxesJugables (Tablero tablero, ArrayList<Fitxa> fitxesJug){
        for (int i = 0; i < fitxesJug.size(); i++){
            if (fitxesJug.get(i).getCara1() == tablero.getExtrem1() ||
                    fitxesJug.get(i).getCara2() == tablero.getExtrem1() ||
                    fitxesJug.get(i).getCara1() == tablero.getExtrem2() ||
                    fitxesJug.get(i).getCara2() == tablero.getExtrem2()) {
                fitxesJug.get(i).setJugable(true);
            }
        }
    }

}
