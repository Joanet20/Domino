package com.company.domino;

import java.util.Scanner;

public class Input {

    public static int triarModMex (){

        int opcio = 0;
        Scanner sc = new Scanner(System.in);

        switch (sc.nextInt()){
            case 0:
                opcio = 0;
                break;

            case 1:
                opcio = 1;
                break;

            case 2:
                opcio = 2;
                break;

            default:
                Output.opcioNoCorrecte();
                break;
        }
        return opcio;
    }
}
