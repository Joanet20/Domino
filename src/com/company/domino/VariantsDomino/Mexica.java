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
                iniciMexicaInd(newGame, tablero, 7);
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
        return index;
    }

    public void jocInd (Parella p1, Parella p2, Domino newGame, Tablero tablero){

        int tirades = 0;
        boolean començat = false;
        int torn = jugadorInicial(newGame.getFitxesJoc());
        while (p1.getPuntacioParella() < this.getPuntuacio() || p2.getPuntacioParella() < this.getPuntuacio()){
            if (!començat){
                començat = true;
            } else {
                tornJugInd(p1, p2, torn, tirades, tablero, newGame);
                torn = seguentTorn(torn);
                System.out.println(torn);
                tirades++;
            }
        }
    }


    public void tornJugInd (Parella p1, Parella p2, int torn, int tirades, Tablero tablero, Domino newGame){
        for (int i = 0; i < p1.getJugadorsParella().length; i++){
            Jugador jugActual = p1.getJugadorsParella()[i];
            if (torn == jugActual.getIdJug()){
                newGame.fitxesJugables(tablero, jugActual.getFitxesJug());
                int indexFitxa = Input.triaFitxa(jugActual.getFitxesJug(), jugActual, tirades);
                if (newGame.teFitxesJugables(jugActual.getFitxesJug())){
                    tablero.getFitxesTab().add(jugActual.getFitxesJug().get(indexFitxa));
                    jugActual.getFitxesJug().remove(indexFitxa);
                    tablero.setExtrem1(jugActual.getFitxesJug().get(indexFitxa).getCara1());
                    tablero.setExtrem2(jugActual.getFitxesJug().get(indexFitxa).getCara2());
                } else {
                    Output.pasarTorn(jugActual);
                }
            }

            if (torn == p2.getJugadorsParella()[i].getIdJug()){
                Jugador jugActual2 = p2.getJugadorsParella()[i];
                newGame.fitxesJugables(tablero, jugActual2.getFitxesJug());
                int indexFitxa = Input.triaFitxa(jugActual2.getFitxesJug(), jugActual2, tirades);
                if (newGame.teFitxesJugables(jugActual2.getFitxesJug())){
                    tablero.getFitxesTab().add(jugActual2.getFitxesJug().get(indexFitxa));
                    jugActual2.getFitxesJug().remove(indexFitxa);
                    tablero.setExtrem1(jugActual2.getFitxesJug().get(indexFitxa).getCara1());
                    tablero.setExtrem2(jugActual2.getFitxesJug().get(indexFitxa).getCara2());
                } else {
                    Output.pasarTorn(jugActual2);
                }
            }
        }
        torn = seguentTorn(torn);
    }

    public int seguentTorn (int torn){
        if (torn == 4){
            torn = 1;
        } else {
            torn++;
        }
        return torn;
    }
}
