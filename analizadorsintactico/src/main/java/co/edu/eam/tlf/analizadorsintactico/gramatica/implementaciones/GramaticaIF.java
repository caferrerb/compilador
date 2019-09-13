package co.edu.eam.tlf.analizadorsintactico.gramatica.implementaciones;

import co.edu.eam.tlf.analizadorlexico.modelo.TipoLexemaEnum;
import co.edu.eam.tlf.analizadorsintactico.excepciones.SintacticException;
import co.edu.eam.tlf.analizadorsintactico.gramatica.definiciones.Gramatica;
import co.edu.eam.tlf.analizadorsintactico.sentencias.definicion.Sentencia;
import co.edu.eam.tlf.analizadorsintactico.sentencias.implementaciones.Condicion;
import co.edu.eam.tlf.analizadorsintactico.sentencias.implementaciones.IF;

public class GramaticaIF implements Gramatica {

	@Override
	public Sentencia analizar(Sentencia padre, FlujoTokens flujoTokens) {

		flujoTokens.getTokenActual();
		
		if (flujoTokens.getTokenActual().getTipo() != TipoLexemaEnum.RES_IF)
			return  null;
		flujoTokens.avanzar();
		
		if (flujoTokens.getTokenActual().getTipo() != TipoLexemaEnum.PARENTESIS_ABIERTO){
			throw new SintacticException(flujoTokens.getTokenActual(), TipoLexemaEnum.PARENTESIS_ABIERTO);
		}
		
		Condicion condicion = (Condicion) new GramaticaCondicion()
				.analizar(null, flujoTokens);
		
		if (condicion==null)
			throw new SintacticException(flujoTokens.getTokenActual(), TipoLexemaEnum.PARENTESIS_ABIERTO);

		IF si = new IF();
		si.setCondicion(condicion);
		flujoTokens.avanzar();

		if (flujoTokens.getTokenActual().getTipo() != TipoLexemaEnum.PARENTESIS_CERRADO){
			throw new SintacticException(flujoTokens.getTokenActual(), TipoLexemaEnum.PARENTESIS_CERRADO);
		}
		
		
		return null;
	}
	
	
	/**
	 * if (String){
	 * }
	 * 
	 * boolean a = x<10 && y>20
	 * 
	 */

}
