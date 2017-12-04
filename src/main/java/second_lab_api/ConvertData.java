package second_lab_api;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class ConvertData
{


    //########### Unmarshaling #############
    public static Object getObject(String  answer, Class c) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Object object = unmarshaller.unmarshal(new StringReader(answer));

        return object;
    }
}