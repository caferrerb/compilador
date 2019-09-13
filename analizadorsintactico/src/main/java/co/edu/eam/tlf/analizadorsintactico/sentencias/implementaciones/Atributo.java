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
public class Atributo extends Sentencia {

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
    private SimboloLexico tipoDato;
    

    public Atributo() {
    }

    public Atributo(SimboloLexico modificador, SimboloLexico nombre, SimboloLexico tipoDato) {
        this.modificador = modificador;
        this.nombre = nombre;
        this.tipoDato = tipoDato;
    }

    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        if(modificador!=null)hijos.add(new SentenciaToken(modificador));
        hijos.add(new SentenciaToken(tipoDato));
        hijos.add(new SentenciaToken(nombre));
        return hijos;
    }

    @Override
    public String toString() {
        return "Atributo:"+tipoDato.getLexema()+"-"+ nombre.getLexema();
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

    public SimboloLexico getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(SimboloLexico tipoDato) {
        this.tipoDato = tipoDato;
    }

	@Override
	public String parse() {
		StringBuilder str = new StringBuilder();
		
		str.append("atributo ");
		
		if (modificador.getLexema().equals("private")) {
			str.append(" privado ");
		}
		
		if (modificador.getLexema().equals("public")) {
			str.append(" publico ");
		}
		
		str.append("con nombre ").append(nombre.getLexema());
		str.append(" y de tipo ").append(tipoDato.getLexema());
		str.append(";");

		return str.toString();
	}

}
