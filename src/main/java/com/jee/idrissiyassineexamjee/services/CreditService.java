package com.jee.idrissiyassineexamjee.services;

import com.jee.idrissiyassineexamjee.dtos.CreditDTO;
import com.jee.idrissiyassineexamjee.entities.Credit;

import java.util.List;

public interface CreditService {
    Credit save(Credit credit);
    List<CreditDTO> getAll();
    CreditDTO getById(Long id);
    void deleteById(Long id);
}
