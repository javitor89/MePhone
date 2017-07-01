package es.sidelab.MailMailMail.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.http.HttpStatus;

import es.sidelab.MailMailMail.model.Usuario;

@RestController
public class MailController {

	
	@PostMapping(value = "/pedido")
	@ResponseStatus(HttpStatus.OK)
	public Usuario webInicial(@RequestBody Usuario usuario) {
		
		System.out.println("Pedido recibido. Usuario: " + usuario.getNombre() + ".");
		
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		// Get a Properties object
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.store.protocol", "pop3");
		props.put("mail.transport.protocol", "smtp");
		final String username = "mephone.asistencia@gmail.com";
	    final String password = "mephone90";
		try {
			Session session = Session.getDefaultInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			// -- Create a new message --
			Message msg = new MimeMessage(session);

			// -- Set the FROM and TO fields --
			msg.setFrom(new InternetAddress(username));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(usuario.getCorreo(), false));
			msg.setSubject("Mephone");
			msg.setText("Pedido realizado. Recibo (ID's):\n   " + usuario.getPedidos().get(usuario.getPedidos().size()-1).getRecibo());
			msg.setSentDate(new Date());
			Transport.send(msg);
			System.out.println("Message sent.");
		} catch (MessagingException e) {
			System.out.println("ERRORRRRRRRRRR" + e);
		}
		
		
		System.out.println("Mail enviado.");
		
		return usuario;
	}
	
}
