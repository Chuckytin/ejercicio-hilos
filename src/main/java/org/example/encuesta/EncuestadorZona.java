package org.example.encuesta;

import java.util.Random;

/*
Clase que representa a un encuestador que recopila respuestas en una zona específica
 */
public class EncuestadorZona implements Runnable{

    private final String idZona;
    private final ResultadosEncuesta resultados;

    public EncuestadorZona(String idZona, ResultadosEncuesta resultados) {
        this.idZona = idZona;
        this.resultados = resultados;
    }

    //Método que se ejecuta cuando el hilo asociado comienza.
    @Override
    public void run() {

        System.out.println(">>Encuestador para zona "+idZona+" comienza.");
        Random r = new Random();
        int numRespuestas = 100 + r.nextInt(200-100)+1;

        for(int i = 0; i < numRespuestas; i++){
            int numRespuesta = r.nextInt(10); //Valor 0-9
            String respuesta = null;
            if (numRespuesta > 0){
                respuesta = "respuesta_" + numRespuesta;
            }

            resultados.anotaRespuesta(idZona, respuesta);

        }
        System.out.println("##Encuestador zona " + idZona + " termina.");

    }

}
