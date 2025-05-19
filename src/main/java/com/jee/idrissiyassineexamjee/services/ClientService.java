package com.jee.idrissiyassineexamjee.services;

import com.jee.idrissiyassineexamjee.dtos.ClientDTO;
import com.jee.idrissiyassineexamjee.entities.Client;

import java.util.List;

public interface ClientService {
    Client save(Client client);
    List<ClientDTO> getAll();
    ClientDTO getById(Long id);
    void deleteById(Long id);
}
