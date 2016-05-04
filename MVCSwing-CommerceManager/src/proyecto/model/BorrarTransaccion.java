package proyecto.model;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * @author andre
 * BORRA UNA TRANSACCION DEL DOCUMENTO XML
 */
public class BorrarTransaccion extends ManageDocument {  

    public boolean borrarRegistro(int codigoTransaccion) {
        Document document = manageDocument("archivoTransaccion.xml");
        File file = null;
        boolean bool;
        int len = 0;
        Node parentNode = null;
        String codigoString = Integer.toString(codigoTransaccion);
        try {
            file = new File("archivoTransaccion.xml");
            Element raiz = document.getDocumentElement();
            NodeList nodelist = raiz.getElementsByTagName("numero-transaccion");
            len = nodelist.getLength();
            for (int i = 0; i < len; i++) {
                String nodeString = nodelist.item(i).getTextContent();
                if (nodeString.equals(codigoString)) {
                    // si encuentra la transaccion
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
            
        } catch (Exception e) {
            e.printStackTrace();
            bool = false;
        }
    return bool;
    }
}
