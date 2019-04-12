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
class WithdrawalObject {
    private String withdraweeName;
    private String withdraweePhoneNumber;
    private String amount;
    private String agent;
    private String withdrawalDate;
    private String withdrawalTime;
    private String nouveauSolde;
    private String transactionID;
    private String frais;
    
    public WithdrawalObject(){
        
    }

    public String getWithdraweeName() {
        return withdraweeName;
    }

    public void setWithdraweeName(String withdraweeName) {
        this.withdraweeName = withdraweeName;
    }

    public String getWithdraweePhoneNumber() {
        return withdraweePhoneNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
     
    public void setWithdraweePhoneNumber(String withdraweePhoneNumber) {
        this.withdraweePhoneNumber = withdraweePhoneNumber;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(String withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public String getWithdrawalTime() {
        return withdrawalTime;
    }

    public void setWithdrawalTime(String withdrawalTime) {
        this.withdrawalTime = withdrawalTime;
    }

    public String getNouveauSolde() {
        return nouveauSolde;
    }

    public void setNouveauSolde(String nouveauSolde) {
        this.nouveauSolde = nouveauSolde;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getFrais() {
        return frais;
    }

    public void setFrais(String frais) {
        this.frais = frais;
    }
    
    
}
