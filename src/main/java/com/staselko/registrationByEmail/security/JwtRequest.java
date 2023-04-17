package com.staselko.registrationByEmail.security;
import com.staselko.registrationByEmail.validator.EmailValid;
import com.staselko.registrationByEmail.validator.PasswordValid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtRequest implements Serializable {
    @EmailValid
    private String username;

    @PasswordValid
    private String password;

}
