package com.gungalla.springresttask.service;

import com.gungalla.springresttask.web.dto.auth.JwtRequest;
import com.gungalla.springresttask.web.dto.auth.JwtResponse;


public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);

}
