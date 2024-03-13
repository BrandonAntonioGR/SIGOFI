package com.pollo.view;

import com.pollo.controller.ControladorCargarEnviados;
import java.sql.SQLException;
import com.pollo.utilities.ModeloDeTabla;
import javax.swing.JComboBox;
import com.pollo.DAO.entities.Enviado;
import com.pollo.controller.CoOpciones;
import com.pollo.controller.ControladorCargaEnviadosFiltroComentarios;
import com.pollo.controller.ControladorCargaEnviadosFiltroFechGene;
import com.pollo.controller.ControladorCargaEnviadosFiltroFechOficio;
import com.pollo.controller.ControladorCargaEnviadosFiltroNumOfiicio;
import com.pollo.controller.ControladorCargaEnviadosFiltroTema;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VistaEnviados extends javax.swing.JFrame {

    CoOpciones co = new CoOpciones();
    public JComboBox<Integer> comboBoxFilasPermitidas;
    ControladorCargarEnviados controlador;
    ControladorCargaEnviadosFiltroFechGene conFechGene;
    ControladorCargaEnviadosFiltroNumOfiicio conNumOficio;
    ControladorCargaEnviadosFiltroFechOficio conFechOficio;
    ControladorCargaEnviadosFiltroTema conTema;
    ControladorCargaEnviadosFiltroComentarios conComentarios;

    public VistaEnviados() throws SQLException {
        initComponents();
        tblEnviados.setModel(crearModeloTabla());
        controlador = new ControladorCargarEnviados(this);
        txtFiltroTexto.setEnabled(false);
        txtFiltroFecha.setEnabled(false);
    }

    private ModeloDeTabla crearModeloTabla() {

        return new ModeloDeTabla<Enviado>() {
            @Override
            public Object getValueAt(Enviado t, int columna) {
                switch (columna) {
                    case 0:
                        return t.getId_Enviado();
                    case 1:
                        return t.getFech_Generacion();
                    case 2:
                        return t.getNum_Oficio();
                    case 3:
                        return t.getFech_Oficio();
                    case 4:
                        return t.getTema();
                    case 5:
                        return t.getComentarios();
                }
                return null;
            }

            @Override
            public String getColumnName(int columna) {
                switch (columna) {
                    case 0:
                        return "ID";
                    case 1:
                        return "Fecha Generación";
                    case 2:
                        return "Número Oficio";
                    case 3:
                        return "Fecha Oficio";
                    case 4:
                        return "Tema";
                    case 5:
                        return "Comentarios";
                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return 6;
            }
        };

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEnviados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox<>();
        txtFiltroTexto = new javax.swing.JTextField();
        txtFiltroFecha = new com.toedter.calendar.JDateChooser();
        btnFiltro = new javax.swing.JButton();
        paginationPanel = new javax.swing.JPanel();
        opcMenu = new javax.swing.JComboBox<>();
        btnCancelarFiltro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(tblEnviados);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 36)); // NOI18N
        jLabel1.setText("Oficios Enviados");

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar columna a filtrar-", "Fecha de generación", "Número de Oficio", "Fecha de Oficio", "Tema", "Comentarios" }));
        cmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroActionPerformed(evt);
            }
        });

        txtFiltroFecha.setDateFormatString("dd-MM-yyyy");

        btnFiltro.setText("Filtrar");
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });

        opcMenu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        opcMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione operacion a realizar-", "Agregar", "Modificar", "Eliminar" }));
        opcMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcMenuActionPerformed(evt);
            }
        });

        btnCancelarFiltro.setText("Cancelar Filtro");
        btnCancelarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(223, 223, 223))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(paginationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbFiltro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCancelarFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFiltroFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(txtFiltroTexto)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(opcMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltroTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFiltroFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paginationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(opcMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelarFiltro))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        int filtroseleccionado = cmbFiltro.getSelectedIndex();
        switch (filtroseleccionado) {
            case 0:
                tblEnviados.removeAll();
                paginationPanel.removeAll();
                tblEnviados.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarEnviados(this);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaEnviados.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 1:
                java.sql.Date fechGeneracion = new java.sql.Date(txtFiltroFecha.getDate().getTime());
                tblEnviados.removeAll();
                paginationPanel.removeAll();
                tblEnviados.setModel(crearModeloTabla());
                try {
                    conFechGene = new ControladorCargaEnviadosFiltroFechGene(this, fechGeneracion);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaEnviados.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 2:
                String numOficio = txtFiltroTexto.getText();
                tblEnviados.removeAll();
                paginationPanel.removeAll();
                tblEnviados.setModel(crearModeloTabla());
                try {
                    conNumOficio = new ControladorCargaEnviadosFiltroNumOfiicio(this, numOficio);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaEnviados.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 3:
                java.sql.Date fechOficio = new java.sql.Date(txtFiltroFecha.getDate().getTime());
                tblEnviados.removeAll();
                paginationPanel.removeAll();
                tblEnviados.setModel(crearModeloTabla());
                try {
                    conFechOficio = new ControladorCargaEnviadosFiltroFechOficio(this, fechOficio);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaEnviados.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 4:
                String tema = txtFiltroTexto.getText();
                tblEnviados.removeAll();
                paginationPanel.removeAll();
                tblEnviados.setModel(crearModeloTabla());
                try {
                    conTema = new ControladorCargaEnviadosFiltroTema(this, tema);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaEnviados.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 5:
                String comentarios = txtFiltroTexto.getText();
                tblEnviados.removeAll();
                paginationPanel.removeAll();
                tblEnviados.setModel(crearModeloTabla());
                try {
                    conComentarios = new ControladorCargaEnviadosFiltroComentarios(this, comentarios);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaEnviados.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void opcMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcMenuActionPerformed
        int opcMenu = this.opcMenu.getSelectedIndex();
        int fila = tblEnviados.getSelectedRow();
        switch (opcMenu) {
            case 1:
                co.altaEnviados();
                this.dispose();
                break;
            case 2:

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un registro para modificar");
                } else {
                    int id = Integer.parseInt(tblEnviados.getValueAt(fila, 0).toString());
                    co.modificaEnviados(id);
                    this.dispose();
                }
                break;
            case 3:

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un registro para eliminar");
                } else {
                    int id = Integer.parseInt(tblEnviados.getValueAt(fila, 0).toString());
                    Boolean respuesta = com.pollo.controller.ControladorEnviados.Eliminar(id);
                    tblEnviados.removeAll();
                    paginationPanel.removeAll();
                    tblEnviados.setModel(crearModeloTabla());
                    try {
                        controlador = new ControladorCargarEnviados(this);
                    } catch (SQLException ex) {
                        Logger.getLogger(VistaEnviados.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_opcMenuActionPerformed

    private void cmbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiltroActionPerformed
        int filtroseleccionado = cmbFiltro.getSelectedIndex();
        switch (filtroseleccionado) {
            case 0:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(false);
                txtFiltroFecha.setEnabled(false);
                tblEnviados.removeAll();
                paginationPanel.removeAll();
                tblEnviados.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarEnviados(this);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaEnviados.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 1:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(false);
                txtFiltroFecha.setEnabled(true);
                tblEnviados.removeAll();
                paginationPanel.removeAll();
                tblEnviados.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarEnviados(this);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaEnviados.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 2:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(true);
                txtFiltroFecha.setEnabled(false);
                tblEnviados.removeAll();
                paginationPanel.removeAll();
                tblEnviados.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarEnviados(this);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaEnviados.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 3:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(false);
                txtFiltroFecha.setEnabled(true);
                tblEnviados.removeAll();
                paginationPanel.removeAll();
                tblEnviados.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarEnviados(this);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaEnviados.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 4:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(true);
                txtFiltroFecha.setEnabled(false);
                tblEnviados.removeAll();
                paginationPanel.removeAll();
                tblEnviados.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarEnviados(this);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaEnviados.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 5:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(true);
                txtFiltroFecha.setEnabled(false);
                tblEnviados.removeAll();
                paginationPanel.removeAll();
                tblEnviados.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarEnviados(this);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaEnviados.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_cmbFiltroActionPerformed

    private void btnCancelarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarFiltroActionPerformed
        txtFiltroTexto.setText("");
        txtFiltroFecha.setDate(null);
        cmbFiltro.setSelectedIndex(0);
        txtFiltroTexto.setEnabled(false);
        txtFiltroFecha.setEnabled(false);
        tblEnviados.removeAll();
        paginationPanel.removeAll();
        tblEnviados.setModel(crearModeloTabla());
        try {
            controlador = new ControladorCargarEnviados(this);
        } catch (SQLException ex) {
            Logger.getLogger(VistaEnviados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCancelarFiltroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarFiltro;
    private javax.swing.JButton btnFiltro;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> opcMenu;
    public javax.swing.JPanel paginationPanel;
    public javax.swing.JTable tblEnviados;
    private com.toedter.calendar.JDateChooser txtFiltroFecha;
    private javax.swing.JTextField txtFiltroTexto;
    // End of variables declaration//GEN-END:variables
}
