package com.security.app.services;

import com.security.app.dto.SignUpRequest;
import com.security.app.entity.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);
}
