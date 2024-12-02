package org.example.transferencia;

/*
Clase Hilo que realiza múltiples transferencias entre dos cuentas
 */
public class Hilo implements Runnable {

    Cuenta c1, c2;
    String nombre;

    //Constructor que asocia las cuentas y asigna un nombre al hilo
    public Hilo(Cuenta c1, Cuenta c2, String nombre) {
        this.c1 = c1;
        this.c2 = c2;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    //Método run que realiza 10000 transferencias de 10 unidades cada una
    @Override
    public void run() {

        int cantidad = 10;
        int numTransf = 0;

        for(int i=0; i < 10000; i++){
            if (GestorTransferencias.transferencia(c1, c2, cantidad)) {
                numTransf++;
            }
        }
        System.out.println("**** FIN de " + this.getNombre() + ", " + numTransf + " transferencias hechas de " + c1.getNumCuenta() + " a " + c2.getNumCuenta());
    }
}
