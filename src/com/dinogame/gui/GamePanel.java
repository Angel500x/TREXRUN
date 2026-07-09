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
import com.dinogame.entities.Obstacle;
import com.dinogame.threads.FloorThread;
import com.dinogame.threads.GameThread;
import com.dinogame.threads.ScoreThread;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.swing.ImageIcon;

public class GamePanel extends JPanel implements KeyListener {
    
    private Dinosaur dino;
    private int puntaje = 0;
    private Obstacle cactus;
    
    private GameThread loghilo;
    private ScoreThread score;
    private boolean juegoTerminado = false;
    
    private FloorThread logicaSuelo; 
    private int sueloX = 0;  
    
    private Image imgDino;
    private Image imgCactus;
    // Constructor del lienzo
    public GamePanel() {
        dino = new Dinosaur(50, 350, imgDino);
        cactus = new Obstacle(850, 350, imgCactus);
        // color del panel 
        setBackground(Color.WHITE);
        
        //Tecla 
        setFocusable(true);
        addKeyListener(this);
        
        // CARGAR IMÁGENES DESDE LA CARPETA RESOURCES
            try {
             imgDino = new ImageIcon(getClass().getResource("/resources/images/dino")).getImage();
              imgCactus = new ImageIcon(getClass().getResource("/resources/images/catus.png")).getImage();
         } catch (Exception e) {
               System.out.println("Error al cargar imágenes, se usarán rectángulos de respaldo: " + e.getMessage());
         }

            // PASAR LAS IMÁGENES A LAS ENTIDADES
            // Modificamos el nacimiento del Dino y Cactus para enviarles la imagen correspondiente
            dino = new Dinosaur(50, 350, imgDino);
            cactus = new Obstacle(850, 350, imgCactus);
        
        //implemetamos el hilo del dino para saltar
        loghilo = new GameThread(this);
        score = new ScoreThread(this);
        logicaSuelo = new FloorThread(this);
        
        Thread hilop = new Thread(loghilo);
        Thread hilop2 = new Thread(score);
        Thread suelo = new Thread(logicaSuelo);
        
        hilop.start();
        hilop2.start();
        suelo.start();
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
          cactus.dibujar(g);
          // CColor de la letras del puntaje
            g.setColor(Color.BLACK);
            // fuente de la letra
            g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
            //dibujamos el texto del puntaje
            g.drawString("SCORE: " + puntaje, 650, 40);
            
            if (juegoTerminado) {
            g.setColor(Color.RED);
            g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 40));
            g.drawString("GAME OVER", 280, 200);
            }
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
        if (juegoTerminado) return;
        dino.actualizar();
         cactus.actualizar();
         
         if(cactus.getX() < -30){
             cactus = new Obstacle(850, 350, imgCactus);
         }
         
         if (dino.getBounds().intersects(cactus.getBounds())){
             juegoTerminado = true;
             loghilo.detener();
             score.detener();
         }
         
         if (dino.getBounds().intersects(cactus.getBounds())) {
                juegoTerminado = true;
                if(loghilo != null){
                loghilo.detener();
                }
                if (score != null) {
                score.detener();
                }
                if(logicaSuelo != null){
                logicaSuelo.detener();
                }
        }
    }
    
    public void incrementarPuntaje(){
        this.puntaje++;
    }
    
    public void actualizarSuelo() {
    if (juegoTerminado) return; // Si perdiste, el suelo se detiene
    
    // Movemos el suelo hacia la izquierda
    sueloX -= 5; 
   
    if (sueloX <= -40) {
        sueloX = 0;
    }
}
}