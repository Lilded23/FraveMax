/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

/**
 *
 * @author jdbar
 */
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class FloatingWindow extends JFrame {

    private int lastX, lastY;

    public FloatingWindow() {

        setUndecorated(true); // Quitar bordes y decoración
        setSize(800, 450);
        setLocationRelativeTo(null); // Inicialmente, centrar en la pantalla

        Color borderColor = new Color(66, 73, 73); //Color del borde
        int borderWidth = 2; // Ancho del borde en pixeles
        LineBorder lineBorder = new LineBorder(borderColor, borderWidth);
        getRootPane().setBorder(lineBorder); //Llamo al panel principal y seteo el borde

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

    public FloatingWindow(String title) throws HeadlessException {
        super(title);
    }
}
