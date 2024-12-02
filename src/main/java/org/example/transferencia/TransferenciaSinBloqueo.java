package org.example.transferencia;

/*
Clase que coordina la simulación y posee el método main
 */
public class TransferenciaSinBloqueo {

    public static void main(String[] args){

        Cuenta c1 = new Cuenta("ES12345678901234567890",12500);
        Cuenta c2 = new Cuenta("ES45678901234567890123",23400);

        System.out.println("Saldo Inicial de " + c1.getNumCuenta() +" : " + c1.getSaldo());
        System.out.println("Saldo Inicial de " + c2.getNumCuenta() +" : " + c2.getSaldo());
        System.out.println("----------------------------------------");

        Thread h1 = new Thread(new Hilo(c1, c2,"H1"));
        Thread h2 = new Thread(new Hilo(c1, c2,"H2"));

        h1.start();
        h2.start();

        try{
            h1.join();
            h2.join();

        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println("----------------------------------------");
        System.out.println("Saldo Final de " + c1.getNumCuenta() +" : " + c1.getSaldo());
        System.out.println("Saldo Final de " + c2.getNumCuenta() +" : " + c2.getSaldo());

    }

}
