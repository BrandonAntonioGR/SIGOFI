package com.pollo.DAO.entities;

import java.sql.Date;

/*
<!-- https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api -->
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.4.0-b180830.0359</version>
</dependency>
*/
public class Enviado {
    private int id_Enviado;
    private Date fech_Generacion;
    private String num_Oficio;
    private Date fech_Oficio;
    private String tema;
    private String comentarios;

    public Enviado() {
    }
    
    public Enviado(int id_Enviado, Date fech_Generacion, String num_Oficio, 
            Date fech_Oficio, String tema, String comentarios) {
        this.id_Enviado=id_Enviado;
        this.fech_Generacion=fech_Generacion;
        this.num_Oficio=num_Oficio;
        this.fech_Oficio=fech_Oficio;
        this.tema=tema;
        this.comentarios=comentarios;
    }
    public Enviado(Date fech_Generacion, String num_Oficio, 
            Date fech_Oficio, String tema, String comentarios) {
        this.fech_Generacion=fech_Generacion;
        this.num_Oficio=num_Oficio;
        this.fech_Oficio=fech_Oficio;
        this.tema=tema;
        this.comentarios=comentarios;
    }
    public Enviado(int id_Enviado) {
        this.id_Enviado=id_Enviado;
    }

    public int getId_Enviado() {
        return id_Enviado;
    }

    public void setId_Enviado(int id_Enviado) {
        this.id_Enviado = id_Enviado;
    }

    public Date getFech_Generacion() {
        return fech_Generacion;
    }

    public void setFech_Generacion(Date fech_Generacion) {
        this.fech_Generacion = fech_Generacion;
    }

    public String getNum_Oficio() {
        return num_Oficio;
    }

    public void setNum_Oficio(String num_Oficio) {
        this.num_Oficio = num_Oficio;
    }

    public Date getFech_Oficio() {
        return fech_Oficio;
    }

    public void setFech_Oficio(Date fech_Oficio) {
        this.fech_Oficio = fech_Oficio;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
}
