package util;

import java.io.File;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Joao Samuel Gomes
 */
public class CriarDocXML {
    
    public static void main(String[] args) throws TransformerConfigurationException, TransformerException {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document documentoXML = documentBuilder.newDocument();

            Element root = documentoXML.createElement("root");
            documentoXML.appendChild(root);
            
            Element pessoa = documentoXML.createElement("pessoa");
            Attr id = documentoXML.createAttribute("id");
            id.setValue("1");
            
            pessoa.setAttributeNode(id);
            
            root.appendChild(pessoa);
            
            Element nome = documentoXML.createElement("nome");
            nome.appendChild(documentoXML.createTextNode("Pafuncio"));
            pessoa.appendChild(nome);
            
            Element dataNascimento = documentoXML.createElement("data_nascimento");
            dataNascimento.appendChild(documentoXML.createTextNode("30/02/1999"));
            pessoa.appendChild(dataNascimento);
            
            Element sexo = documentoXML.createElement("sexo");
            dataNascimento.appendChild(documentoXML.createTextNode("Masculino"));
            pessoa.appendChild(sexo);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            DOMSource documentoFonte = new DOMSource(documentoXML);
            
            StreamResult documentoFinal = new StreamResult(new File("C:\\pessoa.xml"));
            
            transformer.transform(documentoFonte, documentoFinal);
            
        } catch(ParserConfigurationException ex){
            Logger.getLogger(CriarDocXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
