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
 * Clase que analiza las palabras reservadas del tipo Tipo_DE_DATO.
 * @author caferrerb
 */
public class AutomataTipoDatoPrimitivo extends AutomataPalabraReservada{

    /**
     * Constructor...
     */
    public AutomataTipoDatoPrimitivo() {
        super(TipoLexemaEnum.TIPO_DATO, null);
    }

    /**
     * Determina si en el flujo de caracteres esta alguno de los modificadores
     * de acceso
     * @param flujo
     * @return el simbolo.
     */
    @Override
    public SimboloLexico ejecutar(FlujoCaracteres flujo) {
        
        if(validarToken(PalabraReservadaEnum.INT.getLexema(), flujo)){
            return new SimboloLexico(PalabraReservadaEnum.INT.getLexema(), 
                    flujo.getFila(), flujo.getColumna(), tipoLexema);
        }
        
        if(validarToken(PalabraReservadaEnum.DOUBLE.getLexema(), flujo)){
            return new SimboloLexico(PalabraReservadaEnum.DOUBLE.getLexema(), 
                    flujo.getFila(), flujo.getColumna(), tipoLexema);
        }
        return null;
    }
    
    
    
}
