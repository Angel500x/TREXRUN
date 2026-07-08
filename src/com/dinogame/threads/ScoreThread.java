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
public class ScoreThread implements Runnable {
    private GamePanel panel;
    private boolean enEjecucion;

    public ScoreThread(GamePanel panel) {
        this.panel = panel;
        this.enEjecucion = true;
    }

    @Override
    public void run() {
        while (enEjecucion) {
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            panel.incrementarPuntaje();
        }
    }

    public void detener() {
        this.enEjecucion = false;
    }
}
