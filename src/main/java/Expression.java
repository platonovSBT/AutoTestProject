import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "operand1", "operation" ,"operand2"}, name = "expression")
public class Expression
{
    private String operand1;
    private String operation;
    private String operand2;

    //######### Constructors #############
    public Expression()
    {}
    public Expression(String operand1, String operation,String operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
    }

    //######### Getters & Setters ##########
    public String getOperand1() {
        return operand1;
    }
    @XmlElement
    public void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    public String getOperand2() {
        return operand2;
    }
    @XmlElement
    public void setOperand2(String operand2) {
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }
    @XmlElement
    public void setOperation(String operation) {
        this.operation = operation;
    }
}