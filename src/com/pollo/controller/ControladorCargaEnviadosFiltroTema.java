package com.pollo.controller;

import com.pollo.DAO.entities.Enviado;
import com.pollo.DAO.model.ModelQuerysEnviados;
import com.pollo.DAO.model.ModelQuerysFiltroEnviados;
import com.pollo.utilities.ProveedorDatosPaginacion;
import com.pollo.view.VistaEnviados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;


public class ControladorCargaEnviadosFiltroTema implements ActionListener, TableModelListener{
    private final VistaEnviados tblEnv;
    private final ModelQuerysEnviados model;
    private PaginadorDeTabla<Enviado> paginadorDeTabla;
    
    public final void events(){
        tblEnv.comboBoxFilasPermitidas.addActionListener(this);
        tblEnv.tblEnviados.getModel().addTableModelListener(this);
    }
    public ControladorCargaEnviadosFiltroTema(VistaEnviados tbl,String tema) throws SQLException{
        this.tblEnv = tbl;
        model = new ModelQuerysEnviados();
        ProveedorDatosPaginacion<Enviado> proveedorDeDatosPaginacion =crearProveedorDeDatos(tema);
        paginadorDeTabla= new PaginadorDeTabla(tblEnv.tblEnviados,proveedorDeDatosPaginacion,new int []{2,4,6},3);
        paginadorDeTabla.crearListadoDeFilasPermitidas(tblEnv.paginationPanel);
        
        tblEnv.comboBoxFilasPermitidas=paginadorDeTabla.getComboBoxFilasPermitidas();
        
        events();
        tblEnv.comboBoxFilasPermitidas.setSelectedItem(Integer.parseInt("2"));//15 en nuestro caso
    }
    private ProveedorDatosPaginacion<Enviado> crearProveedorDeDatos(String tema) throws SQLException{
        List<Enviado> lista = ModelQuerysFiltroEnviados.filtraTema(tema);
        return new ProveedorDatosPaginacion<Enviado>() {
            @Override
            public int getTotalRowCount() {
                return lista.size();
            }

            @Override
            public List<Enviado> getRows(int starIndex, int endIndex) {
                return lista.subList(starIndex, endIndex);
            }
        };
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evt =ae.getSource();
        if(evt.equals(tblEnv.comboBoxFilasPermitidas)){
            paginadorDeTabla.eventComboBox(tblEnv.comboBoxFilasPermitidas);
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        paginadorDeTabla.actualizarBotonesPaginacion();
        
    }
}
