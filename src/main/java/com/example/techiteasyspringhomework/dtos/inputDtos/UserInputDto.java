package com.example.techiteasyspringhomework.dtos.inputDtos;

import com.example.techiteasyspringhomework.models.Authority;
import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Data
public class UserInputDto {

    private String username;
    private String password;
    private String email;
    private String apikey;

}
