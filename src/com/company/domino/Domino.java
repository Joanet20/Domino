package com.company.domino;

import java.util.ArrayList;

public class Domino {

    private int puntuacio;
    private ArrayList<Fitxa> fitxesJoc;

    public Domino (int puntuacio){
        this.puntuacio = puntuacio;
        this.fitxesJoc = new ArrayList<>();
    }

    public void jugar (){

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
}
