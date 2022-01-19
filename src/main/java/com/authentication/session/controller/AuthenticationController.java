package com.authentication.session.controller;

import com.authentication.session.controller.constant.LoginSession;
import com.authentication.session.controller.dto.AuthResponse;
import com.authentication.session.controller.dto.LoginInfo;
import com.authentication.session.controller.model.Member;
import com.authentication.session.controller.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @GetMapping("/")
    public String index(@SessionAttribute(name = LoginSession.LOGIN_USER, required = false) Member loginMember) {

        if(loginMember == null) return "login";

        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "session/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public AuthResponse login(@RequestBody LoginInfo loginInfo, HttpServletRequest request) {
        Member loginResult = authenticationService.login(loginInfo);

        if(loginResult == null) return AuthResponse.builder().isSuccess(false).build();

        HttpSession session = request.getSession();
        session.setAttribute(LoginSession.LOGIN_USER, loginResult);

        return AuthResponse.builder().isSuccess(true).build();
    }

    @PostMapping("/logout")
    @ResponseBody
    public AuthResponse logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if(session != null) session.invalidate();

        return AuthResponse.builder().isSuccess(true).build();
    }

}
