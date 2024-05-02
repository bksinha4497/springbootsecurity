package com.okta.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OktaDemoController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal OidcUser user) {
        return "Welcome, "+ user.getFullName() + "!";
    }
}
