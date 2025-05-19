package com.jee.idrissiyassineexamjee.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {
    private Long id;
    private String nom;
    private String email;
}
