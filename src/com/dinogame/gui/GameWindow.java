/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dinogame.gui;

/**
 *
 * @author angel
 */
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class GameWindow extends JFrame{
    
    private CardLayout cardLayout;
    private JPanel mainPanel; 
    private int recordPuntaje = 0; 
    

    // Constructor de la clase
    public GameWindow() {
        //titulo
        setTitle("T - REX RUN");
        //tamanio de nuestra ventana
        setSize(800,800);
        //ventana cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         // 2. CONFIGURAR EL CARDLAYOUT
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        add(mainPanel);
        //ventana centrada
        setLocationRelativeTo(null);
        //ventana sin hacerce relativo
        setResizable(false);
        
        /*
         //crearemos lienzo
        GamePanel panel = new GamePanel();
        add(panel);*/
    }  
    
    public void mostrarMenu() {
        MenuPanel menu = new MenuPanel(this, recordPuntaje);
        mainPanel.add(menu, "MENU");
        cardLayout.show(mainPanel, "MENU");
    }
    
    public void iniciarJuego() {
        GamePanel juego = new GamePanel(this);
        mainPanel.add(juego, "JUEGO");
        cardLayout.show(mainPanel, "JUEGO");
        juego.requestFocusInWindow(); 
    }

    public void actualizarRecord(int nuevoPuntaje) {
        if (nuevoPuntaje > recordPuntaje) {
            recordPuntaje = nuevoPuntaje;
        }
        
    }
}
