package org.example.transferencia;

/*
Clase Gestor de Transferencias que coordina y ejecuta las transferencias entre cuentas de forma segura
 */
public class GestorTransferencias {

    //Método que realiza una transferencia de cantidad de c1 a c2 siempre que haya saldo
    public static boolean transferencia(Cuenta c1, Cuenta c2, int cantidad) {

        Cuenta cuentaMenor, cuentaMayor;
        if (c1.getNumCuenta().compareTo(c2.getNumCuenta()) < 0) {
            cuentaMenor = c1;
            cuentaMayor = c2;
        } else {
            cuentaMenor = c2;
            cuentaMayor = c1;
        }

        boolean result = false;
        //si el saldo de c1 es suficiente transfiere la cantidad
        synchronized (cuentaMenor) {
            synchronized (cuentaMayor) {
                if(c1.getSaldo() >= cantidad){
                    c1.sacar(cantidad);
                    c2.meter(cantidad);
                    result=true;
                }
            }
        }
        return result;
    }

}
