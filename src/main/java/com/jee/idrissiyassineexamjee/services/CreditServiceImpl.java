package com.jee.idrissiyassineexamjee.services;


import com.jee.idrissiyassineexamjee.dtos.CreditDTO;
import com.jee.idrissiyassineexamjee.entities.Credit;
import com.jee.idrissiyassineexamjee.mappers.CreditMapper;
import com.jee.idrissiyassineexamjee.repositories.CreditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CreditServiceImpl implements CreditService {
    private final CreditRepository repo;
    private final CreditMapper mapper;

    @Override
    public Credit save(Credit credit) {
        return repo.save(credit);
    }

    @Override
    public List<CreditDTO> getAll() {
        return mapper.toDTOs(repo.findAll());
    }

    @Override
    public CreditDTO getById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
