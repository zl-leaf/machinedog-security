package me.yipzale.machinedog.security.core;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserModel extends User {
    private Long id;

    public UserModel(Long id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
