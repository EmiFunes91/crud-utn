package com.api.crud.controllers;

import com.api.crud.models.AccessModel;
import com.api.crud.models.UsuarioDTO;
import com.api.crud.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class AccessController {

    private final UserService userService;

    public AccessController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Optional<UsuarioDTO> saveUser(@RequestBody AccessModel accessModel) {
        return this.userService.getByUsuarioAndClave(accessModel.getUsuario(), accessModel.getClave());
    }
}
