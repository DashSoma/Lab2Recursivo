package Juego;

import javax.swing.*;
import java.awt.*;

public class TableroReina extends JPanel {

    private final int[] tablero; // Posiciones de las reinas
    private final int n; // Tamaño del tablero
    private int filaActual = 0; // Fila hasta la cual se han colocado las reinas

    public TableroReina(int[] tablero) {
        this.n = tablero.length;
        this.tablero = tablero;
    }

    public void setFilaActual(int filaActual) {
        this.filaActual = filaActual; // Actualizar la fila que se está mostrando
    }
    ImageIcon imagenCaballoIcon = new ImageIcon(getClass().getResource("/Iconos/Reina.png"));
    Image imagenCaballo = imagenCaballoIcon.getImage();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = Math.min(getWidth(), getHeight()) / n;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // Dibujar el tablero
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);

                // Dibujar las reinas hasta la fila actual
                if (row < filaActual && tablero[row] == col) {
                    g.drawImage(imagenCaballo, col * cellSize, row * cellSize, cellSize, cellSize, this);
                }
            }
        }
    }
}
