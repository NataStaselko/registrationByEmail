package com.staselko.registrationByEmail.utils;

import com.staselko.registrationByEmail.dto.UserDto;
import com.staselko.registrationByEmail.dto.VerificationTokenDto;
import com.staselko.registrationByEmail.model.User;
import com.staselko.registrationByEmail.model.VerificationToken;
import com.staselko.registrationByEmail.service.UserService;
import com.staselko.registrationByEmail.service.VerTokenService;
import com.staselko.registrationByEmail.service.mail.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class RegistrationUserImpl implements RegistrationUser {
    private final VerTokenService verTokenService;
    private final UserService userService;
    private final MailService mailService;

    @Override
    public void registrationUser(UserDto userDto) {
        User user = userService.createUser(userDto);
        String token = verTokenService.createVerToken(user);
        mailService.sendMailToUser(user, token);
    }

    @Override
    public boolean confirmEmail(VerificationTokenDto tokenDto, Long userId) {
        User user = userService.getUserById(userId);
        VerificationToken token = verTokenService.getVerTokenByTokenDto(tokenDto);
        if(Objects.equals(user.getId(), token.getId())){
            if (!verTokenService.checkToken(token)){
                String newToken = verTokenService.updateVerToken(token).getToken();
                mailService.sendMailToUser(user, newToken);
                return false;
            }
            user.setEnabled(true);
            userService.updateUser(user);
            return true;
        }else {
            return false;
        }
    }
}
