package com.prueba.zabudbackend.service;

import com.prueba.zabudbackend.domain.Cajero;
import com.prueba.zabudbackend.domain.Usuario;
import com.prueba.zabudbackend.dto.LoginDTO;
import com.prueba.zabudbackend.dto.RegisterDTO;
import com.prueba.zabudbackend.dto.UserDTO;
import com.prueba.zabudbackend.mapper.AuthMapper;
import com.prueba.zabudbackend.repository.CajeroRepository;
import com.prueba.zabudbackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    //Repositorios
    @Autowired
    private CajeroRepository cajeroRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    //Mappers
    @Autowired
    private AuthMapper authMapper;

    @Override
    public UserDTO login(LoginDTO loginDTO) {
        UserDTO user = new UserDTO();
        try{
            Usuario usuario = usuarioRepository
                    .findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
            if(usuario != null){
                user = authMapper.cajeroToUserDTO(cajeroRepository.findByUsuario(usuario));
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return user;
    }

    @Override
    public UserDTO register(RegisterDTO registerDTO) {
        UserDTO user = new UserDTO();
        try{
            Usuario usuario = usuarioRepository.save(authMapper.registerDTOToUsuario(registerDTO));
            Cajero cajero = authMapper.registerDTOToCajero(registerDTO);
            cajero.setUsuario(usuario);
            user = authMapper.cajeroToUserDTO(cajeroRepository.save(cajero));
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return user;
    }
}
