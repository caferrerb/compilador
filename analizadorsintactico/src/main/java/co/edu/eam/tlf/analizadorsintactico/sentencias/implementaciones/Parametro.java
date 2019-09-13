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
public class Parametro extends Sentencia {

    /**
     * Nombre del parametro
     */
    private SimboloLexico nombre;
    /**
     * Tipo de dato del parametro.
     */
    private SimboloLexico tipo;

    /**
     * COnstructor
     */
    public Parametro() {
    }

    /**
     * COnstructor.
     *
     * @param nombre
     * @param tipo
     */
    public Parametro(SimboloLexico nombre, SimboloLexico tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    @Override
    public List<Sentencia> llenarHijos() {

        hijos = new ArrayList<>();

        hijos.add(new SentenciaToken(tipo));
        hijos.add(new SentenciaToken(nombre));
        return hijos;
    }

    @Override
    public String toString() {

        return "Parametro:"+nombre.getLexema();
                
        
    }

	@Override
	public String parse() {
		// TODO Auto-generated method stub
		return null;
	}
    
    

}
