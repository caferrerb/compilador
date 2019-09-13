/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorsintactico.gramatica.implementaciones;

import co.edu.eam.tlf.analizadorlexico.modelo.SimboloLexico;
import java.util.List;

/**
 *Clase que representa al flujo de caracteres que se analiza.
 * @author Camilo Andres Ferrer Bustos
 */
public class FlujoTokens {
    
    /**
     * cadena que representa al codigo a analizar.
     */
    private final List<SimboloLexico> lexemas;
    
    /**
     * Posicion actual donde va el flujo de caracteres
     */
    private int posActual;
    /**
     * Posicion temporal para backtrack.
     */
    private int posTemp;
    
   
    /**
     * Constructor
     * @param lista, lista de tokens.... 
     */
    public FlujoTokens(List<SimboloLexico> lista) {
        this.lexemas=lista;
    }
    
    /**
     * Metodo que avanza una posicion en el flujo de caracteres
     * y retorna una posicion.
     * @return 
     */
    public SimboloLexico avanzar(){
        posActual++;
        
       
        return getTokenActual();
    }
    
    /**
     * Metodo para retornar el caracter en el que va el flujo de caracteres.
     * @return el caracter actual.
     */
    public SimboloLexico getTokenActual(){
        if(posActual>=lexemas.size()){
            return null;
        }
        return lexemas.get(posActual);
    }
    
    /**
     * MEtodo que almacena las posiciones de fila, 
     * columna y posActual del flujo de caracteres. 
     * estas posiciones almacenadas se usan luego en backtracking.
     */
    public void guardarPosicion(){
        posTemp=posActual;
    }
    
    /**
     * metodo para devolver las posiciones al estado 
     * almacenado en el arreglo temporal.
     */
    public void backTrack(){
        
        posActual=posTemp;
    }

    
    
    
    
    
}
