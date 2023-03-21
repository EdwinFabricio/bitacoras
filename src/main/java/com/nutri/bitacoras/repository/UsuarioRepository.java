package com.nutri.bitacoras.repository;

import com.nutri.bitacoras.model.entiy.Usuario;
import com.nutri.bitacoras.repository.generic.GenericRepository;

import java.util.Optional;

public interface UsuarioRepository extends GenericRepository<Usuario> {
    public Optional<Usuario> findByUsername(String username);
    public Boolean existsByUsername(String username);
}
