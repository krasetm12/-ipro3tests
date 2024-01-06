package common;

import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailReader {
    public static String getPassFromMail(String user, String password) throws MessagingException{
        String codeRegistration = "";
        try {
//            String host = "imap.rambler.ru";
            String host = "pop.rambler.ru";
            Properties properties = new Properties();
//            properties.put("mail.store.protocol", "imaps");
            properties.put("mail.store.protocol", "pop3");

            Session emailSession = Session.getDefaultInstance(properties);
            Store store = emailSession.getStore();
            store.connect(host, user, password);

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            Message[] messages = emailFolder.getMessages();

            Message message = messages[messages.length-1];
            String text = message.getContent().toString();
            codeRegistration = (text.substring(text.length() - 12)).substring(0,8);
            emailFolder.close(false);
            store.close();
            System.out.println(codeRegistration);
            return codeRegistration;
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codeRegistration;
    }
}