import java.util.Properties;
import javax.mail.*;  
import javax.mail.internet.*;  
import java.io.*;  
public class SendMailBySite {  
 public static void main(String[] args) {  
  
  Console console = System.console();//Using Console class to get password securely from the user
  final String user="joeavaikath@yahoo.co.in";//change accordingly
  
  System.out.printf("Enter the password for host %s:  ",user);
  char ch[] = console.readPassword();//Character array accepted 'ch'

  String host="smtp.mail.yahoo.com";
  final String password=String.valueOf(ch);//'ch' changed to String format  
    
  String to="joeavaikath@yahoo.co.in";//change accordingly  
  
   //Get the session object  
   Properties props = new Properties();  
   props.put("mail.smtp.host",host);  
   props.put("mail.smtp.auth", "true");
   //props.put("smtp.starttls.enable","true");
   props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
   props.put("mail.smtp.port",465);  
   Session session = Session.getDefaultInstance(props,  
    new javax.mail.Authenticator() {  
      protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }  
    });  
  
   //Compose the message  
    try {  
     MimeMessage message = new MimeMessage(session);  
     message.setFrom(new InternetAddress(user));  
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
     message.setSubject("javatpoint");  
     message.setText("This is simple program of sending email using JavaMail API");  
       
    //send the message  
     Transport.send(message);  
  
     System.out.println("message sent successfully...");  
   
     } catch (MessagingException e) {e.printStackTrace();}  
 }  
} 
