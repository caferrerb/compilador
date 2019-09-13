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
import co.edu.eam.tlf.analizadorsintactico.sentencias.implementaciones.Parametro;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

/**
 *Gramatica para identificar a un parametro de un metodo.
 * la regla sintactica es:
 * parametro::=<tipodato> <identificador>
 * tipodato::=<identificador>|<tipoprimitivo>
 * @author caferrerb
 */
public class GramaticaParametro implements Gramatica{

   
    
    @Override
    public Parametro analizar(Sentencia raiz,FlujoTokens flujoTokens) {
       
        SimboloLexico tipo,nombre;
        SimboloLexico lexema=flujoTokens.getTokenActual();
        
        //si empieza con identificador o tipo de dato
        if(lexema.getTipo()==TipoLexemaEnum.IDENTIFICADOR || lexema.getTipo()==TipoLexemaEnum.TIPO_DATO){
             tipo=lexema;
            lexema=flujoTokens.avanzar();
            //luego se espera indentificador.
            if(lexema.getTipo()==TipoLexemaEnum.IDENTIFICADOR){
                nombre=lexema;
            }else{//si no se recibe <identificador> hay un error de sintaxis.
                throw new SintacticException(lexema, TipoLexemaEnum.IDENTIFICADOR);
            }
            //se retorna la sentencia.
            return new Parametro(nombre, tipo);
        }else{
            return null;
        }
    }

    
}
