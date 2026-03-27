package com.redes.app.isp.controller;

import com.redes.app.isp.dto.ApiResponse;
import com.redes.app.isp.dto.UsuarioDTO;
import com.redes.app.isp.model.Usuario;
import com.redes.app.isp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    //metodo para listar todos los usuairios
    @GetMapping
    public ResponseEntity<ApiResponse<List<Usuario>>> listar() {
        List<Usuario> usuarios = service.findAll();
        return ResponseEntity.ok(
                new ApiResponse<>("Lista de usuarios", usuarios)
        );
    }

    // metodo para listar por identificador
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Usuario>> obtener(@PathVariable Long id) {
        Usuario usuario = service.findById(id);
        return ResponseEntity.ok(
                new ApiResponse<>("Usuario encontrado", usuario)
        );
    }

    // metodo para crear un usuario nuevo
    @PostMapping
    public ResponseEntity<ApiResponse<Usuario>> crear(@RequestBody UsuarioDTO dto) {
        Usuario usuario = service.create(dto);
        return ResponseEntity.status(201).body(
                new ApiResponse<>("Usuario creado correctamente", usuario)
        );
    }

    // metodo para actualizar un usuario existente por medio del identificador
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Usuario>> actualizar(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
        Usuario usuario = service.update(id, dto);
        return ResponseEntity.ok(
                new ApiResponse<>("Usuario actualizado correctamente", usuario)
        );
    }

    // metodo para eliminar un usuarioi
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(
                new ApiResponse<>("Usuario eliminado correctamente", null)
        );
    }
}
