package me.yipzale.machinedog.security.repository;


import me.yipzale.machinedog.security.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findById(Long id);
    UserEntity findByAccount(String account);
}
