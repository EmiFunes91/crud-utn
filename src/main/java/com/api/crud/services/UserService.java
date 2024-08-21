package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUser() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id) {
        return userRepository.findById(id);
    }

    public UserModel updateById(UserModel request, Long id) {
        // Buscar el usuario existente por ID
        UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        // Actualizar los campos del usuario con los valores del request
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setTelefono(request.getTelefono());
        user.setEmail(request.getEmail());

        // Guardar el usuario actualizado en la base de datos
        return userRepository.save(user);
    }

    public Boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

