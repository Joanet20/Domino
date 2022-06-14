package com.company.domino;

public class Fitxa {

    private int cara1;
    private int cara2;
    private boolean jugada;
    private boolean jugable;
    private boolean assignada;
    private int caraCreu;

    public Fitxa(int cara1, int cara2){
        this.cara1 = cara1;
        this.cara2 = cara2;
        this.jugable = false;
        this.jugada = false;
        this.assignada = false;
        this.caraCreu = 0;
    }

    public boolean isAssignada() {
        return assignada;
    }

    public void setAssignada (boolean assignada){
        this.assignada = true;
    }

    public int getCara1() {
        return cara1;
    }

    public int getCara2() {
        return cara2;
    }

    public boolean isJugable() {
        return jugable;
    }

    public void setJugable(boolean jugable) {
        this.jugable = jugable;
    }

    public int getCaraCreu() {
        return caraCreu;
    }

    public void setCaraCreu(int caraCreu) {
        this.caraCreu = caraCreu;
    }

    public int sumaCares (Fitxa fitxa){
        cara1 = fitxa.getCara1();
        cara2 = fitxa.getCara2();
        return cara1 + cara2;
    }
}
