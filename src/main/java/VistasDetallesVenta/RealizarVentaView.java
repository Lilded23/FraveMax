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
 * @author Victor Angel
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

 /**
 * Actualiza la etiqueta de datos del cliente con la información del cliente
 * asociado a la venta.
 */
private void datosCliente() {
    DatosCliente.setText(venta.getCliente().getNombre() + " "
            + venta.getCliente().getApellido() + ". DNI: " + venta.getCliente().getDni());
}

/**
 * Agrega las cabeceras a las tablas de productos y detalles de compra.
 * Configura las columnas de las tablas.
 */
private void agregarCabeceras() {
    // Cabeceras de Productos
    modeloProd.addColumn("ID");
    modeloProd.addColumn("Nombre");
    modeloProd.addColumn("Descripción");
    modeloProd.addColumn("Precio");
    modeloProd.addColumn("Stock");
    jtTablaProd.setModel(modeloProd);

    // Cabeceras de Detalles de Compra
    modeloDetalle.addColumn("ID");
    modeloDetalle.addColumn("Producto");
    modeloDetalle.addColumn("Descripción");
    modeloDetalle.addColumn("Cantidad");
    modeloDetalle.addColumn("Precio");
    jtTablaDetalles.setModel(modeloDetalle);

    // Ajusta el ancho de las columnas en las tablas
    ajustarCabeceras();
}

/**
 * Elimina todas las filas de la tabla de productos. Este método se utiliza para
 * borrar los resultados anteriores antes de mostrar una nueva lista de productos.
 */
private void borrarfilasProd() {
    int filas = jtTablaProd.getRowCount() - 1;

    for (int i = filas; i >= 0; i--) {
        modeloProd.removeRow(i);
    }
}

/**
 * Ajusta el ancho de las columnas en las tablas de productos y detalles de compra.
 * Esto ayuda a que las columnas se ajusten mejor al contenido y sean más legibles.
 */
private void ajustarCabeceras() {
    // Cabeceras de Productos
    TableColumnModel columnModel = jtTablaProd.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(25);  // ID
    columnModel.getColumn(1).setPreferredWidth(75);  // Nombre
    columnModel.getColumn(2).setPreferredWidth(170); // Descripción
    columnModel.getColumn(3).setPreferredWidth(75);  // Precio
    columnModel.getColumn(4).setPreferredWidth(50);  // Stock

    // Cabeceras de Detalles de Compra
    TableColumnModel columnModelDetalles = jtTablaDetalles.getColumnModel();
    columnModelDetalles.getColumn(0).setPreferredWidth(25);  // ID
    columnModelDetalles.getColumn(1).setPreferredWidth(75);  // Producto
    columnModelDetalles.getColumn(2).setPreferredWidth(170); // Descripción
    columnModelDetalles.getColumn(3).setPreferredWidth(65);  // Cantidad
    columnModelDetalles.getColumn(4).setPreferredWidth(75);  // Precio
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

        jbFin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-carro-rápido-30.png"))); // NOI18N
        jbFin.setText("Finalizar venta");
        jbFin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinActionPerformed(evt);
            }
        });

        jLabel2.setText("Venta al Cliente:");

        DatosCliente.setText("Nombre y dni cliente");

        jbVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atrás-30.png"))); // NOI18N
        jbVolver.setText("Volver");
        jbVolver.setAlignmentY(0.2F);
        jbVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jtTablaProdAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
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

        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-añadir-20.png"))); // NOI18N
        jbAgregar.setText("Agregar");
        jbAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addGroup(jpPoductosLayout.createSequentialGroup()
                        .addGroup(jpPoductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPoductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpPoductosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAgregar)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jpPoductosLayout.setVerticalGroup(
            jpPoductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPoductosLayout.createSequentialGroup()
                .addGroup(jpPoductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
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

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-menos-20.png"))); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        jpDetallesLayout.setVerticalGroup(
            jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminar)
                    .addComponent(jLabel3)
                    .addComponent(jlTotal)))
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

/**
 * Maneja la acción de eliminar un detalle de venta. Extrae la información de la fila seleccionada
 * en la tabla de detalles de compra, elimina el detalle de la base de datos y de la tabla, actualiza
 * el precio total y ajusta el stock del producto correspondiente.
 */
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

/**
 * Agrega un producto a la lista de detalles de venta. Obtiene la cantidad de productos a agregar,
 * el producto seleccionado y verifica si hay suficiente stock. Si la validación es exitosa,
 * se registra el detalle en la base de datos, se actualiza el precio total, se agrega una fila
 * a la tabla de detalles de compra y se realiza la actualización de la tabla de productos.
 */
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
    
 /**
 * Finaliza la venta. Si no se han vendido productos, se eliminará la venta y se mostrará
 * un mensaje informativo. Si se han vendido productos, se mostrará un mensaje de confirmación
 * para continuar con los detalles de la venta.
 */
    private void jbFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinActionPerformed
        if (jtTablaDetalles.getRowCount() == 0) {
            VentaData.eliminarVenta(venta.getIdVenta());
            Principal.mostrarListaClientes();
            JOptionPane.showMessageDialog(this, "La venta se anulará porque no se vendieron productos. ");
            this.setVisible(false);
            Principal.ClienteSelect = false;
            Principal.mostrarListaClientes();
        } else {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "Confirmacion de la venta",
                    "Confirmación", JOptionPane.OK_CANCEL_OPTION);
            if (respuesta == JOptionPane.OK_OPTION) {

                Principal.cambiar(new DetallesVentaView(venta));
                Principal.anterior = Principal.clientesVistas;
            }
        }
    }//GEN-LAST:event_jbFinActionPerformed

 /**
 * Maneja el evento de tecla liberada en el campo de búsqueda de productos. 
 * Filtra y muestra los productos que coinciden con el texto ingresado en el campo de búsqueda.
 * Si el campo de búsqueda está vacío, muestra todos los productos nuevamente.
 *
 * @param evt Evento de tecla liberada.
 */
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
/**
 * Maneja el evento de acción del botón "Volver".
 * Permite al usuario confirmar si desea anular la venta actual. Si la venta no tiene detalles de compra,
 * se eliminará la venta y se volverá a la vista de lista de clientes. Si la venta tiene detalles de compra,
 * se restaurará el stock de los productos y se eliminará la venta antes de volver a la lista de clientes.
 *
 * @param evt Evento de acción del botón "Volver".
 */
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

/**
 * Maneja el evento del mouse cuando se hace clic en una fila de la tabla de productos (jtTablaProd).
 * Si se hace doble clic en una fila, se llama al método btnAgrega() para agregar el producto a la venta.
 * Si se hace clic una vez en una fila, se muestra el nombre y la descripción del producto seleccionado.
 *
 * @param evt Evento de mouse al hacer clic en la tabla de productos.
 */
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

/**
 * Carga la lista de productos en la tabla de productos (jtTablaProd) en función de la disponibilidad y estado de los productos.
 * Si no hay productos disponibles, se muestra un mensaje de advertencia.
 */
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

 /**
 * Valida la cantidad de productos seleccionada en el control jsCantidad.
 * La cantidad debe ser mayor a cero (0) para ser considerada válida.
 * @return true si la cantidad es válida, de lo contrario, muestra un mensaje de error y devuelve false.
 */
    private boolean validarCantidad() {
        int valor = (int) jsCantidad.getValue();
        if (valor > 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Cantidad debe ser mayor a 0 (CERO)",
                    "Error en Cantidad de producto", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

 /**
 * Busca el producto seleccionado en la tabla de productos (jtTablaProd) y devuelve el objeto Producto correspondiente.
 * Si no se ha seleccionado ningún producto o el producto no se encuentra en la lista de productos disponibles, muestra un mensaje de error.
 * @return El objeto Producto correspondiente al producto seleccionado en la tabla, o null si no se ha seleccionado o no se encuentra.
 */
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

 /**
 * Actualiza el stock de un producto en función de si se realiza una compra (venta) o una devolución. 
 * Verifica si hay suficiente stock para realizar la compra y actualiza la base de datos. 
 * @param compra Un booleano que indica si se trata de una compra (true) o una devolución (false).
 * @param prod El objeto Producto que se va a comprar o devolver.
 * @param cantidad La cantidad de productos que se van a comprar o devolver.
 * @return true si la operación se realizó con éxito (suficiente stock o actualización exitosa), de lo contrario, muestra un mensaje de error y devuelve false.
 */
    private boolean actualizarStock(boolean compra, Producto prod, int cantidad) {
        int stock = prod.getStock();
        int idProd = prod.getIdProducto();
        if (compra) {
            if (stock >= cantidad) {
                stock = stock - cantidad;
                ProductoData.ActualizarStock(stock, idProd);
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "No hay suficiente stock para realizar la venta.",
                        "Stock insuficiente", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            stock = stock + cantidad;
            ProductoData.ActualizarStock(stock, idProd);
            return true;
        }

    }

 /**
 * Carga la lista de productos disponibles en la interfaz de usuario.
 * Limpia las filas anteriores de la tabla de productos (jtTablaProd) y agrega las filas correspondientes a los productos disponibles.
 */
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
