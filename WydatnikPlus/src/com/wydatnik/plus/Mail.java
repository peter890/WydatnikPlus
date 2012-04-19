package com.wydatnik.plus;

import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	private String[] odbiorca;
	private String temat;
	private String tresc;
	
	
	public Mail(){
		odbiorca = new String[] {};
		temat = "";
		tresc = "";
	}
	
	
	public Mail(String[] odbiorca_, String temat_, String tresc_) {
		odbiorca = odbiorca_;
		temat = temat_;
		tresc = tresc_;
	}


	public synchronized boolean sendMail(String[] to, String subject,
			String text) {
		
		//dane serwera pocztowego
		final String senderUserName = "siekierski89@o2.pl";
		final String senderPassword = "12101989ps";
		final String senderHost = "poczta.o2.pl";
		final String senderPort = "465";

		String starttls = "true";
		String auth = "true";
		boolean debug = true;
		String socketFactoryClass = "javax.net.ssl.SSLSocketFactory";
		String fallback = "false";

		Properties props = new Properties();
		//Properties props=System.getProperties();
		props.put("mail.smtp.user", senderUserName);
		props.put("mail.smtp.host", senderHost);
		if (!"".equals(senderPort))
			props.put("mail.smtp.port", senderPort);
		if (!"".equals(starttls))
			props.put("mail.smtp.starttls.enable", starttls);
		props.put("mail.smtp.auth", auth);
		if (debug) {
			props.put("mail.smtp.debug", "true");
		} else {
			props.put("mail.smtp.debug", "false");
		}
		if (!"".equals(senderPort))
			props.put("mail.smtp.socketFactory.port", senderPort);
		if (!"".equals(socketFactoryClass))
			props.put("mail.smtp.socketFactory.class", socketFactoryClass);
		if (!"".equals(fallback))
			props.put("mail.smtp.socketFactory.fallback", fallback);

		try {
			Session session = Session.getDefaultInstance(props, null);
			session.setDebug(debug);		//tryb debugowania
			MimeMessage msg = new MimeMessage(session);
			msg.setText(text);
			msg.setSubject(subject);
			msg.setFrom(new InternetAddress(senderUserName));
			for (int i = 0; i < to.length; i++) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
						to[i]));
			}
			for (int i = 0; i < to.length; i++) {
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(
						to[i]));
			}
			for (int i = 0; i < to.length; i++) {
				msg.addRecipient(Message.RecipientType.BCC,
						new InternetAddress(to[i]));
			}
			
			msg.saveChanges();
			Transport transport = session.getTransport("smtp");
			transport.connect(senderHost, senderUserName, senderPassword);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
	public final String[] getOdbiorca() {
		return odbiorca;
	}

	public final void setOdbiorca(String[] odbiorca) {
		this.odbiorca = odbiorca;
	}

	public final String getTemat() {
		return temat;
	}

	public final void setTemat(String temat) {
		this.temat = temat;
	}

	public final String getTresc() {
		return tresc;
	}

	public final void setTresc(String tresc) {
		this.tresc = tresc;
	}

	
	
	
	
	
	
	public static void main(String[] arg) {
		
		String[] to = {"siekierski1989@gmail.com"};
		//Mail mail = new Mail(to, "test", "testowa wiadomoœæ");
		Mail mail = new Mail();
		
		
		
		mail.sendMail(to, "test", "testowa wiadomoœæ");
	}
}
