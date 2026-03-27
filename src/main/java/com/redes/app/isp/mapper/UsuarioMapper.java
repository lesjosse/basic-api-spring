package com.redes.app.isp.mapper;

import com.redes.app.isp.dto.UsuarioDTO;
import com.redes.app.isp.model.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario u = new Usuario();
        u.setNombre(dto.getNombre());
        u.setApellido(dto.getApellido());
        u.setNumeroIdentificacion(dto.getNumeroIdentificacion());
        u.setCorreo(dto.getCorreo());
        u.setTelefono(dto.getTelefono());
        return u;
    }

    public static void updateEntity(Usuario u, UsuarioDTO dto) {
        u.setNombre(dto.getNombre());
        u.setApellido(dto.getApellido());
        u.setNumeroIdentificacion(dto.getNumeroIdentificacion());
        u.setCorreo(dto.getCorreo());
        u.setTelefono(dto.getTelefono());
    }
}