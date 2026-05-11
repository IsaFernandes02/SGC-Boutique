package com.sgc.boutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgc.boutique.domain.Cliente;
import com.sgc.boutique.exception.CPFJaCadastradoException;
import com.sgc.boutique.exception.ClienteNaoEncontradoException;
import com.sgc.boutique.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ClienteNaoEncontradoException("Cliente não encontrado"));
    }

    public Cliente salvar(Cliente cliente) {

        if (repository.existsByCpf(cliente.getCpf())) {

            throw new CPFJaCadastradoException("CPF já cadastrado");
        }

        return repository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente cliente) {

        Cliente clienteExistente = buscarPorId(id);

        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setCpf(cliente.getCpf());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setTelefone(cliente.getTelefone());
        clienteExistente.setEndereco(cliente.getEndereco());

        return repository.save(clienteExistente);
    }

    public void deletar(Long id) {

        Cliente cliente = buscarPorId(id);

        repository.delete(cliente);
    }
}