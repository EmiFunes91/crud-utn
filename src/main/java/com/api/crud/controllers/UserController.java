package com.api.crud.controllers;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUser() {
        return this.userService.getUser();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable Long id) {
        return this.userService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);

        if (ok) {
            return "El usuario de clave " + id + " se ha eliminado correctamente!";
        } else {
            return "Error, no se ha podido eliminar el registro con clave " + id;
        }
    }
}

