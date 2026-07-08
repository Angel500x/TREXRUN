/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dinogame.gui;

/**
 *
 * @author angel
 */
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import com.dinogame.entities.Dinosaur;
import com.dinogame.threads.GameThread;
import com.dinogame.threads.ScoreThread;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements KeyListener {
    
    private Dinosaur dino;
    private int puntaje = 0;
    // Constructor del lienzo
    public GamePanel() {
        dino = new Dinosaur(50, 350);
        // color del panel 
        setBackground(Color.WHITE);
        
        //Tecla 
        setFocusable(true);
        addKeyListener(this);
        
        //implemetamos el hilo del dino para saltar
        GameThread loghilo = new GameThread(this);
        Thread hilop = new Thread(loghilo);
        hilop.start();
        
        ScoreThread score = new ScoreThread(this);
        Thread hilop2 = new Thread(score);
        hilop2.start();
         }

    // creamos un metodo del pintado del lienzo para verificar 
    @Override
    protected void paintComponent(Graphics g) {
        //limpiamos pantalla
        super.paintComponent(g);
        
        // color linea azul piso 
          g.setColor(Color.blue);
          //la dibujamos de 0 a 800 en x, y de y 400
          g.drawLine(0, 400, 800, 400);

        // color del donde esta nuestro dino
          g.setColor(Color.green);
          //dibujamos un rectangulo del dino cerca del piso
          //50 en x y 350 en y -> 40 y 50 de ancho y alto de dino
          dino.dibujar(g);
          
          // CColor de la letras del puntaje
            g.setColor(Color.BLACK);
            // fuente de la letra
            g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
            //dibujamos el texto del puntaje
            g.drawString("SCORE: " + puntaje, 650, 40);
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
     
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_SPACE || ke.getKeyCode() == KeyEvent.VK_UP){
            System.out.println("Verificar saltar");
            dino.saltando();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    
    }
    // metodo actulizar ser usado en el hilo
    public void actualizarJuego(){
        dino.actualizar();
    }
    
    public void incrementarPuntaje(){
        this.puntaje++;
    }
}