package com.loperals.forochallenge.domain.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface Usuariorepository extends JpaRepository<Usuario, Long> {
    UserDetails findByNombre(String username);
}
