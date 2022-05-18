package com.company.domino;

public class Fitxa {

    private int cara1;
    private int cara2;
    private boolean jugada;
    private boolean assignada;

    public Fitxa(int cara1, int cara2){
        this.cara1 = cara1;
        this.cara2 = cara2;
        this.jugada = false;
        this.assignada = false;
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

    public int sumaCares (Fitxa fitxa){
        cara1 = fitxa.getCara1();
        cara2 = fitxa.getCara2();
        return cara1 + cara2;
    }
}
