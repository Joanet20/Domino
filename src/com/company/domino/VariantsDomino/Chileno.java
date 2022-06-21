package com.company.domino.VariantsDomino;

import com.company.domino.*;
import com.company.domino.VariantsTorns.TornEsp;

import java.util.ArrayList;

public class Chileno extends Domino {
    private ArrayList<Jugador> jugadors;

    public Chileno (){
        super(121, "Chileno");
        this.jugadors = new ArrayList<>();
    }

    @Override
    public void jugar(Domino newGame, Tablero tablero){
        super.jugar(newGame, tablero);

        Output.triarModChi();

        switch (Input.triarModChi()){
            case INDIVIDUAL:
                iniciChiIndividual(newGame, tablero, 7);
                break;

            case PARELLES:
                iniciChiParelles(newGame, tablero, 7);
                break;

            default:
                Output.opcioNoCorrecte();
                break;
        }
    }

    public void iniciChiIndividual (Domino newGame, Tablero tablero, int fitxesPerJug){
        this.jugadors.add(new Jugador(1));
        this.jugadors.add(new Jugador(2));
        newGame.assignarFitxesJug(newGame.getFitxesJoc(), this.jugadors, fitxesPerJug);
        jocChi(newGame, tablero, 0);
    }

    public void iniciChiParelles (Domino newGame, Tablero tablero, int fitxesPerJug){
        this.jugadors.add(new Jugador(1, 1));
        this.jugadors.add(new Jugador(2, 2));
        this.jugadors.add(new Jugador(3, 1));
        this.jugadors.add(new Jugador(4, 2));
        newGame.assignarFitxesJug(newGame.getFitxesJoc(), this.jugadors, fitxesPerJug);
        jocChi(newGame, tablero, 1);
    }

    public boolean comprobarGuanyador (int modalitat){
        boolean hasGuanyat = false;
        if (modalitat == 0){
            for (Jugador jugador : this.jugadors){
                if (jugador.getPuntucaioJug() >= this.getPuntuacio()){
                    hasGuanyat = true;
                }
            }
        }
        return hasGuanyat;
    }

    public void jocChi (Domino newGame, Tablero tablero, int modalitat){
        int tirades = 0;
        boolean begin = false;
        Torn torn = new TornEsp();
        int tornInicial = torn.jugadorInicial(this.jugadors);

        while (!comprobarGuanyador(modalitat)){
            if (!begin){
                begin = true;
            } else {
                if (modalitat == 0){
                    modalitatIndividual(newGame, tirades, tablero, modalitat, torn, tornInicial);
                } else if (modalitat == 1) {
                    modalitatParelles(newGame, tirades, tablero, modalitat, torn, tornInicial);
                }
            }
        }

        Output.hasGuanyat(this.jugadors.get(tornInicial));
    }

    public void modalitatIndividual (Domino newGame, int tirades, Tablero tablero, int modalitat, Torn torn, int tornInicial){
        if (!newGame.teFitxes(this.jugadors) || newGame.isCierre(this.jugadors, newGame)){

            if (newGame.isCierre(this.jugadors, newGame)){
                this.jugadors.get(newGame.jugadorGuanyadorCierre(this.jugadors)).setPuntucaioJug(newGame.calcularPuntuacio(this.jugadors));
            } else {
                this.jugadors.get(newGame.wiinerHand(this.jugadors)).setPuntucaioJug(newGame.calcularPuntuacio(this.jugadors));
            }

            tirades = 0;
            newGame.eliminarFitxes(this.jugadors);
            newGame.crearFitxes(newGame.getFitxesJoc());
            newGame.assignarFitxesJug(newGame.getFitxesJoc(), this.jugadors, 7);
            borrarTablero(tablero);
        }

        Output.printPuntuacio(this.jugadors, modalitat);
        torn.torn(this.jugadors, tornInicial, newGame, tablero, tirades);
        tornInicial = torn.seguentTorn(tornInicial, this.jugadors.size());
        tirades++;
    }

    public void modalitatParelles (Domino newGame, int tirades, Tablero tablero, int modalitat, Torn torn, int tornInicial){
        if (!newGame.teFitxes(this.jugadors)){
            int parellaGuanyadora = this.jugadors.get(newGame.wiinerHand(this.jugadors)).getIdParella();
            for (Jugador player : this.jugadors){
                if (player.getIdParella() == parellaGuanyadora){
                    this.jugadors.get(newGame.wiinerHand(this.jugadors)).setPuntucaioJug(newGame.calcularPuntuacio(this.jugadors));
                }
            }
            tirades = 0;
            borrarTablero(tablero);
            newGame.eliminarFitxes(this.jugadors);
        }

        torn.torn(this.jugadors, tornInicial, newGame, tablero, tirades);
        tornInicial = torn.seguentTorn(tornInicial, this.jugadors.size());
        tirades++;
    }
}
