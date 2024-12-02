package org.example.intro;

import org.example.intro.Hilo;
import org.example.intro.HiloRunnable;

public class Main {

    public static void main(String[] args) {

        //Forma 1
        Hilo proceso = new Hilo();
        //Forma 2
        Thread proceso2 = new Thread(new HiloRunnable());

        proceso.start();
        proceso2.start();

    }

}
