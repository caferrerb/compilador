/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorsintactico.gramatica.implementaciones;

import co.edu.eam.tlf.analizadorsintactico.gramatica.definiciones.Gramatica;
import co.edu.eam.tlf.analizadorlexico.modelo.SimboloLexico;
import co.edu.eam.tlf.analizadorlexico.modelo.TipoLexemaEnum;
import co.edu.eam.tlf.analizadorsintactico.sentencias.definicion.Sentencia;
import co.edu.eam.tlf.analizadorsintactico.sentencias.implementaciones.Atributo;
import co.edu.eam.tlf.analizadorsintactico.sentencias.implementaciones.Metodo;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

/**
 * Clase que representa a un atributo como elemeto gramatical.
 *
 * @author caferrerb
 */
public class GramaticaAtributo implements Gramatica {

    @Override
    public Atributo analizar(Sentencia padre,FlujoTokens flujoTokens) {

        //Sentencia a retornar....
        Atributo atributo = new Atributo();
        flujoTokens.guardarPosicion();
        //primer token de la gramatica.
        SimboloLexico lexema = flujoTokens.getTokenActual();
        //modificador de acceso del atributo...
        //esto es opcional, por eso no tiene else
        if (lexema.getTipo() == TipoLexemaEnum.MOD_ACCESO) {
            atributo.setModificador(lexema);
            lexema = flujoTokens.avanzar();
        }

        //tipo de dato.....
        if (lexema.getTipo() == TipoLexemaEnum.IDENTIFICADOR || lexema.getTipo() == TipoLexemaEnum.TIPO_DATO) {
            atributo.setTipoDato(lexema);
            lexema = flujoTokens.avanzar();

            //nombre del atributo....
            if (lexema.getTipo() == TipoLexemaEnum.IDENTIFICADOR) {
                atributo.setNombre(lexema);
                lexema = flujoTokens.avanzar();

                if (lexema.getTipo() == TipoLexemaEnum.PUNTOCOMMA) {
                    //derivar...
                    return atributo;
                } else {
                    //si no es identificador, no es atributo, se retorna el flujo a 
                    //la posicion inicial
                    flujoTokens.backTrack();
                    return null; //se retorna null para que se pruebe con otra regal..
                }

            } else {
                //si no es identificador, no es atributo, se retorna el flujo a 
                //la posicion inicial
                flujoTokens.backTrack();
                return null; //se retorna null para que se pruebe con otra regal..
            }

        }
        return null;

    }
}
