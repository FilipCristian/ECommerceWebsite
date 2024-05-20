package com.example.gamesMarketplace.email;

import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;



@Service
public class EmailService implements EmailSender{

    private final static Logger LOGGER = LoggerFactory
            .getLogger(EmailService.class);

    private final JavaMailSender mailSender;


    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            if (helper != null) { // Add null check for helper
                helper.setTo(to);
                helper.setSubject("Confirm your email");
                helper.setFrom("ClientService@steam.com");
                helper.setText(email, true); // Set email content as HTML
                mailSender.send(mimeMessage);
            } else {
                LOGGER.error("MimeMessageHelper is null");
                throw new IllegalStateException("MimeMessageHelper is null");
            }
        } catch (Exception e) {
            LOGGER.error("Failed to send email", e);
            throw new IllegalStateException("Failed to send email", e);
        }
    }



}