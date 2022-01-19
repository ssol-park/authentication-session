package com.authentication.session.controller.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginInfo {

    private String email;

    private String password;

}
