/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorlexico.automatas.definiciones;

import co.edu.eam.tlf.analizadorlexico.modelo.FlujoCaracteres;
import co.edu.eam.tlf.analizadorlexico.modelo.SimboloLexico;
import java.io.Serializable;

/**
 *Clase que representa un automata.
 * @author aCamilo Andres Ferrer Bustos.
 */
public interface Automata extends Serializable {
    
    /**
     * Metodo que ejecuta la logica del automata sobre el flujo 
     * de caracteres.
     * @param flujo, flujo de caracteres
     * @return 
     */
    SimboloLexico ejecutar(FlujoCaracteres flujo);
}
