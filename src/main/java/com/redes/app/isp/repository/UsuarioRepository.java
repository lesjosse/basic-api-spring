package com.redes.app.isp.repository;

import com.redes.app.isp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNumeroIdentificacion(String numeroIdentificacion);

    Optional<Usuario> findByCorreo(String correo);
}
