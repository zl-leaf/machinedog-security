package me.yipzale.machinedog.security.core;

import me.yipzale.machinedog.security.entity.UserEntity;
import me.yipzale.machinedog.security.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserRepository userRepository = UserRepository.getInstance();
        UserEntity userEntity = userRepository.findByAccount(s);
        if (null == userEntity) {
            throw new UsernameNotFoundException("can not found the account: " + s);
        }
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        UserModel userModel = new UserModel(userEntity.getId(), userEntity.getAccount(), userEntity.getPassword(), authorities);
        return userModel;
    }
}
