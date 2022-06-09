package com.company.domino;

import java.util.ArrayList;

public abstract class Domino {

    private int puntuacio;
    private String name;
    private ArrayList<Fitxa> fitxesJoc;

    public Domino (int puntuacio, String name){
        this.puntuacio = puntuacio;
        this.name = name;
        this.fitxesJoc = new ArrayList<>();
    }

    public Domino (String name){
        this.name = name;
        this.fitxesJoc = new ArrayList<>();
    }

    public static void inici (){
        Output.triarClase();
        Domino newGame = Input.triarClasse();
        Tablero tab = new Tablero();

        newGame.jugar(newGame, tab);
    }

    public String getName (){
        return name;
    }

    public int getPuntuacio (){
        return puntuacio;
    }

    public ArrayList<Fitxa> getFitxesJoc (){
        return fitxesJoc;
    }

    public void jugar (Domino newGame, Tablero tablero){
        Output.classeTriada(newGame.getName());
        newGame.crearFitxes(fitxesJoc);
    }

    public abstract boolean comprobarGuanyador(int modalitat);

    public abstract boolean comprobarGuanyador();

    public void crearFitxes (ArrayList<Fitxa> fitxesJoc){
        for (int i = 0; i < 7; i++)
            for (int j = i; j < 7; j++){
                fitxesJoc.add(new Fitxa(i, j));
                this.fitxesJoc = fitxesJoc;
            }
    }

    public void assignarFitxesJug (ArrayList<Fitxa> fitxesJoc, ArrayList<Jugador> jugadors, int fitxesPerJug){
        for (Jugador jug : jugadors){
            int count = 0;
            while (count < fitxesPerJug){
                int rand = (int) Math.floor(Math.random()*fitxesJoc.size());

                if (!fitxesJoc.get(rand).isAssignada()){
                    jug.getFitxesJug().add(fitxesJoc.get(rand));
                    fitxesJoc.get(rand).setAssignada(true);
                    count++;
                }
            }
        }
    }

    public void fitxesJugables (Tablero tablero, ArrayList<Fitxa> fitxesJug){
        for (Fitxa fitxa : fitxesJug){
            if (fitxa.getCara1() == tablero.getExtrem1() ||
                    fitxa.getCara2() == tablero.getExtrem1() ||
                    fitxa.getCara1() == tablero.getExtrem2() ||
                    fitxa.getCara2() == tablero.getExtrem2()) {
                fitxa.setJugable(true);
            } else {
                fitxa.setJugable(false);
            }
        }
    }

    public boolean teFitxesJugables (ArrayList<Fitxa> fitxesJug){
        boolean agafar = false;
        for (Fitxa fitxa : fitxesJug){
            if (fitxa.isJugable()){
                agafar = true;
            }
        }
        return agafar;
    }

    public int numeroJugadors (ArrayList<Jugador> jugadors){
        return jugadors.size();
    }

    public boolean teFitxes (ArrayList<Jugador> jugadors){
        boolean teFitxes = false;
        for (Jugador player : jugadors){
            if (player.getFitxesJug().size() > 0){
                teFitxes = true;
            }
        }
        return teFitxes;
    }

    public int wiinerHand (ArrayList<Jugador> jugadors){
        int indexJugador = 0;

        for (Jugador player : jugadors){
            if (player.getFitxesJug().size() > 0){
                indexJugador = player.getIdJug();
            }
        }
        return indexJugador;
    }

    public void eliminarFitxes (ArrayList<Jugador> jugadors){
        for (Jugador player : jugadors){
            for (Fitxa fitxa : player.getFitxesJug()){
                player.getFitxesJug().remove(fitxa);
            }
        }
    }

    public int calcularPuntuacio (ArrayList<Jugador> jugadors){
        int puntuacio = 0;

        for (Jugador player : jugadors){
            for (Fitxa fitxa : player.getFitxesJug()){
                puntuacio += fitxa.getCara1() + fitxa.getCara2();
            }
        }
        return puntuacio;
    }

    public void robarFitxa (ArrayList<Fitxa> fitxesJoc, Jugador player){
        if (!fitxesJoc.isEmpty()){
            player.getFitxesJug().add(fitxesJoc.get(0));
            fitxesJoc.remove(0);
        } else {
            Output.pasarTorn(player);
        }

    }


    public void posarExtremsTablero (Tablero tablero, Jugador player, int fitxaTriada){
        if (tablero.getExtrem1() == player.getFitxesJug().get(fitxaTriada).getCara1()) {
            tablero.setExtrem1(player.getFitxesJug().get(fitxaTriada).getCara2());
            player.getFitxesJug().remove(fitxaTriada);
        } else if (tablero.getExtrem1() == player.getFitxesJug().get(fitxaTriada).getCara2()){
            tablero.setExtrem1(player.getFitxesJug().get(fitxaTriada).getCara1());
            player.getFitxesJug().remove(fitxaTriada);
        } else if (tablero.getExtrem2() == player.getFitxesJug().get(fitxaTriada).getCara1()){
            tablero.setExtrem2(player.getFitxesJug().get(fitxaTriada).getCara2());
            player.getFitxesJug().remove(fitxaTriada);
        } else if (tablero.getExtrem2() == player.getFitxesJug().get(fitxaTriada).getCara2()){
            tablero.setExtrem2(player.getFitxesJug().get(fitxaTriada).getCara1());
            player.getFitxesJug().remove(fitxaTriada);
        }
    }

    public boolean isTranca (ArrayList<Jugador> jugadors, Domino newGame){
        boolean isTranca = false;
        int limit = 1;

        for (Jugador player : jugadors){
            if (player.getFitxesJug().isEmpty()){
                limit++;
            }
        }

        if (limit == jugadors.size() && newGame.getFitxesJoc().isEmpty()){
            isTranca = true;
        }

        return isTranca;
    }

    public int guanyadorTranca (ArrayList<Jugador> jugadors){
        int parellaGuanyadora = 0;
        int puntsP1 = 0;
        int puntsP2 = 0;

        for (Jugador player : jugadors){
            if (player.getIdParella() == 1){
                puntsP1 += player.getPuntucaioJug();
            } else if (player.getIdParella() == 2){
                puntsP2 += player.getPuntucaioJug();
            }
        }

        if (puntsP1 > puntsP2){
            parellaGuanyadora = 1;
        } else {
            parellaGuanyadora = 2;
        }
        return parellaGuanyadora;
    }
}
