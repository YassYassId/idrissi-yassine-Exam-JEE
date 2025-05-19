package com.jee.idrissiyassineexamjee.services;

import com.jee.idrissiyassineexamjee.dtos.ClientDTO;
import com.jee.idrissiyassineexamjee.entities.Client;
import com.jee.idrissiyassineexamjee.mappers.ClientMapper;
import com.jee.idrissiyassineexamjee.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repo;
    private final ClientMapper mapper;

    @Override
    public Client save(Client client) {
        return repo.save(client);
    }

    @Override
    public List<ClientDTO> getAll() {
        return mapper.toDTOs(repo.findAll());
    }

    @Override
    public ClientDTO getById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
