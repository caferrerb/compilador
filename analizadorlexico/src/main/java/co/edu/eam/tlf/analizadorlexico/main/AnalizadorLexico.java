/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorlexico.main;

import co.edu.eam.tlf.analizadorlexico.automatas.definiciones.Automata;
import co.edu.eam.tlf.analizadorlexico.automatas.implementaciones.AutomataClass;
import co.edu.eam.tlf.analizadorlexico.automatas.implementaciones.AutomataComma;
import co.edu.eam.tlf.analizadorlexico.automatas.implementaciones.AutomataIdentificador;
import co.edu.eam.tlf.analizadorlexico.automatas.implementaciones.AutomataLlaveCerrada;
import co.edu.eam.tlf.analizadorlexico.automatas.implementaciones.AutomataLlavesAbierta;
import co.edu.eam.tlf.analizadorlexico.automatas.implementaciones.AutomataModificadorAcceso;
import co.edu.eam.tlf.analizadorlexico.automatas.implementaciones.AutomataNumeroReal;
import co.edu.eam.tlf.analizadorlexico.automatas.implementaciones.AutomataParentesisAbierto;
import co.edu.eam.tlf.analizadorlexico.automatas.implementaciones.AutomataParentesisCerrado;
import co.edu.eam.tlf.analizadorlexico.automatas.implementaciones.AutomataPuntoComma;
import co.edu.eam.tlf.analizadorlexico.automatas.implementaciones.AutomataTipoDatoPrimitivo;
import co.edu.eam.tlf.analizadorlexico.modelo.FlujoCaracteres;
import co.edu.eam.tlf.analizadorlexico.modelo.SimboloLexico;
import co.edu.eam.tlf.analizadorlexico.modelo.TipoLexemaEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.reflections.Reflections;

/**
 * Analizador lexico del codigo.
 *
 * @author Camilo Andres Ferrer Bustos.
 */
public class AnalizadorLexico {

    /**
     * Lista de tokens descubiertos.
     */
    private List<SimboloLexico> tokens;

    /**
     * Lista de errores
     */
    private List<SimboloLexico> errores;

    /**
     * FLujo de caracteres para recorrer el codigo.
     */
    private FlujoCaracteres flujoCaracteres;

    /**
     * Metodo para analizar el codigo en busca de los simbolos lexiicos que lo
     * componente.
     */
    public void analizar(String codigo) {

        tokens = new ArrayList<>();
        errores = new ArrayList<>();

        Reflections reflections = new Reflections("co.edu.eam.tlf.analizadorlexico.automatas.implementaciones");
        Set<Class<? extends Automata>> automatas
                = reflections.getSubTypesOf(Automata.class);
        flujoCaracteres = new FlujoCaracteres(codigo);
        //se recorre el codigo buscando con cada uno de los automatas. 
        while (flujoCaracteres.getCaracterActual() != 0) {
            //se ejecutan los automatas uno a uno
            if (flujoCaracteres.getCaracterActual() == ' ') {
                flujoCaracteres.avanzar();
                continue;
            }
            
            if (flujoCaracteres.getCaracterActual() == '\n') {
                flujoCaracteres.avanzar();
                continue;
            }

            if (ejecutarAutomata(AutomataClass.class)) {
                continue;
            }
            if (ejecutarAutomata(AutomataModificadorAcceso.class)) {
                continue;
            }
            if (ejecutarAutomata(AutomataNumeroReal.class)) {
                continue;
            }

            if (ejecutarAutomata(AutomataTipoDatoPrimitivo.class)) {
                continue;
            }
           
            if (ejecutarAutomata(AutomataLlaveCerrada.class)) {
                continue;
            }
            if (ejecutarAutomata(AutomataLlavesAbierta.class)) {
                continue;
            }
            if (ejecutarAutomata(AutomataParentesisAbierto.class)) {
                continue;
            }
            if (ejecutarAutomata(AutomataParentesisCerrado.class)) {
                continue;
            }
            
             if (ejecutarAutomata(AutomataComma.class)) {
                continue;
            }
              if (ejecutarAutomata(AutomataPuntoComma.class)) {
                continue;
            }
              
             if (ejecutarAutomata(AutomataIdentificador.class)) {
                continue;
            }  
              

            errores.add(new SimboloLexico(String.valueOf(flujoCaracteres.getCaracterActual()),
                    flujoCaracteres.getFila(), flujoCaracteres.getColumna(),
                    TipoLexemaEnum.ERROR));

            flujoCaracteres.avanzar();

        }

    }

    /**
     * Metodo que ejecuta un automata.ºﬁ
     *
     * @param afdClass
     * @return
     */
    private boolean ejecutarAutomata(Class<? extends Automata> afdClass) {
        try {
            Automata afd = afdClass.newInstance();
            //se ejecuta el automata.
            SimboloLexico simbolo = afd.ejecutar(flujoCaracteres);

            //si se retorna null, no era este automata, se sigue con el siguiente.
            if (simbolo != null) {
                //si el simbolo esta errorneo se coloca en el la lista de
                //errores.
                if (simbolo.isError()) {
                    //se agrega a los errores, estaba malo.
                    errores.add(simbolo);
                } else {//se agrega a los tokens, se encontro.
                    tokens.add(simbolo);
                }
                return true;
            }

        } catch (InstantiationException ex) {
            Logger.getLogger(AnalizadorLexico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AnalizadorLexico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<SimboloLexico> getErrores() {
        return errores;
    }

    public List<SimboloLexico> getTokens() {
        return tokens;
    }

}
