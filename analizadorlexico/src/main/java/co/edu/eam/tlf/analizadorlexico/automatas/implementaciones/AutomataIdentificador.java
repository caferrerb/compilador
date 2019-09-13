/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorlexico.automatas.implementaciones;

import co.edu.eam.tlf.analizadorlexico.automatas.definiciones.Automata;
import co.edu.eam.tlf.analizadorlexico.modelo.FlujoCaracteres;

import co.edu.eam.tlf.analizadorlexico.modelo.SimboloLexico;
import co.edu.eam.tlf.analizadorlexico.modelo.TipoLexemaEnum;

/**
 *
 * @author caferrerb
 */
public class AutomataIdentificador implements Automata {

    @Override
    public SimboloLexico ejecutar(FlujoCaracteres flujo) {

        //aqui se acumulara el lexema.
        StringBuilder lexema = new StringBuilder();
        //se alamacenan las posiciones actuales del flujo.
        flujo.guardarPosiciones();
        //se toma el caracter actual.
        char caracter = flujo.getCaracterActual();

        if (Character.isLetter(caracter)
                || caracter == '_') {

            lexema.append(caracter);
            caracter = flujo.avanzar();
            while (Character.isDigit(caracter) || Character.isLetter(caracter)
                    || caracter == '_') {
                lexema.append(caracter);
                caracter = flujo.avanzar();

            }
            return new SimboloLexico(lexema.toString(), flujo.getFila(), flujo.getColumna(), TipoLexemaEnum.IDENTIFICADOR);
        }
        flujo.backTrack();
        return null;
    }

}
