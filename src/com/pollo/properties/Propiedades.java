package com.pollo.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Propiedades {
    public Properties cargarArchivobd() throws FileNotFoundException, IOException{
        Properties propiedades = new Properties();
        InputStream archivo = new FileInputStream("C:\\Users\\mkpol\\OneDrive\\Documentos\\NetBeansProjects\\taller_practico_jsfP\\CRUD_SQLSERVER_FINAL\\src\\crud_sqlserver_final\\resources\\conexionbd.properties");
        propiedades.load(archivo);
        return propiedades;
    }
}
