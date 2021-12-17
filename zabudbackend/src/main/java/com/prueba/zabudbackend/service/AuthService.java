package com.prueba.zabudbackend.service;

import com.prueba.zabudbackend.dto.LoginDTO;
import com.prueba.zabudbackend.dto.RegisterDTO;
import com.prueba.zabudbackend.dto.UserDTO;

public interface AuthService {
    UserDTO login(LoginDTO loginDTO);
    UserDTO register(RegisterDTO registerDTO);
}
