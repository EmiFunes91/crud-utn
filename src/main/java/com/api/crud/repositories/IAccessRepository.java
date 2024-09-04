package com.api.crud.repositories;

import com.api.crud.models.AccessModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccessRepository extends CrudRepository<AccessModel, Long> {
 Optional<AccessModel> findByUsuarioAndClave(String usuario, String clave);
}

