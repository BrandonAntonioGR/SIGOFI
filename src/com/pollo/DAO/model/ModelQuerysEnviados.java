package com.pollo.DAO.model;

import com.pollo.DAO.entities.Enviado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModelQuerysEnviados {
    public static void cerrarConexion(PreparedStatement ps,Connection con,ResultSet respuesta) throws SQLException{
        ps.close();
        con.close();
        respuesta.close();
    }
    
    public static ArrayList<Enviado> CargarRegistros() throws SQLException{
        PreparedStatement ps;
        Connection con;
        ResultSet respuesta;
        try {
            con= com.pollo.controller.ControladorConection.getConnectionControler();
            ps=con.prepareStatement("SELECT * FROM TOFICIO_ENVIADOS ORDER BY fech_Generacion DESC");
            respuesta = ps.executeQuery();
            ArrayList<Enviado> listaEnv = new ArrayList<>();
            while(respuesta.next()){
                Enviado env= new Enviado();
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
            System.out.println("Error: "+e);
            return null;
        }
    }
    
    public static boolean RegistrarUsuario(Date fech_generacion,String num_oficio, 
            Date fech_oficio,String tema,String comentarios){
        PreparedStatement ps;
        boolean retorno = false;
        Connection con;
        try {
            con = com.pollo.controller.ControladorConection.getConnectionControler();
            ps=con.prepareStatement("INSERT INTO TOFICIO_ENVIADOS(fech_Generacion,num_Oficio,"
                    + "fech_Oficio,tema,comentarios)VALUES(?,?,?,?,?)");
            ps.setDate(1, fech_generacion);
            ps.setString(2, num_oficio);
            ps.setDate(3, fech_oficio);
            ps.setString(4, tema);
            ps.setString(5, comentarios);
            retorno = Boolean.parseBoolean(Integer.toString(ps.executeUpdate()));
            JOptionPane.showMessageDialog(null,"Oficio Enviado registrado correctamente");
            con.close();
            ps.close();
            
            return retorno;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return retorno;
        }
    }
    
    public static Enviado cargadatoModificar(int id){
        PreparedStatement ps;
        Connection con;
        try {
            con= ModelConection.getConnection();
            ps=con.prepareStatement("SELECT fech_Generacion,num_Oficio,"
                    + "fech_Oficio,tema,comentarios FROM TOFICIO_ENVIADOS WHERE id_Enviado="+id);
            ResultSet respuesta = ps.executeQuery();
            Enviado env = new Enviado();
            while(respuesta.next()){
                env.setFech_Generacion(respuesta.getDate("fech_Generacion"));
                env.setNum_Oficio(respuesta.getString("num_Oficio"));
                env.setFech_Oficio(respuesta.getDate("fech_Oficio"));
                env.setTema(respuesta.getString("tema"));
                env.setComentarios(respuesta.getString("comentarios"));
            }
            cerrarConexion(ps, con, respuesta);
            return env;
        } catch (Exception e) {
            System.out.println("Errores: "+e);
            return null;
        }
    }

    public static boolean Actualizar(int id_enviado,Date fech_generacion,String num_oficio, 
            Date fech_oficio,String tema,String comentarios){
        boolean retorno=false;
        Connection con;
        try {
            con = com.pollo.controller.ControladorConection.getConnectionControler();
            PreparedStatement ps=con.prepareStatement("UPDATE TOFICIO_ENVIADOS SET fech_Generacion = '"+fech_generacion+
                    "', num_Oficio='"+num_oficio+"', fech_Oficio =' "+fech_oficio+" ', tema ='"+tema+"', comentarios ='"+
                    comentarios+"' WHERE id_Enviado='"+id_enviado+"'");
            retorno=Boolean.parseBoolean(Integer.toString(ps.executeUpdate()));
            JOptionPane.showMessageDialog(null,"Registro modificado exitosamente");
            con.close();
            ps.close();
            return retorno;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return retorno;
        }
    }
    
    public static boolean Eliminar(int id){
        boolean retorno=false;
        Connection con;
        try {
            con = com.pollo.controller.ControladorConection.getConnectionControler();
            PreparedStatement ps=con.prepareStatement("DELETE FROM TOFICIO_ENVIADOS WHERE id_Enviado='"+id+"'");
            retorno=Boolean.parseBoolean(Integer.toString(ps.executeUpdate()));
            JOptionPane.showMessageDialog(null,"Registro eliminado exitosamente");
            return retorno;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return retorno;
        }
    }
}
