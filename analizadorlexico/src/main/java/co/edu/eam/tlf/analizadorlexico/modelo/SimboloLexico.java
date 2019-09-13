/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorlexico.modelo;

import java.io.Serializable;

/**
 *Clase que representa un lexema del lenguaje
 * @author Camilo Andres Ferrer Bustos
 */
public class SimboloLexico implements Serializable {
    
    /**
     * Representacion textual del simbolo
     */
    private String lexema;
    /**
     * Fila en la que se encuentra el lexema
     */
    private int fila;
    /**
     * Columna donde se encuentra el lexema
     */
    private int columna;
    
    /**
     * Tipo de simpbolo lexico.
     */
    private TipoLexemaEnum tipo;

    /**
     * determina si el lexema esta erroneo.
     */
    private boolean error;
    /**
     * COnstructor por defecto
     */
    public SimboloLexico() {
    }

    /**
     * COnstructor
     * @param lexema
     * @param fila
     * @param columna
     * @param tipo 
     */
    public SimboloLexico(String lexema, int fila, int columna, TipoLexemaEnum tipo) {
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
        this.tipo = tipo;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public TipoLexemaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoLexemaEnum tipo) {
        this.tipo = tipo;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
    
    
    
    
    
    
}
