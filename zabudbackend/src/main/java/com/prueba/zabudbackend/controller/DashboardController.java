package com.prueba.zabudbackend.controller;

import com.prueba.zabudbackend.dto.DashboardDTO;
import com.prueba.zabudbackend.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin("*")
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<?> getDashboard(){
        DashboardDTO dashboardDTO = dashboardService.getDashboard();
        if(dashboardDTO == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(dashboardDTO, HttpStatus.OK);
    }
}
