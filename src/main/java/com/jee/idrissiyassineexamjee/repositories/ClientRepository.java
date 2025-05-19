package com.jee.idrissiyassineexamjee.repositories;

import com.jee.idrissiyassineexamjee.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
