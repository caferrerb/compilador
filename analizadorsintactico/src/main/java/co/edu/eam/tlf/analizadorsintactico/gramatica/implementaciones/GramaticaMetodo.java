/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorsintactico.gramatica.implementaciones;

import co.edu.eam.tlf.analizadorsintactico.gramatica.definiciones.Gramatica;
import co.edu.eam.tlf.analizadorlexico.modelo.SimboloLexico;
import co.edu.eam.tlf.analizadorlexico.modelo.TipoLexemaEnum;
import co.edu.eam.tlf.analizadorsintactico.excepciones.SintacticException;
import co.edu.eam.tlf.analizadorsintactico.sentencias.definicion.Sentencia;
import co.edu.eam.tlf.analizadorsintactico.sentencias.implementaciones.Clase;
import co.edu.eam.tlf.analizadorsintactico.sentencias.implementaciones.Lista;
import co.edu.eam.tlf.analizadorsintactico.sentencias.implementaciones.Metodo;
import co.edu.eam.tlf.analizadorsintactico.sentencias.implementaciones.Parametro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

/**
 * Clase que represetna la gramatica de un metodo.
 *
 * @author caferrerb
 */
public class GramaticaMetodo implements Gramatica {

    @Override
    public Metodo analizar(Sentencia raiz,FlujoTokens flujoTokens) {
        //Sentencia a retornar....
        Metodo metodo = new Metodo();
        flujoTokens.guardarPosicion();
        //primer token de la gramatica.
        SimboloLexico lexema = flujoTokens.getTokenActual();
        //modificador de acceso del metodo...
        //esto es opcional, por eso no tiene else
        if (lexema.getTipo() == TipoLexemaEnum.MOD_ACCESO) {
            metodo.setModificador(lexema);
            lexema = flujoTokens.avanzar();
        }

        //tipo de retorno.....
        if (lexema.getTipo() == TipoLexemaEnum.IDENTIFICADOR || lexema.getTipo() == TipoLexemaEnum.TIPO_DATO) {
            metodo.setRetorno(lexema);
            lexema = flujoTokens.avanzar();

            //nombre del metodo....
            if (lexema.getTipo() == TipoLexemaEnum.IDENTIFICADOR) {
                metodo.setNombre(lexema);
                lexema = flujoTokens.avanzar();
            } else {
                //si no es identificador, no es metodo, se retorna el flujo a 
                //la posicion inicial
                flujoTokens.backTrack();
                return null; //se retorna null para que se pruebe con otra regal..
            }

            //parentesis.......
            if (lexema.getTipo() == TipoLexemaEnum.PARENTESIS_ABIERTO) {
                //lista de parametros......

                Lista<Parametro> parametros = new Lista<>();
                GramaticaParametro gramma = new GramaticaParametro();
                //Parametro parametro = grammma.verificar(flujoTokens);
               /////
                GramaticaLista<Parametro> grammaParametros=new GramaticaLista<>();
                parametros=grammaParametros.analizar(gramma,metodo,flujoTokens, TipoLexemaEnum.COMMA);
                metodo.setListaParametros(parametros);
                lexema=flujoTokens.getTokenActual();
                if (lexema.getTipo() == TipoLexemaEnum.PARENTESIS_CERRADO) {
                    metodo.setListaParametros(parametros);//se setean los parametros.
                    lexema = flujoTokens.avanzar();
                    //se espera llave abierta.....
                    if (lexema.getTipo() == TipoLexemaEnum.LLAVE_ABIERTA) {
                           //se analiza el cuerpo del metodo.....
                        
                          //se acabo el metodo.....
                        lexema=flujoTokens.avanzar();
                        if (lexema.getTipo() == TipoLexemaEnum.LLAVE_CERRADA) {

                            return metodo;
                        } else {//si no se termina con llave cerrada, excepcion...
                            throw new SintacticException(lexema, TipoLexemaEnum.LLAVE_CERRADA);
                        }

                    } else {//si no se empieza con llave abierta, error.
                        throw new SintacticException(lexema, TipoLexemaEnum.LLAVE_ABIERTA);
                    }

                } else {
                    throw new SintacticException(lexema, TipoLexemaEnum.PARENTESIS_CERRADO);
                }

            } else {
                //si no es identificador, no es metodo, se retorna el flujo a 
                //la posicion inicial
                flujoTokens.backTrack();
                return null; //se retorna null para que se pruebe con otra regal..
            }

        } else {
            //si no es identificador o tipo de dato, no es metodo, se retorna el flujo a 
            //la posicion inicial
            flujoTokens.backTrack();
            return null; //se retorna null para que se pruebe con otra regal..
        }

    }

}
