package com.pollo.DAO.entities;

import java.util.ArrayList;
import java.util.List;

public class lstRecibidos {
    ArrayList<Recibido> lstRecibidosA = new ArrayList();
    List<Recibido> lstRecibidosL = new ArrayList();

    public ArrayList<Recibido> getLstRecibidosA() {
        return lstRecibidosA;
    }

    public void setLstRecibidosA(ArrayList<Recibido> lstRecibidosA) {
        this.lstRecibidosA = lstRecibidosA;
    }

    public List<Recibido> getLstRecibidosL() {
        return lstRecibidosL;
    }

    public void setLstRecibidosL(List<Recibido> lstRecibidosL) {
        this.lstRecibidosL = lstRecibidosL;
    }
    
    
}
