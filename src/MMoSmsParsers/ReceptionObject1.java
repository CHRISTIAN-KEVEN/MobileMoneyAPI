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
public class ReceptionObject1 {
    
    private String amount;
    private String senderName;
    private String date;
    private String newSolde;
    private String transactionID;
    private String time;
 
    public ReceptionObject1(){
        
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String agentName) {
        this.senderName = agentName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNewSolde() {
        return newSolde;
    }

    public void setNewSolde(String newSolde) {
        this.newSolde = newSolde;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
}
