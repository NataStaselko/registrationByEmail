package com.staselko.registrationByEmail.converter;

import com.staselko.registrationByEmail.dto.UserDto;
import com.staselko.registrationByEmail.model.User;

public interface UserConverter {

    User toUser (UserDto userDto);

    UserDto toUserDto(User user);
}
