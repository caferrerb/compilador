/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorlexico.automatas.implementaciones;

import co.edu.eam.tlf.analizadorlexico.automatas.definiciones.Automata;
import co.edu.eam.tlf.analizadorlexico.modelo.FlujoCaracteres;
import co.edu.eam.tlf.analizadorlexico.modelo.SimboloLexico;
import co.edu.eam.tlf.analizadorlexico.modelo.TipoLexemaEnum;

/**
 *Clase Utilitaria para analizar palabras reservadas.
 * @author Camilo Andres Ferrer Bustos.
 */
public class AutomataPalabraReservada implements Automata{

    /**
     * Palabra a analizar.
     */
    protected TipoLexemaEnum tipoLexema;
    
    /**
     * Lexema.
     */
    protected String palabra;

    /**
     * Constructor
     * @param tipoLexema, clasificacion
     * @param palabra , lexema.
     */
    public AutomataPalabraReservada(TipoLexemaEnum tipoLexema, String palabra) {
        this.tipoLexema = tipoLexema;
        this.palabra = palabra;
    }
    
    
    
    
    
    /**
     * Matoro para validar si dentro del flujo de caracteres se encuentra 
     * una palabra dada.
     * @param palabra, palabra a buscar.
     * @param flujoCaracteres, flujo de caracteres.
     * @return true, si esta la palabra.
     */
    protected boolean validarToken(String palabra,FlujoCaracteres flujoCaracteres){
        flujoCaracteres.guardarPosiciones();
        //se recorre la cadena buscando la cadena en el flujo.
        for(char caracter: palabra.toCharArray()){
           if(caracter==flujoCaracteres.getCaracterActual()){
               flujoCaracteres.avanzar();
           }else{
               flujoCaracteres.backTrack();
               return false;//no esta la palabra en el flujo.
           }
        }
        return true;
    }

    @Override
    public SimboloLexico ejecutar(FlujoCaracteres flujo) {
        if(validarToken(palabra, flujo)){
            return new SimboloLexico(palabra, flujo.getFila(), flujo.getColumna(), tipoLexema);
        }
        return null;
    }
    
}
