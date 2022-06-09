package com.company.domino.VariantsDomino;

import com.company.domino.*;
import com.company.domino.VariantsTorns.TornEsp;

import java.util.ArrayList;

public class Latino extends Domino {

    private ArrayList<Jugador> jugadors;

    public Latino() {
        super(200, "Latino");
        this.jugadors = new ArrayList<>();
    }

    @Override
    public void jugar(Domino newGame, Tablero tablero){
        super.jugar(newGame, tablero);

        Output.triarModEsp();

        switch (Input.triarModLat()){
            case PARELLES:
                iniciLatParelles(newGame, tablero, 5);
                break;

            default:
                Output.opcioNoCorrecte();
                break;
        }
    }

    @Override
    public boolean comprobarGuanyador(int modalitat) {
        return false;
    }

    public void iniciLatParelles (Domino newGame, Tablero tablero, int fitxesPerJug){
        this.jugadors.add(new Jugador(1, 1));
        this.jugadors.add(new Jugador(2, 2));
        this.jugadors.add(new Jugador(3, 1));
        this.jugadors.add(new Jugador(4, 2));
        newGame.assignarFitxesJug(newGame.getFitxesJoc(), this.jugadors, fitxesPerJug);
        jocLat(newGame, tablero, 1);
    }

    @Override
    public boolean comprobarGuanyador (){
        boolean hasGuanyat = false;

        for (Jugador jugador : this.jugadors){
            if (jugador.getPuntucaioJug() >= this.getPuntuacio()){
                hasGuanyat = true;
            }
        }
        return hasGuanyat;
    }

    public void jocLat (Domino newGame, Tablero tablero, int modalitat){
        int tirades = 0;
        boolean begin = false;
        Torn torn = new TornEsp();
        int tornInicial = torn.jugadorInicial(this.jugadors);

        while (!comprobarGuanyador(modalitat)){
            if (!begin){
                begin = true;
            } else {
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

        Output.hasGuanyat(this.jugadors.get(tornInicial));
    }


}
