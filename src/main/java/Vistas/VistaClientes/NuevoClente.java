/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas.VistaClientes;

import Conexion.ClienteData;
import Entidades.Cliente;
import Vistas.FloatingWindow;
import Vistas.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import com.formdev.flatlaf.icons.FlatFileViewHardDriveIcon;

/**
 *
 * @author jdbar
 */
public class NuevoClente extends javax.swing.JPanel {

    /**
     * Creates new form NuevoClente
     */
    private FloatingWindow parentWindow;
    private boolean ejecutarAccion = true;

    public NuevoClente(FloatingWindow parentWindow) {
        this.parentWindow = parentWindow;

        initComponents();
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
        JTName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTDNI = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTDomicilio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JTelefono = new javax.swing.JTextField();
        JBNuevo = new javax.swing.JButton();
        JBCerrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        JTCorreo = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Apellido Cliente");

        JTName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTNameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("DNI");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nombre Cliente");

        JTApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTApellidoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Domicilio");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Telefono");

        JBNuevo.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        JBNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-guardar-30.png"))); // NOI18N
        JBNuevo.setText("Guardar");
        JBNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBNuevoActionPerformed(evt);
            }
        });

        JBCerrar.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        JBCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cancelar-30.png"))); // NOI18N
        JBCerrar.setText("Cancelar");
        JBCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCerrarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(276, 276, 276))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBCerrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JBNuevo))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JTCorreo)
                                    .addComponent(JTDNI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTName, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4)
                                        .addComponent(JTDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(JTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(73, 73, 73))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JTDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(JTCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBNuevo)
                    .addComponent(JBCerrar))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JTNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTNameActionPerformed

    private void JTApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTApellidoActionPerformed

    private void JBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBNuevoActionPerformed
        // TODO add your handling code here:
        if (ejecutarAccion) {
            try {
                String apellido = JTApellido.getText().trim();
                String nombre = JTName.getText().trim();
                String domicilio = JTDomicilio.getText().trim();
                String telefono = JTelefono.getText().trim();
                String dniString = JTDNI.getText().trim();
                String correo = JTCorreo.getText().trim();

                // Verificar Datos
                if (apellido.matches(".*[.,?@0-9].*") || apellido.isEmpty()) {
                    throw new RuntimeException("Apellido mal ingresado");
                }
                if (nombre.matches(".*[.,?@0-9].*") || nombre.isEmpty()) {
                    throw new RuntimeException("Nombre mal ingresado");
                }
                if (!domicilio.matches(".*[A-Za-z, ].*") || domicilio.length() < 10 || domicilio.length() > 100) {
                    throw new RuntimeException("Domicilio mal ingresado");
                }

                if (!telefono.matches("[0-9]+") || telefono.length() < 6) {
                    throw new RuntimeException("Telefono mal ingresado");
                }
                if (dniString.length() != 8) {
                    throw new RuntimeException("DNI debe tener exactamente 8 dígitos");
                }

                if (!correo.isEmpty() && !correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                    throw new IllegalArgumentException("Correo mal ingresado");
                }

                int dni = Integer.parseInt(dniString);

                Cliente cliente = new Cliente(apellido, nombre, domicilio, telefono, dni, correo);
                if (!ClienteData.crearCliente(cliente)) {
                    Principal.mostrarListaClientes();
                    throw new RuntimeException("Error al guardar en la base de datos verifique que DNI ya se encuentre guardado");
                }
                Principal.mostrarListaClientes();
                JOptionPane.showMessageDialog(null, "Creado el Cliente " + nombre + " " + apellido);
                parentWindow.dispose();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error al ingresar el DNI. Asegúrate de ingresar un número válido.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
//                    int[] digitos = new int[7];
//
//                    //Guardar los 7 primeros digitos
//                    for (int i = 0; i < 7; i++) {
//                        digitos[i] = dni % 10;
//                        dni /= 10;
//                    }
//
//                    //sumar los datos
//                    int sumaPonderada = 0;
//                    int peso = 2;
//
//                    for (int i = 0; i < 7; i++) {
//                        System.out.println(digitos[i]);
//                        sumaPonderada += digitos[i] * peso;
//                        peso++;
//                    }
//                    System.out.println("Resultado " + sumaPonderada);
//
//                    //Calcular el modulo de la suma
//                    int resultado = sumaPonderada % 11;
//                    System.out.println("Resultado " + resultado);
//                    if (resultado == 0) {
//                        Cliente cliente = new Cliente(apellido, nombre, domicilio, telefono, dni);
//                        System.out.println("Se ejecuto");
//                        if (!ClienteData.crearCliente(cliente)) {
//                            throw new RuntimeException("Error al guardar en la base de datos verifique que DNI ya se encuentre guardado");
//                        }
//                        JOptionPane.showMessageDialog(null, "Creado el Cliente " + nombre + " " + apellido);
//                        ClientesVistas.borrarfilasProd();
//                        ClientesVistas.cargarDatosClientes();
//                        parentWindow.dispose();
//                    } else {
//                        throw new RuntimeException("DNI mal ingresado");
//                    }
//

    }//GEN-LAST:event_JBNuevoActionPerformed

    private void JBCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCerrarActionPerformed
        // TODO add your handling code here:
        parentWindow.dispose();
    }//GEN-LAST:event_JBCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCerrar;
    private javax.swing.JButton JBNuevo;
    private javax.swing.JTextField JTApellido;
    private javax.swing.JTextField JTCorreo;
    private javax.swing.JTextField JTDNI;
    private javax.swing.JTextField JTDomicilio;
    private javax.swing.JTextField JTName;
    private javax.swing.JTextField JTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

    public void Datos(Cliente cliente) {
        JTName.setText(cliente.getNombre());
        JTApellido.setText(cliente.getApellido());
        JTDomicilio.setText(cliente.getDomiciio());
        JTDNI.setText(String.valueOf(cliente.getDni()));
        JTelefono.setText(cliente.getTelefono());
        JTCorreo.setText(cliente.getCorreo());  // Agregar el campo "correo"

        System.out.println(cliente.toString());

        JBNuevo.setText("Modificar");
        ejecutarAccion = false;
        if (!ejecutarAccion) {
            try {
                JBNuevo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String apellido = JTApellido.getText().trim();
                            String nombre = JTName.getText().trim();
                            String domicilio = JTDomicilio.getText().trim();
                            String telefono = JTelefono.getText().trim();
                            String dniString = JTDNI.getText().trim();
                            String correo = JTCorreo.getText().trim();

                            // Verificar Datos
                            if (apellido.matches(".*[.,?@].*") || apellido.isEmpty()) {
                                throw new RuntimeException("Apellido mal ingresado");
                            }
                            if (nombre.matches(".*[.,?@].*") || nombre.isEmpty()) {
                                throw new RuntimeException("Nombre mal ingresado");
                            }
                            if (!domicilio.matches(".*[A-Za-z, ].*") || domicilio.length() < 10 || domicilio.length() > 100) {
                                throw new RuntimeException("Domicilio mal ingresado");
                            }
                            if (!telefono.matches("^[0-9]+$") || telefono.length() < 8) {
                                throw new RuntimeException("Telefono mal ingresado");
                            }
                            if (!correo.isEmpty() && !correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                                throw new IllegalArgumentException("Correo mal ingresado");
                            }
                            if (dniString.length() != 8) {
                                throw new RuntimeException("DNI debe tener exactamente 8 dígitos");
                            }

                            int dni = Integer.parseInt(dniString);

                            cliente.setNombre(nombre);
                            cliente.setApellido(apellido);
                            cliente.setDomiciio(domicilio);
                            cliente.setDni(dni);
                            cliente.setTelefono(telefono);
                            cliente.setCorreo(correo);

                            System.out.println(cliente.toString());

                            int id = cliente.getIdCliente();

                            System.out.println("ID: " + id);

                            boolean modificar = ClienteData.modifocarCliente(cliente, id);

                            if (modificar) {
                                Principal.mostrarListaClientes();
                                System.out.println("Se ejecutó la modificación");
                                JOptionPane.showMessageDialog(null, "Se modificó: " + cliente.toString());
                            } else {
                                System.out.println("No se ejecutó la modificación");
                            }

                            parentWindow.dispose();
                        } catch (RuntimeException ex) {
                            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                        }
                    }
                });
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

    }

}
