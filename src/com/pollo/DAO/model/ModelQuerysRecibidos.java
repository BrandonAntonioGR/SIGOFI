package com.pollo.DAO.model;

import com.pollo.DAO.entities.Recibido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModelQuerysRecibidos {

    public static void cerrarConexion(PreparedStatement ps, Connection con, ResultSet respuesta) throws SQLException {
        ps.close();
        con.close();
        respuesta.close();
    }

    public static ArrayList<Recibido> CargarRegistros() throws SQLException {
        PreparedStatement ps;
        Connection con;
        ResultSet respuesta;
        try {
            con = com.pollo.controller.ControladorConection.getConnectionControler();
            ps = con.prepareStatement("Select TOFICIO_RECIBIDOS.id_Recibido, \n"
                    + "TOFICIO_RECIBIDOS.fechaRecepcion,\n"
                    + "TOFICIO_RECIBIDOS.numeroOficio, \n"
                    + "TOFICIO_RECIBIDOS.fechaOficio,\n"
                    + "TOFICIO_RECIBIDOS.tema,\n"
                    + "TOFICIO_CATALOGO_ATENCONO.descAtenCono, \n"
                    + "TOFICIO_CATALOGO_ESTADO.descEstado, \n"
                    + "TOFICIO_RECIBIDOS.fechaTurnado,\n"
                    + "TOFICIO_CATALOGO_ATENDIO.descAtendio,\n"
                    + "TOFICIO_RECIBIDOS.oficioRespuesta, \n"
                    + "TOFICIO_RECIBIDOS.fechaRespuesta,\n"
                    + "TOFICIO_RECIBIDOS.COMENTARIOS \n"
                    + "FROM TOFICIO_RECIBIDOS \n"
                    + "INNER JOIN TOFICIO_CATALOGO_ATENCONO \n"
                    + "ON TOFICIO_RECIBIDOS.id_AtenCono = TOFICIO_CATALOGO_ATENCONO.id_AtenCono \n"
                    + "INNER JOIN TOFICIO_CATALOGO_ESTADO \n"
                    + "ON TOFICIO_RECIBIDOS.id_Estado = TOFICIO_CATALOGO_ESTADO.id_Estado \n"
                    + "INNER JOIN TOFICIO_CATALOGO_ATENDIO \n"
                    + "ON TOFICIO_RECIBIDOS.id_Atendio = TOFICIO_CATALOGO_ATENDIO.id_Atendio\n"
                    + "ORDER BY fechaRecepcion DESC;");
            respuesta = ps.executeQuery();
            ArrayList<Recibido> listaRec = new ArrayList<>();
            while (respuesta.next()) {
                Recibido rec = new Recibido();
                rec.setId_Recibidos(respuesta.getInt("id_Recibido"));
                rec.setFechaRecepcion(respuesta.getDate("fechaRecepcion"));
                rec.setNumeroOficio(respuesta.getString("numeroOficio"));
                rec.setFechaOficio(respuesta.getDate("fechaOficio"));
                rec.setTema(respuesta.getString("tema"));
                rec.setAtenCono(respuesta.getString("descAtenCono"));
                rec.setEstado(respuesta.getString("descEstado"));
                rec.setFechaTurnado(respuesta.getDate("fechaTurnado"));
                rec.setAtendio(respuesta.getString("descAtendio"));
                rec.setOficioRespuesta(respuesta.getString("oficioRespuesta"));
                rec.setFechaRespuesta(respuesta.getDate("fechaRespuesta"));
                rec.setComentarios(respuesta.getString("comentarios"));
                listaRec.add(rec);
            }
            cerrarConexion(ps, con, respuesta);
            return listaRec;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    public static boolean RegistrarUsuario(Date fechaRecepcion,String numeroOficio, 
            Date fechaOficio,String tema,int atenCono,int estado,Date fechaTurnado,
            int atendio,String oficioRespuesta,Date fechaRespuesta,String comentarios){
        PreparedStatement ps;
        boolean retorno = false;
        Connection con;
        try {
            con = com.pollo.controller.ControladorConection.getConnectionControler();
            ps=con.prepareStatement("INSERT INTO TOFICIO_RECIBIDOS(fechaRecepcion,numeroOficio,"
                    + "fechaOficio,tema,id_AtenCono,id_Estado,fechaTurnado,id_Atendio,oficioRespuesta,"
                    + "fechaRespuesta,comentarios)VALUES(?,?,?,?,?)");
            ps.setDate(1, fechaRecepcion);
            ps.setString(2, numeroOficio);
            ps.setDate(3, fechaOficio);
            ps.setString(4, tema);
            ps.setInt(5, atenCono);
            ps.setInt(6, estado);
            ps.setDate(7, fechaTurnado);
            ps.setInt(8, atendio);
            ps.setString(9, oficioRespuesta);
            ps.setDate(10, fechaRespuesta);
            ps.setString(11, comentarios);
            
            retorno = Boolean.parseBoolean(Integer.toString(ps.executeUpdate()));
            JOptionPane.showMessageDialog(null,"Oficio Recibido registrado correctamente");
            con.close();
            ps.close();
            
            return retorno;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return retorno;
        }
    }
    
    public static Recibido cargadatoModificar(int id){
        PreparedStatement ps;
        Connection con;
        try {
            con= ModelConection.getConnection();
            ps=con.prepareStatement("SELECT * FROM TOFICIO_RECIBIDOS WHERE id_Recibido="+id);
            ResultSet respuesta = ps.executeQuery();
            Recibido rec = new Recibido();
            while(respuesta.next()){
                rec.setFechaRecepcion(respuesta.getDate("fechaRecepcion"));
                rec.setNumeroOficio(respuesta.getString("numeroOficio"));
                rec.setFechaOficio(respuesta.getDate("fechaOficio"));
                rec.setTema(respuesta.getString("tema"));
                rec.setId_AtenCono(respuesta.getInt("id_AtenCono"));
                rec.setId_Estado(respuesta.getInt("id_Estado"));
                rec.setFechaTurnado(respuesta.getDate("fechaTurnado"));
                rec.setId_Atendio(respuesta.getInt("id_Atendio"));
                rec.setOficioRespuesta(respuesta.getString("oficioRespuesta"));
                rec.setFechaRespuesta(respuesta.getDate("fechaRespuesta"));
                rec.setComentarios(respuesta.getString("comentarios"));
            }
            cerrarConexion(ps, con, respuesta);
            return rec;
        } catch (Exception e) {
            System.out.println("Errores: "+e);
            return null;
        }
    }

    public static boolean Actualizar(int id_Recibido,Date fechaRecepcion,String numeroOficio, 
            Date fechaOficio,String tema,int  id_AtenCono,int id_Estado,Date fechaTurnado,
            int id_Atendio,String oficioRespuesta, Date fechaRespuesta,String comentarios){
        boolean retorno=false;
        Connection con;
        try {
            con = com.pollo.controller.ControladorConection.getConnectionControler();
            PreparedStatement ps=con.prepareStatement("UPDATE TOFICIO_RECIBIDOS SET fechaRecepcion = '"
                    +fechaRecepcion+"', numeroOficio='"+numeroOficio+"', fechaOficio =' "+fechaOficio
                    +" ', tema ='"+tema+"', id_AtenCono='"+id_AtenCono+"', id_Estado='"+id_Estado
                    +" ', fechaTurnado ='"+fechaTurnado+"', id_Atendio='"+id_Atendio+"', oficioRespuesta='"+oficioRespuesta
                    +" ', fechaRespuesta ='"+fechaRespuesta+"', comentarios ='"+
                    comentarios+"' WHERE id_Recibido='"+id_Recibido+"'");
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
            PreparedStatement ps=con.prepareStatement("DELETE FROM TOFICIO_RECIBIDOS WHERE id_Recibido='"+id+"'");
            retorno=Boolean.parseBoolean(Integer.toString(ps.executeUpdate()));
            JOptionPane.showMessageDialog(null,"Registro eliminado exitosamente");
            return retorno;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return retorno;
        }
    }
    
    
}
