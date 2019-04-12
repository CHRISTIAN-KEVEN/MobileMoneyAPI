
package MMoSmsParsers;

/**
 *
 * @author Christian
 */
public class MMOParser {

    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) {
        
        String solde = "Solde Courant: 0 FCFA ; Solde disponible: 0 FCFA ; Solde Credit de communication: 195 FCFA; Point de fidelite: 0";
        String reception1 = ": Vous avez recu 5000 FCFA de VEO SA  sur votre compte Mobile Money 2018-01-29 13:52:55."
                + " Message de l'expediteur: ."
                + " Votre nouveau solde est de: 5025 FCFA."
                + " Transaction Id: 228727690."
                + "";
        String reception2 = "Vous avez recu 2000 FCFA de STEPHANO YOUDOM KWEKAM (237679725441) le 2017-12-18 12:38:09. Transaction Id: 202074383.Reference: 1. Nouveau solde:17400 FCFA.";
       // String retrait = "Vous, Teguemne Fokam Cabrel (237674602315) avez effectue avec succes le retrait de 15000 FCFA de votre compte mobile money, chez CHINEDU MAGNUS CHINEDU MAGNUS le 2017-12-18 12:40:56. Transaction Id: 202076583. Votre nouveau solde est 2000. Frais 400.";
        String retrait = "Vous, AGWANJE AGWEIBAB AJEITOH CHRISTIAN KEVEN (237678491482) avez effectué avec succès le retrait de 2500 FCFA de votre compte mobile money, chez TAKAM JEAN BERTIN le 2018-02-02 08:33:19. Transaction Id: 231517236. Votre nouveau solde est 425. Frais 0.";
        String envoi = "Transfert de 5000 FCFA effectue avec succes a VANILLE SERGINE (237674856517) le 2017-12-22 14:38:15. FRAIS 50 FCFA. Transaction Id: 204952294 ; Reference: Chaussures. Nouveau solde est: 5350 FCFA.";
        
       // Map m2, m3, m4;
        ReceptionObject1 ro1 = receptionParser1(reception1);
        SendObject sObj = sendingParser(envoi);
        SoldeObject so = soldeParser(solde);
        WithdrawalObject wObj = withdrawalParser(retrait);
        ReceptionObject2 ro2 = ReceptionObject2.receptionParser2(reception2);
        
        
        System.out.println("********Retrait********\n\n"+wObj.getWithdraweeName()+"\n"+wObj.getWithdraweePhoneNumber()+"\n"
                + wObj.getAmount()+"\n"+wObj.getAgent()+"\n"+wObj.getWithdrawalDate()+" "+wObj.getWithdrawalTime()+"\n"
                +wObj.getTransactionID()+"\n"
                + wObj.getNouveauSolde()+"\n"+wObj.getFrais()
                
                +"\n\n********Solde********\n");
        System.out.println(so.getSoldeCourant()+"\n"+so.getSoldeDisponible()
        
                + "\n\n********Reception 1********\n");
        System.out.println(ro2.getAmount()+"\n"+ro2.getSenderName()+"\n"+ro2.getSenderNumber()+"\n"+ro2.getDate()+"\n"+ro2.getTime()+"\n"
                + ro2.getNewSolde()+"\n"+ro2.getTransactionID()+"\n"+ro2.getReference()
        
         + "\n\n********Reception 2********\n");
        System.out.println(ro2.getAmount()+"\n"+ro2.getSenderName()+"\n"+ro2.getSenderNumber()+"\n"+ro2.getDate()+" "+ro2.getTime()+"\n"
                + ro2.getNewSolde()+"\n"+ro2.getTransactionID()+"\n"+ro2.getReference()
                
                + "\n\n********Envoi********\n");
        System.out.println(sObj.getAmount()+"\n"+sObj.getRecipientName()+"\n"
                +sObj.getRecipientNumber()+"\n"+sObj.getDate()+" "+sObj.getTime()+"\n"
                +sObj.getFrais()+"\n"+sObj.getReference()+"\n"+sObj.getNouveauSolde()
        );
        //System.out.println(soldeParser(solde)+"\n\n********Envoi********\n");
        //System.out.println(sendingParser(envoi)+"\n\n********Reception********\n");
        //System.out.println(receptionParser(reception));
    }
    
       
    public static SoldeObject soldeParser(String msg){
        //Map<String, String> m = new HashMap();
        SoldeObject so = new SoldeObject();
        String[] parts = msg.split(";");
        String[] tab;
        
        StringBuilder sb = new StringBuilder();
        
        tab = parts[0].split(":");
        tab[1] = tab[1].substring(0, tab[1].indexOf('F'));
       // m.put(tab[0].trim().toLowerCase(), tab[1].trim());
        so.setSoldeCourant(tab[1].trim());

        
        tab = parts[1].split(":");
        tab[1] = tab[1].substring(0, tab[1].indexOf('F'));
        
        //m.put(tab[0].trim().toLowerCase(), tab[1].trim());
        so.setSoldeDisponible(tab[1].trim());
        
        return so;//sb.toString();
    }
    
//    public static Map receptionParser(String msg){
//        
//        Map<String,String> m = new HashMap();
//        
//        String[] tab;
//        
//        String FCFA = "FCFA";
//        
//        StringBuilder sb = new StringBuilder();
//        
//        msg = msg.replace(".", ";");
//        
//        String [] parts = msg.split(";");
//        
//        String amount = "Amount received:";
//        
//        String amountValue = parts[0].substring(parts[0].indexOf("recu")+4, parts[0].indexOf("FCFA"));
//        
//        m.put("Montant Recu".trim().toLowerCase(), amountValue.trim()+"");
//        
//        sb.append(amount);
//        
//        sb.append(amountValue);
//        
//        String sendBy = "Sent By:";
//        
//        String sender = parts[0].substring(parts[0].indexOf("de")+2, parts[0].indexOf("("));
//        
//        sb.append("\n");
//        
//        m.put("senderName".trim().toLowerCase(), sender.trim());
//        
//        sb.append(sendBy);
//        
//        sb.append(sender);
//        
//        sb.append("\n");
//        
//        String phone = "Sender's phone number: ";
//        
//        String phoneNumber = parts[0].substring(parts[0].indexOf("(")+1, parts[0].indexOf(")"));
//        
//        m.put("senderPhone".trim().toLowerCase(), phoneNumber.trim());
//        
//        sb.append(phone);
//        
//        sb.append(phoneNumber);
//        
//        sb.append("\n");
//        
//        sb.append(parts[1]); // to split with :
//        
//        tab = parts[1].split(":");
//        
//        m.put(tab[0].trim().toLowerCase(), tab[1].trim());
//        
//        tab = parts[2].split(":");
//        
//        m.put(tab[0].trim().toLowerCase(), tab[1].trim());
//        
//        sb.append("\n");
//        
//        sb.append(parts[3]);
//        
//        tab = parts[3].split(":");
//        
//        tab[1] = tab[1].substring(0, tab[1].indexOf('F'));
//        m.put(tab[0].trim().toLowerCase(), tab[1].trim());
//        return m;
//    }
    
    public static WithdrawalObject withdrawalParser(String msg){
        
        WithdrawalObject wo = new WithdrawalObject();
       // Map<String, String> m = new HashMap();
        String[] tab;
        
        msg = msg.replace(".", ";");
        
        String [] parts = msg.split(";");
        
        String [] firstPart = msg.split(",");
        
       // String withdrawee = "Withdrawee:";
        
        String withdraweeName = firstPart[1].substring(firstPart[1].indexOf(" "), firstPart[1].indexOf("("));
       // m.put("withdrawee".trim().toLowerCase(), withdraweeName.trim());
        wo.setWithdraweeName(withdraweeName.trim());
       
        
      //  String phone = "Withdrawee's phone number: ";
        
        String phoneNumber = firstPart[1].substring(firstPart[1].indexOf("(")+1, firstPart[1].indexOf(")"));
        //m.put("withdraweePhone".trim().toLowerCase(), phoneNumber.trim());
        wo.setWithdraweePhoneNumber(phoneNumber.trim());
        
       // String amount = "Withdrawal Amount:";
        
        String amountValue = firstPart[1].substring(firstPart[1].indexOf("retrait de")+10, firstPart[1].indexOf("FCFA"));
        //m.put("Montant retire".trim().toLowerCase(), amountValue.trim());
        wo.setAmount(amountValue.trim());
        
       // String agence = "Mobile Money Agent:";
        
        String agent = firstPart[2].substring(firstPart[2].indexOf("chez")+4, firstPart[2].indexOf("le"));
       // m.put("agence".trim().toLowerCase(), agent.trim());
        wo.setAgent(agent.trim());
        
        String[] lastPart = firstPart[2].substring(firstPart[2].indexOf("le ")+3).split(" ");
                
       // String date = "Date: ";
        
        String withdrawalDate = lastPart[0];
       
       // m.put("date".trim().toLowerCase(), withdrawalDate.trim());
        wo.setWithdrawalDate(withdrawalDate.trim());
        
      //  String hour = "Time: ";
        
        String withdrawalTime = lastPart[1].substring(0, lastPart[1].length()-1);
       // m.put("hour".trim().toLowerCase(), withdrawalTime.trim());
        wo.setWithdrawalTime(withdrawalTime.trim());
        
        //Getting tht transaction id
        
        tab = parts[1].split(":");
      //  m.put(tab[0].trim().toLowerCase(), tab[1].trim());
        wo.setTransactionID(tab[1].trim());
        
        
        parts[2] = parts[2].substring(parts[2].indexOf("est")+3, parts[2].length()).trim();
        
        //tab = parts[2].split(":");
        
        //m.put("Nouveau Solde".trim().toLowerCase(), parts[2]);
        wo.setNouveauSolde(parts[2].trim());
        
        //tab = parts[3].split(":");
        
        parts[3] = parts[3].substring(parts[3].indexOf('s')+1, parts[3].length()).trim();
      //  m.put("frais".trim().toLowerCase(), parts[3].trim());
        wo.setFrais(parts[3].trim());
        //sb.append(" FCFA");
        
        return wo;
    }
    
    public static SendObject sendingParser(String msg){
        //Map<String, String> m = new HashMap();
        SendObject so = new SendObject();
        
        String[] tab ;
        msg = msg.replace(".", ";");
        
        String[] parts = msg.split(";");
        
        String part1 = parts[0];
        
        // Getting amount
        
        String amountValue = part1.substring(part1.indexOf("de")+2, part1.indexOf("FCFA"));
        // m.put("Montant envoye".trim().toLowerCase(), amountValue.trim());
        so.setAmount(amountValue.trim());   
        
        // Getting Receipient's Name
        String recipientName = part1.substring(part1.indexOf("a ")+2, part1.indexOf("("));
                
      //  m.put("senderName".trim().toLowerCase(), recipientName.trim());
        so.setRecipientName(recipientName.trim());
        
        // Getting Recipient's phone number
        
        String phoneNumber = part1.substring(part1.indexOf("(")+1, part1.indexOf(")"));   
       // m.put("withdraweePhone".trim().toLowerCase(), phoneNumber.trim());
        so.setRecipientNumber(phoneNumber.trim());
        
        String[] lastPart = part1.substring(part1.indexOf("le ")+3).split(" ");
                
       // Getting the date
       String withdrawalDate = lastPart[0];

       // m.put("date".trim().toLowerCase(), withdrawalDate.trim());
        so.setDate(withdrawalDate.trim());
        
       // Getting time
        String withdrawalTime = lastPart[1].substring(0, lastPart[1].length());
        
        //m.put("hour".trim().toLowerCase(), withdrawalTime.trim());
        so.setTime(withdrawalTime.trim());

        //tab = parts[1].split(":");
        
    // Getting frais    
        parts[1] = parts[1].substring(parts[1].indexOf('S')+2, parts[1].length());
        
        String frais = parts[1].substring(0, parts[1].indexOf('F')).trim();
        
       // m.put("frais".trim().toLowerCase(), frais.trim());
        so.setFrais(frais.trim());
        
      // Getting transaction id
        tab = parts[2].split(":");
        
       // m.put(tab[0].trim().toLowerCase(), tab[1].trim());
        so.setTransactionID(tab[1].trim());
        
       // Getting Reference 
        tab = parts[3].split(":");
       // m.put(tab[0].trim().toLowerCase(), tab[1].trim());
        so.setReference(tab[1].trim());
        
        tab = parts[4].split(":");
        
       // m.put("Nouveau Solde".trim().toLowerCase(), tab[1].substring(0, tab[1].indexOf('F')).trim());
        so.setNouveauSolde(tab[1].substring(0, tab[1].indexOf('F')).trim());
        
        
        return so;
    }
    
    
    public static ReceptionObject1 receptionParser1(String msg){
        
        ReceptionObject1 ro = new ReceptionObject1();
        String[] parts = msg.split("\\.");
        
        String part1 = parts[0];
        String part3 = parts[2];
        String part4 = parts[3];
        
        //Getting the amount
        String amount = part1.substring(part1.indexOf("recu")+5, part1.indexOf("FCFA")).trim();
        ro.setAmount(amount);
        
        //Getting the Mobile Money agent Name
        String senderName = part1.substring(part1.indexOf("de")+2, part1.indexOf("sur"));
        ro.setSenderName(senderName.trim());
        
        //Getting the date
        String date = part1.substring(part1.indexOf("Money")+6, part1.indexOf("Money")+16).trim();
        ro.setDate(date);
        
        //Getting the time
        String time = part1.substring(part1.indexOf("Money")+16, part1.indexOf("Money")+25).trim();
        ro.setTime(time);
        
        //Getting the solde
        String nouveauSolde = part3.substring(part3.indexOf(":")+1,part3.indexOf("FCFA"));
        ro.setNewSolde(nouveauSolde.trim());
        
        //Getting the transaction id
        String transactionId = part4.substring(part4.indexOf(":")+1);
        ro.setTransactionID(transactionId.trim());
        
        return ro;
    }
}