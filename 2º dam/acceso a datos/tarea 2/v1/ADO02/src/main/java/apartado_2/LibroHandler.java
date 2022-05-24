package apartado_2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LibroHandler extends DefaultHandler {

    private StringBuilder value;

    public LibroHandler() {
        this.value = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName,
            String qName, Attributes attributes)
            throws SAXException {

        this.value.setLength(0);

        if (qName.equals("libro")) {
            String anio = attributes.getValue("año");
            System.out.println("Atributo año: " + anio);
        }

    }

    @Override
    public void characters(char ch[], int start, int length)
            throws SAXException {

        this.value.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        switch (qName) {
            case "libro":
                System.out.println("");
                break;
            case "titulo":
                System.out.println("Titulo: " + this.value.toString());
                break;
            case "apellido":
                System.out.println("Apellido autor: " + this.value.toString());
                break;
            case "nombre":
                System.out.println("Nombre autor: " + this.value.toString());
                break;
            case "editorial":
                System.out.println("Editorial: " + this.value.toString());
                break;
            case "precio":
                System.out.println("Precio: " + this.value.toString());
                break;
        }

    }

}
