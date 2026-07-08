/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dinogame.entities;

/**
 *
 * @author angel
 */
import java.awt.Graphics;
import java.awt.Color;
public class Obstacle {
    private int x, y, ancho, alto;
    private int velocidad = 7; 

    // Constructor del Obstáculo
    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
        this.ancho = 25; // más delgado que el dino
        this.alto = 45;  // Altura del cactus
    }
        //dibujo del cactus
    public void dibujar(Graphics g) {
        // color del cactus
        g.setColor(Color.RED);
        g.fillRect(this.x, this.y, this.ancho, this.alto);
    }

    // movimiento
    public void actualizar() {
        // movimiento a la izquierda
        this.x -= velocidad;
    }

    // metodos para calcular colisiones
    public int getX() { return x; }
    public int getY() { return y; }
    public int getAncho() { return ancho; }
    public int getAlto() { return alto; }
}
