package com.gungalla.springresttask.service;

import com.gungalla.springresttask.web.dto.auth.JwtResponse;
import com.gungalla.springresttask.web.dto.auth.JwtRequest;


public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);

}
