/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.tlf.guicompilador.vista.util;

import co.edu.eam.tlf.guicompilador.language.util.LanguageToken;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.ToolTipManager;
import org.fife.rsta.ac.LanguageSupport;
import org.fife.rsta.ac.LanguageSupportFactory;
import org.fife.rsta.ac.java.JavaLanguageSupport;
import org.fife.rsta.ac.java.buildpath.DirLibraryInfo;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 *
 * @author user
 */
public class JCodeEditor extends RTextScrollPane {

    static{
        AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
        atmf.putMapping("text/myLanguage", LanguageToken.class.getCanonicalName());
        
    }
    /*static {
        
     LanguageSupportFactory lsf = LanguageSupportFactory.get();
     LanguageSupport support = lsf.
     JavaLanguageSupport jls = (JavaLanguageSupport) support;
     // TODO: This API will change!  It will be easier to do per-editor
     // changes to the build path.
     try {
     jls.getJarManager().addCurrentJreClassFileSource();
     jls.getJarManager().addClassFileSource(new DirLibraryInfo(new File("C:/Users/user/Dropbox/compartidocamilo/entrenador JPA/VideoTienda/src")));
     //jsls.getJarManager().addClassFileSource(ji);
     } catch (IOException ioe) {
     ioe.printStackTrace();
     }
     }*/
    private RSyntaxTextArea textArea;
    private String lenguaje;

    public JCodeEditor() {

        this("text/myLanguage", true);
    }

    public JCodeEditor(String lenguaje, boolean numerado) {
        super(null, numerado, Color.GRAY);

        

        textArea = createTextArea();
        //textArea.setSyntaxEditingStyle("text/myLanguage");
        textArea.setSyntaxEditingStyle(lenguaje);

        setViewportView(textArea);
        setLineNumbersEnabled(true);
        setIconRowHeaderEnabled(true);

        //
        // getGutter().setBookmarkingEnabled(true);
    }

    /**
     * Creates the text area for this application.
     *
     * @return The text area.
     */
    private RSyntaxTextArea createTextArea() {
        RSyntaxTextArea textArea = new RSyntaxTextArea(25, 80);
        LanguageSupportFactory.get().register(textArea);
        textArea.setCaretPosition(0);
        textArea.requestFocusInWindow();
        textArea.setMarkOccurrences(true);
        textArea.setCodeFoldingEnabled(true);
        textArea.setTabsEmulated(true);
        textArea.setTabSize(3);
        ToolTipManager.sharedInstance().registerComponent(textArea);
        return textArea;
    }

    public String getCodigo() {
        return textArea.getText();
    }

    public void setCodigo(String codigo) {
        textArea.setText(codigo);
    }

    @Override
    public RTextArea getTextArea() {
        return super.getTextArea(); //To change body of generated methods, choose Tools | Templates.
    }

}
