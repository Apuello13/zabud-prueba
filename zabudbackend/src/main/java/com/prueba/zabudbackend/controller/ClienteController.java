package com.prueba.zabudbackend.controller;

import com.prueba.zabudbackend.dto.ClienteDTO;
import com.prueba.zabudbackend.dto.ErrorDTO;
import com.prueba.zabudbackend.service.ClienteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClienteDTO clienteDTO){
        ErrorDTO error = clienteService.saveCliente(clienteDTO);
        if(error.getMensaje() == null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<ClienteDTO> clientes = clienteService.findAll();
        if(Objects.isNull(clientes))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return clienteService.findById(id)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/numeroDocumento/{numeroDocumento}")
    public ResponseEntity<?> getByNumeroDocumento(@PathVariable String numeroDocumento){
        return clienteService.findByNumeroDocumento(numeroDocumento)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if(clienteService.deleteById(id))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
