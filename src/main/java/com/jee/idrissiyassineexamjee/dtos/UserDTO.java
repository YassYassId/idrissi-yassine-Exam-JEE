package com.jee.idrissiyassineexamjee.dtos;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String nom;
    private String email;
}
