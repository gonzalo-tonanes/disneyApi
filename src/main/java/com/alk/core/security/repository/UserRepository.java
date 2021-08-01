package com.alk.core.security.repository;

import com.alk.core.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String nombreUsuario);
    boolean existsByUsername(String nombreUsuario);
    boolean existsByEmail(String email);

}
