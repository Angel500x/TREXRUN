/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dinogame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
/**
 *
 * @author angel
 */
public class Dinosaur {
    //atributos
    private int x, y, ancho, alto;
    private int velY;
    private boolean saltar;
    
    //contantes para el salto del dino
    private final int GRAVEDAD = 1;
    private final int FUERZA_SALTO = -15;
    private final int SUELO_Y = 350;
    
    private Image imagen;
    
    //contructor
    public Dinosaur(int x, int y, Image imagen){
        this.x = x;
        this.y = y;
        this.ancho = 40;
        this.alto = 50;
        this.velY = 0;
        this.saltar = false;
        this.imagen = imagen;
    }
    
    //metodo para dibujar
    public void dibujar(Graphics g){
        /*
        g.setColor(Color.BLACK);
        g.fillRect(this.x, this.y, this.ancho, this.alto);
        */
        if (imagen != null) {
            // Si la imagen cargó con éxito, la dibujamos en sus coordenadas y tamaño
            g.drawImage(imagen, this.x, this.y, this.ancho, this.alto, null);
        } else {
            // Respaldo en caso de que la imagen falle (así el juego no se rompe)
            g.setColor(Color.BLACK);
            g.fillRect(this.x, this.y, this.ancho, this.alto);
        }
    }
    
    //metodo iniciar a saltar
    public void saltando(){
        if(!saltar){
            velY = FUERZA_SALTO;
            saltar = true;
        }
    }
    
    //metodo para logica de mover y saltar del frame
    public void actualizar(){
        if (saltar){
            y += velY;
            velY += GRAVEDAD;
            if(y >= SUELO_Y){
                y = SUELO_Y;
                velY = 0;
                saltar = false;
            }
        }
    }
        public java.awt.Rectangle getBounds(){
            return new java.awt.Rectangle(this.x, this.y, this.ancho, this.alto);
        }
    }