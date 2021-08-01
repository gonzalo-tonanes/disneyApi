package com.alk.core.security.entity;

import com.alk.core.security.enums.RolName;
import javax.persistence.*;


@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private RolName rolname;

    public Rol() {
    }

    public Rol(RolName rolName) {
        this.rolname = rolName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolName getRolname() {
        return rolname;
    }

    public void setRolname(RolName rolName) {
        this.rolname = rolName;
    }
}
