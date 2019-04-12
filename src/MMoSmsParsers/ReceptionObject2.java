/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MMoSmsParsers;

/**
 *
 * @author Christian
 */
public class ReceptionObject2 extends ReceptionObject1 {
    
    private String reference;
    private String senderNumber;

    
    public ReceptionObject2(){
        super();
    }

    
    public String getSenderNumber() {
        return senderNumber;
    }

    public void setSenderNumber(String senderNumber) {
        this.senderNumber = senderNumber;
    }
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    
    public static ReceptionObject2 receptionParser2(String message){
        
       ReceptionObject2 ro2 = new ReceptionObject2();
        
       String[] parts = message.split("\\.");
       
       String amount = parts[0].substring(parts[0].indexOf("recu")+5, parts[0].indexOf("FCFA")-1);
       ro2.setAmount(amount.trim());
       
       String senderName = parts[0].substring(parts[0].indexOf("de")+3, parts[0].indexOf("(")-1);
       ro2.setSenderName(senderName.trim());
       
       String senderNumber = parts[0].substring(parts[0].indexOf("(")+1, parts[0].indexOf(")"));
       ro2.setSenderNumber(senderNumber.trim());
       
       String date = parts[0].substring(parts[0].indexOf("le")+3, parts[0].indexOf("le")+13);
       ro2.setDate(date.trim());
       
       String time = parts[0].substring(parts[0].indexOf("le")+14);
       ro2.setTime(time.trim());
       
       String transactionID = parts[1].substring(parts[1].indexOf(":")+2);
       ro2.setTransactionID(transactionID.trim());
       
       String reference = parts[2].substring(parts[2].indexOf(":")+2);
       ro2.setReference(reference.trim());
       
       String nouveauSolde = parts[3].substring(parts[3].indexOf(":")+1, parts[3].indexOf("FCFA")-1);
       ro2.setNewSolde(nouveauSolde.trim());
       
       return ro2;
    }
}
