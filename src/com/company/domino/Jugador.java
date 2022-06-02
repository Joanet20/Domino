package com.company.domino;

import java.util.ArrayList;

public class Jugador {

    private int idJug;
    private int puntucaioJug;
    private ArrayList<Fitxa> fitxesJug;
    private int idParella;

    public Jugador (int idJug){
        this.idJug = idJug;
        this.fitxesJug = new ArrayList<>(7);
    }

    public int getIdJug (){
        return idJug;
    }

    public void setIdJug(int idJug) {
        this.idJug = idJug;
    }

    public ArrayList<Fitxa> getFitxesJug (){
        return fitxesJug;
    }

    public int getPuntucaioJug() {
        return puntucaioJug;
    }

    public int getIdParella() {
        return idParella;
    }

    public void setIdParella(int idParella) {
        this.idParella = idParella;
    }

}
