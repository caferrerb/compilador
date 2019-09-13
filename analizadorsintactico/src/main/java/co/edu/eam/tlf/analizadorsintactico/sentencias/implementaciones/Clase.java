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
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author caferrerb
 */
public class Clase extends Sentencia {

    /**
     * Lista de metodos de la clase....
     */
    private Lista<Metodo> listaMetodos;

    /**
     * Lista de atributos de la clase.
     */
    private Lista<Atributo> listaAtributos;

    /**
     * Nombre de la clase.
     */
    private SimboloLexico nombreClase;

    /**
     * Modificador de acceso de la clase.
     */
    private SimboloLexico modificador;

    public Clase() {
        listaAtributos = new Lista();
        listaMetodos = new Lista<>();
    }

    @Override
    public List<Sentencia> llenarHijos() {

        hijos = new ArrayList<>();

        if (modificador != null) {
            hijos.add(new SentenciaToken(modificador));
        }
        hijos.add(new SentenciaToken(nombreClase));
        if (!listaAtributos.getSentencias().isEmpty()) {
            hijos.add(listaAtributos);
        }
        if (!listaMetodos.getSentencias().isEmpty()) {
            hijos.add(listaMetodos);
        }
        return hijos;
    }

    @Override
    public String toString() {
        return "Clase:" + nombreClase.getLexema();
    }

    public Lista<Metodo> getListaMetodos() {
        return listaMetodos;
    }

    public void setListaMetodos(Lista<Metodo> listaMetodos) {
        this.listaMetodos = listaMetodos;
    }

    public Lista<Atributo> getListaAtributos() {
        return listaAtributos;
    }

    public void setListaAtributos(Lista<Atributo> listaAtributos) {
        this.listaAtributos = listaAtributos;
    }

    public SimboloLexico getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(SimboloLexico nombreClase) {
        this.nombreClase = nombreClase;
    }

    public SimboloLexico getModificador() {
        return modificador;
    }

    public void setModificador(SimboloLexico modificador) {
        this.modificador = modificador;
    }

	@Override
	public String parse() {
		
		StringBuilder str = new StringBuilder();
		
		str.append("clase");
		
		if (modificador.getLexema().equals("private")) {
			str.append(" privada ");
		}
		
		if (modificador.getLexema().equals("public")) {
			str.append(" publica ");
		}
		
		str.append(nombreClase.getLexema());
		str.append("[");
		
		for (Sentencia sentencia : listaAtributos.getSentencias()) {
			str.append(sentencia.parse());
		}
		
		for (Sentencia sentencia : listaMetodos.getSentencias()) {
			str.append(sentencia.parse());
		}
		
		str.append("]");

		
		return str.toString();
	}

}
