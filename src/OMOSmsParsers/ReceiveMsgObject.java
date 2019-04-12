
package omosmsparsers;

/**
 *
 * @author Christian
 */

public class ReceiveMsgObject{
        
        private String senderPhone;
        private String senderName;
        private String withdraweePhone;
        private String withdraweeName;
        private String transactionID;
        private String transactionAmt;
        private String frais;
        private String commission;
        private String netAmt;
        private String newSolde;
        
        private ReceiveMsgObject(){
            
        }
    

        public String getSenderPhone() {
            return senderPhone;
        }

        public void setSenderPhone(String senderPhone) {
            this.senderPhone = senderPhone;
        }

        public String getSenderName() {
            return senderName;
        }

        public void setSenderName(String senderName) {
            this.senderName = senderName;
        }

        public String getWithdraweePhone() {
            return withdraweePhone;
        }

        public void setWithdraweePhone(String withdraweePhone) {
            this.withdraweePhone = withdraweePhone;
        }

        public String getWithdraweeName() {
            return withdraweeName;
        }

        public void setWithdraweeName(String withdraweeName) {
            this.withdraweeName = withdraweeName;
        }

        public String getTransactionID() {
            return transactionID;
        }

        public void setTransactionID(String transactionID) {
            this.transactionID = transactionID;
        }

        public String getTransactionAmt() {
            return transactionAmt;
        }

        public void setTransactionAmt(String transactionAmt) {
            this.transactionAmt = transactionAmt;
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

        public String getNetAmt() {
            return netAmt;
        }

        public void setNetAmt(String netAmt) {
            this.netAmt = netAmt;
        }

        public String getNewSolde() {
            return newSolde;
        }

        public void setNewSolde(String newSolde) {
            this.newSolde = newSolde;
        }
    }