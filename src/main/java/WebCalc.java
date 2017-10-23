import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.File;
import java.io.IOException;

@XmlRootElement(name = "webcalc")
@XmlType(propOrder = {"result","expression","errorDescription","success"})
public class WebCalc
{
    private String result;
    private Expression expression;
    private String errorDescription;
    private boolean success;

    //############## Constructors ####################
    public WebCalc() {}

    //############## Getters & Setters ###############
    public boolean isSuccess() {
        return success;
    }
    @XmlElement
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
    @XmlElement
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getResult() {
        return result;
    }
    @XmlElement
    public void setResult(String result) {
        this.result = result;
    }

    public Expression getExpression() {
        return expression;
    }
    @XmlElement
    public void setExpression(Expression express) {
        this.expression = express;
    }

    /**
     * Должен возвращать /calc тело запроса: {"operand1": "2", "operation": "mult","operand2": "2"}
     * @return
     */
    @Override
    public String toString() {
        return "WebCalc{" +
                "result: " + getResult()  +", " +
                "expression{: " +
                "operand1: " + expression.getOperand1() + ", " +
                "operation: " + expression.getOperation() + ", " +
                "operand2: " + expression.getOperand2() + "}, " +
                "errorDescription: " + getErrorDescription() +", " +
                "success: " + isSuccess() +
                "}";
    }
    //########## Marshalling ##############
    public static void marshaller(WebCalc webCalc,String nameXmlFile) throws IOException
    {
        XStream xStream=new XStream(new DomDriver());
        xStream.alias(nameXmlFile, WebCalc.class);
        xStream.processAnnotations(WebCalc.class);
    }

    //########### Unmarshaling #############

    public static Object getObject(File file, Class c) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(file);

        return object;
    }
    //############ Main ##############
    public static void main(String[] args) throws IOException, ClassNotFoundException, JAXBException {
        Expression inCalc=new Expression("1","mult","2");
        HttpConnection connection=new HttpConnection("POST");
        connection.createJson(inCalc.getOperand1(),inCalc.getOperation(),inCalc.getOperand2());
        String str=connection.sendRequest().toString();
        System.out.println(str);
        //String nameXmlFile = "webcalc";
       // marshaller(inCalc, nameXmlFile);

        WebCalc exCalc =(WebCalc)  getObject(new File("Response.xml"), WebCalc.class);
      //  WebCalc exCalc = unmarshalling(new File("Response.xml"));
        System.out.println(exCalc.toString());

    }

}