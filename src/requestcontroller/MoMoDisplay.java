/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requestcontroller;

/**
 *
 * @author Christian
 */
public class MoMoDisplay {
    
    private String ReceiverNumber;
    private String StatusCode;
    private String Amount;
    private String TransactionID;
    private String ProcessingNumber;
    private String OpComment;
    private String StatusDesc;
    private String SenderNumber;
    private String OperationType;
    
    public MoMoDisplay(){
    }
    
    public String getReceiverNumber(){
        return ReceiverNumber;
    } 
    public void setReceiverNumber(String s){
        ReceiverNumber = s;
    }
    
    public String getStatusCode(){
        return StatusCode;
    }
    public void setStatusCode(String s){
        StatusCode = s;
    }
    
    public String getAmount(){
        return Amount;
    }
    public void setAmount(String s){
        Amount = s;
    }
    
    public String getTransactionID(){
        return TransactionID;
    }
    public void setTransactionID(String s){
        TransactionID = s;
    }
    
    public String getProcessingNumber(){
        return ProcessingNumber;
    }
    public void setProcessingNumber(String s){
        ProcessingNumber = s;
    }
    
    public String getOpComment(){
        return OpComment;
    }
    public void setOpComment(String s){
        OpComment = s;
    }
    
    public String getStatusDesc(){
        return StatusDesc;
    }
    public void setStatusDesc(String s){
        StatusDesc = s;
    }
    
    public String getSenderNumber(){
        return SenderNumber;
    }
    public void setSenderNumber(String s){
        SenderNumber = s;
    }
    
    public String getOperationType(){
        return OperationType;
    }
    public void setOperationType(String s){
        OperationType = s;
    }
    
    @Override
    public String toString(){
        
        return " Vous, numero "+getSenderNumber()+" avez essaye d envoye la somme de "+getAmount()+" au numero "+getReceiverNumber()+"\n\n"
                +"********TransactionID: "+getTransactionID()+"********\n"
                +"********Status Code : "+getStatusCode()+" ********\n"
                +"********OpComment: "+getOpComment()+"********\n"
                +"********Processing Number: "+getProcessingNumber()+"********\n"
                +"*********Operation Type: "+getOperationType()+"********\n"
                +"*********Status Description: "+getStatusDesc()+"********\n\n"
                +"*********Commentaire de la transaction: "+getOpComment();
    }
}
