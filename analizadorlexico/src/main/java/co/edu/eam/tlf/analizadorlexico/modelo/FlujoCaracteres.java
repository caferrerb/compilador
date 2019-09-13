/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorlexico.modelo;

/**
 *Clase que representa al flujo de caracteres que se analiza.
 * @author Camilo Andres Ferrer Bustos
 */
public class FlujoCaracteres {
    
    /**
     * cadena que representa al codigo a analizar.
     */
    private String codigo;
    
    /**
     * Posicion actual donde va el flujo de caracteres
     */
    private int posActual;
    
    /**
     * Flia actual
     */
    private int fila;
    
    /**
     * Columna actual
     */
    private int columna;
    
    
    /**
     * arreglo donde se almacenaran temporalmente las 
     * posiciones actuales del flujo de caracteres para 
     * hacer el backtracking.
     */
    private int[] posTemp;
    

    /**
     * Constructor
     * @param codigo, cadena que administrara el flujo. 
     */
    public FlujoCaracteres(String codigo) {
        this.codigo = codigo;
        this.posActual = 0;
        posTemp=new int[3];
    }
    
    /**
     * Metodo que avanza una posicion en el flujo de caracteres
     * y retorna una posicion.
     * @return 
     */
    public char avanzar(){
        posActual++;
        if(posActual>=codigo.length()){
            return (char)0;
        }
        columna++;
        if(codigo.charAt(posActual)=='\n'){
            fila++;
            columna=0;
            
        }
        if(codigo.charAt(posActual)=='\t'){
            columna+=4;
        }
        return getCaracterActual();
    }
    
    /**
     * Metodo para retornar el caracter en el que va el flujo de caracteres.
     * @return el caracter actual.
     */
    public char getCaracterActual(){
        if(posActual>=codigo.length()){
            return 0;
        }
        return codigo.charAt(posActual);
    }
    
    /**
     * MEtodo que almacena las posiciones de fila, 
     * columna y posActual del flujo de caracteres. 
     * estas posiciones almacenadas se usan luego en backtracking.
     */
    public void guardarPosiciones(){
        posTemp[0]=fila;
        posTemp[1]=columna;
        posTemp[2]=posActual;
    }
    
    /**
     * metodo para devolver las posiciones al estado 
     * almacenado en el arreglo temporal.
     */
    public void backTrack(){
        fila=posTemp[0];
        columna=posTemp[1];
        posActual=posTemp[2];
    }

    /**
     * Metodo que retorna la fila
     * @return 
     */
    public int getFila() {
        return fila;
    }
    
    /**
     * metodo que retorna la columna actual donde va el codigo
     * @return 
     */
    public int getColumna(){
        return columna;
    }
    
    
    
    
}
