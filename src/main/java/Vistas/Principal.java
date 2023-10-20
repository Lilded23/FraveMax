/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import VistasDetallesVenta.Boletas;
import Entidades.*;

import Vistas.VistaClientes.ClientesVistas;
import VistasDetallesVenta.DetallesVentaView;
import VistasDetallesVenta.RealizarVentaView;
import VistasProducto.Buscar;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Color;
import java.awt.Component;

/**
 *
 * @author cisco
 */
public class Principal extends javax.swing.JFrame {

    Color color1 = new Color(0, 122, 255);
    Color backgraoundOriginal = new Color(30, 30, 30);
    public static boolean ClienteSelect = false;
    private boolean ProductosSelect = false;
    private boolean VentaSelect = false;
    public static Component anterior;
    static String vistaActual;

    public static ClientesVistas clientesVistas;
    public static Boletas vistaVentas;
    private static Buscar buscar;

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
//        vistaVentas = new Ventas();
//        mostrarVentas();
        clientesVistas = new ClientesVistas();
        vistaVentas = new Boletas();
        buscar = new Buscar();
        mostrarListaClientes();
    }

    public static void cambiar(Component vista) {
        anterior = tablero.getComponent(0);
        anterior.setVisible(false);
        tablero.removeAll();
        vista.setVisible(true);
        tablero.add(vista);
        tablero.revalidate();
        tablero.repaint();
    }

    public static void mostrarBoletas() {
        tablero.removeAll();
        vistaVentas.setVisible(true);
        tablero.add(new Boletas());
        tablero.revalidate();
        tablero.repaint();
    }

    public static void mostrarBoletas(Cliente cliente) {
        tablero.removeAll();
        tablero.add(new Boletas(cliente));
        tablero.revalidate();
        tablero.repaint();
    }

    public static void mostrarRealizarVenta(Cliente cliente) {
        tablero.removeAll();
        tablero.add(new RealizarVentaView(cliente));
        tablero.revalidate();
        tablero.repaint();
    }

    public static void mostrarListaClientes() {
        if (!ClienteSelect) {

            tablero.removeAll();
            tablero.add(clientesVistas);
            tablero.revalidate();
            tablero.repaint();
        }

    }

    private static void mostrarListaProductos() {
        tablero.removeAll();
        tablero.add(buscar);
        tablero.revalidate();
        tablero.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLCliente = new javax.swing.JLabel();
        JLProductos = new javax.swing.JLabel();
        JLVentas = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 1), new java.awt.Dimension(0, 1), new java.awt.Dimension(32767, 1));
        tablero = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FraveMax");
        setMinimumSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FraveMax");

        JLCliente.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        JLCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLCliente.setText("Clientes");
        JLCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLCliente.setOpaque(true);
        JLCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLClienteMouseExited(evt);
            }
        });

        JLProductos.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        JLProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLProductos.setText("Productos");
        JLProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLProductos.setOpaque(true);
        JLProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLProductosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLProductosMouseExited(evt);
            }
        });

        JLVentas.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        JLVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLVentas.setText("Ventas");
        JLVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLVentas.setOpaque(true);
        JLVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLVentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLVentasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JLProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JLVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(222, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JLCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(363, Short.MAX_VALUE))
        );

        tablero.setMinimumSize(new java.awt.Dimension(800, 600));
        tablero.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(tablero, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JLVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLVentasMouseClicked
        // TODO add your handling code here:

        mostrarBoletas();
        ClienteSelect = false;
        ProductosSelect = false;
        VentaSelect = true;
    }//GEN-LAST:event_JLVentasMouseClicked

    private void JLClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLClienteMouseClicked
        // TODO add your handling code here:
        mostrarListaClientes();
        ClienteSelect = true;
        ProductosSelect = false;
        VentaSelect = false;
    }//GEN-LAST:event_JLClienteMouseClicked

    private void JLProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLProductosMouseClicked
        // TODO add your handling code here:
        mostrarListaProductos();
        ClienteSelect = false;
        ProductosSelect = true;
        VentaSelect = false;
    }//GEN-LAST:event_JLProductosMouseClicked

    private void JLClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLClienteMouseEntered
        // TODO add your handling code here:
        JLCliente.setBackground(color1);

    }//GEN-LAST:event_JLClienteMouseEntered

    private void JLClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLClienteMouseExited
        // TODO add your handling code here:
        JLCliente.setBackground(color1);
        setColor(
                ClienteSelect,
                ProductosSelect,
                VentaSelect
        );

    }//GEN-LAST:event_JLClienteMouseExited

    private void JLProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLProductosMouseEntered
        // TODO add your handling code here:
        JLProductos.setBackground(color1);
    }//GEN-LAST:event_JLProductosMouseEntered

    private void JLProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLProductosMouseExited
        // TODO add your handling code here:
        JLProductos.setBackground(backgraoundOriginal);
        setColor(ClienteSelect,
                ProductosSelect,
                VentaSelect
        );

    }//GEN-LAST:event_JLProductosMouseExited

    private void JLVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLVentasMouseEntered
        // TODO add your handling code here:
        JLVentas.setBackground(color1);
    }//GEN-LAST:event_JLVentasMouseEntered

    private void JLVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLVentasMouseExited
        // TODO add your handling code here:
        JLVentas.setBackground(backgraoundOriginal);
        setColor(ClienteSelect, ProductosSelect, VentaSelect);

    }//GEN-LAST:event_JLVentasMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }

        //</editor-fold>
        FlatMacDarkLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLCliente;
    private javax.swing.JLabel JLProductos;
    private javax.swing.JLabel JLVentas;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JPanel tablero;
    // End of variables declaration//GEN-END:variables

    private void setColor(boolean ClienteSelect, boolean ProductoSelect, boolean VentasSelect) {

        JLCliente.setBackground(ClienteSelect ? color1 : backgraoundOriginal);
        JLProductos.setBackground(ProductoSelect ? color1 : backgraoundOriginal);
        JLVentas.setBackground(VentasSelect ? color1 : backgraoundOriginal);
    }
}
