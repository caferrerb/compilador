/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.guicompilador.vista.controlador;

import co.edu.eam.tlf.analizadorlexico.modelo.SimboloLexico;
import co.edu.eam.tlf.analizadorsintactico.excepciones.SintacticException;
import co.edu.eam.tlf.analizadorsintactico.main.AnalizadorSintactico;
import co.edu.eam.tlf.analizadorsintactico.sentencias.definicion.Sentencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author swatit
 */
public class ControladorCompilador {

    /**
     * Analizador
     */
    private AnalizadorSintactico analizaddorSintactico;

    /**
     * Lexemas encontrados..
     */
    private List<SimboloLexico> tokens;

    /**
     * Texto de la consola de errores
     */
    private StringBuilder textoConsola;

    /**
     * Raiz del arbol.
     */
    private Sentencia raiz;
    /**
     * constructor
     *
     */
    public ControladorCompilador() {
        analizaddorSintactico = new AnalizadorSintactico();
        tokens = new ArrayList<>();
    }

    /**
     * Metodod para analizar el codigo lexica y sintacticamente
     *
     * @param codigo
     */
    public String ejecutar(String codigo) {
         textoConsola = new StringBuilder("");
        try {
            analizaddorSintactico.analizar(codigo);
            tokens = analizaddorSintactico.getAnalizadorLexico().getTokens();
            raiz=analizaddorSintactico.getUnidadCompilacion();
            raiz.llenarHijos();
                        
            final List<SimboloLexico> errores = analizaddorSintactico.getAnalizadorLexico().getErrores();
            llenarConsolaErrores(errores);
            return raiz.parse();

        } catch (SintacticException exc) {
            textoConsola.append(exc.getMessage()).append("\n");
            return null;
        }
    }

    /**
     * MEtodo par allenar la consola con los errores.
     *
     * @param errores
     */
    private void llenarConsolaErrores(final List<SimboloLexico> errores) {
        for (SimboloLexico simbolo : errores) {
            textoConsola.append(String.format("Simbolo desconocido en (%d,%d):%s", simbolo.getFila() + 1, simbolo.getColumna() + 1, simbolo.getLexema()));
            textoConsola.append("\n");
        }
    }

    public List<SimboloLexico> getTokens() {
        return tokens;
    }

    public StringBuilder getTextoConsola() {
        return textoConsola;
    }

    public Sentencia getRaiz() {
        return raiz;
    }
    
    

}
