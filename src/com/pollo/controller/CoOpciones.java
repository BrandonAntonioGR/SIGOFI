package com.pollo.controller;

import com.pollo.view.VistaEnviados;
import com.pollo.view.tblRecibidos;
import com.pollo.view.altaEnviados;
import com.pollo.view.menu;
import com.pollo.view.modificaEnviados;
import java.sql.SQLException;


public class CoOpciones {
    public void tablaEnviados() throws SQLException{
        VistaEnviados usu= new VistaEnviados();
        usu.setVisible(true);
    }
    public void tablaRecibidos() throws SQLException{
        tblRecibidos usu= new tblRecibidos();
        usu.setVisible(true);
    }
    public void altaEnviados(){
        altaEnviados ae = new altaEnviados();
        ae.setVisible(true);
    }
    public void modificaEnviados(int fila){
        modificaEnviados me = new modificaEnviados(fila);
        me.setVisible(true);
    }
    public void menu(){
        menu m = new menu();
        m.setVisible(true);
    }
}
