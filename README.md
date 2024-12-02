# Ejercicio de Hilos en Java

Este ejercicio consiste en implementar un programa en Java que ejecuta **dos hilos** simultáneamente. Uno de los hilos realizará un conteo regresivo desde un número establecido por el usuario, mientras que el otro mostrará las letras del alfabeto desde la 'A' hasta una letra que también será ingresada por el usuario. La ejecución de ambos hilos debe detenerse cuando el primer hilo encuentre la letra ingresada.

## Requisitos del Ejercicio

1. **Hilo de Conteo Regresivo**: 
   - Este hilo debe contar hacia atrás desde un número que el usuario introduzca.
   - La temporización entre cada número mostrado debe ser de **600 ms**.

2. **Hilo de Letras**: 
   - Este hilo debe mostrar las letras del alfabeto comenzando desde 'A' hasta la letra ingresada por el usuario.
   - La temporización entre cada letra mostrada debe ser de **500 ms**.

3. Ambos hilos deben detenerse una vez que el hilo que muestra letras encuentre la letra ingresada por el usuario.

4. Al finalizar, cada hilo debe imprimir un mensaje indicando que su trabajo ha terminado.
