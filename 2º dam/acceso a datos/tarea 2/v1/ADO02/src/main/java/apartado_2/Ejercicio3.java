package apartado_2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio3 {

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documento = builder.parse(new File("libros.xml"));

            NodeList listaLibros = documento.getElementsByTagName("libro");

            for (int i = 0; i < listaLibros.getLength(); i++) {

                Node nodo = listaLibros.item(i);

                if (nodo.hasAttributes()) {
                    for (int j = 0; j < nodo.getAttributes().getLength(); j++) {
                        System.out.println("Atributo: " + nodo.getAttributes().item(j).getNodeName()
                                + ", Valor: " + nodo.getAttributes().item(j).getNodeValue());
                    }
                }

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                    Element e = (Element) nodo;
                    NodeList hijosLibro = e.getChildNodes();
                    for (int j = 0; j < hijosLibro.getLength(); j++) {

                        Node hijoLibro = hijosLibro.item(j);

                        if (hijoLibro.getNodeType() == Node.ELEMENT_NODE) {

                            if (hijoLibro.getNodeName().equals("autor")) {

                                Element e2 = (Element) hijoLibro;
                                NodeList hijosAutor = e2.getChildNodes();
                                for (int k = 0; k < hijosAutor.getLength(); k++) {
                                    Node hijoAutor = hijosAutor.item(k);
                                    if (hijoAutor.getNodeType() == Node.ELEMENT_NODE) {
                                        System.out.println("\tPropiedad: " + hijoAutor.getNodeName() + ", Valor: " + hijoAutor.getTextContent());
                                    }
                                }
                            } else {
                                System.out.println("Propiedad: " + hijoLibro.getNodeName() + ", Valor: " + hijoLibro.getTextContent());
                            }

                        }

                    }
                    System.out.println("");

                }

            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
