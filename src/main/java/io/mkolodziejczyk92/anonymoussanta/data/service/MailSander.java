package io.mkolodziejczyk92.anonymoussanta.data.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSander {

    String username = "anonymous.santa.reg@gmail.com";
    String password = "anonymoussantaadmin";

    public void sendEmail(String name,
                          String surname,
                          String email,
                          String eventCode) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Anonymous Santa - invitation");
            message.setText(
                    "Hello <name / surname>," +
                            " you have been invited to <name>'s event. " +
                            "Please register on our website and join the event by entering the code/password: <random password>." +
                            "If you already have an account log in and join the event." +
                            "Anonymous Team");

            Transport.send(message);

        } catch (MessagingException e) {
            System.out.println("Wystąpił błąd podczas wysyłania wiadomości: " + e.getMessage());
        }

    }


}
