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
    public void jugar(Domino newGame, Tablero tablero) {
        super.jugar(newGame, tablero);
        int fitxesPerJug = 0;

        Output.triarModMex();

        switch (Input.triarModMex()){
            case INDIVIDUAL:
                fitxesPerJug = 7;
                iniciMexicaInd(newGame, tablero, fitxesPerJug);
                break;

        }
    }

    public void iniciMexicaInd (Domino newGame, Tablero tablero, int fitxesPerJug){
        Parella [] parellas = triarParellesInd();
        newGame.assignarFitxesJug(newGame.getFitxesJoc(), this.jugadors, fitxesPerJug);
        jocInd(parellas[0], parellas[1], newGame, tablero);
    }

    public Parella [] triarParellesInd (){
        Parella p1 = new Parella(1);
        Parella p2 = new Parella(2);
        int totalJugs = p1.getJugadorsParella().length + p2.getJugadorsParella().length;

        for (int i = 0; i < totalJugs; i++){
            this.jugadors.add(new Jugador(i+1));
        }

        for (int i = 0; i < this.jugadors.size(); i++){
            switch (i){
                case 0:
                    p1.getJugadorsParella()[0] = this.jugadors.get(i);
                    break;

                case 1:
                    p2.getJugadorsParella()[0] = this.jugadors.get(i);
                    break;

                case 2:
                    p1.getJugadorsParella()[1] = this.jugadors.get(i);
                    break;

                case 3:
                    p2.getJugadorsParella()[1] = this.jugadors.get(i);
            }
        }

        Parella [] parelles = {p1, p2};
        return parelles;
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
        return 2;
    }

    public void jocInd (Parella p1, Parella p2, Domino newGame, Tablero tablero){

        int tirades = 0;

        while (p1.getPuntacioParella() < this.getPuntuacio() || p2.getPuntacioParella() < this.getPuntuacio()){
            int torn = jugadorInicial(newGame.getFitxesJoc());
            tornJugInd(p1, p2, torn, tirades, tablero);
        }
    }


    public void tornJugInd (Parella p1, Parella p2, int torn, int tirades, Tablero tablero){
        for (int i = 0; i < p1.getJugadorsParella().length; i++){
            Jugador jugActual = p1.getJugadorsParella()[i];
            if (torn == jugActual.getIdJug()){
                int indexFitxa = Input.triaFitxa(jugActual.getFitxesJug(), jugActual, tirades);

                if (indexFitxa != 10){
                    tablero.getFitxesTab().add(jugActual.getFitxesJug().get(indexFitxa));
                    tirades ++;
                    tablero.setExtrem1(jugActual.getFitxesJug().get(indexFitxa).getCara1());
                    tablero.setExtrem2(jugActual.getFitxesJug().get(indexFitxa).getCara2());
                } else {
                    Output.pasarTorn(jugActual);
                }
            }

            if (torn == p2.getJugadorsParella()[i].getIdJug()){
                Jugador jugActual2 = p2.getJugadorsParella()[i];
                int indexFitxa = Input.triaFitxa(jugActual2.getFitxesJug(), jugActual2, tirades);

                if (indexFitxa != 10){
                    tablero.getFitxesTab().add(jugActual2.getFitxesJug().get(indexFitxa));
                    tirades ++;
                    tablero.setExtrem1(jugActual2.getFitxesJug().get(indexFitxa).getCara1());
                    tablero.setExtrem2(jugActual2.getFitxesJug().get(indexFitxa).getCara2());
                } else {
                    Output.pasarTorn(jugActual2);
                }
            }
        }
    }
}
