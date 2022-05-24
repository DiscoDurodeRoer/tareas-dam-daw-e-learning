
package apartado_2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class Ejercicio4 {
    
    public static void main(String[] args) {
        
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            
            SAXParser parser = factory.newSAXParser();
            
            LibroHandler handler = new LibroHandler();
            parser.parse("libros.xml", handler);
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
