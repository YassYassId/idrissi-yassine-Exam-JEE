package com.jee.idrissiyassineexamjee.dtos;

import lombok.Data;

@Data
public class RegisterRequest {
    private String nom;
    private String email;
    private String password;
}
