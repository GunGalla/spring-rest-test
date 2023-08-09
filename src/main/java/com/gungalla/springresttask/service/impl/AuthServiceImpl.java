package com.gungalla.springresttask.service.impl;

import com.gungalla.springresttask.service.AuthService;
import com.gungalla.springresttask.web.dto.auth.JwtRequest;
import com.gungalla.springresttask.web.dto.auth.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }

}
