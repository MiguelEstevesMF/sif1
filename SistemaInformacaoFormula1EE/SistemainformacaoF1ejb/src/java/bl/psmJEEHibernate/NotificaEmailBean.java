/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl.psmJEEHibernate;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ejb.Stateless;



/**
 * Classe que contÃ©m a lÃ³gica de negÃ³cio necessÃ¡ria para fazer notificaÃ§Ãµes por email
 *
 */


@Stateless
public class NotificaEmailBean implements NotificaEmailLocal, NotificaEmailRemote
{

	public void enviarEmail(String assunto, String texto, String destino) throws Exception
	{
        String host = "smtp.gmail.com";
        String from = "siformula1@gmail.com";
        String pass = "sistemaf1";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true"); // added this line
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));

        System.out.println(Message.RecipientType.TO);

        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));

        message.setSubject(assunto);
        message.setText(texto);
        Transport transport = session.getTransport("smtp");
        transport.connect(host, from, pass);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
	}

}
