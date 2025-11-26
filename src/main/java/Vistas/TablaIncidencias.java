package Vistas;

import Model.*;
import Observer.*;
import javax.swing.table.DefaultTableModel;
import Repositorio.*;
import Servicio.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import javax.swing.JOptionPane;

public class TablaIncidencias extends javax.swing.JPanel implements Observador {

    private final DefaultTableModel modelo;
    private final IClienteService usuarioService = new ClienteService(new ClienteRepositorio());

    public TablaIncidencias() {
        initComponents();
        modelo = (DefaultTableModel) tablaUsuario.getModel();
        EntidadObservableSingleton.getInstancia().agregarObservador(this);
        cargarUsuarios();
    }

    @Override
    public void actualizar() {
        cargarUsuarios();
    }

    private void cargarUsuarios() {
        modelo.setRowCount(0);
        List<Cliente> lista = usuarioService.obtenerTodos();

        for (Cliente u : lista) {
            if (u.getRol() != null && u.getRol().equalsIgnoreCase("ROLE_USER")) {
                modelo.addRow(new Object[]{
                    u.getIdCliente(),
                    u.getNombreCliente(),
                    u.getRucCliente(),
                    u.getEmailCliente(),
                    u.getTelefonoCliente(),
                    u.getDireccionCliente(),
                    u.getRol(),
                    u.getFechaRegistro() != null ? u.getFechaRegistro().toLocalDate() : null
                });
            }
        }
    }

    //MÉTODOS REUTILIZABLES//
    //Método para validar la fecha
    private boolean validarCampos(String nombre, String apellido, String email, String telefono, String contrasena) {
        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || telefono.isEmpty() || contrasena.isEmpty()) {
            mostrarError("Todos los campos son obligatorios.");
            return false;
        }

        if (!email.contains("@")) {
            mostrarError("El email debe contener '@'.");
            return false;
        }

        if (!telefono.matches("9\\d{8}")) {
            mostrarError("El teléfono debe comenzar con 9 y tener 9 dígitos.");
            return false;
        }

        if (!contrasena.matches("u\\d{6}")) {
            mostrarError("La contraseña debe comenzar con 'u' y tener 6 números.");
            return false;
        }

        return true;
    }

    private boolean validarEdad(LocalDate fechaNacimiento) {
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        if (edad < 16 || edad > 70) {
            mostrarError("La edad debe estar entre 16 y 70 años.");
            return false;
        }
        return true;
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarInfo(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel15.setText("INSTRUCTOR");

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(797, 449));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tablaUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Proyecto", "Descripción", "Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaUsuario);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("GESTIÓN DE INCIDENCIAS");

        botonRegresar.setText("Regresar");
        botonRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Filtrar por Proyecto:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Nueva Incidencia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(455, 455, 455)
                .addComponent(botonRegresar))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(botonRegresar))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


//----------------------------Llena los campos -----------------------------------
    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        NuevaIncidencia nueInc = new NuevaIncidencia();
        nueInc.setVisible(true);
        nueInc.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean contrasenaVisible = false;

//---------------------------Días del calendario--------------------------------  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsuario;
    // End of variables declaration//GEN-END:variables
}
