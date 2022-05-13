package com.company.domino;

import java.util.ArrayList;

public class Jugador {

    private int idJug;
    private int idEquip;
    private ArrayList<Fixa> fitxesJug;

    public Jugador (int idJug){
        this.idJug = idJug;
    }

    public Jugador (int idJug, int idEquip){
        this.idJug = idJug;
        this.idEquip = idEquip;
    }
}
