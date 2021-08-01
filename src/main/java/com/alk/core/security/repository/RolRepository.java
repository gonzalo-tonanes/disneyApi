package com.alk.core.security.repository;

import com.alk.core.security.entity.Rol;
import com.alk.core.security.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolname(RolName rolname);
}
