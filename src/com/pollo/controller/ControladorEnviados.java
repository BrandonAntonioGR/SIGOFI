package com.pollo.controller;

import com.pollo.DAO.entities.Enviado;
import com.pollo.DAO.model.ModelQuerysEnviados;
import com.pollo.utilities.ProveedorDatosPaginacion;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ControladorEnviados {

//    Alta de datos
    public static boolean RegistraEnviado(Enviado env){
        return com.pollo.DAO.model.ModelQuerysEnviados.RegistrarUsuario(env.getFech_Generacion(), 
                env.getNum_Oficio(), env.getFech_Oficio(), env.getTema(), env.getComentarios());
    }

    public static Enviado CargadatosModificaEnviado(int ID){
        return com.pollo.DAO.model.ModelQuerysEnviados.cargadatoModificar(ID);
    }
        public static boolean ModificaEnviado(Enviado env){
        return com.pollo.DAO.model.ModelQuerysEnviados.Actualizar(env.getId_Enviado(),env.getFech_Generacion(), 
                env.getNum_Oficio(), env.getFech_Oficio(), env.getTema(), env.getComentarios());
    }
    public static boolean Eliminar(int ID){
        return com.pollo.DAO.model.ModelQuerysEnviados.Eliminar(ID);
    }

}
