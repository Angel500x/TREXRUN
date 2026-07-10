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
import java.awt.Image;
import java.awt.Rectangle;
public class Pterodactyl {
    private int x, y, ancho, alto;
    private int velocidad = 8;
    private Image imagen;

    public Pterodactyl(int x, int tipoAltura, Image imagen) {
        this.x = x;
        this.ancho = 55;
        this.alto = 45;
        this.imagen = imagen;
        // Decidimos la altura 
        if (tipoAltura == 1) {
            this.y = 220; 
        } else {
            this.y = 340; 
        }
    }

    public void actualizar() {
        this.x -= velocidad;
    }

    public void dibujar(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, this.x, this.y, this.ancho, this.alto, null);
        }
    }

    public int getX() { return x; }
    
    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.ancho, this.alto);
    }
}
