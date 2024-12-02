package org.example.intro;

/*
Es una clase Runnable que puede implementar todas las interfaces que quieras.
Permite una mejor reutilización de código.
 */
public class HiloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hilo ejecutándose usando Runnable.");
    }
}
