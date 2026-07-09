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

public class FloorThread implements Runnable{
    private GamePanel panel;
    private boolean enEjecucion;

    public FloorThread(GamePanel panel) {
        this.panel = panel;
        this.enEjecucion = true;
    }

    @Override
    public void run() {
        while (enEjecucion) {
            
            try {
                Thread.sleep(20); 
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            panel.actualizarSuelo();
        }
    }

    public void detener() {
        this.enEjecucion = false;
    }
}
