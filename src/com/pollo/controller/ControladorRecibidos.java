package com.pollo.controller;

import com.pollo.DAO.entities.Recibido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ControladorRecibidos {
    public static ArrayList CargaRecibidos() throws SQLException{
        return com.pollo.DAO.model.ModelQuerysRecibidos.CargarRegistros();
    }
}
