/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorlexico.automatas.implementaciones;

import co.edu.eam.tlf.analizadorlexico.automatas.definiciones.Automata;
import co.edu.eam.tlf.analizadorlexico.modelo.FlujoCaracteres;
import co.edu.eam.tlf.analizadorlexico.modelo.SimboloLexico;
import co.edu.eam.tlf.analizadorlexico.modelo.TipoLexemaEnum;

/**
 *Clase que representa un automata para un numero real.
 * @author Camilo Andres Ferrer Bustos.
 */
public class AutomataNumeroReal implements Automata {

    
    @Override
    public SimboloLexico ejecutar(FlujoCaracteres flujo) {
        //aqui se acumulara el lexema.
        StringBuilder lexema = new StringBuilder();
        //se alamacenan las posiciones actuales del flujo.
        flujo.guardarPosiciones();
        //se toma el caracter actual.
        char caracter = flujo.getCaracterActual();

        //q0->transicion numero->estadofinal q0
        while (Character.isDigit(caracter)) {
            lexema.append(caracter);
            caracter=flujo.avanzar();
        }
    

        //qo->transicion '.'->estado final q1
        if ('.' == caracter) {
            lexema.append(caracter);
            caracter = flujo.avanzar();

            //q1->transicion numero->estadofinal q2
            while (Character.isDigit(caracter)) {
                lexema.append(caracter);
                caracter=flujo.avanzar();
            }
            //si ya llega otro caracter ya se salio del automata de numeroreal
            SimboloLexico sl=new SimboloLexico(lexema.toString(), flujo.getFila(), 
                    flujo.getColumna(),TipoLexemaEnum.LITERAL_NUMREAL);
            
            return sl;

        } else {
            //no representa un numero real
            //hay que devolverse.
            flujo.backTrack();
            //con null indicamos que no es este automata el que identifica
            //el simbolo numero Real.
            return null;
        }




    }
}
