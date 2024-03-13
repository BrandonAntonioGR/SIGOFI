package com.pollo.DAO.model;

import com.pollo.DAO.entities.Enviado;
import static com.pollo.DAO.model.ModelQuerysEnviados.cerrarConexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelQuerysFiltroEnviados {
    public static ArrayList<Enviado> filtrarFechaGeneracion(Date fech_Generacion) throws SQLException {
        PreparedStatement ps;
        Connection con;
        ResultSet respuesta;
        try {
            con = com.pollo.controller.ControladorConection.getConnectionControler();
            ps = con.prepareStatement("SELECT * FROM TOFICIO_ENVIADOS WHERE fech_Generacion = '" 
                    + fech_Generacion + "' ORDER BY fech_Generacion DESC");
            respuesta = ps.executeQuery();
            ArrayList<Enviado> listaEnv = new ArrayList<>();
            while (respuesta.next()) {
                Enviado env = new Enviado();
                env.setId_Enviado(respuesta.getInt("id_Enviado"));
                env.setFech_Generacion(respuesta.getDate("fech_Generacion"));
                env.setNum_Oficio(respuesta.getString("num_Oficio"));
                env.setFech_Oficio(respuesta.getDate("fech_Oficio"));
                env.setTema(respuesta.getString("tema"));
                env.setComentarios(respuesta.getString("comentarios"));
                listaEnv.add(env);
            }
            cerrarConexion(ps, con, respuesta);
            return listaEnv;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    public static ArrayList<Enviado> filtrarNumeroOficio(String num_Oficio) throws SQLException {
        PreparedStatement ps;
        Connection con;
        ResultSet respuesta;
        try {
            con = com.pollo.controller.ControladorConection.getConnectionControler();
            ps = con.prepareStatement("SELECT * FROM TOFICIO_ENVIADOS WHERE num_Oficio LIKE '%" 
                    + num_Oficio + "%' ORDER BY fech_Generacion DESC");
            respuesta = ps.executeQuery();
            ArrayList<Enviado> listaEnv = new ArrayList<>();
            while (respuesta.next()) {
                Enviado env = new Enviado();
                env.setId_Enviado(respuesta.getInt("id_Enviado"));
                env.setFech_Generacion(respuesta.getDate("fech_Generacion"));
                env.setNum_Oficio(respuesta.getString("num_Oficio"));
                env.setFech_Oficio(respuesta.getDate("fech_Oficio"));
                env.setTema(respuesta.getString("tema"));
                env.setComentarios(respuesta.getString("comentarios"));
                listaEnv.add(env);
            }
            cerrarConexion(ps, con, respuesta);
            return listaEnv;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    public static ArrayList<Enviado> filtrarFechaOficio(Date fech_Oficio) throws SQLException {
        Connection con;
        PreparedStatement ps;
        ResultSet respuesta;
        try {
            con = com.pollo.controller.ControladorConection.getConnectionControler();
            ps = con.prepareStatement("SELECT * FROM TOFICIO_ENVIADOS WHERE fech_Oficio = '" 
                    + fech_Oficio + "' ORDER BY fech_Generacion DESC");
            respuesta = ps.executeQuery();
            ArrayList<Enviado> listaEnv = new ArrayList<>();
            while (respuesta.next()) {
                Enviado env = new Enviado();
                env.setId_Enviado(respuesta.getInt("id_Enviado"));
                env.setFech_Generacion(respuesta.getDate("fech_Generacion"));
                env.setNum_Oficio(respuesta.getString("num_Oficio"));
                env.setFech_Oficio(respuesta.getDate("fech_Oficio"));
                env.setTema(respuesta.getString("tema"));
                env.setComentarios(respuesta.getString("comentarios"));
                listaEnv.add(env);
            }
            cerrarConexion(ps, con, respuesta);
            return listaEnv;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    
    public static ArrayList<Enviado> filtraTema(String tema) throws SQLException {
        PreparedStatement ps;
        Connection con;
        ResultSet respuesta;
        try {
            con = com.pollo.controller.ControladorConection.getConnectionControler();
            ps = con.prepareStatement("SELECT * FROM TOFICIO_ENVIADOS WHERE tema LIKE '%" 
                    + tema + "%' ORDER BY fech_Generacion DESC");
            respuesta = ps.executeQuery();
            ArrayList<Enviado> listaEnv = new ArrayList<>();
            while (respuesta.next()) {
                Enviado env = new Enviado();
                env.setId_Enviado(respuesta.getInt("id_Enviado"));
                env.setFech_Generacion(respuesta.getDate("fech_Generacion"));
                env.setNum_Oficio(respuesta.getString("num_Oficio"));
                env.setFech_Oficio(respuesta.getDate("fech_Oficio"));
                env.setTema(respuesta.getString("tema"));
                env.setComentarios(respuesta.getString("comentarios"));
                listaEnv.add(env);
            }
            cerrarConexion(ps, con, respuesta);
            return listaEnv;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    
    public static ArrayList<Enviado> filtraComentarios(String comentarios) throws SQLException {
        PreparedStatement ps;
        Connection con;
        ResultSet respuesta;
        try {
            con = com.pollo.controller.ControladorConection.getConnectionControler();
            ps = con.prepareStatement("SELECT * FROM TOFICIO_ENVIADOS WHERE comentarios LIKE '%" 
                    + comentarios + "%' ORDER BY fech_Generacion DESC");
            respuesta = ps.executeQuery();
            ArrayList<Enviado> listaEnv = new ArrayList<>();
            while (respuesta.next()) {
                Enviado env = new Enviado();
                env.setId_Enviado(respuesta.getInt("id_Enviado"));
                env.setFech_Generacion(respuesta.getDate("fech_Generacion"));
                env.setNum_Oficio(respuesta.getString("num_Oficio"));
                env.setFech_Oficio(respuesta.getDate("fech_Oficio"));
                env.setTema(respuesta.getString("tema"));
                env.setComentarios(respuesta.getString("comentarios"));
                listaEnv.add(env);
            }
            cerrarConexion(ps, con, respuesta);
            return listaEnv;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    
}

