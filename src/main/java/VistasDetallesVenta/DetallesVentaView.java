/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package VistasDetallesVenta;

import com.mycompany.fravemax.ExportPDF;
import Conexion.DetalleVentaData;
import Conexion.VentaData;
import Entidades.Cliente;
import Entidades.Venta;
import Entidades.detalleVenta;
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
public class DetallesVentaView extends javax.swing.JPanel {

    private List<detalleVenta> productosVendidos = new ArrayList();
    private Venta ventaRealizada;
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    public DetallesVentaView(Venta venta, double total) {
        initComponents();
        agregarCabecera();
        this.ventaRealizada = venta;
        configurarCliente();
        cargarListaProd();
        llenarTabla();
    }
    
    public DetallesVentaView(Venta venta) {
        initComponents();
        agregarCabecera();
        this.ventaRealizada = venta;
        configurarCliente();
        cargarListaProd();
        llenarTabla();
    }

    private void configurarCliente() {
        jtNombre.setText(ventaRealizada.getCliente().getNombre());
        jtApellido.setText(ventaRealizada.getCliente().getApellido());
        jtDni.setText(String.valueOf(ventaRealizada.getCliente().getDni()));
        jtTel.setText(ventaRealizada.getCliente().getTelefono());
        jtDomicilio.setText(ventaRealizada.getCliente().getDomiciio());
    }

    private void cargarListaProd() {
        productosVendidos = DetalleVentaData.listaProductosPorIdVenta(ventaRealizada.getIdVenta());
        if (productosVendidos.isEmpty()) {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "No se vendio ningun producto, desea eliminar la venta?",
                    "Eliminar venta", JOptionPane.OK_CANCEL_OPTION);
            if (respuesta == JOptionPane.OK_OPTION) {
                VentaData.eliminarVenta(ventaRealizada.getIdVenta());
                this.setVisible(false);
                Principal.mostrarVentas();
            }
        } else {
            double total = 0;
            for (detalleVenta producto : productosVendidos) {
                total = total + producto.getPrecioVenta();
            }
            jtTotal.setText(String.valueOf(total));
        }
    }


    private void llenarTabla() {
        productosVendidos.forEach(producto -> {
            modelo.addRow(new Object[]{
                producto.getProducto().getNombreProducto(),
                producto.getProducto().getDescripcion(),
                producto.getCantidad(),
                "$ " + producto.getPrecioVenta(),});
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Detalles = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtDomicilio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaProd = new javax.swing.JTable();
        jtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jtApellido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtTel = new javax.swing.JTextField();
        jtTotal = new javax.swing.JTextField();
        jtDni = new javax.swing.JTextField();
        jbImprimir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel7.setText("Domicilio:");

        jLabel1.setText("Detalle de venta:");

        jtDomicilio.setEditable(false);

        jLabel2.setText("Datos del Cliente.");

        jLabel8.setText("Datos del Producto:");

        jLabel3.setText("Nombre:");

        jtTablaProd.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtTablaProd);

        jtNombre.setEditable(false);

        jLabel4.setText("Apellido:");

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jtApellido.setEditable(false);
        jtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtApellidoActionPerformed(evt);
            }
        });

        jLabel9.setText("Total  Venta:");

        jtTel.setEditable(false);

        jtTotal.setEditable(false);
        jtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTotalActionPerformed(evt);
            }
        });

        jtDni.setEditable(false);

        jbImprimir.setText("Imprimir");
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });

        jLabel6.setText("Nro Tel:");

        jLabel5.setText("Nro  DNI:");

        javax.swing.GroupLayout DetallesLayout = new javax.swing.GroupLayout(Detalles);
        Detalles.setLayout(DetallesLayout);
        DetallesLayout.setHorizontalGroup(
            DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetallesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(DetallesLayout.createSequentialGroup()
                        .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(189, 189, 189)
                        .addComponent(jbImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(DetallesLayout.createSequentialGroup()
                .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DetallesLayout.createSequentialGroup()
                        .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DetallesLayout.createSequentialGroup()
                                .addGap(222, 222, 222)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(DetallesLayout.createSequentialGroup()
                                .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(DetallesLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
            .addGroup(DetallesLayout.createSequentialGroup()
                .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetallesLayout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                    .addGroup(DetallesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(295, 295, 295)))
                .addGap(328, 328, 328))
        );
        DetallesLayout.setVerticalGroup(
            DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetallesLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DetallesLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)))
                .addGap(12, 12, 12)
                .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(DetallesLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel5)))
                .addGap(16, 16, 16)
                .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Detalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Detalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtApellidoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        Principal.mostrarVentas();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed
        String nombreCliente = jtNombre.getText();
        String apellidoCliente = jtApellido.getText();
        int dniCliente = Integer.parseInt(jtDni.getText());
        String telefonoCliente = jtTel.getText();
        String domicilioCliente = jtDomicilio.getText();
        String total = jtTotal.getText();
        String nombreArchivo = apellidoCliente + dniCliente + ".pdf";
        ExportPDF.exportToPDF(nombreCliente, apellidoCliente, dniCliente, telefonoCliente,
                domicilioCliente, total, jtTablaProd, nombreArchivo);
    }//GEN-LAST:event_jbImprimirActionPerformed

    private void jtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTotalActionPerformed

    private void agregarCabecera() {
        modelo.addColumn("Nombre del Producto");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        jtTablaProd.setModel(modelo);
        ajustarCabeceras();
        RealizarVentaview.centrarTabla(jtTablaProd);
    }

    private void ajustarCabeceras() {
        TableColumnModel columnModel = jtTablaProd.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(75);
        columnModel.getColumn(1).setPreferredWidth(170);
        columnModel.getColumn(2).setPreferredWidth(75);
        columnModel.getColumn(3).setPreferredWidth(85);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Detalles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtDomicilio;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTable jtTablaProd;
    private javax.swing.JTextField jtTel;
    private javax.swing.JTextField jtTotal;
    // End of variables declaration//GEN-END:variables
}
