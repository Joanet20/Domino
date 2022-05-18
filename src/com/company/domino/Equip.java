package com.company.domino;

import java.util.ArrayList;

public class Equip {

    private int idEquip;
    private int puntuacioEquip;
    private ArrayList<Jugador> jugadorsEquip;
    private ArrayList<Fitxa> fitxesEquip;

    public Equip (int idEquip){
        this.idEquip = idEquip;
        this.jugadorsEquip = new ArrayList<>();
    }
}
