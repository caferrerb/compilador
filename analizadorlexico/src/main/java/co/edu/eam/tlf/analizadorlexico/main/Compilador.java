/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorlexico.main;

import co.edu.eam.tlf.analizadorlexico.modelo.SimboloLexico;
import java.util.List;
import java.util.Observable;

/**
 *Clase que implementa toda la logica del compilador.
 * @author Camilo Andres Ferrer Bustos.
 */
public class Compilador {
    
    /**
     * Analizador lexico.
     */
    private final AnalizadorLexico analizadorLexico;
    /**
     * Codigo a analizar.
     */
    private String codigo;

    /**
     * Constructor
     */
    public Compilador() {
        analizadorLexico=new AnalizadorLexico();
    }
    
    /**
     * Metodo para ejecutar el codigo.
     */
    public void ejecutar(String codigo){
        analizadorLexico.analizar(codigo);
        List<SimboloLexico> tokens=analizadorLexico.getTokens();
        List<SimboloLexico> errores=analizadorLexico.getErrores();
        //si no hay errores, se continua con el analisis semantico.
        if(errores.isEmpty()){
            //TODO:analisis sintactico.
        }
        
                
    }

    public AnalizadorLexico getAnalizadorLexico() {
        return analizadorLexico;
    }
    
    
    
     
    
    
    
    
    
    
}
