package com.sgc.boutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sgc.boutique.domain.Usuario;
import com.sgc.boutique.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	 	@Autowired
	    private UsuarioRepository repository;

	    public List<Usuario> listarTodos() {
	        return repository.findAll();
	    }

	    public Usuario buscarPorId(Long id) {
	        return repository.findById(id).orElse(null);
	    }

	    public Usuario salvar(Usuario usuario) {
	    	usuario.setSenha(
	    		    passwordEncoder.encode(usuario.getSenha())
	    	);

	    	return repository.save(usuario);
	    }

	    public Usuario atualizar(Long id, Usuario usuario) {

	        Usuario existente = buscarPorId(id);

	        if (existente == null) {
	            return null;
	        }

	        existente.setUsername(usuario.getUsername());
	        existente.setSenha(usuario.getSenha());
	        existente.setPerfil(usuario.getPerfil());

	        return repository.save(existente);
	    }

	    public void deletar(Long id) {
	        repository.deleteById(id);
	    }
	    
	    @Autowired
	    private PasswordEncoder passwordEncoder;

}
