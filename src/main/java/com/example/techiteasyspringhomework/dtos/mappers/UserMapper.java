package com.example.techiteasyspringhomework.dtos.mappers;

import com.example.techiteasyspringhomework.dtos.inputDtos.UserInputDto;
import com.example.techiteasyspringhomework.dtos.outputDtos.UserOutputDto;
import com.example.techiteasyspringhomework.models.User;

public class UserMapper {

    public static User fromInputToModel(UserInputDto userInputDto) {
        User u = new User();
        u.setUsername(userInputDto.getUsername());
        u.setPassword(userInputDto.getPassword());
        u.setEmail(userInputDto.getEmail());
        u.setApikey(userInputDto.getApikey());
        return u;
    }

    public static UserOutputDto fromModelToDto(User user) {
        UserOutputDto userDto = new UserOutputDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setApikey(user.getApikey());
        userDto.setAuthorities(user.getAuthorities());
        return userDto;
    }

//
//    public static UserOutputDto fromUser(User user){
//
//        var dto = new UserOutputDto();
//
//        dto.username = user.getUsername();
//        dto.password = user.getPassword();
//        dto.enabled = user.isEnabled();
//        dto.apikey = user.getApikey();
//        dto.email = user.getEmail();
//        dto.authorities = user.getAuthorities();
//
//        return dto;
//    }
//
//    public User toUser(UserOutputDto userDto) {
//
//        var user = new User();
//
//        user.setUsername(userDto.getUsername());
//        user.setPassword(/*TODO encrypted password*/);
//        user.setEnabled(userDto.getEnabled());
//        user.setApikey(userDto.getApikey());
//        user.setEmail(userDto.getEmail());
//
//        return user;
//    }
}
