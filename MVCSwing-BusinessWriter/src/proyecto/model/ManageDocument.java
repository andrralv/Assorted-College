package proyecto.model;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 * @author andre
 * SUPERCLASE QUE ABRE O CREA UN DOCUMENTO XML
 */
public class ManageDocument {
        public Document manageDocument(String path) {
        // crea el documento   
        Document doc = null;
        try {
        // utilidad para crear un documento xml de usuariosRegistro
        File file = new File(path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        // si el archivo existe, abralo
        if (file.exists()) {
        doc = dBuilder.parse(file);
        // normalizar formato
        doc.getDocumentElement().normalize();
        } else {
        // sino existe cree uno nuevo
            doc = dBuilder.newDocument();
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    return doc;
    }
}
