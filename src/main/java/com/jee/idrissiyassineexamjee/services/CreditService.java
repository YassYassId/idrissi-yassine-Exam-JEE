package com.jee.idrissiyassineexamjee.services;

import com.jee.idrissiyassineexamjee.entities.Credit;

import java.util.List;

public interface CreditService {
    Credit saveCredit(Credit credit);
    List<Credit> getAllCredits();
    Credit getCreditById(Long id);
}
