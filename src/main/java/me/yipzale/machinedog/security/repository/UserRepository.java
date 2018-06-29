package me.yipzale.machinedog.security.repository;


import me.yipzale.machinedog.security.entity.UserEntity;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static UserRepository instance = null;
    private Map<Long, UserEntity> data = new HashMap<Long, UserEntity>();

    public UserRepository() {
        this.load();
    }

    public static UserRepository getInstance() {
        if (null == instance) {
            instance = new UserRepository();
        }
        return instance;
    }

    /**
     * 加载数据
     */
    public void load() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId((long)100000);
        userEntity.setNickname("machinedog-admin");
        userEntity.setAccount("admin");
        userEntity.setPassword("0c909a141f1f2c0a1cb602b0b2d7d050");
        this.data.put(userEntity.getId(), userEntity);
    }

    public UserEntity findById(Long id) {
        if (this.data.containsKey(id)) {
            return this.data.get(id);
        }
        return null;
    }

    public UserEntity findByAccount(String account) {
        for (UserEntity userEntity : this.data.values()) {
            if (account.equals(userEntity.getAccount())) {
                return userEntity;
            }
        }
        return null;
    }
}
