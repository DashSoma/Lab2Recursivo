package Piezas;

/**
 *
 * @author DaniTini
 */
public class Caballo {

    private int[][] tablero;
    private int[] moviX = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] moviY = {1, 2, 2, 1, -1, -2, -2, -1};
    private int N = 8;
    private int contadorIntentos = 0;  // Contador de intentos

    public Caballo(int[][] tablero) {
        this.tablero = tablero;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                this.tablero[i][j] = -1;
            }
        }
    }

    public boolean recorridoCaballo(int x, int y, int moviContador) {

        if (moviContador == N * N) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            int nextX = x + moviX[i];
            int nextY = y + moviY[i];

            if (esMovimientoValido(nextX, nextY)) {
                tablero[nextX][nextY] = moviContador;
                contadorIntentos++;

                if (recorridoCaballo(nextX, nextY, moviContador + 1)) {
                    return true;
                } else {
                    tablero[nextX][nextY] = -1;
                }
            }
        }
        return false;
    }

    private boolean esMovimientoValido(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && tablero[x][y] == -1);
    }

    public int[][] getTablero() {
        return tablero;
    }

    public int getContadorIntentos() {
        return contadorIntentos;
    }

    public void setIniticial(int x, int y) {
        tablero[x][y] = 0;
    }
}
