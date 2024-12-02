package org.example.intro;

/*
Es una clase que es un hilo en sí, solo puede heredar de Thread.
 */
public class Hilo extends Thread {

    @Override
    public void run() {
        System.out.println("Hilo ejecutándose con clase Thread.");
    }

}
