/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package VistasDetallesVenta;

import Entidades.*;
import Conexion.*;
import Vistas.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author cisco
 */
public final class RealizarVentaView extends javax.swing.JPanel {

    List<Producto> listaProd = new ArrayList();
    private double total = 0;
    private Venta venta;

    private DefaultTableModel modeloProd = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    private DefaultTableModel modeloDetalle = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    /**
     * Creates new form Ventas
     */
    public RealizarVentaView() {
        initComponents();
    }

    public RealizarVentaView(Cliente cliente) {
        initComponents();
        this.venta = new Venta(cliente);
        VentaData.guardarVenta(venta);
        datosCliente();
        agregarCabeceras();
        cargarListaProd();
        jsCantidad.setValue(1);
    }

    private void datosCliente() {
        DatosCliente.setText(venta.getCliente().getNombre() + " "
                + venta.getCliente().getApellido() + ". DNI: " + venta.getCliente().getDni());
    }

    private void agregarCabeceras() {
        //Cabeceras de Productos
        modeloProd.addColumn("ID");
        modeloProd.addColumn("Nombre");
        modeloProd.addColumn("Descripcion");
        modeloProd.addColumn("Precio");
        modeloProd.addColumn("Stock");
        jtTablaProd.setModel(modeloProd);
        //Cabeceras de Detalles de Compra
        modeloDetalle.addColumn("ID");
        modeloDetalle.addColumn("Producto");
        modeloDetalle.addColumn("Descripcion");
        modeloDetalle.addColumn("Cantidad");
        modeloDetalle.addColumn("Precio");
        jtTablaDetalles.setModel(modeloDetalle);
        ajustarCabeceras();
    }

    private void borrarfilasProd() {
        int f = jtTablaProd.getRowCount() - 1;

        for (int i = f; i >= 0; i--) {
            modeloProd.removeRow(i);
        }
    }

    private void ajustarCabeceras() {
        //Cabeceras de Productos
        TableColumnModel columnModel = jtTablaProd.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(25);
        columnModel.getColumn(1).setPreferredWidth(75);
        columnModel.getColumn(2).setPreferredWidth(170);
        columnModel.getColumn(3).setPreferredWidth(75);
        columnModel.getColumn(4).setPreferredWidth(50);

        //Cabeceras de Detalles de Compra
        TableColumnModel columnModelDetalles = jtTablaDetalles.getColumnModel();
        columnModelDetalles.getColumn(0).setPreferredWidth(25);
        columnModelDetalles.getColumn(1).setPreferredWidth(75);
        columnModelDetalles.getColumn(2).setPreferredWidth(170);
        columnModelDetalles.getColumn(3).setPreferredWidth(65);
        columnModelDetalles.getColumn(4).setPreferredWidth(75);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpVenta = new javax.swing.JPanel();
        jbFin = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jLabel2 = new javax.swing.JLabel();
        DatosCliente = new javax.swing.JLabel();
        jbVolver = new javax.swing.JButton();
        jpPoductos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtNombreProd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaProd = new javax.swing.JTable();
        jbAgregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jlDescripcion = new javax.swing.JLabel();
        jlProducto = new javax.swing.JLabel();
        jsCantidad = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jpDetalles = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaDetalles = new javax.swing.JTable();
        jbEliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jlTotal = new javax.swing.JLabel();

        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });

        jpVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jbFin.setText("Finalizar venta");
        jbFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinActionPerformed(evt);
            }
        });

        jLabel2.setText("Venta al Cliente:");

        DatosCliente.setText("Nombre y dni cliente");

        jbVolver.setText("Volver");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        jpPoductos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nombre del Producto:");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jtNombreProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreProdActionPerformed(evt);
            }
        });
        jtNombreProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtNombreProdKeyReleased(evt);
            }
        });

        jLabel7.setText("Lista de productos");

        jtTablaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Descripcion", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaProd.setFillsViewportHeight(true);
        jtTablaProd.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jtTablaProdAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jtTablaProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTablaProd);

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jLabel6.setText("Cantidad:");

        jsCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsCantidadStateChanged(evt);
            }
        });

        jLabel4.setText("Producto:");

        jLabel5.setText("Descripcion:");

        javax.swing.GroupLayout jpPoductosLayout = new javax.swing.GroupLayout(jpPoductos);
        jpPoductos.setLayout(jpPoductosLayout);
        jpPoductosLayout.setHorizontalGroup(
            jpPoductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPoductosLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPoductosLayout.createSequentialGroup()
                .addGroup(jpPoductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPoductosLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jpPoductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPoductosLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jsCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                                .addComponent(jbAgregar))
                            .addGroup(jpPoductosLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpPoductosLayout.createSequentialGroup()
                        .addGroup(jpPoductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPoductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jpPoductosLayout.setVerticalGroup(
            jpPoductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPoductosLayout.createSequentialGroup()
                .addGroup(jpPoductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPoductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPoductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPoductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar)
                    .addComponent(jsCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        jpDetalles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Detalles de la Venta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jtTablaDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtTablaDetalles);

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jLabel3.setText("TOTAL :   $");

        jlTotal.setText("0");

        javax.swing.GroupLayout jpDetallesLayout = new javax.swing.GroupLayout(jpDetalles);
        jpDetalles.setLayout(jpDetallesLayout);
        jpDetallesLayout.setHorizontalGroup(
            jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jlTotal)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );
        jpDetallesLayout.setVerticalGroup(
            jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jbEliminar)
                    .addComponent(jlTotal))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpVentaLayout = new javax.swing.GroupLayout(jpVenta);
        jpVenta.setLayout(jpVentaLayout);
        jpVentaLayout.setHorizontalGroup(
            jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVentaLayout.createSequentialGroup()
                .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVentaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpVentaLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(DatosCliente))
                            .addComponent(jbVolver))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jpPoductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbFin)
                    .addComponent(jpDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpVentaLayout.setVerticalGroup(
            jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVentaLayout.createSequentialGroup()
                .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVentaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DatosCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpVentaLayout.createSequentialGroup()
                        .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpVentaLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jpPoductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpVentaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jpDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)))
                .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbFin)
                    .addComponent(jbVolver))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorResized

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        int fila = jtTablaDetalles.getSelectedRow();
        int idProd = (int) jtTablaDetalles.getValueAt(fila, 0);

        String precioString = (String) jtTablaDetalles.getValueAt(fila, 4);
        precioString = precioString.replace("$", "");
        double precio = Double.parseDouble(precioString);

        int cantidad = (int) jtTablaDetalles.getValueAt(fila, 3);
        DetalleVentaData.eliminarDetalleVenta(venta.getIdVenta(), idProd);
        modeloDetalle.removeRow(fila);
        total = total - precio;
        jlTotal.setText(String.valueOf(total));
        Producto prod = ProductoData.buscarPorId(idProd);
        actualizarStock(false, prod, cantidad);
        cargarListaProd();
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jsCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsCantidadStateChanged

    }//GEN-LAST:event_jsCantidadStateChanged

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        btnAgrega();
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void btnAgrega() {
        int cantidad = (int) jsCantidad.getValue();
        Producto productoSeleccionado = buscaProd();
        boolean conStock = actualizarStock(true, productoSeleccionado, cantidad);
        if (productoSeleccionado != null && validarCantidad() && conStock) {
            detalleVenta dv = new detalleVenta(cantidad, venta, productoSeleccionado.getPrecioActual(), productoSeleccionado);
            DetalleVentaData.registrarDetalleVenta(dv);
            total = (total + dv.getCantidad() * productoSeleccionado.getPrecioActual());
            modeloDetalle.addRow(new Object[]{
                dv.getProducto().getIdProducto(),
                dv.getProducto().getNombreProducto(),
                dv.getProducto().getDescripcion(),
                dv.getCantidad(),
                "$ " + dv.getCantidad() * productoSeleccionado.getPrecioActual(),});
            jlTotal.setText(String.valueOf(total));
            cargarListaProd();
            jtNombreProd.setText("");
            jsCantidad.setValue(1);
        }
    }
    private void jbFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinActionPerformed
        if (jtTablaDetalles.getRowCount() == 0) {
            VentaData.eliminarVenta(venta.getIdVenta());
            Principal.mostrarListaClientes();
            JOptionPane.showMessageDialog(this, "Se elimino la venta por falta de productos");
            this.setVisible(false);
            Principal.ClienteSelect = false;
            Principal.mostrarListaClientes();
        } else {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "Confirmacion de la venta",
                    "Confirmación", JOptionPane.OK_CANCEL_OPTION);
            if (respuesta == JOptionPane.OK_OPTION) {
                Principal.anterior = Principal.clientesVistas;
                Principal.cambiar(new DetallesVentaView(venta));
            }
        }
    }//GEN-LAST:event_jbFinActionPerformed

    private void jtNombreProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreProdKeyReleased
        borrarfilasProd();
        String nombreBuscado = jtNombreProd.getText().toLowerCase();
        if (!nombreBuscado.isEmpty()) {
            for (Producto prod : listaProd) {
                if (prod.getNombreProducto().toLowerCase().contains(nombreBuscado) || prod.getDescripcion().toLowerCase().contains(nombreBuscado)) {
                    modeloProd.addRow(new Object[]{
                        prod.getIdProducto(),
                        prod.getNombreProducto(),
                        prod.getDescripcion(),
                        "$ " + prod.getPrecioActual(),
                        prod.getStock(),});
                }
            }
        } else {
            cargarListaProd();
        }
    }//GEN-LAST:event_jtNombreProdKeyReleased

    private void jtNombreProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreProdActionPerformed

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        int res = JOptionPane.showConfirmDialog(
                this,
                "¿Anular venta?",
                "Confirmar",
                JOptionPane.OK_CANCEL_OPTION);
        if (res == 0) {
            if (jtTablaDetalles.getRowCount() == 0) {
                DetalleVentaData.eliminarDetalleVenta(venta.getIdVenta());
                VentaData.eliminarVenta(venta.getIdVenta());
                this.setVisible(false);
                Principal.ClienteSelect = false;
                Principal.mostrarListaClientes();
            } else {
                Producto prod;
                for (int i = 0; i < modeloDetalle.getRowCount(); i++) {
                    int idProducto = (int) modeloDetalle.getValueAt(i, 0);
                    int cantidad = (int) modeloDetalle.getValueAt(i, 3);
                    prod = ProductoData.buscarPorId(idProducto);
                    actualizarStock(false, prod, cantidad);
                }

                VentaData.eliminarVenta(venta.getIdVenta());
                this.setVisible(false);
                Principal.ClienteSelect = false;
                Principal.mostrarListaClientes();
            }
        }
    }//GEN-LAST:event_jbVolverActionPerformed

    private void jtTablaProdAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jtTablaProdAncestorAdded

    }//GEN-LAST:event_jtTablaProdAncestorAdded

    private void jtTablaProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaProdMouseClicked
        if (evt.getClickCount() == 2) {
            btnAgrega();
        } else {
            int fila = jtTablaProd.getSelectedRow();
            String nombre = (String) jtTablaProd.getValueAt(fila, 1);
            String descripcion = (String) jtTablaProd.getValueAt(fila, 2);
            jlProducto.setText(nombre);
            jlDescripcion.setText(descripcion);
        }


    }//GEN-LAST:event_jtTablaProdMouseClicked

    private void listaProductos() {
        if (listaProd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay Productos en el sistema");
        } else {
            listaProd.forEach(producto -> {
                if (producto.isEstado() && producto.getStock() > 0) {
                    modeloProd.addRow(new Object[]{
                        producto.getIdProducto(),
                        producto.getNombreProducto(),
                        producto.getDescripcion(),
                        "$ " + producto.getPrecioActual(),
                        producto.getStock(),});
                }
            });
        }
    }

    private boolean validarCantidad() {
        int valor = (int) jsCantidad.getValue();
        if (valor > 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Cantidad no puede ser 0 (CERO)",
                    "Error en Cantidad de producto", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private Producto buscaProd() {
        int fila = jtTablaProd.getSelectedRow();
        if (fila >= 0) {
            int idProd = (int) jtTablaProd.getValueAt(fila, 0);
            for (Producto producto : listaProd) {
                if (producto.getIdProducto() == idProd) {
                    return producto;
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto",
                    "Error en producto", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return null;
    }

    private boolean actualizarStock(boolean compra, Producto prod, int cantidad) {
        int stock = prod.getStock();
        int idProd = prod.getIdProducto();
        if (compra) {
            if (stock >= cantidad) {
                stock = stock - cantidad;
                ProductoData.ActualizarStock(stock, idProd);
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "No hay suficiente stock para realizar la compra.",
                        "Stock insuficiente", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            stock = stock + cantidad;
            ProductoData.ActualizarStock(stock, idProd);
            return true;
        }

    }

    private void cargarListaProd() {
        listaProd = ProductoData.listaProducto();
        borrarfilasProd();
        listaProductos();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DatosCliente;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbFin;
    private javax.swing.JButton jbVolver;
    private javax.swing.JLabel jlDescripcion;
    private javax.swing.JLabel jlProducto;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JPanel jpDetalles;
    private javax.swing.JPanel jpPoductos;
    private javax.swing.JPanel jpVenta;
    private javax.swing.JSpinner jsCantidad;
    private javax.swing.JTextField jtNombreProd;
    private javax.swing.JTable jtTablaDetalles;
    private javax.swing.JTable jtTablaProd;
    // End of variables declaration//GEN-END:variables
}
