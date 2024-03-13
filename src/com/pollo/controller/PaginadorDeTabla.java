package com.pollo.controller;

import com.pollo.utilities.ModeloDeTabla;
import com.pollo.utilities.ProveedorDatosPaginacion;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class PaginadorDeTabla<T> {

    private JTable tabla;
    private ProveedorDatosPaginacion<T> provedorDeDatosPaginacion;
    private int[] arrayFilasPermitidas;
    private int filaPermitida;
    private ModeloDeTabla<T> modeloDeTabla;
    private int paginaActual = 1;
    private JComboBox<Integer> comboBoxFilasPermitidas;
    private JPanel panelPaginacionBotones;
    private int limiteBotonesPaginadores=9;

    public PaginadorDeTabla(JTable tablaEnviados, ProveedorDatosPaginacion<T> provedorDeDatosPaginacion,
            int[] arrayFilasPermitidas, int filaPermitida) {
        this.tabla = tablaEnviados;
        this.provedorDeDatosPaginacion = provedorDeDatosPaginacion;
        this.arrayFilasPermitidas = arrayFilasPermitidas;
        this.filaPermitida = filaPermitida;
        init();
    }

    private void init() {
        inicializarModeloDeTabla();
        paginar();
    }

    private void inicializarModeloDeTabla() {
        try {
            modeloDeTabla = (ModeloDeTabla<T>) tabla.getModel();
        } catch (Exception e) {
            System.out.println("Error metodo inicializarModeloDeTabla()" + e);
        }
    }
    
    private void paginar() {
        int inicio = (paginaActual - 1) * filaPermitida;
        int finalizacion = inicio + filaPermitida;
        if (finalizacion > provedorDeDatosPaginacion.getTotalRowCount()) {
            finalizacion = provedorDeDatosPaginacion.getTotalRowCount();
        }
        List<T> listaEnv = provedorDeDatosPaginacion.getRows(inicio, finalizacion);
        modeloDeTabla.setLista(listaEnv);
        modeloDeTabla.fireTableDataChanged();
    }
    
    public void crearListadoDeFilasPermitidas(JPanel panelPaginador) {
        panelPaginacionBotones = new JPanel(new GridLayout(1, limiteBotonesPaginadores, 3, 3));
        panelPaginador.add(panelPaginacionBotones);

        if (arrayFilasPermitidas != null) {
            Integer array[] = new Integer[arrayFilasPermitidas.length];
            for (int i = 0; i < arrayFilasPermitidas.length; i++) {
                array[i]=arrayFilasPermitidas[i];
            }
            comboBoxFilasPermitidas=new JComboBox<>(array);
            panelPaginador.add(Box.createHorizontalStrut(15));
            panelPaginador.add(new JLabel("Numero de Filas:"));
            panelPaginador.add(comboBoxFilasPermitidas);
        }

    }
    
    public void eventComboBox(JComboBox<Integer> paginaComboBox){
        int filaInicialPagina=((paginaActual-1)*filaPermitida)+1;
        filaPermitida=(Integer) paginaComboBox.getSelectedItem();
        paginaActual=((filaInicialPagina-1)/filaPermitida)+1;
        paginar();
    }

    public JComboBox<Integer> getComboBoxFilasPermitidas() {
        return comboBoxFilasPermitidas;
    }

    public void setComboBoxFilasPermitidas(JComboBox<Integer> comboBoxFilasPermitidas) {
        this.comboBoxFilasPermitidas = comboBoxFilasPermitidas;
    }
    private void agregarBotonesPaginacion(JPanel panelPadre,int numeroPagina){
        JToggleButton toggleButton = new JToggleButton(Integer.toString(numeroPagina));
        toggleButton.setMargin(new Insets(1, 3, 1, 3));
        panelPadre.add(toggleButton);
        if(numeroPagina==paginaActual){
            toggleButton.setSelected(true);
        }
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginaActual=Integer.parseInt(e.getActionCommand());
                paginar();
            }
        });
    }
    private void agregaRangoBotonesPaginacion(JPanel panelPadre,int inicio,int finalizacion){
        int init=inicio;
        for(inicio=init;inicio<=finalizacion;inicio++){
            agregarBotonesPaginacion(panelPadre,inicio);
        }
    }
    private JLabel crearElipses(){
        return new JLabel("...",SwingConstants.CENTER);
    }
    public void actualizarBotonesPaginacion(){
        panelPaginacionBotones.removeAll();
        int totalFilas =provedorDeDatosPaginacion.getTotalRowCount();
        int paginas =(int)Math.ceil((double)totalFilas/filaPermitida);
        if(paginas>limiteBotonesPaginadores){
            agregarBotonesPaginacion(panelPaginacionBotones, 1);
            
            if(paginaActual<=(limiteBotonesPaginadores+1/2)){
                agregaRangoBotonesPaginacion(panelPaginacionBotones, 2, limiteBotonesPaginadores-2);
                panelPaginacionBotones.add(crearElipses());
                agregarBotonesPaginacion(panelPaginacionBotones, paginas);
            }else if(paginaActual>(paginas-((limiteBotonesPaginadores+1)/2)) ){
                panelPaginacionBotones.add(crearElipses());
                agregaRangoBotonesPaginacion(panelPaginacionBotones, paginas-limiteBotonesPaginadores+3, paginas);
            }else{
                panelPaginacionBotones.add(crearElipses());
                int inicio=paginaActual-(limiteBotonesPaginadores-4)/2;
                int finalizacion=inicio+limiteBotonesPaginadores-5;
                agregaRangoBotonesPaginacion(panelPaginacionBotones, inicio, finalizacion);
                panelPaginacionBotones.add(crearElipses());
                agregarBotonesPaginacion(panelPaginacionBotones, paginas);
            }
        }else{
            agregaRangoBotonesPaginacion(panelPaginacionBotones, 1, paginas);
        }
        panelPaginacionBotones.getParent().validate();
        panelPaginacionBotones.getParent().repaint();
    }
}
