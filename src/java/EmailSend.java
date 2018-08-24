/**
 *
 * @author Arjun Thakor
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSend {
    
    /*
        * Setup Guidance:
         1. To use email functionality, you have to make you account to less secure.
         2. After this, you have to use your own mobile or home network to send email.
    */
    Books s = new Books();
    String sender = s.getAuthor();
    private String SMTP_HOST ="smtp.gmail.com";
	private String FROM_ADDRESS ="arjunthakor00740@gmail.com"; /* Email Address */
	private String PASSWORD ="Your account password";
	private String FROM_NAME= sender;
	
	public boolean sendMail(String[] recepients, String[] bccRecepients, String subject,String message)
	{
		String [] rec = new String[] {"arjunthakor00740@gmail.com"};/* Reciever Email Address */
		String [] bcc = new String[] {" arjunthakor00740@gmail.com "};/*BCC Email Address */
		String sub="Hi";                                                /* Subject */
		String mess = "Test Mail.";                                 /* Message */
		
		try{
			Properties props =new Properties();
			props.put("mail.smtp.host",SMTP_HOST );
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "false");
			props.put("mail.smtp.ssl.enable", "true");
			
			
			Session session = Session.getInstance(props, new javax.mail.Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication(FROM_ADDRESS,PASSWORD);
				}
			});
			
			Message msg = new MimeMessage(session);
			InternetAddress from = new InternetAddress(FROM_ADDRESS, FROM_NAME);
			msg.setFrom(from);	
			//To Recipients
			InternetAddress[] toAddresses = new InternetAddress[rec.length];
			for (int i =0;i<rec.length; i++)
			{
				toAddresses[i] = new InternetAddress(rec[i]);	
			}
			msg.setRecipients(Message.RecipientType.TO, toAddresses);
			//BCC Recipients
			InternetAddress[] bccAddresses = new InternetAddress[bccRecepients.length];
			for (int i =0;i<bccRecepients.length; i++)
			{
				bccAddresses[i] = new InternetAddress(bccRecepients[i]);		
			}	
			msg.setRecipients(Message.RecipientType.BCC, bccAddresses);	
			msg.setSubject(subject);
			msg.setContent(message,"text/plain");
			Transport.send(msg);	
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
}
