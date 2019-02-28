package pdfcompare;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.lang.Exception;
import java.lang.ClassLoader;
import java.io.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws java.io.IOException, TikaException, SAXException
    {
    	BodyContentHandler body = new BodyContentHandler();
        Metadata schema = new Metadata();
        FileInputStream stream = new FileInputStream(new File("C:\\Users\\My Pc\\eclipse-workspace\\pdfcompare\\googleprivacypolicy.pdf"));
        ParseContext parsecontext = new ParseContext();
        
        //parsing the document using PDF parser
        PDFParser parsePDF = new PDFParser(); 
        parsePDF.parse(stream, body, schema,parsecontext);
        
        //getting the content of the document
        System.out.println("Contents of the PDF :" + body.toString());
        
        //getting metadata of the document
        System.out.println("Metadata of the PDF:");
        String[] metadataNames = schema.names();
        
        for(String name : metadataNames) {
           System.out.println(name+ " : " + schema.get(name));
        }
    }
}
