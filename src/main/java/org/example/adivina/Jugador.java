package org.example.adivina;

import java.util.Random;

/*
Clase que representa a un jugador que intenta adivinar el número oculto
 */
public class Jugador implements Runnable {

    int id;
    NumeroOculto n;
    int min, max;

    //Constructor que recibe un id único y obtiene los valores min y max del rango de adivinanza
    public Jugador (int id, NumeroOculto n) {
        this.id = id;
        this.n = n;
        min = n.getMin();
        max = n.getMax();
    }

    //método run que genera números aleatorios dentro del rango
    //llamá al método propuestaNumero de la clase NumeroOculto
    @Override
    public void run() {

        Random r = new Random();
        boolean isOn = true;
        int i=0;

        while(isOn) {

            i++;
            int guess = r.nextInt(n.getMin(),n.getMax() + 1);
            int outcome = n.propuestaNumero(guess);
            System.out.println("Soy el jugador " + id + " es mi intento " + i + ". Pruebo con " + guess);

            switch(outcome) {
                case 1 -> {
                    isOn = false;
                    System.out.println("Hilo " + id + " ha adivinado.");
                }
                case -1 -> {
                    isOn = false;
                    System.out.println("Hilo " + id + " acabo porque ya han adivinado.");
                }
            }
        }
    }
}
