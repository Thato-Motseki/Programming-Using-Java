package ubuntusure.service;
/** Notification boundary. Configure SMTP and add a mail provider in the email implementation phase. */
public class EmailService {
 public void customerRegistered(String email,String name){notifyConfigured("Customer registered",email,"Hello "+name+", your UbuntuSure customer registration was successful.");}
 public void policyAssigned(String email,String policyNumber){notifyConfigured("Policy assigned",email,"Your UbuntuSure policy "+policyNumber+" has been assigned.");}
 public void claimStatusChanged(String email,String claimNumber,String status){notifyConfigured("Claim status updated",email,"Claim "+claimNumber+" status is now "+status+".");}
 private void notifyConfigured(String event,String email,String body){if(email==null||email.isBlank()){System.out.println("Email skipped (no address): "+event);return;}System.out.println("EMAIL ADAPTER NOT CONFIGURED: would send to "+email+" | "+event+" | "+body);}
}
