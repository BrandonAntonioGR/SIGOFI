package com.pollo.DAO.entities;

import java.util.ArrayList;
import java.util.List;

public class lstEnviados {
    ArrayList<Enviado> lstEnviadosA = new ArrayList();
    List<Enviado> lstEnviadosL = new ArrayList();

    public ArrayList<Enviado> getLstEnviadosA() {
        return lstEnviadosA;
    }

    public void setLstEnviadosA(ArrayList<Enviado> lstEnviadosA) {
        this.lstEnviadosA = lstEnviadosA;
    }

    public List<Enviado> getLstEnviadosL() {
        return lstEnviadosL;
    }

    public void setLstEnviadosL(List<Enviado> lstEnviadosL) {
        this.lstEnviadosL = lstEnviadosL;
    }
    
    
}
