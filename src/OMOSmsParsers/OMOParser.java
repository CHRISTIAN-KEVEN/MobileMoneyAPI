package omosmsparsers;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tfcyoo and Christian
 */
public class OMOParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String solde = "Le solde de votre compte est de 32040.00 FCFA.";
        String solde = "Le solde de votre compte est de 840.00 FCFA.";
        String envoi = "Transfert de 696201988 Gouado vers 698497639 NGUEKAM KOUE MAPOH reussi. ID transaction: PP171224.2025.A64712, Montant Transaction: 20000.00 FCFA, Frais: 100.00 FCFA, Commission: 0.00 FCFA, Montant Net: 20100.00 FCFA, Nouveau Solde: 3740.00 FCFA.";
        String reception ="Transfert de 655867729 NJOYA POKAM vers 696201988 Gouado reussi. Details: ID transaction: PP171231.0206.A62210, Montant Transaction: 5000.00FCFA, Frais: 0.00 FCFA, Commission: 0.00 FCFA, Montant Net: 5000.00 FCFA, Nouveau Solde: 6040.00 FCFA.";
        //String retrait = "Retrait d'argent reussi par le 694473589. Informations detaillees : Montant: 2000.00 FCFA, Frais: 60.00 FCFA, commission: 0.00 FCFA, No de transaction CO171207.1221.A17973, montant net debite 2060.00 FCFA, Nouveau solde: 1840.00 FCFA.";
          String retrait = "Retrait d'argent reussi par le 655916949. Informations detaillees : Montant: 50000.00 FCFA, Frais: 700.00 FCFA, commission: 0.00 FCFA, No de transaction CO180103.1437.A89697, montant net debite 50700.00 FCFA, Nouveau solde: 56820.00 FCFA.";
      //  Map m,m1,m2,m3;
        SoldeMsgObject smo = soldeMsgParser(solde);
        SendMsgObject sendMsgObj= sendingParser(envoi);
        SendMsgObject receiveMsgObj = sendingParser(reception);
        CashoutMsgObject cmo = withdrawalParser(retrait);
        
        
        System.out.println("********Retrait (Cashout)********\n\n"+cmo.getPhoneNum()+"\n"
                                                                  +cmo.getAmount()+"\n"
                                                                  +cmo.getFrais()+"\n"
                                                                  +cmo.getTransactionNum()+"\n"
                                                                  +cmo.getAmtDebited()+"\n"
                                                                  +cmo.getNewSolde()
                +"\n\n********Solde********\n");
        System.out.println(smo.getSolde()+ "\n\n********Envoi********\n");
        System.out.println(sendMsgObj.getSenderPhone()+"\n"
                          +sendMsgObj.getSenderName()+"\n"
                          +sendMsgObj.getWithdraweePhone()+"\n"
                          +sendMsgObj.getWithdraweeName()+"\n"
                          +sendMsgObj.getTransactionID()+"\n"
                          +sendMsgObj.getTransactionAmt()+"\n"
                          +sendMsgObj.getFrais()+"\n"
                          +sendMsgObj.getCommission()+"\n"
                          +sendMsgObj.getNetAmt()+"\n"
                          +sendMsgObj.getNewSolde()
                
               +"\n\n********Reception********\n");
        
        System.out.println(receiveMsgObj.getSenderPhone()+"\n"
                          +receiveMsgObj.getSenderName()+"\n"
                          +receiveMsgObj.getWithdraweePhone()+"\n"
                          +receiveMsgObj.getWithdraweeName()+"\n"
                          +receiveMsgObj.getTransactionID()+"\n"
                          +receiveMsgObj.getTransactionAmt()+"\n"
                          +receiveMsgObj.getFrais()+"\n"
                          +receiveMsgObj.getCommission()+"\n"
                          +receiveMsgObj.getNetAmt()+"\n"
                          +receiveMsgObj.getNewSolde()
                );
    }
    
    public static SoldeMsgObject soldeMsgParser(String msg){
        
        //Map<String, String> m = new HashMap();
        SoldeMsgObject smo = new SoldeMsgObject();
        //String[] tab;
        StringBuilder sb = new StringBuilder();       
        int indexSolde = msg.lastIndexOf("de ")+2;
        
        String soldeLabel = "solde: ";
        
        String montantSolde = msg.substring(indexSolde, msg.lastIndexOf("."));
        
        montantSolde = montantSolde.substring(0, montantSolde.indexOf('F'));
        sb.append(soldeLabel);
        smo.setSolde(montantSolde.trim());
        
        //sb.append(montantSolde);
        
        return smo;
    }
    
    // Also used for Receive Messages //
    public static SendMsgObject sendingParser(String msg){
        
        //Map<String, String> m = new HashMap();
        SendMsgObject smo = new SendMsgObject();
        String[] tab;  
        StringBuilder sb = new StringBuilder();
        
        String part1 = msg.substring(0, msg.indexOf("."));
        
        String senderPhone = "sender's phone number";
        
        String phoneNumber = part1.substring(part1.indexOf("de")+2, part1.indexOf("de")+12);
        String senderName = part1.substring(part1.indexOf("de")+12, part1.indexOf("vers"));
        smo.setSenderPhone(phoneNumber.trim());
        smo.setSenderName(senderName.trim());
        
        String withdraweePhone = part1.substring(part1.indexOf("vers")+4, part1.indexOf("vers")+14);
        smo.setWithdraweePhone(withdraweePhone.trim());
        String withdraweeName = part1.substring(part1.indexOf("vers")+15, part1.indexOf("reussi")-1);
        smo.setWithdraweeName(withdraweeName.trim());
        
        
     //   String sender = "sender:";
     //  String senderName = part1.substring(part1.indexOf("de")+12, part1.indexOf("vers"));
        
        String[] part2 = msg.substring(msg.indexOf(".")+1).split(",");
                
        tab = part2[0].split(":");
       
        //tab[1] = tab[1].substring(0, tab[1].indexOf('F'));
        if(tab.length == 2)
           // m.put("Transaction Id".trim().toLowerCase(), tab[1].trim());
            smo.setTransactionID(tab[1].trim());
        else{
           // m.put("Transaction Id".trim().toLowerCase(), tab[2].trim());
            smo.setTransactionID(tab[2].trim());
        }
     // Transaction amount
        tab = part2[1].split(":");
        tab[1] = tab[1].substring(0, tab[1].indexOf('F'));       
       // m.put(tab[0].trim().toLowerCase(), tab[1].trim());
        smo.setTransactionAmt(tab[1].trim());
        
     // Frais   
        tab = part2[2].split(":");
        tab[1] = tab[1].substring(0,tab[1].indexOf("F"));
        smo.setFrais(tab[1].trim());
        
        //sb.append(part2[3]);
        
    // Commission 
        tab = part2[3].split(":");
        tab[1] = tab[1].substring(0, tab[1].indexOf('F'));
       // m.put(tab[0].trim().toLowerCase(), tab[1].trim());
        smo.setCommission(tab[1].trim());
        
    // Montant Net
        tab = part2[4].split(":");
        tab[1] = tab[1].substring(0, tab[1].indexOf('F'));
       // m.put(tab[0].trim().toLowerCase(), tab[1].trim());
        smo.setNetAmt(tab[1].trim());
        
    // Nouveau Solde    
        tab = part2[5].split(":");
        tab[1] = tab[1].substring(0, tab[1].indexOf('F'));
       // m.put(tab[0].trim().toLowerCase(), tab[1].trim());
        smo.setNewSolde(tab[1].trim());
        //m.put("asend", parts2[5].substring(0, parts2[5].lastIndexOf(".")));
        
        
        return smo;
    }
    
    public static String receptionParser(String msg){
        
        return null;
    }
    
    public static CashoutMsgObject withdrawalParser(String msg){
        
        CashoutMsgObject cmp = new CashoutMsgObject();
        String[]tab;
        StringBuilder sb = new StringBuilder();
        
        String part1 = msg.substring(0, msg.indexOf("."));
        
    // Phone Number    
        String phoneNumber = part1.substring(part1.indexOf("le")+2, part1.indexOf("le")+12);
        
       // m.put("withdraweePhone".trim().toLowerCase(), phoneNumber.trim());
        cmp.setPhoneNum(phoneNumber.trim());
        
        //String phone2 = "Withdrawee's phone number";
        
        /*String phone2Number = part1.substring(part1.indexOf("vers")+4, part1.indexOf("vers")+14);
        
        sb.append(phone2);
        
        sb.append(phone2Number);
        
        sb.append("\n");
        
        String sender = "sender:";
        
        String senderName = part1.substring(part1.indexOf("de")+12, part1.indexOf("vers"));
       
        sb.append(sender);
        
        sb.append(senderName);
        
        sb.append("\n");*/
    
    // Montant
        String[] parts2 = msg.substring(msg.indexOf(":")+1).split(",");
        
        sb.append(parts2[0]);
        
        tab = parts2[0].split(":");
        tab[1] = tab[1].substring(0, tab[1].indexOf('F'));
        //m.put(tab[0].trim().toLowerCase(), tab[1].trim());
        cmp.setAmount(tab[1].trim());
    
    // Frais    
        tab = parts2[1].split(":");
        tab[1] = tab[1].substring(0, tab[1].indexOf('F'));
       // m.put(tab[0].trim().toLowerCase(), tab[1].trim());
        cmp.setFrais(tab[1].trim());
    
    // Commission    
        tab = parts2[2].split(":");
        tab[1] = tab[1].substring(0, tab[1].indexOf('F'));
       // m.put(tab[0].trim().toLowerCase(), tab[1].trim());
        cmp.setCommission(tab[1].trim());
        
    // Transaction Number    
        parts2[3] = parts2[3].substring(parts2[3].lastIndexOf('n')+1, parts2[3].length());
        
       // m.put("Transaction Id".trim().toLowerCase(), parts2[3].trim());
        cmp.setTransactionNum(parts2[3].trim());
        
        
        parts2[4] = parts2[4].substring(parts2[4].indexOf("ite")+3, parts2[4].length());
        parts2[4] = parts2[4].substring(0, parts2[4].indexOf('F'));
        //m.put("Montant Net Debite".trim().toLowerCase(), parts2[4].trim());
        cmp.setAmtDebited(parts2[4].trim());
        //tab[1] = tab[1].substring(0, tab[1].indexOf('F'));
        
        sb.append(parts2[5].substring(0, parts2[5].lastIndexOf(".")));
        
        tab = parts2[5].split(":");
        tab[1] = tab[1].substring(0, tab[1].indexOf('F'));
        //m.put("Nouveau Solde".trim().toLowerCase(), tab[1].trim());
        cmp.setNewSolde(tab[1].trim());
           
        return cmp;
    } 
}