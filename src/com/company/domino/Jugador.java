package com.company.domino;

import java.util.ArrayList;

public class Jugador {

    private int idJug;
    private ArrayList<Fitxa> fitxesJug;

    public Jugador (int idJug){
        this.idJug = idJug;
        this.fitxesJug = new ArrayList<>(7);
    }

    public ArrayList<Fitxa> getFitxesJug (){
        return fitxesJug;
    }
}
