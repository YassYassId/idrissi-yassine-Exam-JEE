package com.jee.idrissiyassineexamjee.web;

import com.jee.idrissiyassineexamjee.dtos.CreditDTO;
import com.jee.idrissiyassineexamjee.entities.Credit;
import com.jee.idrissiyassineexamjee.services.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/credits")
@RequiredArgsConstructor
public class CreditController {
    private final CreditService service;

    @PostMapping
    public Credit save(@RequestBody Credit credit) {
        return service.save(credit);
    }

    @GetMapping
    public List<CreditDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditDTO> getById(@PathVariable Long id) {
        return ResponseEntity.of(Optional.ofNullable(service.getById(id)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
