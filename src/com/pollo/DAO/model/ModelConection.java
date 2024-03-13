package com.pollo.DAO.model;

import com.pollo.properties.Propiedades;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ModelConection {
    public static Connection getConnection(){
        Propiedades pr = new Propiedades();
        
        Connection con;
        try {
            String user1="sa";
            String password1="123";
            String url1="jdbc:sqlserver://DESKTOP-DSSMACN:1433; database=Oficios;";
            Properties propiedades=pr.cargarArchivobd();
            String user=propiedades.getProperty("user");
            String pass=propiedades.getProperty("password");
            String url=propiedades.getProperty("url");           
            con = DriverManager.getConnection(url1, user1, password1);
            return con;
        } catch (IOException | SQLException e) {
            System.out.println("No conectado!!");
            System.out.println("Error en :"+ e);
            return null;
        }
    }  
}
