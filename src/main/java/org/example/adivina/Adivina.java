package org.example.adivina;

/*
Clase main que coordina la ejecución del juego
 */
public class Adivina {

    private final static int N_HILOS = 10;

    public static void main(String[] args) {

        NumeroOculto numeroOculto = new NumeroOculto(1, 10);

        Thread[] hilos = new Thread[N_HILOS];

        for(int i=0; i < N_HILOS; i++){
            Thread th = new Thread(new Jugador(i, numeroOculto));
            hilos[i] = th;
            th.start();
        }

        for(Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

}
