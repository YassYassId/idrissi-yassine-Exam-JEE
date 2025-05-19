package com.jee.idrissiyassineexamjee.web;

import com.jee.idrissiyassineexamjee.dtos.*;
import com.jee.idrissiyassineexamjee.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<JwtAuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
        System.out.println(registerRequest);
        JwtAuthenticationResponse response = userService.register(registerRequest);
        return ResponseEntity.ok(response);
    }


    @PostMapping(value = "/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(userService.signin(signinRequest));
    }

    @GetMapping(value = "/usersList")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping(value = "/refresh" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(userService.refreshToken(refreshTokenRequest));
    }
}
