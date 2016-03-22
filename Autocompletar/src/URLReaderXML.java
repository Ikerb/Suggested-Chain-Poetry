import java.net.*;
import java.io.*;

public class URLReaderXML {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("http://google.com/complete/search?output=toolbar&q=tengo%2015");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}