package com.prueba.zabudbackend.controller;

import com.prueba.zabudbackend.dto.ErrorDTO;
import com.prueba.zabudbackend.dto.ProductoDTO;
import com.prueba.zabudbackend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
@CrossOrigin("*")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductoDTO productoDTO){
        ErrorDTO error = productoService.save(productoDTO);
        if(error.getMensaje() == null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<ProductoDTO> productos = productoService.findAll();
        if(Objects.isNull(productos))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<?> getById(@PathVariable Long idProducto){
        return productoService.findById(idProducto)
                .map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<?> deleteById(@PathVariable Long idProducto){
        if(productoService.deleteById(idProducto))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
