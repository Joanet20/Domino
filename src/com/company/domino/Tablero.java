package com.company.domino;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Fitxa> fitxesTab;
    private int extrem1;
    private int extrem2;

    public Tablero (){
        this.fitxesTab = new ArrayList<>();
    }

    public ArrayList<Fitxa> getFitxesTab() {
        return fitxesTab;
    }

    public int getExtrem1() {
        return extrem1;
    }

    public int getExtrem2() {
        return extrem2;
    }
}
