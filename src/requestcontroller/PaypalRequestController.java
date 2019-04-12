package requestcontroller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author Christian
 */
public class PaypalRequestController {

    /**
     * @param args the command line arguments
     */
   public static final String CONTENT_TYPE = "text/html";
   public static void main(String[] args)  throws Exception{
        PaypalRequestController  test =new PaypalRequestController();
        test.go("Chocolat");
        }
   
   public void go(String itemSelected) throws Exception {
          int statut1;
           String reponse ;
       //CloseableHttpClient client = HttpClientBuilder.create().build();// new DefaultHttpClient();

       BufferedReader br = null;

      // HttpGet method;
      
       //Build request with all parameters to be sent
       URI uri = new URIBuilder("https://www.paypal.com/cgi-bin/webscr")
               .addParameter("name", "s-xclick")
               .addParameter("hosted_button_id","WQXYGR8DBGLQG")
               .addParameter("on0", "Articles disponible")
               .addParameter("os0", itemSelected)
               .addParameter("currency_code", "EUR")
       .build();
      
       HttpGet method = new HttpGet(uri);
       CloseableHttpClient client = HttpClientBuilder.create().build();// new DefaultHttpClient();
       try{
                HttpResponse response = client.execute(method);   
                System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

                br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuffer result = new StringBuffer();
                String line;
                PrintWriter pw = new PrintWriter(new FileWriter(new File("paypalReturn.html")));
                while ((line = br.readLine()) != null) {
	               result.append(line);
                       pw.write(line+"\n");
                }
                String string = result.toString();
             //   System.out.println(JsonParser(string));
             
             
              
       }catch (IOException | UnsupportedOperationException e) {
           System.out.println();
       } 
       finally {
           System.out.println("fin de ma connexion "+System.currentTimeMillis());
       method.releaseConnection();
       
       if(br != null){
           try {
               br.close(); 
           } catch (Exception fe) {System.err.println("Unable to close connection");}}
       }   
}
}