package com.staselko.registrationByEmail.service.mail;


import com.staselko.registrationByEmail.model.User;

public interface MailService {
    void sendMailToUser(User user, String token);

}
