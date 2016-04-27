package proyecto.model;

import java.io.File;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author andre
 * BORRA UN COMERCIO DEL ARCHIVO XML
 */
public class BorrarComercio extends ManageDocument {
    public BorrarComercio(int codigoComercio) {
    Document doc = manageDocument("archivoComercio.xml");  
    try {
        borrarRegistro(doc, codigoComercio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    public boolean borrarRegistro(Document document, int codigoTransaccion) throws TransformerException {
        File file = null;
        boolean bool;
        int len = 0;
        Node parentNode = null;
        String codigoString = Integer.toString(codigoTransaccion);
        try {
            file = new File("archivoComercio.xml");
            Element raiz = document.getDocumentElement();
            NodeList nodelist = raiz.getElementsByTagName("codigo-comercio");
            len = nodelist.getLength();
            for (int i = 0; i < len; i++) {
                String nodeString = nodelist.item(i).getTextContent();
                if (nodeString.equals(codigoString)) {
                    // si encuentra el codigo de comercio
                    // toma al padre
                    // borra al padre de la raiz
                    parentNode = nodelist.item(i).getParentNode();
                    raiz.removeChild(parentNode);
                    }
                }
            
            // clase para escribir archivos xml en DOM 
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // agrega indentacion al archivo xml
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            // toma el parametro de documento
            DOMSource source = new DOMSource(document);
            // usa el archivo definido al principio de la clase
            StreamResult result = new StreamResult(file);
            // escribe al archivo
            transformer.transform(source, result);
            // escribe a la consola para testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
            bool = true;
        }
        catch (Exception e) {
            e.printStackTrace();
            bool = false;
        }
    return bool;
    }
}
