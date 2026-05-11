package com.sgc.boutique.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgc.boutique.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByUsername(String username);
}
