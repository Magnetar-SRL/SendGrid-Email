package unq.ar.app;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SendEmailApp {

    static final String key = "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";

    public static void main(String[] args) throws IOException {

        //Email to = new Email("nataliaflorencia.s@gmail.com");
        Email to = new Email("nmonzon@magnetarsoftware.com");
        Email from = new Email("cezcardozo23@gmail.com"); // use your own email address here

        String subject = "Sending with Twilio SendGrid is Fun";
        Content content = new Content("text/html", "and <em>easy</em> to do anywhere with <strong>Java</strong>");

        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(key);
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        Response response = sg.api(request);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());
    }
}
