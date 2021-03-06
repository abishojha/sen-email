package com.publicservice.email;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import com.publicservice.bean.General;
import com.publicservice.db.Dao;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class SendMail {
	
	

	private Configuration cfg;
	private BufferedReader br;
	private Template template;
	private final String filePath="html-mail-template.ftl";
	int i=0;
	
	

	public void run(String eetype) throws NullPointerException, ClassNotFoundException, SQLException {	
        Dao dao=new Dao();


		
		if(eetype.equals("IMAGE"))
		{
			links=image;
			attachFiles=files+"images";
			
		}
		else if(eetype.equalsIgnoreCase("AUDIO"))
		{			
			links=audio;
			attachFiles=files+"audios";

		}
		else if(eetype.equalsIgnoreCase("VIDEO"))
		{			
			links=video;
			attachFiles=files+"videos";

		}
		else if(eetype.equalsIgnoreCase("TEXT"))
		{			
			attachFiles="text";

		}
		
		
		
		
		try{		
			 
			 Properties props = new Properties();
			 
			props.put("mail.smtp.host","localhost");
			props.put("mail.smtp.port",25);
			
			 
		
           List<General> el=dao.getFiletype();        
        
	    	for(General b:el) {
					
			        Session session = Session.getDefaultInstance(props,
					new Authenticator() {

						protected PasswordAuthentication getPasswordAuthentication()
						{
							return new PasswordAuthentication("abc@gmail.com", "");
						}
					});

			try {
				
				if(attachFiles.equals("text")){
					
					System.out.println("EMAIL CHECK  "+b.getSentEmail());
					
					System.out.println("CC  "+b.getEmail());


					InternetAddress[] cc = new InternetAddress[1];
					cc[0]=new InternetAddress(b.getSentEmail());

					
					
					Message message = new MimeMessage(session);

					message.setFrom(new InternetAddress("abc@gmail.com"));
					message.addRecipients(Message.RecipientType.TO,cc); 										
					message.addRecipients(Message.RecipientType.CC,InternetAddress.parse("def@gmail.com"));
					//message.addRecipients(Message.RecipientType.CC,InternetAddress.parse(b.getEmail()));


					message.setSubject("Help Nepal");

					BodyPart body = new MimeBodyPart();


					
					br=new BufferedReader(new InputStreamReader(SendMail.class.getResourceAsStream(filePath)));
					cfg=new Configuration();
					template=new Template("emailTemplate",br,cfg);
					
					Map<String, String> rootMap = new HashMap<String, String>();
					rootMap.put("subject", b.getTitle());
					rootMap.put("message", b.getComplainText());
					rootMap.put("filename",links+b.getFilename());
					rootMap.put("latitude",b.getLatitude());
					rootMap.put("longitude",b.getLongitude());
			            
					Writer out = new StringWriter();
					template.process(rootMap, out);
					body.setContent(out.toString(),	"text/html");

					Multipart multipart = new MimeMultipart();
					multipart.addBodyPart(body);
					
					message.setContent(multipart, "text/html");

					Transport.send(message);
					dao.updateEmailTab(b.getIssueId(),b.getSentEmail());
					
					
				}
				
				
				else{
				System.out.println("EMAIL CHECK  "+b.getSentEmail());
				System.out.println("CC  "+b.getEmail());


				InternetAddress[] cc = new InternetAddress[1];
				cc[0]=new InternetAddress(b.getSentEmail());
				
				
				Message message = new MimeMessage(session);

				message.setFrom(new InternetAddress("abc@gmail.com"));
				message.addRecipients(Message.RecipientType.TO,cc); 										
				message.addRecipients(Message.RecipientType.CC,InternetAddress.parse("def@gmail.com"));



				message.setSubject("Help Nepal");
				BodyPart body = new MimeBodyPart();


				br=new BufferedReader(new InputStreamReader(SendMail.class.getResourceAsStream(filePath)));
				cfg=new Configuration();
				template=new Template("emailTemplate",br,cfg);
				
				Map<String, String> rootMap = new HashMap<String, String>();
				rootMap.put("subject", b.getTitle());
				rootMap.put("message", b.getComplainText());
				rootMap.put("filename",links+b.getFilename());
				rootMap.put("latitude",b.getLatitude());
				rootMap.put("longitude",b.getLongitude());


				Writer out = new StringWriter();
				template.process(rootMap, out);
				body.setContent(out.toString(),	"text/html");

				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(body);	
						      
				
				  // Part two is attachment
		               body = new MimeBodyPart();

				
		         String filename = attachFiles+"/"+b.getFilename();

		         DataSource source = new FileDataSource(filename);
		         body.setDataHandler(new DataHandler(source));
		         body.setFileName(filename);
		         multipart.addBodyPart(body);
				
				
				message.setContent(multipart, "text/html");

				Transport.send(message);
				dao.updateEmailTab(b.getIssueId(),b.getSentEmail());


				} 
				
			}
			catch (MessagingException e) {
				e.printStackTrace();
			}
			

		 }
	    	
		}catch(Exception e){
			System.out.println(e);
			
		}
		System.out.println("MESSAGE SENT");
		
		dao.getSenderEmailType();
		

		
	}
	
}

