package com.prueba.zabudbackend.controller;

import com.prueba.zabudbackend.dto.ErrorDTO;
import com.prueba.zabudbackend.dto.FacturaDTO;
import com.prueba.zabudbackend.dto.FacturaTableDTO;
import com.prueba.zabudbackend.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/factura")
@CrossOrigin("*")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody FacturaDTO facturaDTO){
        ErrorDTO error = facturaService.save(facturaDTO);
        if(error.getMensaje() == null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<FacturaTableDTO> facturas = facturaService.findAll();
        if(Objects.isNull(facturas))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return facturaService.findById(id)
                .map(factura -> new ResponseEntity<>(factura, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if(facturaService.deleteById(id))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
