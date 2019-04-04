/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import email.Protocol;
import java.util.Date;
import java.util.Properties;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Mirko
 */
@Stateless
@LocalBean
public class EmailSessionBean {

    private final int port = 587;
    private final String host = "smtp.live.com";
    private String from = "matt@example.com";
    private final String to = "bgmirko@hotmail.com";
    private final boolean auth = true;
    private final String username = "bgmirko@hotmail.com";
    private final String password = "s@rEn02015";
    private final Protocol protocol = Protocol.SMTPS;
    private final boolean debug = true;

    public boolean sendMail(String from, String subject, String body) {
        this.from=from;
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.ssl.trust", host);
//        switch (protocol) {
//            case SMTPS:
//                props.put("mail.smtp.ssl.enable", true);
//                break;
//            case TLS:
//                props.put("mail.smtp.starttls.enable", true);
//                break;
//        }

        Authenticator authenticator = null;
        if (auth) {
            props.put("mail.smtp.auth", true);
            authenticator = new Authenticator() {

                private final PasswordAuthentication pa = new PasswordAuthentication(username, password);

                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return pa;
                }
            };
        }

        Session session = Session.getInstance(props, authenticator);
        session.setDebug(debug);

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText(body);
            Transport.send(message);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
            System.out.println("nije poslata poruka EMailSessionBean.java");
            return false;
        }

    }
}
