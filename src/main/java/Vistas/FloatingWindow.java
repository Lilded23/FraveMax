/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

/**
 *
 * @author jdbar
 */
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FloatingWindow extends JFrame {

    private int lastX, lastY;

    public FloatingWindow() {

//        setUndecorated(true); // Quitar bordes y decoración
        setSize(800, 500);
        setLocationRelativeTo(null); // Inicialmente, centrar en la pantalla

        // Agregar un MouseAdapter para permitir el arrastre
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastX = e.getXOnScreen();
                lastY = e.getYOnScreen();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = getLocation().x + (e.getXOnScreen() - lastX);
                int y = getLocation().y + (e.getYOnScreen() - lastY);
                setLocation(x, y);
                lastX = e.getXOnScreen();
                lastY = e.getYOnScreen();
            }
        });
    }
}
