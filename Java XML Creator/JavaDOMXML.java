package calculadora;
import java.io.*;
import java.util.Vector;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class JavaDOMXML {
    static void crearXML() throws IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException{
        Vector v = new Vector();
        String archXML;
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese el nombre del elemento raiz(root): ");
        String raiz = bfr.readLine();
        DocumentBuilderFactory Archivo = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = Archivo.newDocumentBuilder();
        Document documento = documentBuilder.newDocument();
        Element elementoRaiz = documento.createElement(raiz);
        documento.appendChild(elementoRaiz);
        System.out.println("Numero de atributos a crear en su archivo XML: ");
        String str = bfr.readLine();
        int nElementos = Integer.parseInt(str);
        // este metodo agrega atributos segun deseado
        for (int i = 1;i <= nElementos; i++) {
            System.out.println("Nombre del atributo: " + String.valueOf(i) + " ");
            str = bfr.readLine();
            v.addElement(str);}
        // se llena el contenido
        for (int i = 0; i < nElementos; i++){
            Element atributo = documento.createElement(v.elementAt(i).toString());
            System.out.println("Digite el contenido de: " + v.elementAt(i) + " ");
            String data = bfr.readLine();
            atributo.appendChild(documento.createTextNode(data));
            elementoRaiz.appendChild(atributo);
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(documento);
        System.out.println("Nombre del archivo XML sin la extension XML: ");
        archXML = bfr.readLine();
        StreamResult pArchivo = new StreamResult(new File(archXML + ".xml"));
        StreamResult pPantalla = new StreamResult(System.out);
        transformer.transform(source, pArchivo);
        transformer.transform(source, pPantalla);
        }
    public static void main(String[] args) throws IOException, 
                ParserConfigurationException, TransformerConfigurationException, TransformerException, SAXException {
            crearXML();
    }
}

