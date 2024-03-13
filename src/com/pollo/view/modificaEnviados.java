package com.pollo.view;

import com.pollo.DAO.entities.Enviado;
import com.pollo.controller.CoOpciones;
import com.pollo.controller.ControladorEnviados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class modificaEnviados extends javax.swing.JFrame {
    CoOpciones co= new CoOpciones();
    PreparedStatement ps;
    ResultSet rs;
    int filaSeleccionada;
    
    public modificaEnviados(int id) {
        initComponents();
        this.filaSeleccionada=id;
        CargaTabla(filaSeleccionada);
    }
    public void CargaTabla(int fila){        
        try {
            Enviado modificaEnviado= ControladorEnviados.CargadatosModificaEnviado(fila);
            
                txtfechGene.setDate(modificaEnviado.getFech_Generacion());
                txtnumOfi.setText(modificaEnviado.getNum_Oficio());
                txtfechOfi.setDate(modificaEnviado.getFech_Oficio());
                txttema.setText(modificaEnviado.getTema());
                txtcomentarios.setText(modificaEnviado.getComentarios());
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtcomentarios = new javax.swing.JTextField();
        txttema = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfechOfi = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtnumOfi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtfechGene = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Modificar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel5.setText("Comentarios");

        jLabel4.setText("Tema:");

        txtfechOfi.setDateFormatString("dd-MM-yyyy");

        jLabel3.setText("Fecha de oficio:");

        jLabel2.setText("Numero de oficio:");

        jLabel1.setText("Fecha de generacion: ");

        txtfechGene.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtfechGene, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(btnAgregar))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addComponent(btnVolver)
                                .addGap(12, 12, 12))
                            .addComponent(txtnumOfi)
                            .addComponent(txttema)
                            .addComponent(txtcomentarios)
                            .addComponent(txtfechOfi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtfechGene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnumOfi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtfechOfi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txttema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtcomentarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnVolver))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        try {
            co.tablaEnviados();
        } catch (SQLException ex) {
            Logger.getLogger(modificaEnviados.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtfechGene.setDate(null);
        txtnumOfi.setText("");
        txtfechOfi.setDate(null);
        txttema.setText("");
        txtcomentarios.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        java.sql.Date FECH_GENERACION=new java.sql.Date(txtfechGene.getDate().getTime());
        String NUM_OFICIO=txtnumOfi.getText();
        java.sql.Date FECH_OFICIO=new java.sql.Date(txtfechOfi.getDate().getTime());
        String TEMA=txttema.getText();
        String COMENTARIOS=txtcomentarios.getText();
        
        Enviado env=new Enviado(filaSeleccionada, FECH_GENERACION, NUM_OFICIO, FECH_OFICIO, TEMA, COMENTARIOS);

        Boolean respuesta = com.pollo.controller.ControladorEnviados.ModificaEnviado(env);
        if(respuesta ==true){
            JOptionPane.showMessageDialog(null,"Error al ingresar usuario");
        }
        this.dispose();
        try {
            co.tablaEnviados();
        } catch (SQLException ex) {
            Logger.getLogger(modificaEnviados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtcomentarios;
    private com.toedter.calendar.JDateChooser txtfechGene;
    private com.toedter.calendar.JDateChooser txtfechOfi;
    private javax.swing.JTextField txtnumOfi;
    private javax.swing.JTextField txttema;
    // End of variables declaration//GEN-END:variables
}
