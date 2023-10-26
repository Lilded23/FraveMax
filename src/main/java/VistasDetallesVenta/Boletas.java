/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package VistasDetallesVenta;

import Entidades.*;
import Conexion.*;
import Vistas.Principal;
import static Vistas.Principal.cambiar;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cisco
 */
public class Boletas extends javax.swing.JPanel {

    /**
     * Creates new form Ventas
     */
    LocalDate today;

    public Boletas() {
        initComponents();
        today = LocalDate.now();
        campoFechaA.setText(today.withDayOfMonth(1).toString());
        campoFechaB.setText(today.toString());
        configurarComboBox();
    }

    private void configurarTabla() {
        try {
            var modeloTabla = new DefaultTableModel(
                    new String[]{"idVenta", "fecha"}, 0
            );
            var fecha = Date.valueOf(campoFechaA.getText()).toLocalDate();
            var fechaB = Date.valueOf(campoFechaB.getText()).toLocalDate();
            var cliente = (Cliente) clientesComboBox.getSelectedItem();
            var lista = cliente != null
                    ? VentaData.buscarVentas(cliente, fecha, fechaB)
                    : VentaData.buscarVentas(fecha, fechaB);

            Collections.reverse(lista);
            lista.forEach((Venta venta) -> {
                var fulano = venta.getCliente();
                Object[] rowData = {
                    venta.getIdVenta(),
                    venta.getFechaVenta().toString()
                };
                modeloTabla.addRow(rowData);
            });
            tablaVentas.setModel(modeloTabla);
            tablaVentas.setDefaultEditor(Object.class, null);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void configurarComboBox() {
        try {
            var param = campoDNI.getText().toLowerCase();
            var key = param.replaceAll("[\\d]", "");
            var val = param.replaceAll("[\\D]", "");
            var listaClientes = ClienteData.listaCliente();
            var modeloClientesCB = new DefaultComboBoxModel<Cliente>();
            modeloClientesCB.addAll(listaClientes);

            clientesComboBox.setModel(modeloClientesCB);

            for (Cliente cliente : listaClientes) {
                String idCliente = String.valueOf(cliente.getIdCliente());
                if ("id#".equals(key)) {
                    if (idCliente.startsWith(val)) {
                        clientesComboBox.getModel().setSelectedItem(cliente);
                        break;
                    }
                } else if (param.isBlank()) {
                    clientesComboBox.setSelectedItem(null);
                    break;
                } else {
                    String dniCliente = String.valueOf(cliente.getDni());
                    if (dniCliente.startsWith(val)) {
                        clientesComboBox.getModel().setSelectedItem(cliente);
                        break;
                    }
                }
            }

            configurarTabla();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dniLabel = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        campoFechaA = new javax.swing.JTextField();
        fechaLabel2 = new javax.swing.JLabel();
        campoFechaB = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        clientesComboBox = new javax.swing.JComboBox<Cliente>();
        campoDNI = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        proTip = new javax.swing.JLabel();
        botonDetalles = new javax.swing.JButton();

        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });

        dniLabel.setText("Buscar DNI");

        fechaLabel.setText("Fecha ");

        campoFechaA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoFechaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoFechaAActionPerformed(evt);
            }
        });

        fechaLabel2.setText("hasta");

        campoFechaB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoFechaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoFechaBActionPerformed(evt);
            }
        });

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "idVenta", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVentas.setFillsViewportHeight(true);
        tablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVentas);
        tablaVentas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        clientesComboBox.setModel(new javax.swing.DefaultComboBoxModel<Cliente>());
        clientesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesComboBoxActionPerformed(evt);
            }
        });

        campoDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDNIActionPerformed(evt);
            }
        });

        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lupa-20.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        proTip.setText("Formato de fecha: yyyy-mm-dd");
        proTip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proTipMouseClicked(evt);
            }
        });

        botonDetalles.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        botonDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons-detalle.png"))); // NOI18N
        botonDetalles.setText("Detalles");
        botonDetalles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDetallesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dniLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                            .addComponent(clientesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addComponent(fechaLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoFechaA, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoFechaB, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                            .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(proTip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonDetalles)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoFechaB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fechaLabel2)
                        .addComponent(campoFechaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fechaLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dniLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proTip)
                    .addComponent(botonDetalles))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoFechaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoFechaAActionPerformed
        configurarTabla();
    }//GEN-LAST:event_campoFechaAActionPerformed

    private void campoDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDNIActionPerformed
        // TODO add your handling code here:
        configurarComboBox();
    }//GEN-LAST:event_campoDNIActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        configurarTabla();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void clientesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesComboBoxActionPerformed
        // TODO add your handling code here:
        configurarTabla();
    }//GEN-LAST:event_clientesComboBoxActionPerformed

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorResized

    private void botonDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDetallesActionPerformed
        // TODO add your handling code here:
        actionDetalle();
    }//GEN-LAST:event_botonDetallesActionPerformed
    private void actionDetalle() {
        var idVenta = (Integer) tablaVentas.getValueAt(
                tablaVentas.getSelectedRow(),
                0);
        var ventaSeleccionada = VentaData.buscarVenta(idVenta);

        Principal.cambiar(new DetallesVentaView(ventaSeleccionada));
    }

    private void proTipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proTipMouseClicked

        if (evt.getClickCount() == 8) {
            Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        int y = proTip.getY();
                        while (proTip.getX() < 420) {
                            Thread.sleep((long) 8);
                            proTip.setLocation(proTip.getX() + 1, y);
                            repaint();
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Boletas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });
            th.start();
        }

    }//GEN-LAST:event_proTipMouseClicked

    private void tablaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentasMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            actionDetalle();
        }
    }//GEN-LAST:event_tablaVentasMouseClicked

    private void campoFechaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoFechaBActionPerformed
        configurarTabla();
    }//GEN-LAST:event_campoFechaBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonDetalles;
    private javax.swing.JTextField campoDNI;
    private javax.swing.JTextField campoFechaA;
    private javax.swing.JTextField campoFechaB;
    private javax.swing.JComboBox<Cliente> clientesComboBox;
    private javax.swing.JLabel dniLabel;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JLabel fechaLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel proTip;
    private javax.swing.JTable tablaVentas;
    // End of variables declaration//GEN-END:variables
}
