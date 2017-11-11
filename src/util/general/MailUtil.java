package util.general;


import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import util.sharedData;

public class MailUtil {
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	public static String getTable (String filePath, String tableName )
	{
        Document htmlFile = null;
        String table = null;
        try {
            htmlFile = Jsoup.parse(new File( filePath ), "ISO-8859-1");
          //  table = htmlFile.body().getElementById( tableName ).text();
            String dtable = htmlFile.body().getElementsByClass( tableName ).html();

            System.out.println("TABLE : " + dtable);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static void generateAndSendEmail( String attachment ) throws AddressException, MessagingException 
	{
		  System.out.println("Starting sending mail.");
	      String to = sharedData.mailReceiversAddress;
		  String[] mailAddresses = sharedData.mailReceiversAddress.split(",");
	      String from = sharedData.mailSendersAddress;
	      final String username = sharedData.mailSendersAddress;
	      final String password = sharedData.mailSendersPassword;

	      String host = "smtp.gmail.com";
	      Properties props = new Properties();
	      props = System.getProperties();
	      props.put("mail.smtp.port", "587");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.starttls.enable", "true");
		  props.put("mail.smtp.host", host);

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
	            }
	         });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         for (int i = 0; i < mailAddresses.length; i++) 
	        	 message.setRecipients(Message.RecipientType.TO,
	 	            InternetAddress.parse(mailAddresses[i]));
	        

	         // Set Subject: header field
	         message.setSubject("Automation result for : " + sharedData.environmentUnderTest);

	         // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setText("K2 : PFA the test result.");

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = attachment ;
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully to : " + sharedData.mailReceiversAddress);
	  
	      } catch (MessagingException e) {
	        // throw new RuntimeException(e);
	    	  e.printStackTrace();
	      }
	}
}
