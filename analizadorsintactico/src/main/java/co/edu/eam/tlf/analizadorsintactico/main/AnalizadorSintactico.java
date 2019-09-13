/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorsintactico.main;

import co.edu.eam.tlf.analizadorlexico.main.AnalizadorLexico;
import co.edu.eam.tlf.analizadorsintactico.gramatica.implementaciones.FlujoTokens;
import co.edu.eam.tlf.analizadorlexico.modelo.SimboloLexico;
import co.edu.eam.tlf.analizadorsintactico.excepciones.SintacticException;
import co.edu.eam.tlf.analizadorsintactico.gramatica.implementaciones.GramaticaClase;
import co.edu.eam.tlf.analizadorsintactico.sentencias.definicion.Sentencia;
import co.edu.eam.tlf.analizadorsintactico.sentencias.implementaciones.Clase;
import java.util.List;

/**
 *
 * @author caferrerb
 */
public class AnalizadorSintactico {
    
    /**
     * Analizador Lexico
     */
    private final AnalizadorLexico analizadorLexico;
    
    /**
     * Raiz del arbol de derivacion
     */
    private Sentencia unidadCompilacion;

    /**
     * Constrctor
     */
    public AnalizadorSintactico() {
        analizadorLexico=new AnalizadorLexico();
    }
    
    
    /**
     * Metodo para analizar el codigo sintacticamente
     * @param codigo 
     */
    public void analizar(String codigo){
        analizadorLexico.analizar(codigo);
        List<SimboloLexico> tokens=analizadorLexico.getTokens();
        List<SimboloLexico> errores=analizadorLexico.getErrores();
        //si no hay errores, se continua con el analisis semantico.
        if(errores.isEmpty()){
            FlujoTokens flujo=new FlujoTokens(tokens);
            GramaticaClase gramm=new GramaticaClase();
            
            unidadCompilacion=gramm.analizar(null,flujo);
            
        }
    }

    public AnalizadorLexico getAnalizadorLexico() {
        return analizadorLexico;
    }

    public Sentencia getUnidadCompilacion() {
        return unidadCompilacion;
    }
    
    
    
}
