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

/**
 *
 * @author swatit
 */
public class SentenciaToken extends Sentencia{

    private SimboloLexico simbolo;

    public SentenciaToken() {
    }

    public SentenciaToken(SimboloLexico simbolo) {
        this.simbolo = simbolo;
    }
    
    
    
    @Override
    public List<Sentencia> llenarHijos() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        
        return simbolo.getTipo()+":"+simbolo.getLexema();
    
    }

    
    
    public SimboloLexico getSimbolo() {
        return simbolo;
    }

	@Override
	public String parse() {
		// TODO Auto-generated method stub
		return null;
	}
     
}
