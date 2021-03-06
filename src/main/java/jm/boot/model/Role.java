package jm.boot.model;


import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }

    public Set<Role>roles(){
        return Set.of(Role.ROLE_USER, Role.ROLE_ADMIN);
    }
}
