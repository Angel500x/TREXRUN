/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dinogame.threads;

/**
 *
 * @author angel
 */
import com.dinogame.gui.GamePanel;
public class GameThread implements Runnable{
    private GamePanel panel;
    private boolean enEjecucion;

    // El constructor con el panel
    public GameThread(GamePanel panel) {
        this.panel = panel;
        this.enEjecucion = true;
    }

    //MÉTODO correr
    @Override
    public void run() {
        // Mientras el juego esté en ejecución...
        while (enEjecucion) {
            //movimiento
            panel.actualizarJuego();
            
            // pintar y volver pintar
            panel.repaint();
            
            try {
                Thread.sleep(16); // 16 ms * 60 vueltas ≈ 1000 ms (1 segundo)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Método detener juego
    public void detener() {
        this.enEjecucion = false;
    }
}
