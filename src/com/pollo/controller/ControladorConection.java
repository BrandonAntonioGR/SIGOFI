package com.pollo.controller;

import java.sql.Connection;


public class ControladorConection {
    public static Connection getConnectionControler(){
        return com.pollo.DAO.model.ModelConection.getConnection();
    }
}
