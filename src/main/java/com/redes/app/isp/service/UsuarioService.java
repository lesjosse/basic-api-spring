package com.redes.app.isp.service;

import com.redes.app.isp.dto.UsuarioDTO;
import com.redes.app.isp.mapper.UsuarioMapper;
import com.redes.app.isp.model.Usuario;
import com.redes.app.isp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario create(UsuarioDTO dto) {

        // Validaciones
        repository.findByNumeroIdentificacion(dto.getNumeroIdentificacion())
                .ifPresent(u -> {
                    throw new RuntimeException("Ya existe un usuario con esa identificación");
                });

        repository.findByCorreo(dto.getCorreo())
                .ifPresent(u -> {
                    throw new RuntimeException("Ya existe un usuario con ese correo");
                });

        Usuario usuario = UsuarioMapper.toEntity(dto);
        return repository.save(usuario);
    }

    public Usuario update(Long id, UsuarioDTO dto) {

        Usuario usuario = findById(id);
        
        //Validamos la identificacion
        if (!usuario.getNumeroIdentificacion().equals(dto.getNumeroIdentificacion())) {
            repository.findByNumeroIdentificacion(dto.getNumeroIdentificacion())
                    .ifPresent(u -> {
                        throw new RuntimeException("Identificación ya en uso");
                    });
        }

        //Validamos el correo
        if(!usuario.getCorreo().equals(dto.getCorreo())){
            repository.findByCorreo(dto.getCorreo())
                    .ifPresent(u->{
                        throw new RuntimeException("El correo ya exite");
                    });
        }

        UsuarioMapper.updateEntity(usuario, dto);

        return repository.save(usuario);
    }
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }

        repository.deleteById(id);
    }
}
