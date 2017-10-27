package second_lab_api;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
        return "second_lab_api.WebCalc{" +
                "result: " + getResult()  +", " +
                "expression{: " +
                "operand1: " + expression.getOperand1() + ", " +
                "operation: " + expression.getOperation() + ", " +
                "operand2: " + expression.getOperand2() + "}, " +
                "errorDescription: " + getErrorDescription() +", " +
                "success: " + isSuccess() +
                "}";
    }
    //############ first_lab.Main ##############
    public static void main(String[] args) throws IOException, ClassNotFoundException, JAXBException {
        Expression inCalc=new Expression("1","mult","2");
        HttpConnection connection=new HttpConnection("POST");
        connection.createJson(inCalc.getOperand1(),inCalc.getOperation(),inCalc.getOperand2());
        String str=connection.sendRequest().toString();
        System.out.println(str);
        //String nameXmlFile = "webcalc";
       // marshaller(inCalc, nameXmlFile);

        WebCalc exCalc =(WebCalc)  ConvertData.getObject(str, WebCalc.class);
      //  second_lab_api.WebCalc exCalc = unmarshalling(new File("Response.xml"));
        System.out.println(exCalc.toString());

    }

}