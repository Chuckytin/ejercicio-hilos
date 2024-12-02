package org.example.encuesta;

import java.util.Set;

/*
Clase Main que coordina la ejecución de los hilos que simulan los encuestadores
 */
public class Encuesta {

    private static final int NUM_ZONAS = 20;

    public static void main(String[] args) {

        ResultadosEncuesta resultadosEncuesta = new ResultadosEncuesta();
        Thread[] encuestadores = new Thread[NUM_ZONAS];

        for(int i=0; i<NUM_ZONAS; i++){

            Thread encuestador = new Thread(new EncuestadorZona("zona "+(i+1), resultadosEncuesta));
            encuestadores[i] = encuestador;
        }

        for(Thread encuestador : encuestadores){
            encuestador.start();
        }

        for(Thread encuestador : encuestadores){
            try {
                encuestador.join(); //asegura que todos los hilos terminen antes de continuar
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("Encuestados por zonas");
        Set<String> zonas = resultadosEncuesta.obtenZonas();
        int granTotalPorZonas = 0;

        for (String zona : zonas){

            int totalParaZona = resultadosEncuesta.obtenNumRespuestasZona(zona);
            System.out.println(zona+": " + totalParaZona);
            granTotalPorZonas += totalParaZona;
        }

        System.out.println("TOTAL: " + granTotalPorZonas);

        System.out.println("Resultados por respuesta:");
        Set<String> respuestas = resultadosEncuesta.obtenRespuestas();
        int granTotalPorRespuestas = 0;

        for (String respuesta : respuestas){
            int totalParaRespuesta = resultadosEncuesta.obtenNumRespuestas(respuesta);
            System.out.println((respuesta != null ? respuesta:"NS/NC") + ": " + totalParaRespuesta);
            granTotalPorRespuestas += totalParaRespuesta;

        }
        System.out.println("TOTAL: " + granTotalPorRespuestas);
    }

}
