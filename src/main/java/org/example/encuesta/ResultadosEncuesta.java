package org.example.encuesta;

import java.util.HashMap;
import java.util.Set;

/*
Clase que encapsula los datos y las operaciones relacionadas con los resultados de la encuesta.
 */
public class ResultadosEncuesta {

    private final HashMap<String, Integer> totalPorRespuesta = new HashMap<>();
    private final HashMap<String, Integer> totalPorZona = new HashMap<>();

    //Método que incrementa el conteo de respuestas para una zona específica
    public synchronized void anotaRespuesta (String idZona, String respuesta) {
        Integer numRespuestaValor = totalPorRespuesta.get(respuesta);
        totalPorRespuesta.put(respuesta, numRespuestaValor == null ? 1 : numRespuestaValor + 1);

        Integer numRespuestaZona = totalPorZona.get(idZona);
        totalPorZona.put(idZona, numRespuestaZona == null ? 1 : numRespuestaZona + 1);
    }

    //Método que devuelve todas las zonas registradas
    synchronized public Set<String> obtenZonas(){
        return this.totalPorZona.keySet();
    }
    //Método que devuelve todas las respuestas registradas
    synchronized public Set<String> obtenRespuestas(){
        return this.totalPorRespuesta.keySet();
    }
    //Método que devuelve todas las respuestas asociadas a una zona específica
    synchronized public int obtenNumRespuestasZona(String zona){
        return this.totalPorZona.get(zona);
    }
    //Método que devuelve el total de respuestas para un tipo específico de respuesta
    synchronized public int obtenNumRespuestas(String respuesta){
        return this.totalPorRespuesta.get(respuesta);
    }

}
