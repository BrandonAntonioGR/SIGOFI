package com.pollo.controller;

import com.pollo.DAO.entities.Recibido;
import com.pollo.DAO.model.ModelQuerysRecibidos;
import com.pollo.utilities.ProveedorDatosPaginacion;
import com.pollo.view.tblRecibidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;


public class ControladorCargarRecibidos implements ActionListener, TableModelListener{
    private final tblRecibidos tblRec;
    private final ModelQuerysRecibidos model;
    private PaginadorDeTabla<Recibido> paginadorDeTabla;
    
    public final void events(){
        tblRec.comboBoxFilasPermitidas.addActionListener(this);
        tblRec.tblRecibidos.getModel().addTableModelListener(this);
    }
    public ControladorCargarRecibidos(tblRecibidos tbl) throws SQLException{
        this.tblRec = tbl;
        model = new ModelQuerysRecibidos();
        ProveedorDatosPaginacion<Recibido> proveedorDeDatosPaginacion =crearProveedorDeDatos();
        paginadorDeTabla= new PaginadorDeTabla(tblRec.tblRecibidos,proveedorDeDatosPaginacion,new int []{2,4,6},3);
        paginadorDeTabla.crearListadoDeFilasPermitidas(tblRec.paginationPanelR);
        
        tblRec.comboBoxFilasPermitidas=paginadorDeTabla.getComboBoxFilasPermitidas();
        
        events();
        tblRec.comboBoxFilasPermitidas.setSelectedItem(Integer.parseInt("2"));//15 en nuestro caso
    }
    private ProveedorDatosPaginacion<Recibido> crearProveedorDeDatos() throws SQLException{
        List<Recibido> lista = ModelQuerysRecibidos.CargarRegistros();
        return new ProveedorDatosPaginacion<Recibido>() {
            @Override
            public int getTotalRowCount() {
                return lista.size();
            }

            @Override
            public List<Recibido> getRows(int starIndex, int endIndex) {
                return lista.subList(starIndex, endIndex);
            }
        };
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evt =ae.getSource();
        if(evt.equals(tblRec.comboBoxFilasPermitidas)){
            paginadorDeTabla.eventComboBox(tblRec.comboBoxFilasPermitidas);
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        paginadorDeTabla.actualizarBotonesPaginacion();
        
    }
}
