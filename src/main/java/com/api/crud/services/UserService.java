package com.api.crud.services;

import com.api.crud.models.AccessModel;
import com.api.crud.models.UserModel;
import com.api.crud.models.UsuarioDTO;
import com.api.crud.repositories.IAccessRepository;
import com.api.crud.repositories.IUserRepository;
import com.api.crud.utills.Password2SHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IAccessRepository accessRepository;

    public ArrayList<UserModel> getUser() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<UsuarioDTO> getByUsuarioAndClave(String usuario, String clave) {
        Password2SHA password2SHA = new Password2SHA();
        Optional<AccessModel> optData = accessRepository.findByUsuarioAndClave(usuario, password2SHA.generateSHA256Hash(clave));

        if (optData.isPresent()) {
            Optional<UserModel> userModel = this.getById(optData.get().getId());
            if (userModel.isPresent()) {
                return Optional.of(new UsuarioDTO(
                        optData.get().getId(),
                        userModel.get().getFirstName(),
                        optData.get().getUsuario(),
                        userModel.get().getPriority()
                ));
            }
        }
        return Optional.empty();
    }

    public UserModel updateById(UserModel request, Long id) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setTelefono(request.getTelefono());
        user.setEmail(request.getEmail());

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


