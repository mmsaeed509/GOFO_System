package GOFO;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class VerifyViaMail {
    private static Random rand ;
    private static  int Rand_Verification_Code ;

    public static boolean Send_Verify_Code(String email,String name) {
        rand = new Random();
        Rand_Verification_Code = rand.nextInt(10000);


        String from = "gofos4304@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("gofos4304@gmail.com", "ABCD*&%$#@12345");
                    }

                }
        );

        session.setDebug(false);
        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));


            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));


            message.setSubject(" GOFO SYSTEM \n\n");
            message.setText( " Hi " + name + " \n\n Your Verification Code Is " + Rand_Verification_Code );

            Transport.send(message);
            return true;
        } catch (
                MessagingException mex) {
            mex.printStackTrace();
            return false;
        }

    }
    public static boolean Check_Validation_Code(int code){
        return code == Rand_Verification_Code;
    }

}
