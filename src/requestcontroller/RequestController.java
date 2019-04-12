
package requestcontroller;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
public class RequestController {

    /**
     * @param args the command line arguments
     */
   public static final String CONTENT_TYPE = "text/html";
   public static void main(String[] args)  throws Exception{
        RequestController  test =new RequestController();
        test.go();
        }
   
   public void go() throws Exception {
          int statut1;
           String reponse ;
       CloseableHttpClient client = HttpClientBuilder.create().build();// new DefaultHttpClient();

       
       BufferedReader br = null;

       HttpGet method;
       
       URI uri = new URIBuilder("https://developer.mtn.cm/OnlineMomoWeb/faces/transaction/transactionRequest.xhtml")
       .addParameter("idbouton","2")
       .addParameter("typebouton", "PAIE")
       .addParameter("_amount", "100")
       .addParameter("_tel", "678491482")
       .addParameter("_clP", "")
       .addParameter("_email", "wfotsingmegasoft@gmail.com")
       .addParameter("typebouton", "PAIE")
       .build();
      
       method = new HttpGet(uri);
       
       try{
                HttpResponse response = client.execute(method);   
                System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

BufferedReader rd = new BufferedReader(
	new InputStreamReader(response.getEntity().getContent()));

StringBuffer result = new StringBuffer();
String line = "";
while ((line = rd.readLine()) != null) {
	result.append(line);
}
 String string = result.toString();
  System.out.println(JsonParser(string));
              
       }catch (Exception e) {
            e.printStackTrace();
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
   public String JsonParser(String str){
       
       Gson gson = new Gson();
       MoMoDisplay display = gson.fromJson(str, MoMoDisplay.class);
       
       if(display != null){
           
         return display.toString();
       }
       return null;
   }
   
   
    
   
   
   
   
   
   
  public MoMoDisplay processMobilePayment(String amount, String clientPhone) throws Exception{
   
           String reponse ;
       CloseableHttpClient client = HttpClientBuilder.create().build();// new DefaultHttpClient();
      
       BufferedReader br = null;

       HttpGet method;
       
       URI uri = new URIBuilder("https://developer.mtn.cm/OnlineMomoWeb/faces/transaction/transactionRequest.xhtml")
       .addParameter("idbouton","2")
       .addParameter("typebouton", "PAIE")
       .addParameter("_amount", amount)
       .addParameter("_tel", clientPhone)
       .addParameter("_clP", "")
       .addParameter("_email", "wfotsingmegasoft@gmail.com")
       .addParameter("typebouton", "PAIE")
       .build();
      
       method = new HttpGet(uri);
       
                HttpResponse response = client.execute(method);   
                System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

    BufferedReader rd = new BufferedReader(
	new InputStreamReader(response.getEntity().getContent()));

   StringBuffer result = new StringBuffer();
   String line = "";
   while ((line = rd.readLine()) != null) {
	result.append(line);
   }
 String string = result.toString();
  //System.out.println(JsonParser(string));
 
 // Create Gson object that will be used to convert the json returned data to our MoMoDisplay object
 Gson gson = new Gson();
 MoMoDisplay display = gson.fromJson(string, MoMoDisplay.class);
       
 method.releaseConnection();
       
 if(br != null){
    try {
          br.close(); 
    } catch (Exception fe) {System.err.println("Unable to close connection");}}
       
 if(display != null)
     return display;
  return null;
  }
}