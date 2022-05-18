package com.company.domino.VariantsDomino;

import com.company.domino.*;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Mexica extends Domino {

    private ArrayList<Jugador> jugadors;

    public Mexica() {
        super(200, "Mexicà");
        this.jugadors = new ArrayList<>();
    }

    public ArrayList<Jugador> getJugadors (){
        return jugadors;
    }

    @Override
    public void jugar(Domino newGame) {
        super.jugar(newGame);

        switch (Input.triarModMex()){
            case INDIVIDUAL:
                iniciMexicaInd(newGame);

        }
    }

    public void iniciMexicaInd (Domino newGame){
        triarParellesInd();
        newGame.assignarFitxesJug(newGame.getFitxesJoc(), getJugadors());
    }

    public void triarParellesInd (){
        Parella p1 = new Parella(1);
        Parella p2 = new Parella(2);

        for (int i = 0; i < 4; i++){
            if (i == 0 || i == 2){
                p1.getJugadorsParella()[i] = new Jugador(i+1);
                this.jugadors.add(p1.getJugadorsParella()[i]);
            } else {
                p2.getJugadorsParella()[i] = new Jugador(i+1);
                this.jugadors.add(p2.getJugadorsParella()[i]);
            }
        }
    }

    public void canviParellesInd (Parella p1, Parella p2){
        for (int i = 0; i < p1.getJugadorsParella().length; i++){
            if (p1.getJugadorsParella()[i].getIdJug() < 4){
                p1.getJugadorsParella()[i].setIdJug(p1.getJugadorsParella()[i].getIdJug()+1);
            } else {
                p1.getJugadorsParella()[i].setIdJug(1);
            }

            if (p2.getJugadorsParella()[i].getIdJug() < 4){
                p2.getJugadorsParella()[i].setIdJug(p2.getJugadorsParella()[i].getIdJug()+1);
            } else {
                p2.getJugadorsParella()[i].setIdJug(1);
            }
        }
    }

    public int jugadorInicial (ArrayList<Fitxa> fitxas){
        int randJ1 = (int) Math.floor(Math.random()*fitxas.size());
        int randJ2 = (int) Math.floor(Math.random()*fitxas.size());
        int randJ3 = (int) Math.floor(Math.random()*fitxas.size());
        int randJ4 = (int) Math.floor(Math.random()*fitxas.size());
        int major = 0;
        int index = 0;

        for (int i = 0; i < fitxas.size(); i++){
            if (i == randJ1 || i == randJ2 || i == randJ3 || i == randJ4){
                if (fitxas.get(i).sumaCares(fitxas.get(i)) > major){
                    major = fitxas.get(i).sumaCares(fitxas.get(i));
                    index++;
                }
            }
        }
        return index;
    }

    public void jocInd (Parella p1, Parella p2, Domino newGame){

        int tirades = 0;

        while (p1.getPuntacioParella() < this.getPuntuacio() || p2.getPuntacioParella() < this.getPuntuacio()){
            int torn = jugadorInicial(newGame.getFitxesJoc());

            switch (torn){
                case 1:
                    for (int i = 0; i < p1.getJugadorsParella().length; i++){
                        if (torn == p1.getJugadorsParella()[i].getIdJug()){
                            if (tirades == 0){
                                tirades ++;

                            }

                        }
                    }
            }
        }
    }
}
