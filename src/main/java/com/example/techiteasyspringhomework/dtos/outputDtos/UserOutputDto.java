package com.example.techiteasyspringhomework.dtos.outputDtos;

import com.example.techiteasyspringhomework.models.Authority;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Set;

@Data
public class UserOutputDto {

    private String username;
    private String password;
    private String email;
    private String apikey;
    @JsonSerialize
    private Set<Authority> authorities;

}
