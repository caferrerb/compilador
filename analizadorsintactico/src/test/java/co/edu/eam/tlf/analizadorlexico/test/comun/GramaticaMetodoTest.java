/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.analizadorlexico.test.comun;

import co.edu.eam.tlf.analizadorlexico.modelo.TipoLexemaEnum;
import co.edu.eam.tlf.analizadorsintactico.excepciones.SintacticException;
import co.edu.eam.tlf.analizadorsintactico.gramatica.implementaciones.GramaticaMetodo;
import co.edu.eam.tlf.analizadorsintactico.sentencias.implementaciones.Metodo;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author swatit
 */
public class GramaticaMetodoTest extends PruebaSintactica {

    public GramaticaMetodoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void test() {

        String codigo = "public int metodo(int  a, int b){}";
        Metodo met = (Metodo) ejecutarGramatica(GramaticaMetodo.class, codigo);
     //   try{

        if (met.getNombre().getLexema().equals("metodo")
                && met.getModificador().getTipo() == TipoLexemaEnum.MOD_ACCESO
                && met.getRetorno().getTipo() == TipoLexemaEnum.TIPO_DATO) {

            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);

        }

    }
}
