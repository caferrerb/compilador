package automatas.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import co.edu.eam.tlf.analizadorlexico.main.Compilador;
import co.edu.eam.tlf.analizadorlexico.modelo.SimboloLexico;
import co.edu.eam.tlf.analizadorlexico.modelo.TipoLexemaEnum;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author swatit
 */
public class TestAutomataNumeroReal {

    public TestAutomataNumeroReal() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void test() {
        String codigo = "23.5";
        Compilador compilador = new Compilador();
        compilador.ejecutar(codigo);
        List<SimboloLexico> lexemas = compilador.getAnalizadorLexico().getTokens();
        if (!lexemas.isEmpty()) {
            assertEquals(lexemas.get(0).getLexema(), codigo);
            assertEquals(lexemas.get(0).getTipo()  , TipoLexemaEnum.LITERAL_NUMREAL);
        }else{
            assertTrue(false);
        }

    }
}
