package com.jee.idrissiyassineexamjee.services;

import com.jee.idrissiyassineexamjee.dtos.RemboursementDTO;
import com.jee.idrissiyassineexamjee.entities.Remboursement;

import java.util.List;

public interface RemboursementService {
    Remboursement save(Remboursement remboursement);
    List<RemboursementDTO> getAll();
    RemboursementDTO getById(Long id);
    void deleteById(Long id);
}
