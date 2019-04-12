/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omosmsparsers;

/**
 *
 * @author Christian
 */
public class CashoutMsgObject{
    
        private String phoneNum;
        private String amount;
        private String frais;
        private String commission;
        private String transactionNum;
        private String amtDebited;
        private String newSolde;
        
        public CashoutMsgObject(){
        }

        public String getPhoneNum() {
            return phoneNum;
        }

        public void setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getFrais() {
            return frais;
        }

        public void setFrais(String frais) {
            this.frais = frais;
        }

        public String getCommission() {
            return commission;
        }

        public void setCommission(String commission) {
            this.commission = commission;
        }

        public String getTransactionNum() {
            return transactionNum;
        }

        public void setTransactionNum(String transactionNum) {
            this.transactionNum = transactionNum;
        }

        public String getAmtDebited() {
            return amtDebited;
        }

        public void setAmtDebited(String amtDebited) {
            this.amtDebited = amtDebited;
        }

        public String getNewSolde() {
            return newSolde;
        }

        public void setNewSolde(String newSolde) {
            this.newSolde = newSolde;
        }
             
    }
