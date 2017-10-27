package second_lab_api;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;

public class ConvertData
{
    //########## Marshalling ##############
    public static void marshaller(WebCalc webCalc,String nameXmlFile) throws IOException
    {
        XStream xStream=new XStream(new DomDriver());
        xStream.alias(nameXmlFile, WebCalc.class);
        xStream.processAnnotations(WebCalc.class);
    }

    //########### Unmarshaling #############
    public static Object getObject(String  answer, Class c) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Object object = unmarshaller.unmarshal(new StringReader(answer));

        return object;
    }
}