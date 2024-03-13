package crud_sqlserver_final;

import com.pollo.controller.CoOpciones;
import com.pollo.view.Prueba;
import com.pollo.view.VistaEnviados;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CRUD_SQLSERVER_FINAL {


    public static void main(String[] args) throws SQLException {
        CoOpciones co = new CoOpciones();
        co.menu();
        //Prueba p=new Prueba();
        //p.setVisible(true);
        
        
        //codigo para remplazar datos estaticos de la plantilla
        String texto="Con /NOMBRE_CTE/ chan se consigue dinero hasta /DINERO/";
        String patron1="/NOMBRE_CTE/1";
        Pattern patronNombre=Pattern.compile(patron1);
        Matcher similitudNombre =patronNombre.matcher(texto);
        String textoDelObjetoNombre="Java";
        String textoNuevo1=similitudNombre.replaceAll(textoDelObjetoNombre);
        
        String patron2="dinero";
        Pattern patronDinero=Pattern.compile(patron2);
        Matcher similitudDinero =patronDinero.matcher(textoNuevo1);
        String textoDelObjetoDinero="20,0";
        String textoNuevo2=similitudDinero.replaceAll(textoDelObjetoDinero);
        System.out.println(textoNuevo2);
        
        
        
    }
    
}
