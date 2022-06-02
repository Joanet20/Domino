package com.company.domino.VariantsDomino;

import com.company.domino.*;
import com.company.domino.VariantsTorns.TornEsp;

import java.util.ArrayList;

public class Espanyol extends Domino {

    private ArrayList<Jugador> jugadors;

    public Espanyol (){
        super(100, "Espanyol");
        this.jugadors = new ArrayList<>();
    }

    @Override
    public void jugar(Domino newGame, Tablero tablero){
        super.jugar(newGame, tablero);

        Output.triarModEsp();

        switch (Input.triarModEsp()){
            case INDIVIDUAL:
                iniciEspIndividual(newGame, tablero, 7);
                break;

            case PARELLES:
                iniciEspParelles(newGame, tablero, 5);
                break;

            default:
                Output.opcioNoCorrecte();
                break;
        }
    }

    public void iniciEspIndividual (Domino newGame, Tablero tablero, int fitxesPerJug){
        this.jugadors.add(new Jugador(1));
        this.jugadors.add(new Jugador(2));
        newGame.assignarFitxesJug(newGame.getFitxesJoc(), this.jugadors, fitxesPerJug);
        jocEsp(newGame, tablero, 0);
    }

    public void iniciEspParelles (Domino newGame, Tablero tablero, int fitxesPerJug){
        this.jugadors.add(new Jugador(1, 1));
        this.jugadors.add(new Jugador(2, 2));
        this.jugadors.add(new Jugador(3, 1));
        this.jugadors.add(new Jugador(4, 2));
        newGame.assignarFitxesJug(newGame.getFitxesJoc(), this.jugadors, fitxesPerJug);
        jocEsp(newGame, tablero, 1);
    }

    public void jocEsp (Domino newGame, Tablero tablero, int modalitat){
        int tirades = 0;
        boolean begin = false;
        Torn torn = new TornEsp();
        int tornInicial = torn.jugadorInicial(this.jugadors);

        while (this.jugadors.get(0).getPuntucaioJug() < this.getPuntuacio() ||
                this.jugadors.get(1).getPuntucaioJug() < this.getPuntuacio()){
            if (!begin){
                begin = true;
            } else {
                if (modalitat == 0){
                    torn.torn(this.jugadors, tornInicial, newGame, tablero, tirades);
                    tornInicial = torn.seguentTorn(tornInicial, this.jugadors.size());
                    tirades++;

                    if (!newGame.teFitxes(this.jugadors)){
                        this.jugadors.get(newGame.wiinerHand(this.jugadors)).setPuntucaioJug(newGame.calcularPuntuacio(this.jugadors));
                        newGame.eliminarFitxes(this.jugadors);
                    }

                } else if (modalitat == 1) {
                    torn.torn(this.jugadors, tornInicial, newGame, tablero, tirades);
                    tornInicial = torn.seguentTorn(tornInicial, this.jugadors.size());
                    tirades++;

                    if (!newGame.teFitxes(this.jugadors)){
                        int parellaGuanyadora = this.jugadors.get(newGame.wiinerHand(this.jugadors)).getIdParella();
                        for (Jugador player : this.jugadors){
                            if (player.getIdParella() == parellaGuanyadora){
                                this.jugadors.get(newGame.wiinerHand(this.jugadors)).setPuntucaioJug(newGame.calcularPuntuacio(this.jugadors));
                            }
                        }
                        newGame.eliminarFitxes(this.jugadors);
                    }
                }
            }
        }
    }
}
