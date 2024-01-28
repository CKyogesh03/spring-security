package com.security.app.controller;

import com.security.app.dto.SignUpRequest;
import com.security.app.entity.User;
import com.security.app.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
//@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest){
        //        return ResponseEntity.ok(authenticationService.signup(signUpRequest));

        // trying to fix the problem of null value
        System.out.println("Received SignUpRequest: " + signUpRequest.toString()); // to test the received data
        User data=authenticationService.signup(signUpRequest);
        System.out.println("object returned from save() " + signUpRequest.toString());
        return  ResponseEntity.ok(data);

    }
}
