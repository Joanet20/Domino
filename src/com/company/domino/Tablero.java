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

    public void setExtrem1(int extrem1) {
        this.extrem1 = extrem1;
    }

    public void setExtrem2(int extrem2) {
        this.extrem2 = extrem2;
    }
}

