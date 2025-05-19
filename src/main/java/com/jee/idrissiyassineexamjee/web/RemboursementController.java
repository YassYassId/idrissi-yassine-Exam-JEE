package com.jee.idrissiyassineexamjee.web;

import com.jee.idrissiyassineexamjee.dtos.RemboursementDTO;
import com.jee.idrissiyassineexamjee.entities.Remboursement;
import com.jee.idrissiyassineexamjee.services.RemboursementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/remboursements")
@RequiredArgsConstructor
public class RemboursementController {
    private final RemboursementService service;

    @PostMapping
    public Remboursement save(@RequestBody Remboursement remboursement) {
        return service.save(remboursement);
    }

    @GetMapping
    public List<RemboursementDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemboursementDTO> getById(@PathVariable Long id) {
        return ResponseEntity.of(Optional.ofNullable(service.getById(id)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
