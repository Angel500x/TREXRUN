/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dinogame.gui;

/**
 *
 * @author angel
 */
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class GameWindow extends JFrame{

    // Constructor de la clase
    public GameWindow() {
        //titulo
        setTitle("T - REX RUN");
        //tamanio de nuestra ventana
        setSize(800,800);
        //ventana cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ventana centrada
        setLocationRelativeTo(null);
        //ventana sin hacerce relativo
        setResizable(false);
        
         //crearemos lienzo
        GamePanel panel = new GamePanel();
        add(panel);
    }  
       
}
