package test_second_lab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import second_lab_api.ConvertData;
import second_lab_api.Expression;
import second_lab_api.HttpConnection;
import second_lab_api.WebCalc;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestWebCalc {
    private  HttpConnection connection;
    private String result;
    private Expression expression;
    private String errorDescription;
    private boolean success;

    /*Поддерживаемые операции:
- Сложение - plus
- Вычитание - minus
- Умножение - mult
- Деление - div
*/
    public TestWebCalc(String inOper1,String inOperat,String inOper2, String result)
    {
        expression=new Expression(inOper1,inOperat,inOper2);
        this.result=result;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
                { "1","plus","2", "3.0"},
                {  "10","minus","3", "7.0"},
                {  "10","mult","10", "100.0"},
                {  "25","div","5", "5.0"},
                {  "25","div","4", "5"},
                {  "25","div","0", "5"},
                {  null,"div","4", "5"},
                {  "25","div","afafsa", "5"}
        });
    }

    public  void init() throws MalformedURLException {
        connection=new HttpConnection("POST");
    }
    @After
    public void afterTest() {
        connection = null;
    }


    @Test
    public void testCalc() throws IOException, JAXBException {
        connection.createJson(expression.getOperand1(),expression.getOperation(),expression.getOperand2());
        String str=connection.sendRequest().toString();
        WebCalc exCalc =(WebCalc)  ConvertData.getObject(str, WebCalc.class);
        System.out.println( exCalc.toString());

        assertEquals("Неверное вычисление!"+exCalc.getErrorDescription(), exCalc.getResult() ,  result );
    }
}