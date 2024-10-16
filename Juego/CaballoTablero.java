package Juego;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author crisp
 */
public class CaballoTablero extends JPanel {

    private int[][] tablero;
    private final int tamCasilla = 60; // Tamaño de cada casilla en píxeles

    public CaballoTablero(int[][] tablero) {
        this.tablero = tablero;
        setPreferredSize(new Dimension(8 * tamCasilla, 8 * tamCasilla));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar el tablero de ajedrez
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j * tamCasilla, i * tamCasilla, tamCasilla, tamCasilla);

                // Dibujar el número del movimiento en la casilla
                if (tablero[i][j] != -1) {
                    g.setColor(Color.BLUE);
                    g.drawString(String.valueOf(tablero[i][j]),
                            j * tamCasilla + tamCasilla / 2 - 5,
                            i * tamCasilla + tamCasilla / 2 + 5);
                }
            }
        }
    }

    public void actualizarTablero(int[][] nuevoTablero) {
        this.tablero = nuevoTablero;
        repaint();
    }

}
