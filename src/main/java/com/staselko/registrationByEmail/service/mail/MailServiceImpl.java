package com.staselko.registrationByEmail.service.mail;

import com.staselko.registrationByEmail.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine engine;


    @Override
    public void sendMailToUser(User user, String token) {
        final Context context = new Context();
        context.setVariable("email", user.getEmail());
        context.setVariable("url", "http://localhost:4200?ac=" + token + "&i=" + user.getId());

        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        try {
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
            message.setFrom("BabaYaga-Shop@yandex.ru");
            message.setTo(user.getEmail());
            message.setSubject("BabaYaga-Shop");
            final String content = this.engine.process("mail", context);
            message.setText(content, true);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        this.mailSender.send(mimeMessage);
    }
}

