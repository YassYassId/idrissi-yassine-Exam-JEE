package com.jee.idrissiyassineexamjee.web;

import com.jee.idrissiyassineexamjee.dtos.ClientDTO;
import com.jee.idrissiyassineexamjee.entities.Client;
import com.jee.idrissiyassineexamjee.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @PostMapping
    public Client save(@RequestBody Client client) {
        return service.save(client);
    }

    @GetMapping
    public List<ClientDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable Long id) {
        return ResponseEntity.of(Optional.ofNullable(service.getById(id)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
