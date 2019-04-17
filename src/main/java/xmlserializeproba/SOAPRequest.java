package xmlserializeproba;

import com.sun.xml.internal.ws.resources.SoapMessages;
import com.sun.xml.internal.ws.util.Constants;

import javax.naming.Name;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.IOException;
import java.net.URL;



public class SOAPRequest {
    public static void main(String[] args) throws SOAPException, IOException {
        SOAPConnectionFactory sfc = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = sfc.createConnection();

        MessageFactory mf = MessageFactory.newInstance();
        SOAPMessage message = mf.createMessage();
        SOAPHeader header = message.getSOAPHeader();
        SOAPBody body = message.getSOAPBody();
        header.detachNode();
        QName bodyName = new QName("","kutyus");
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
        bodyElement.addAttribute(QName.valueOf("id"),"01");
        QName bodyName2 = new QName("","neve");
        SOAPElement bodyElement2 = bodyElement.addChildElement(bodyName2);
        bodyElement2.addTextNode("Bodri");
        QName bodyNamekor = new QName("","kora");
        SOAPElement bodyElementkor = bodyElement.addChildElement(bodyNamekor);
        bodyElementkor.addTextNode("14");
        message.writeTo(System.out);
        System.out.println();
        URL endpoint = new URL("http://kisccia");
        SOAPMessage response = connection.call(message,endpoint);
        System.out.println(response.getContentDescription());
    }
}
