package com.pollo.DAO.entities;

import java.sql.Date;

public class Recibido {
    private int id_Recibidos;
    private Date fechaRecepcion;
    private String numeroOficio;
    private Date fechaOficio;
    private String tema;
    private int id_AtenCono;
    private String atenCono;
    private int id_Estado;
    private String estado;
    private Date fechaTurnado;
    private int id_Atendio;
    private String atendio;
    private String oficioRespuesta;
    private Date fechaRespuesta;
    private String comentarios;

    public Recibido() {
    }

    public Recibido(int id_Recibidos, Date fechaRecepcion, String numeroOficio, Date fechaOficio, String tema, String atenCono, String estado, Date fechaTurnado, String atendio, String oficioRespuesta, Date fechaRespuesta, String comentarios) {
        this.id_Recibidos = id_Recibidos;
        this.fechaRecepcion = fechaRecepcion;
        this.numeroOficio = numeroOficio;
        this.fechaOficio = fechaOficio;
        this.tema = tema;
        this.atenCono = atenCono;
        this.estado = estado;
        this.fechaTurnado = fechaTurnado;
        this.atendio = atendio;
        this.oficioRespuesta = oficioRespuesta;
        this.fechaRespuesta = fechaRespuesta;
        this.comentarios = comentarios;
    }

    public Recibido(Date fechaRecepcion, 
            String numeroOficio, Date fechaOficio, String tema, 
            int id_AtenCono, int id_Estado, Date fechaTurnado, 
            int id_Atendio, String oficioRespuesta, 
            Date fechaRespuesta, String comentarios) {
        this.fechaRecepcion = fechaRecepcion;
        this.numeroOficio = numeroOficio;
        this.fechaOficio = fechaOficio;
        this.tema = tema;
        this.id_AtenCono = id_AtenCono;
        this.id_Estado = id_Estado;
        this.fechaTurnado = fechaTurnado;
        this.id_Atendio = id_Atendio;
        this.oficioRespuesta = oficioRespuesta;
        this.fechaRespuesta = fechaRespuesta;
        this.comentarios = comentarios;
    }

    public int getId_Recibidos() {
        return id_Recibidos;
    }

    public void setId_Recibidos(int id_Recibidos) {
        this.id_Recibidos = id_Recibidos;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getNumeroOficio() {
        return numeroOficio;
    }

    public void setNumeroOficio(String numeroOficio) {
        this.numeroOficio = numeroOficio;
    }

    public Date getFechaOficio() {
        return fechaOficio;
    }

    public void setFechaOficio(Date fechaOficio) {
        this.fechaOficio = fechaOficio;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getId_AtenCono() {
        return id_AtenCono;
    }

    public void setId_AtenCono(int id_AtenCono) {
        this.id_AtenCono = id_AtenCono;
    }

    public String getAtenCono() {
        return atenCono;
    }

    public void setAtenCono(String atenCono) {
        this.atenCono = atenCono;
    }

    public int getId_Estado() {
        return id_Estado;
    }

    public void setId_Estado(int id_Estado) {
        this.id_Estado = id_Estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaTurnado() {
        return fechaTurnado;
    }

    public void setFechaTurnado(Date fechaTurnado) {
        this.fechaTurnado = fechaTurnado;
    }

    public int getId_Atendio() {
        return id_Atendio;
    }

    public void setId_Atendio(int id_Atendio) {
        this.id_Atendio = id_Atendio;
    }

    public String getAtendio() {
        return atendio;
    }

    public void setAtendio(String atendio) {
        this.atendio = atendio;
    }

    public String getOficioRespuesta() {
        return oficioRespuesta;
    }

    public void setOficioRespuesta(String oficioRespuesta) {
        this.oficioRespuesta = oficioRespuesta;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    
}
