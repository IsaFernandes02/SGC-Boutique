package com.sgc.boutique.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.sgc.boutique.domain.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final String SECRET = "segredo-super-seguro-com-mais-de-32-caracteres-123";

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String gerarToken(Usuario usuario) {

        return Jwts.builder()
                .setSubject(usuario.getUsername())
                .claim("perfil", usuario.getPerfil().name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(key)
                .compact();
    }
}