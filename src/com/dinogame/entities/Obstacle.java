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
import java.awt.Image;
public class Obstacle {
    private int x, y, ancho, alto;
    private int velocidad = 7; 
    
    private Image imagen;

    // Constructor del Obstáculo
    public Obstacle(int x, int y, Image imagen) {
        this.x = x;
        this.y = y;
        this.ancho = 45; // más delgado que el dino
        this.alto = 50;  // Altura del cactus
        this.imagen = imagen;
    }
        //dibujo del cactus
    public void dibujar(Graphics g) {
        /*
        // color del cactus
        g.setColor(Color.RED);
        g.fillRect(this.x, this.y, this.ancho, this.alto);
        */
        if (imagen != null) {
            g.drawImage(imagen, this.x, this.y, this.ancho, this.alto, null);
        } else {
            g.setColor(Color.RED);
            g.fillRect(this.x, this.y, this.ancho, this.alto);
        }
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
    
    public java.awt.Rectangle getBounds(){
        return new java.awt.Rectangle(this.x, this.y, this.ancho, this.ancho);
    }
}
