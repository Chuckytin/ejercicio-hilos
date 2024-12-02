package org.example.transferencia;

/*
Clase que representa una cuenta bancaria con un número de cuenta y saldo
 */
public class Cuenta {

    String numCuenta;
    int saldo;

    public String getNumCuenta() {
        return numCuenta;
    }

    public synchronized int getSaldo() {
        return saldo;
    }
    public synchronized void meter(int cantidad) {
        this.saldo+=cantidad;
    }
    public synchronized void sacar(int cantidad) {
        this.saldo-=cantidad;
    }

    public Cuenta(String nombre, int saldo) {
        this.numCuenta=nombre;
        this.saldo=saldo;
    }

}
