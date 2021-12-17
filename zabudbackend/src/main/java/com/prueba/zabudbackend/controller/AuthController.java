package com.prueba.zabudbackend.controller;

import com.prueba.zabudbackend.dto.LoginDTO;
import com.prueba.zabudbackend.dto.RegisterDTO;
import com.prueba.zabudbackend.dto.UserDTO;
import com.prueba.zabudbackend.service.AuthService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        UserDTO user = authService.login(loginDTO);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO){
        UserDTO user = authService.register(registerDTO);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
