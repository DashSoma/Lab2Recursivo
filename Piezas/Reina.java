/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piezas;


/**
 *
 * @author Crisp
 */
public class Reina {

    private int[] tablero; // Almacena la posición de las reinas
    private final int n; // Dimensión del tablero

    public Reina(int n) {
        this.n = n;
        tablero = new int[n];
        for (int i = 0; i < n; i++) {
            tablero[i] = -1; // Inicializamos las posiciones de las reinas a -1
        }
    }

    // Método para comprobar si es seguro colocar una reina en una fila y columna dadas
    private boolean esValido(int fila, int columna) {
        for (int i = 0; i < fila; i++) {
            // Comprobamos si hay otra reina en la misma columna o en las diagonales
            if (tablero[i] == columna
                    || // Misma columna
                    tablero[i] - i == columna - fila
                    || // Misma diagonal (descendente)
                    tablero[i] + i == columna + fila) { // Misma diagonal (ascendente)
                return false;
            }
        }
        return true;
    }

    // Método recursivo para resolver el problema fila por fila
    public boolean resolver(int fila) {
        if (fila == n) {
            return true; // Si hemos colocado todas las reinas, hemos terminado
        }
        // Intentamos colocar la reina en cada columna de la fila actual
        for (int col = 0; col < n; col++) {
            if (esValido(fila, col)) {
                tablero[fila] = col; // Colocamos la reina
                if (resolver(fila + 1)) {
                    return true; // Si logramos resolver para la siguiente fila, terminamos
                }
                tablero[fila] = -1; // Backtracking: deshacemos la colocación de la reina
            }
        }

        return false; // Si no se puede colocar una reina, retrocedemos
    }

    // Devuelve el tablero con las posiciones de las reinas
    public int[] getTablero() {
        return tablero;
    }
}
