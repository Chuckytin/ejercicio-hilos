package org.example.adivina;

import java.util.Random;

/*
Clase que representa el número que los jugadores intenta adivinar.
Maneja la validación y asegura que el proceso sea seguro en un entorno multihilo
 */
public class NumeroOculto {

    int numero;
    boolean adivinado;
    int min, max;

    //Constructor que genera un número aleatorio entre los límites introducidos
    public NumeroOculto(int min, int max) {

        this.min = min;
        this.max = max;
        adivinado = false;
        Random r = new Random();
        numero = r.nextInt(min, max+1);
        System.out.println("A ver quien adivina el " + numero);

    }

    //Método que verifica si un número propuesto coincide con el número oculto
    synchronized public int propuestaNumero(int num) {

        if (adivinado) {
            return -1;
        }
        if (numero==num){
            adivinado=true;
            return 1;
        } else {
            return 0;
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

}
