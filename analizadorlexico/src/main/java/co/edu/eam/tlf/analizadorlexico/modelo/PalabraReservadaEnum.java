/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorlexico.modelo;

/**
 *
 * @author user
 */
public enum PalabraReservadaEnum {
    
    IF("if"),
    FOR("for"),
    CLASS("class"),
    VAR("mama"),
    PUBLIC("public"),PRIVATE("private"),INT("int"),DOUBLE("double");
    
    /**
     * lexema de la plabra reservada.
     */
    private String lexema;

    private PalabraReservadaEnum(String lexema) {
        this.lexema = lexema;
    }
    
    /**
     * Getter del lexema
     * @return 
     */
    public String getLexema(){
        return lexema;
    }
    
}
