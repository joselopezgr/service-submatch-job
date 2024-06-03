package com.jlg.submatch.service.job.mailing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {

    private final JavaMailSender emailService;
    private static final Logger logger = LoggerFactory.getLogger(SendEmail.class);

    public SendEmail(JavaMailSender emailService) {
        this.emailService = emailService;
    }

    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            System.out.println("Sending email to: " + to + " with subject: " + subject);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("joselopezgr@gmail.com");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailService.send(message);
            System.out.println("Email sent to: " + to + " with subject: " + subject);
            logger.info("Email sent to: {} with subject: {}", to, subject);
        } catch (Exception e) {
            System.out.println("Failed to send email: " + e.getMessage());
            logger.error("Failed to send email: ", e);
        }
    }
}
