package com.prueba.zabudbackend.mapper.impl;

import com.prueba.zabudbackend.domain.Cajero;
import com.prueba.zabudbackend.domain.Usuario;
import com.prueba.zabudbackend.dto.RegisterDTO;
import com.prueba.zabudbackend.dto.UserDTO;
import com.prueba.zabudbackend.mapper.AuthMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthMapperImpl implements AuthMapper {

    @Override
    public UserDTO cajeroToUserDTO(Cajero cajero) {
        if(cajero == null)
            return null;
        UserDTO user = new UserDTO();
        user.setId(cajero.getId());
        user.setNombre(cajero.getNombre());
        return user;
    }

    @Override
    public Usuario registerDTOToUsuario(RegisterDTO registerDTO) {
        if(registerDTO == null)
            return null;
        Usuario usuario = new Usuario();
        usuario.setUsername(registerDTO.getUsername());
        usuario.setPassword(registerDTO.getPassword());
        return usuario;
    }

    @Override
    public Cajero registerDTOToCajero(RegisterDTO registerDTO) {
        if(registerDTO == null)
            return null;
        Cajero cajero = new Cajero();
        cajero.setNombre(registerDTO.getNombre());
        return cajero;
    }
}
