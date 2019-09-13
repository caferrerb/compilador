/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorlexico.automatas.implementaciones;

import co.edu.eam.tlf.analizadorlexico.modelo.FlujoCaracteres;
import co.edu.eam.tlf.analizadorlexico.modelo.PalabraReservadaEnum;
import co.edu.eam.tlf.analizadorlexico.modelo.SimboloLexico;
import co.edu.eam.tlf.analizadorlexico.modelo.TipoLexemaEnum;

/**
 * Clase que analiza las palabras reservadas.
 * @author caferrerb
 */
public class AutomataModificadorAcceso extends AutomataPalabraReservada{

    /**
     * Constructor...
     */
    public AutomataModificadorAcceso() {
        super(TipoLexemaEnum.MOD_ACCESO, null);
    }

    /**
     * Determina si en el flujo de caracteres esta alguno de los modificadores
     * de acceso
     * @param flujo
     * @return el simbolo.
     */
    @Override
    public SimboloLexico ejecutar(FlujoCaracteres flujo) {
        
        if(validarToken(PalabraReservadaEnum.PRIVATE.getLexema(), flujo)){
            return new SimboloLexico(PalabraReservadaEnum.PRIVATE.getLexema(), 
                    flujo.getFila(), flujo.getColumna(), tipoLexema);
        }
        
        if(validarToken(PalabraReservadaEnum.PUBLIC.getLexema(), flujo)){
            return new SimboloLexico(PalabraReservadaEnum.PUBLIC.getLexema(), 
                    flujo.getFila(), flujo.getColumna(), tipoLexema);
        }
        return null;
    }
    
    
    
}
