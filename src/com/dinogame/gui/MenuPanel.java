/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dinogame.gui;

/**
 *
 * @author angel
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MenuPanel extends JPanel {
    private Image fondo;
    private GameWindow ventana;

    public MenuPanel(GameWindow ventana, int record) {
        this.ventana = ventana;
        setLayout(null);

        try {
            fondo = new ImageIcon(getClass().getResource("/resources/images/fondo_run.jpeg")).getImage();
        } catch (Exception e) {
            System.out.println("No se encontró el fondo del menú.");
        }

        //BOTÓN DE INICIAR
        JButton btnIniciar = new JButton("INICIAR JUEGO");
        btnIniciar.setBounds(300, 250, 200, 50); // Posición y tamaño
        btnIniciar.setBackground(new Color(0, 255, 54)); // El verde del Dino
        btnIniciar.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 18));
        
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.iniciarJuego(); // Le avisamos a la ventana que cambie al juego
            }
        });
        
        add(btnIniciar);

        //RÉCORD
        JLabel lblRecord = new JLabel("MÁXIMO RÉCORD: " + record);
        lblRecord.setBounds(300, 150, 300, 40);
        lblRecord.setForeground(Color.WHITE);
        lblRecord.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblRecord);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujamos el fondo
        if (fondo != null) {
            g.drawImage(fondo, 0, 0, 800, 800, this);
        } else {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 400, 800, 400);
        }
    }
}
