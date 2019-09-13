package co.edu.eam.tlf.analizadorlexico.test.comun;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import co.edu.eam.tlf.analizadorlexico.main.AnalizadorLexico;
import co.edu.eam.tlf.analizadorsintactico.excepciones.SintacticException;
import co.edu.eam.tlf.analizadorsintactico.gramatica.definiciones.Gramatica;
import co.edu.eam.tlf.analizadorsintactico.gramatica.implementaciones.FlujoTokens;
import co.edu.eam.tlf.analizadorsintactico.sentencias.definicion.Sentencia;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author swatit
 */
public class PruebaSintactica {

    public PruebaSintactica() {
    }
    
    /**
     * Metodo para ejecutar una grmatica sobre un fragmento de codigo.
     * @param <T>
     * @param clase, Gramatica a probar.
     * @param codigo, codigo a analizar por la gramatica.
     * @return 
     */
    public <T extends Gramatica> Sentencia ejecutarGramatica(Class<T> clase, String codigo) {
        try {
            //se hace un analisis lexico del codigo para extraer los tokens
            AnalizadorLexico lexico = new AnalizadorLexico();
            //se analiza el codigo
            lexico.analizar(codigo);
            //si no hay errores, se hace el ananlisis de la gramatica.
            if (lexico.getErrores().isEmpty()) {
                Gramatica grammar = clase.newInstance();
                FlujoTokens flujo=new FlujoTokens(lexico.getTokens());
                return grammar.analizar(null,flujo);
            }else{
                assertFalse("Errores en el analisis lexico", true);
            }

        } catch (InstantiationException ex) {
            Logger.getLogger(PruebaSintactica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PruebaSintactica.class.getName()).log(Level.SEVERE, null, ex);
        
         }catch(SintacticException exc){
            Assert.assertTrue(exc.getMessage(),false);

        }
        return null;

    }

}
