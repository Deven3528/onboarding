package com.onboarding.onboarding.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import jakarta.mail.MessagingException;
import org.thymeleaf.context.Context;

import jakarta.mail.internet.MimeMessage;
@Service
public class emailService {

    @Autowired 
    private JavaMailSender javaMailSender;
 
    @Value("${spring.mail.username}") private String sender;
    
    @Autowired
    private TemplateEngine templateEngine;

    public void sendWelcomeEmail(String to, String subject, String templateName, Context context) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {
            
            helper.setTo(to);
            helper.setSubject(subject);
            String htmlContent = templateEngine.process(templateName, context);
            helper.setText(htmlContent, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e){

            // Handle exception    
        }

 }
}