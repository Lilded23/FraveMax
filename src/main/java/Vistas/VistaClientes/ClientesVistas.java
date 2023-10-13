/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas.VistaClientes;

import Conexion.ClienteData;
import Entidades.Cliente;
import Vistas.FloatingWindow;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jdbar
 */
public class ClientesVistas extends javax.swing.JPanel {

    static DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    /**
     * Creates new form ClientesVistas
     */
    public ClientesVistas() {
        initComponents();
        borrarfilasProd();
        cargarTabla();
        cargarDatosClientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JTBuscarCliente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTClientes = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(701, 477));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Buscar");

        JTBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTBuscarClienteActionPerformed(evt);
            }
        });
        JTBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTBuscarClienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTBuscarClienteKeyReleased(evt);
            }
        });

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        JTClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° de Cliente", "Nombre", "Apellido", "D.N.I", "Domicilio", "Telefono"
            }
        ));
        JTClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(JTBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(JTBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectRow = JTClientes.getSelectedRow();
        int selectColumn = 0;
        int idCliente = -1;

        if (selectColumn >= 0 && selectRow >= 0) {
            
            idCliente = Integer.parseInt(JTClientes.getValueAt(selectRow, selectColumn).toString());
            
            System.out.println(idCliente);
            
           // Cliente cliente = ClienteData.BuscarClienteDNI(idCliente);

            int confDelete = JOptionPane.showConfirmDialog(null, "Seguro que desea Eleminar" );

            if (confDelete == JOptionPane.YES_OPTION) {
                System.out.println(idCliente);
                ClienteData.borrarCliente(idCliente);
                borrarfilasProd();
                cargarDatosClientes();
            }
        } else {
            System.out.println("Error al eliminar al Cliente Seleccionado ");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void JTBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTBuscarClienteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(() -> {
            FloatingWindow floatingWindow = new FloatingWindow();
            NuevoClente cliente = new NuevoClente(floatingWindow);
            floatingWindow.add(cliente);
            floatingWindow.repaint();
            floatingWindow.setVisible(true);
        });
    }//GEN-LAST:event_jButton2ActionPerformed

    private void JTBuscarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTBuscarClienteKeyPressed
        // TODO add your handling code here:    

    }//GEN-LAST:event_JTBuscarClienteKeyPressed

    private void JTBuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTBuscarClienteKeyReleased
        // TODO add your handling code here:
        borrarfilasProd();
        try {
            int buscar = Integer.parseInt(JTBuscarCliente.getText());
            ClienteData.listaClientePorDNI(buscar).forEach(action -> {
                modelo.addRow(new Object[]{action.getIdCliente(), action.getNombre(), action.getApellido(), action.getDni(), action.getDomiciio(), action.getTelefono()});
            });
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            ClienteData.listaCliente().forEach(action -> {
                modelo.addRow(new Object[]{action.getIdCliente(), action.getNombre(), action.getApellido(), action.getDni(), action.getDomiciio(), action.getTelefono()});
            });
        }


    }//GEN-LAST:event_JTBuscarClienteKeyReleased

    private void JTClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTClientesMouseClicked
        // TODO add your handling code here:
        int id = (int) JTClientes.getValueAt(JTClientes.getSelectedRow(), 0);
        String nombre = JTClientes.getValueAt(JTClientes.getSelectedRow(), 1).toString();
        String apellido = JTClientes.getValueAt(JTClientes.getSelectedRow(), 2).toString();
        String domicilio = JTClientes.getValueAt(JTClientes.getSelectedRow(), 4).toString();
        int dni = (int) JTClientes.getValueAt(JTClientes.getSelectedRow(), 3);
        String telefono = JTClientes.getValueAt(JTClientes.getSelectedRow(), 5).toString();

        Cliente cliente = new Cliente(id, apellido, nombre, domicilio, telefono, dni);
        if (evt.getClickCount() >= 2) {
            System.out.println(nombre + " " + apellido + " " + " " + domicilio + " " + dni + " " + telefono);
            SwingUtilities.invokeLater(() -> {

                FloatingWindow modificar = new FloatingWindow();
                NuevoClente modCliente = new NuevoClente(modificar);
                modCliente.Datos(cliente);
                modificar.add(modCliente);
                modificar.repaint();
                modificar.setVisible(true);
            });
        }
    }//GEN-LAST:event_JTClientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTBuscarCliente;
    private javax.swing.JTable JTClientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    private void cargarTabla() {

        modelo.addColumn("N° De Cliente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("D.N.I");
        modelo.addColumn("Domicilio");
        modelo.addColumn("Telefono");

        JTClientes.setModel(modelo);

    }

    public static void cargarDatosClientes() {
        borrarfilasProd();
        ClienteData.listaCliente().forEach(action -> {
            modelo.addRow(new Object[]{action.getIdCliente(), action.getNombre(), action.getApellido(), action.getDni(), action.getDomiciio(), action.getTelefono()});
        });

    }

    public static void borrarfilasProd() {
        int f = modelo.getRowCount() - 1;

        for (int i = f; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

}
