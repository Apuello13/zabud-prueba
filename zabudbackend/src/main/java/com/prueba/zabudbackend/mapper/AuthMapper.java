package com.prueba.zabudbackend.mapper;

import com.prueba.zabudbackend.domain.Cajero;
import com.prueba.zabudbackend.domain.Usuario;
import com.prueba.zabudbackend.dto.RegisterDTO;
import com.prueba.zabudbackend.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface AuthMapper {
    UserDTO cajeroToUserDTO(Cajero cajero);
    Usuario registerDTOToUsuario(RegisterDTO registerDTO);
    Cajero registerDTOToCajero(RegisterDTO registerDTO);
}
