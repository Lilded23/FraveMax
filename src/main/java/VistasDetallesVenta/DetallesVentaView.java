/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package VistasDetallesVenta;

import Conexion.ClienteData;
import com.mycompany.fravemax.ExportPDF;
import Conexion.DetalleVentaData;
import Entidades.Venta;
import Entidades.detalleVenta;
import Vistas.Principal;
import com.mycompany.fravemax.EnviarTicket;
import java.io.File;
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

    public DetallesVentaView(Venta venta) {
        initComponents();
        agregarCabecera();
        this.ventaRealizada = venta;
        configurarCliente();
        cargarListaProd();
        llenarTabla();
    }

    /**
     * Configura la información del cliente en la interfaz.
     */
    private void configurarCliente() {
        jlNombre.setText(ventaRealizada.getCliente().getNombre());
        jlApellido.setText(ventaRealizada.getCliente().getApellido());
        jlDni.setText(String.valueOf(ventaRealizada.getCliente().getDni()));
        jlTel.setText(ventaRealizada.getCliente().getTelefono());
        jlDom.setText(ventaRealizada.getCliente().getDomiciio());
        jlCorreo.setText(ventaRealizada.getCliente().getCorreo());
    }

    /**
     * Carga la lista de productos vendidos y actualiza el monto total de la
     * venta.
     */
    private void cargarListaProd() {
        productosVendidos = DetalleVentaData.listaProductosPorIdVenta(ventaRealizada.getIdVenta());
        double total = 0;
        for (detalleVenta producto : productosVendidos) {
            total += producto.getPrecioVenta();
        }
        jlTotal.setText(String.valueOf(total));
    }

    /**
     * Llena la tabla con los detalles de los productos vendidos.
     */
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
        PanelDatosCliente = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlTel = new javax.swing.JLabel();
        jlApellido = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlDni = new javax.swing.JLabel();
        jlDom = new javax.swing.JLabel();
        jpIconUser = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jlCorreo = new javax.swing.JLabel();
        PanelProductos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaProd = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jlTotal = new javax.swing.JLabel();
        jbVolver = new javax.swing.JButton();
        jbImprimir = new javax.swing.JButton();
        jbEnviarCorreo = new javax.swing.JButton();

        PanelDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Domicilio:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Nro Tel:");

        jlTel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlTel.setText("Nro tel");

        jlApellido.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlApellido.setText("Apellido Cliente");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Apellido:");

        jlNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlNombre.setText("Nombre Cliente");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Nro  DNI:");

        jlDni.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlDni.setText("DNI cliete");

        jlDom.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlDom.setText("Dom");

        jpIconUser.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Correo:");

        jlCorreo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlCorreo.setText("Correo");

        javax.swing.GroupLayout PanelDatosClienteLayout = new javax.swing.GroupLayout(PanelDatosCliente);
        PanelDatosCliente.setLayout(PanelDatosClienteLayout);
        PanelDatosClienteLayout.setHorizontalGroup(
            PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlDni, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpIconUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlDom, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PanelDatosClienteLayout.setVerticalGroup(
            PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jlDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlDom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jpIconUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de los Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

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

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel9.setText("Total  Venta:    $");

        jlTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlTotal.setText("Total");

        javax.swing.GroupLayout PanelProductosLayout = new javax.swing.GroupLayout(PanelProductos);
        PanelProductos.setLayout(PanelProductosLayout);
        PanelProductosLayout.setHorizontalGroup(
            PanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelProductosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlTotal)
                        .addGap(11, 11, 11))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        PanelProductosLayout.setVerticalGroup(
            PanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jbVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atrás-30.png"))); // NOI18N
        jbVolver.setText("Volver");
        jbVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        jbImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-impresora-trazador-30.png"))); // NOI18N
        jbImprimir.setText("Imprimir PDF");
        jbImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });

        jbEnviarCorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-enviar-correo-electrónico-masivo-30.png"))); // NOI18N
        jbEnviarCorreo.setText("Enviar Correo");
        jbEnviarCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEnviarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarCorreoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DetallesLayout = new javax.swing.GroupLayout(Detalles);
        Detalles.setLayout(DetallesLayout);
        DetallesLayout.setHorizontalGroup(
            DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DetallesLayout.createSequentialGroup()
                .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DetallesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(359, 359, 359)
                        .addComponent(jbImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEnviarCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        DetallesLayout.setVerticalGroup(
            DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbImprimir)
                    .addComponent(jbVolver)
                    .addComponent(jbEnviarCorreo))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Detalles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Detalles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        Principal.doDaThing();
        Principal.cambiar(Principal.anterior);
    }//GEN-LAST:event_jbVolverActionPerformed

    /**
     * Abre un archivo PDF generado y lo muestra al usuario.
     */
    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed
        // Crea un archivo PDF y obtiene su nombre F
        String nombreArchivo = CrearPDF();
        String total = jlTotal.getText();
        // Abre el archivo PDF para imprimir
        ExportPDF.abrirPDF(nombreArchivo);
    }//GEN-LAST:event_jbImprimirActionPerformed

    /**
     * Envía el ticket de la venta por correo electrónico al cliente.
     */
    private void jbEnviarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnviarCorreoActionPerformed
        String correoCliente = ventaRealizada.getCliente().getCorreo();
        // Verifica si el cliente tiene un correo registrado
        if (correoCliente.isEmpty()) {
            int response = JOptionPane.showConfirmDialog(null, "El cliente no tiene un correo registrado. ¿Desea agregar un correo para recibir el ticket?", "Agregar Correo", JOptionPane.YES_NO_OPTION);

            // Si el usuario elige agregar un correo
            if (response == JOptionPane.YES_OPTION) {
                String nuevoCorreo = JOptionPane.showInputDialog("Por favor, ingrese el correo del cliente:");

                // Si el usuario ingresa un correo
                if (nuevoCorreo != null) {
                    // Crea un archivo PDF del ticket
                    String nombreArchivo = CrearPDF();
                    // Crea y envía un correo con el archivo PDF adjunto
                    EnviarTicket.crearEmail(nuevoCorreo, new File(nombreArchivo), nombreArchivo, ventaRealizada);
                    boolean envíoCorrecto = EnviarTicket.sendEmail();
                    // Si el correo se envía con éxito, actualiza el correo del cliente
                    if (envíoCorrecto) {
                        int idCliente = ventaRealizada.getCliente().getIdCliente();
                        ClienteData.agregaCorreo(nuevoCorreo, idCliente);
                        jlCorreo.setText(nuevoCorreo);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se ingresó un correo. No se enviará el ticket.");
                }
            }
        } else {
            // Si el cliente ya tiene un correo registrado, crea un archivo PDF del ticket y lo envía por correo.
            String nombreArchivo = CrearPDF();
            EnviarTicket.crearEmail(correoCliente, new File(nombreArchivo), nombreArchivo, ventaRealizada);
            EnviarTicket.sendEmail();
        }
    }//GEN-LAST:event_jbEnviarCorreoActionPerformed

    /**
     * Crea un archivo PDF del ticket de la venta y devuelve el nombre del
     * archivo.
     */
    private String CrearPDF() {
        String apellidoCliente = jlApellido.getText();
        String dniCliente = jlDni.getText();

        // Obtiene el total de la venta
        String total = jlTotal.getText();

        // Genera un nombre de archivo PDF basado en el apellido y DNI del cliente
        String nombreArchivo = apellidoCliente + dniCliente + ".pdf";

        // Exporta los detalles de la venta a un archivo PDF
        ExportPDF.exportToPDF(jtTablaProd, nombreArchivo, ventaRealizada, total);

        return nombreArchivo;
    }

    /**
     * Agrega las cabeceras de la tabla de productos, definiendo las columnas.
     */
    private void agregarCabecera() {
        modelo.addColumn("Nombre del Producto");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        jtTablaProd.setModel(modelo);
        ajustarCabeceras();

    }

    /**
     * Ajusta el ancho de las columnas en la tabla de productos.
     */
    private void ajustarCabeceras() {
        TableColumnModel columnModel = jtTablaProd.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(90);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(55);
        columnModel.getColumn(3).setPreferredWidth(85);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Detalles;
    private javax.swing.JPanel PanelDatosCliente;
    private javax.swing.JPanel PanelProductos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEnviarCorreo;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JButton jbVolver;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlCorreo;
    private javax.swing.JLabel jlDni;
    private javax.swing.JLabel jlDom;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlTel;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JPanel jpIconUser;
    private javax.swing.JTable jtTablaProd;
    // End of variables declaration//GEN-END:variables
}
