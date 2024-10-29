import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/*  EJERCICIO:
Plantear un programa que ejecute DOS HILOS de programa al mismo tiempo,
para esto se requiere que uno de los hilos realice un conteo regresivo temporizado partiendo de un número establecido por el usuario,
la temporización entre cada ejecución del hilo debe ser de 600 ms,
el otro hilo, debe mostrar las letras del alfabeto partiendo desde la A hasta una letra ingresada por el usuario, este hilo debe estar temporizado a 500 ms.

Ambos hilos deben detenerse cuando el hilo numero 1 encuentre la letra ingresada por el usuario.

Al ejecutar el programa en consola se debe evidenciar la salida entregada por ambos hilos,
al final de su ejecución cada hilo debe mostrar el mensaje “Trabajo del hilo [nombre] terminado”.
 */
public class Main {

    public static void main(String[] args) {

        //Administra tareas utilizando los hilos virtuales [Runnable o Callable]
        //Los Runnable NO devuelven algo y los Callable devuelve algo
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        //maneja de forma segura valores concurrentes
        AtomicBoolean encontrado = new AtomicBoolean(false);

        //Hilo que busca la letra
        char letra = JOptionPane.showInputDialog("Ingresa una letra: ").charAt(0);
        Runnable hilo1 = () -> {

            try {

                Thread.currentThread().setName("Hilo-Letra");

                for (char i = 'A'; i <= 'Z'; i++) {

                    Thread.sleep(500); //5 segundos

                    System.out.print(i);

                    if (i == letra) {
                        
                        encontrado.set(true);
                        System.out.println("Letra " + i + " encontrada.");
                        System.out.format("Trabajo del hilo " + Thread.currentThread().getName() + " terminado.");

                    }

                }

            } catch (Exception e) {
                System.err.println("ERROR: " + e.getMessage());
            }
        };

        //Hilo para contar hacia atrás
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un número"));
        AtomicInteger numeroAtomico = new AtomicInteger(numero);
        Runnable hilo2 = () -> {

            try {

                Thread.currentThread().setName("Hilo-número");

                while (!encontrado.get()) {

                    Thread.sleep(600); //6 segundos
                    System.out.println(numeroAtomico.getAndDecrement());

                }

                System.out.println("Trabajo del hilo " + Thread.currentThread().getName() + " terminado.");

            } catch (Exception e) {
                System.err.println("ERROR: " + e.getMessage());
            }

        };

        executor.submit(hilo1); //levanta el hilo 1
        executor.submit(hilo2); //levanta el hilo 2
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS); //espera 30 segundos a que los 2 hilos anteriores terminen
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();

    }

}
