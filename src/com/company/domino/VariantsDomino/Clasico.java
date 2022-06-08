package com.company.domino.VariantsDomino;

import com.company.domino.*;
import com.company.domino.VariantsTorns.TornEsp;

import java.util.ArrayList;

public class Clasico extends Domino {

    private ArrayList<Jugador> jugadors;

    public Clasico (){
        super("Clásico");
        this.jugadors = new ArrayList<>();
    }

    @Override
    public void jugar(Domino newGame, Tablero tablero){
        super.jugar(newGame, tablero);

        Output.triarModEsp();

        switch (Input.triarModCla()){
            case INDIVIDUAL:
                iniciClaIndividual(newGame, tablero, 7);
                break;

            default:
                Output.opcioNoCorrecte();
                break;
        }
    }

    public void iniciClaIndividual (Domino newGame, Tablero tablero, int fitxesPerJug){
        this.jugadors.add(new Jugador(1));
        this.jugadors.add(new Jugador(2));
        newGame.assignarFitxesJug(newGame.getFitxesJoc(), this.jugadors, fitxesPerJug);
        jocCla(newGame, tablero, 0);
    }

    public boolean comprobarGuanyador (int modalitat){
        boolean hasGuanyat = false;
        if (modalitat == 0){
            for (Jugador jugador : this.jugadors){
                if (jugador.getFitxesJug().isEmpty()){
                    hasGuanyat = true;
                }
            }
        }
        return hasGuanyat;
    }

    public void jocCla (Domino newGame, Tablero tablero, int modalitat){
        int tirades = 0;
        boolean begin = false;
        Torn torn = new TornEsp();
        int tornInicial = torn.jugadorInicial(this.jugadors);

        while (!comprobarGuanyador(modalitat)){
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
