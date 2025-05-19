package com.jee.idrissiyassineexamjee.services;

import com.jee.idrissiyassineexamjee.dtos.RemboursementDTO;
import com.jee.idrissiyassineexamjee.entities.Remboursement;
import com.jee.idrissiyassineexamjee.mappers.RemboursementMapper;
import com.jee.idrissiyassineexamjee.repositories.RemboursementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RemboursementServiceImpl implements RemboursementService {
    private final RemboursementRepository repo;
    private final RemboursementMapper mapper;

    @Override
    public Remboursement save(Remboursement remboursement) {
        return repo.save(remboursement);
    }

    @Override
    public List<RemboursementDTO> getAll() {
        return mapper.toDTOs(repo.findAll());
    }

    @Override
    public RemboursementDTO getById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
