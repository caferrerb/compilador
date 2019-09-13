/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorlexico.automatas.implementaciones;

import co.edu.eam.tlf.analizadorlexico.modelo.PalabraReservadaEnum;
import co.edu.eam.tlf.analizadorlexico.modelo.TipoLexemaEnum;

/**
 *
 * @author caferrerb
 */
public class AutomataLlaveCerrada extends AutomataPalabraReservada {

    public AutomataLlaveCerrada() {
        super(TipoLexemaEnum.LLAVE_CERRADA, "}");
    }

}
