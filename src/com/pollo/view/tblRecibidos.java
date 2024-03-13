package com.pollo.view;

import com.pollo.DAO.entities.Recibido;
import com.pollo.controller.CoOpciones;
import com.pollo.controller.ControladorCargarRecibidos;
import com.pollo.utilities.ModeloDeTabla;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class tblRecibidos extends javax.swing.JFrame {

    CoOpciones co = new CoOpciones();
    public JComboBox<Integer> comboBoxFilasPermitidas;
    ControladorCargarRecibidos controlador;

    public tblRecibidos() throws SQLException {
        initComponents();
        tblRecibidos.setModel(crearModeloTabla());
        controlador = new ControladorCargarRecibidos(this);
        txtFiltroTexto.setEnabled(false);
        txtFiltroFecha.setEnabled(false);

    }

    private ModeloDeTabla crearModeloTabla() {

        return new ModeloDeTabla<Recibido>() {
            @Override
            public Object getValueAt(Recibido t, int columna) {
                switch (columna) {
                    case 0:
                        return t.getId_Recibidos();
                    case 1:
                        return t.getFechaRecepcion();
                    case 2:
                        return t.getNumeroOficio();
                    case 3:
                        return t.getFechaOficio();
                    case 4:
                        return t.getTema();
                    case 5:
                        return t.getAtenCono();
                    case 6:
                        return t.getEstado();
                    case 7:
                        return t.getFechaTurnado();
                    case 8:
                        return t.getAtendio();
                    case 9:
                        return t.getOficioRespuesta();
                    case 10:
                        return t.getFechaRespuesta();
                    case 11:
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
                        return "Fecha Recepcion";
                    case 2:
                        return "Número Oficio";
                    case 3:
                        return "Fecha Oficio";
                    case 4:
                        return "Tema";
                    case 5:
                        return "Atencion/Conocimiento";
                    case 6:
                        return "Estado";
                    case 7:
                        return "Fecha Turnado";
                    case 8:
                        return "Atendio";
                    case 9:
                        return "Oficio de Respuesta";
                    case 10:
                        return "Fecha de Respuesta";
                    case 11:
                        return "Comentarios";

                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return 12;
            }
        };

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecibidos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelarFiltro = new javax.swing.JButton();
        btnFiltro = new javax.swing.JButton();
        txtFiltroFecha = new com.toedter.calendar.JDateChooser();
        txtFiltroTexto = new javax.swing.JTextField();
        cmbFiltro = new javax.swing.JComboBox<>();
        opcMenu = new javax.swing.JComboBox<>();
        paginationPanel = new javax.swing.JPanel();
        paginationPanelR = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblRecibidos.setFocusable(false);
        tblRecibidos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblRecibidos.setRowHeight(25);
        tblRecibidos.setSelectionBackground(new java.awt.Color(64, 247, 64));
        tblRecibidos.setShowVerticalLines(false);
        tblRecibidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblRecibidos);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 36)); // NOI18N
        jLabel1.setText("Oficios Recibidos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(285, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(200, 200, 200))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        btnCancelarFiltro.setText("Cancelar Filtro");
        btnCancelarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarFiltroActionPerformed(evt);
            }
        });

        btnFiltro.setText("Filtrar");
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });

        txtFiltroFecha.setDateFormatString("dd-MM-yyyy");

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar columna a filtrar-", "Fecha de Recepción", "Número de Oficio", "Fecha de Oficio", "Tema", "Aten/Cono", "Estado", "Fecha turnado", "Atendio", "Oficio Repsuesta", "Fecha de Respuesta", "Comentarios" }));
        cmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroActionPerformed(evt);
            }
        });

        opcMenu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        opcMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione operacion a realizar-", "Agregar", "Modificar", "Eliminar" }));
        opcMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paginationPanelR, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbFiltro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCancelarFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtFiltroTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFiltroFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(opcMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(paginationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(27, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFiltroTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(btnCancelarFiltro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(txtFiltroFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(btnFiltro)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paginationPanelR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(opcMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(197, 197, 197)
                    .addComponent(paginationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(189, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarFiltroActionPerformed
        txtFiltroTexto.setText("");
        txtFiltroFecha.setDate(null);
        cmbFiltro.setSelectedIndex(0);
        txtFiltroTexto.setEnabled(false);
        txtFiltroFecha.setEnabled(false);
        tblRecibidos.removeAll();
        paginationPanel.removeAll();
        tblRecibidos.setModel(crearModeloTabla());
        try {
            controlador = new ControladorCargarRecibidos(this);
        } catch (SQLException ex) {
            Logger.getLogger(VistaEnviados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCancelarFiltroActionPerformed

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
//        int filtroseleccionado = cmbFiltro.getSelectedIndex();
//        switch (filtroseleccionado) {
//            case 0:
//            tblEnviados.removeAll();
//            paginationPanel.removeAll();
//            tblEnviados.setModel(crearModeloTabla());
//            try {
//                controlador = new ControladorCargarEnviados(this);
//            } catch (SQLException ex) {
//                Logger.getLogger(tblEnviados.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            break;
//            case 1:
//            java.sql.Date fechGeneracion = new java.sql.Date(txtFiltroFecha.getDate().getTime());
//            tblEnviados.removeAll();
//            paginationPanel.removeAll();
//            tblEnviados.setModel(crearModeloTabla());
//            try {
//                conFechGene = new ControladorCargaEnviadosFiltroFechGene(this, fechGeneracion);
//            } catch (SQLException ex) {
//                Logger.getLogger(tblEnviados.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            break;
//            case 2:
//            String numOficio = txtFiltroTexto.getText();
//            tblEnviados.removeAll();
//            paginationPanel.removeAll();
//            tblEnviados.setModel(crearModeloTabla());
//            try {
//                conNumOficio = new ControladorCargaEnviadosFiltroNumOfiicio(this, numOficio);
//            } catch (SQLException ex) {
//                Logger.getLogger(tblEnviados.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            break;
//            case 3:
//            java.sql.Date fechOficio = new java.sql.Date(txtFiltroFecha.getDate().getTime());
//            tblEnviados.removeAll();
//            paginationPanel.removeAll();
//            tblEnviados.setModel(crearModeloTabla());
//            try {
//                conFechOficio = new ControladorCargaEnviadosFiltroFechOficio(this, fechOficio);
//            } catch (SQLException ex) {
//                Logger.getLogger(tblEnviados.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            break;
//            case 4:
//            String tema = txtFiltroTexto.getText();
//            tblEnviados.removeAll();
//            paginationPanel.removeAll();
//            tblEnviados.setModel(crearModeloTabla());
//            try {
//                conTema = new ControladorCargaEnviadosFiltroTema(this, tema);
//            } catch (SQLException ex) {
//                Logger.getLogger(tblEnviados.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            break;
//            case 5:
//            String comentarios = txtFiltroTexto.getText();
//            tblEnviados.removeAll();
//            paginationPanel.removeAll();
//            tblEnviados.setModel(crearModeloTabla());
//            try {
//                conComentarios = new ControladorCargaEnviadosFiltroComentarios(this, comentarios);
//            } catch (SQLException ex) {
//                Logger.getLogger(tblEnviados.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            break;
//            default:
//            break;
//        }
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void opcMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcMenuActionPerformed
        int opcMenu = this.opcMenu.getSelectedIndex();
        int fila = tblRecibidos.getSelectedRow();
        switch (opcMenu) {
            case 1:
                //Alta recibidos
                //co.altaRecibidos();
                this.dispose();
                break;
            case 2:
                //modifica recibidos
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un registro para modificar");
                } else {
                    int id = Integer.parseInt(tblRecibidos.getValueAt(fila, 0).toString());
                    //co.modificaRecibidos(id);
                    this.dispose();
                }
                break;
            case 3:
                //Eliminar registro
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un registro para eliminar");
                } else {
                    int id = Integer.parseInt(tblRecibidos.getValueAt(fila, 0).toString());
                    Boolean respuesta = com.pollo.controller.ControladorEnviados.Eliminar(id);
                    tblRecibidos.removeAll();
                    paginationPanel.removeAll();
                    tblRecibidos.setModel(crearModeloTabla());
                    try {
                        controlador = new ControladorCargarRecibidos(this);
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
                tblRecibidos.removeAll();
                paginationPanelR.removeAll();
                tblRecibidos.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarRecibidos(this);
                } catch (SQLException ex) {
                    Logger.getLogger(tblRecibidos.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 1:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(false);
                txtFiltroFecha.setEnabled(true);
                tblRecibidos.removeAll();
                paginationPanelR.removeAll();
                tblRecibidos.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarRecibidos(this);
                } catch (SQLException ex) {
                    Logger.getLogger(tblRecibidos.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 2:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(true);
                txtFiltroFecha.setEnabled(false);
                tblRecibidos.removeAll();
                paginationPanelR.removeAll();
                tblRecibidos.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarRecibidos(this);
                } catch (SQLException ex) {
                    Logger.getLogger(tblRecibidos.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 3:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(false);
                txtFiltroFecha.setEnabled(true);
                tblRecibidos.removeAll();
                paginationPanelR.removeAll();
                tblRecibidos.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarRecibidos(this);
                } catch (SQLException ex) {
                    Logger.getLogger(tblRecibidos.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 4:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(true);
                txtFiltroFecha.setEnabled(false);
                tblRecibidos.removeAll();
                paginationPanelR.removeAll();
                tblRecibidos.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarRecibidos(this);
                } catch (SQLException ex) {
                    Logger.getLogger(tblRecibidos.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 5:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(true);
                txtFiltroFecha.setEnabled(false);
                tblRecibidos.removeAll();
                paginationPanelR.removeAll();
                tblRecibidos.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarRecibidos(this);
                } catch (SQLException ex) {
                    Logger.getLogger(tblRecibidos.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 6:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(true);
                txtFiltroFecha.setEnabled(false);
                tblRecibidos.removeAll();
                paginationPanelR.removeAll();
                tblRecibidos.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarRecibidos(this);
                } catch (SQLException ex) {
                    Logger.getLogger(tblRecibidos.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 7:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(false);
                txtFiltroFecha.setEnabled(true);
                tblRecibidos.removeAll();
                paginationPanelR.removeAll();
                tblRecibidos.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarRecibidos(this);
                } catch (SQLException ex) {
                    Logger.getLogger(tblRecibidos.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 8:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(true);
                txtFiltroFecha.setEnabled(false);
                tblRecibidos.removeAll();
                paginationPanelR.removeAll();
                tblRecibidos.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarRecibidos(this);
                } catch (SQLException ex) {
                    Logger.getLogger(tblRecibidos.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 9:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(true);
                txtFiltroFecha.setEnabled(false);
                tblRecibidos.removeAll();
                paginationPanelR.removeAll();
                tblRecibidos.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarRecibidos(this);
                } catch (SQLException ex) {
                    Logger.getLogger(tblRecibidos.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 10:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(false);
                txtFiltroFecha.setEnabled(true);
                tblRecibidos.removeAll();
                paginationPanelR.removeAll();
                tblRecibidos.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarRecibidos(this);
                } catch (SQLException ex) {
                    Logger.getLogger(tblRecibidos.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 11:
                txtFiltroTexto.setText("");
                txtFiltroFecha.setDate(null);
                txtFiltroTexto.setEnabled(true);
                txtFiltroFecha.setEnabled(false);
                tblRecibidos.removeAll();
                paginationPanelR.removeAll();
                tblRecibidos.setModel(crearModeloTabla());
                try {
                    controlador = new ControladorCargarRecibidos(this);
                } catch (SQLException ex) {
                    Logger.getLogger(tblRecibidos.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_cmbFiltroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarFiltro;
    private javax.swing.JButton btnFiltro;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> opcMenu;
    public javax.swing.JPanel paginationPanel;
    public javax.swing.JPanel paginationPanelR;
    public javax.swing.JTable tblRecibidos;
    private com.toedter.calendar.JDateChooser txtFiltroFecha;
    private javax.swing.JTextField txtFiltroTexto;
    // End of variables declaration//GEN-END:variables
}
