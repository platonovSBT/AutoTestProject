package second_lab_api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConnection
{
    private URL url;

    private String jsonStr;

    private String typeRequest;

    private JsonObject jsonObj;

    public HttpConnection(String typeRequest) throws MalformedURLException {
        this.typeRequest = typeRequest;
        this.url=new URL("http://localhost:8888/calc");
    }

    public void createJson(String oper1,String operand,String oper2)
    {
        jsonStr = "{\"operand1\": \""+oper1+"\", \"operation\": \""+operand+"\",\"operand2\":\""+oper2+"\"}";
        JsonParser parser=new JsonParser();
        jsonObj =parser.parse(jsonStr).getAsJsonObject();
    }

    public String sendRequest() throws IOException
    {
        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
        conn.setRequestMethod(typeRequest);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        OutputStream os=conn.getOutputStream();
        os.write(jsonObj.toString().getBytes("UTF-8"));
        os.close();
        System.out.println(jsonObj.toString()+" Status:"+conn.getResponseCode() + " - "+conn.getResponseMessage());


        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        /**
         * Вывод ответа в файл

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("Response.xml")));
        bufferedWriter.write(response.toString());
        bufferedWriter.close();
         */
        in.close();
        conn.disconnect();
        return  response.toString();
    }


}