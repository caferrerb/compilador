/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorsintactico.sentencias.implementaciones;

import co.edu.eam.tlf.analizadorlexico.modelo.SimboloLexico;
import co.edu.eam.tlf.analizadorsintactico.sentencias.definicion.Sentencia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

/**
 *
 * @author caferrerb
 */
public class Metodo extends Sentencia {

    /**
     * Modificador de acceso del metodo.
     */
    private SimboloLexico modificador;
    /**
     * Nombre del metodo
     */
    private SimboloLexico nombre;

    /**
     * Tipo de retorno.
     */
    private SimboloLexico retorno;

    /**
     * Lista de parametros.
     */
    private Lista<Parametro> listaParametros;

    /**
     * Instrucciones dentro del metodo.
     */
    private Lista<Sentencia> listaSentencias;

    /**
     * COnstructor
     */
    public Metodo() {
       listaParametros=new Lista<>();
       listaSentencias=new Lista<>();
    }

    /**
     * Constructor.
     *
     * @param nombre
     * @param retorno
     * @param listaParametros
     * @param listaSentencias
     */
    public Metodo(SimboloLexico nombre, SimboloLexico retorno, Lista<Parametro> listaParametros, Lista<Sentencia> listaSentencias) {
        this.nombre = nombre;
        this.retorno = retorno;
        this.listaParametros = listaParametros;
        this.listaSentencias = listaSentencias;
    }

    /**
     * COnstructor.
     *
     * @param modificador
     * @param nombre
     * @param retorno
     * @param listaParametros
     * @param listaSentencias
     */
    public Metodo(SimboloLexico modificador, SimboloLexico nombre, SimboloLexico retorno, Lista<Parametro> listaParametros, Lista<Sentencia> listaSentencias) {
        this.modificador = modificador;
        this.nombre = nombre;
        this.retorno = retorno;
        this.listaParametros = listaParametros;
        this.listaSentencias = listaSentencias;
    }

    @Override
    public List<Sentencia> llenarHijos() {

        hijos = new ArrayList<>();
        if (modificador != null) {
            hijos.add(new SentenciaToken(modificador));
        }
        hijos.add(new SentenciaToken(retorno));
        hijos.add(new SentenciaToken(nombre));

       if(!listaParametros.getSentencias().isEmpty()) hijos.add(listaParametros);
        if(!listaSentencias.getSentencias().isEmpty())  hijos.add(listaSentencias);
        return hijos;

    }

     @Override
    public String toString() {
        return "Metodo:  "+ nombre.getLexema();
    }
    
    public SimboloLexico getModificador() {
        return modificador;
    }

    public void setModificador(SimboloLexico modificador) {
        this.modificador = modificador;
    }

    public SimboloLexico getNombre() {
        return nombre;
    }

    public void setNombre(SimboloLexico nombre) {
        this.nombre = nombre;
    }

    public SimboloLexico getRetorno() {
        return retorno;
    }

    public void setRetorno(SimboloLexico retorno) {
        this.retorno = retorno;
    }

    public Lista<Parametro> getListaParametros() {
        return listaParametros;
    }

    public void setListaParametros(Lista<Parametro> listaParametros) {
        this.listaParametros = listaParametros;
    }

    public Lista<Sentencia> getListaSentencias() {
        return listaSentencias;
    }

    public void setListaSentencias(Lista<Sentencia> listaSentencias) {
        this.listaSentencias = listaSentencias;
    }

	@Override
	public String parse() {
		StringBuilder str = new StringBuilder();
		str.append("metodo ");
		
		if (modificador.getLexema().equals("private")) {
			str.append(" privado ");
		}
		
		if (modificador.getLexema().equals("public")) {
			str.append(" publico ");
		}
		
		str.append("con nombre ").append(nombre.getLexema());
		str.append(" y paramatros:  ").append(listaParametros.parse());
		str.append(" retornando ").append(retorno.getLexema());

		return str.toString();
	}

}
