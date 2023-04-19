package com.staselko.registrationByEmail.security;
import com.staselko.registrationByEmail.validator.PasswordValid;
import com.staselko.registrationByEmail.validator.TextValid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtRequest implements Serializable {
    @TextValid
    private String username;

    @PasswordValid
    private String password;

}
