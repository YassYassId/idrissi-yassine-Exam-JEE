package com.jee.idrissiyassineexamjee.mappers;

import com.jee.idrissiyassineexamjee.dtos.ClientDTO;
import com.jee.idrissiyassineexamjee.entities.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientMapper {
    public ClientDTO toDTO(Client client) {
        if (client == null) return null;
        return new ClientDTO(client.getId(), client.getNom(), client.getEmail());
    }

    public List<ClientDTO> toDTOs(List<Client> clients) {
        return clients.stream().map(this::toDTO).toList();
    }
}
