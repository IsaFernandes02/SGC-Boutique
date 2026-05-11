package com.sgc.boutique.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgc.boutique.domain.Usuario;
import com.sgc.boutique.dto.LoginDTO;
import com.sgc.boutique.repository.UsuarioRepository;
import com.sgc.boutique.security.JwtService;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private JwtService jwtService;

    public String login(LoginDTO loginDTO) {

        // Busca usuário pelo username
        Usuario usuario = repository.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Valida senha
        if (!usuario.getSenha().equals(loginDTO.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        // Gera token JWT
        return jwtService.gerarToken(usuario);
    }
}