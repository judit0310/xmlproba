package kiscica;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XMLBeolvasas {
    public static void main(String[] args) throws JAXBException, IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        File file = new File( "src/main/resources/menhely.xml" );
        Source xmlfile = new StreamSource(file);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File("src/main/resources/menhely.xsd")) ;
        Validator valudator = schema.newValidator();
        try {
            valudator.validate(xmlfile);
            unmarshall(file);
        }catch (SAXParseException e){
            System.out.println("Problem, It is not valid! "+e.getMessage());
        }


    }

    private  static void unmarshall(File xmlFile) throws JAXBException, XPathExpressionException, IOException, SAXException, ParserConfigurationException {
        JAXBContext jc = JAXBContext.newInstance( Menhely.class);
        Unmarshaller u = jc.createUnmarshaller();

        Menhely o = (Menhely) u.unmarshal( xmlFile);
        List<Kutyus> kicsikutyik= o.getKiskutyak().getKutyus();
        List<String> ivartalanitvaMost = new ArrayList<String>();
        o.setNeve("Allatbarotki");
        o.getKiskutyak().kutyus=orokbefogadas(o.getKiskutyak().getKutyus(), "Mici");
        for (Kutyus k : o.getKiskutyak().getKutyus() ) {
            System.out.println(k.getKora());
            k.setKora(k.getKora()+1);
            if(k.getNeve().equalsIgnoreCase("mici")){
                k.setAllatutlevelSzama(BigInteger.valueOf(28));
            }
            if(!k.isIvartalanitva()){
                ivartalanitvaMost.add(k.getNeve());
            k.setIvartalanitva(true);}
        }
        System.out.println(ivartalanitvaMost);
        Marshaller m =jc.createMarshaller();
        m.marshal(o, new File("probakiscica.xml"));
        System.out.println(o.getKiskutyak().getKutyus());


        /*
        private void SerializeDataSet(string filename){

            XmlSerializer ser = new XmlSerializer(typeof(DataSet));

        // Creates a DataSet; adds a table, column, and ten rows.
        DataSet ds = new DataSet("myDataSet");
        DataTable t = new DataTable("table1");
        DataColumn c = new DataColumn("thing");
        t.Columns.Add(c);
        ds.Tables.Add(t);
        DataRow r;
        for(int i = 0; i<10;i++){
            r = t.NewRow();
             r[0]    = "Thing " + i;
         t.Rows.Add(r);
        }
        TextWriter writer = new StreamWriter(filename);
        ser.Serialize(writer, ds);
        writer.Close();

         */

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("src/main/resources/menhely.xml");
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        XPathExpression expr = xpath.compile("//nem");

        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i<nodes.getLength();i++){
            System.out.println(nodes.item(i).getTextContent());
        }
        System.out.println(nodes.getLength());
    }

    private static List<Kutyus> orokbefogadas(List<Kutyus> kutyik,String mici) {
        List<Kutyus> result = new ArrayList<Kutyus>(kutyik);
        for(Kutyus k : kutyik){
            if(k.getNeve().equalsIgnoreCase(mici)){
            result.remove(k);
            break;
        }}
        return result;

    }
}
