package me.yipzale.machinedog.security.controller;

import me.yipzale.machinedog.security.entity.UserEntity;
import me.yipzale.machinedog.security.model.ErrorModel;
import me.yipzale.machinedog.security.model.UserModel;
import me.yipzale.machinedog.security.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/{userId}/check_login", method = RequestMethod.GET)
    public Object checkLogin(@PathVariable Long userId) {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", userId:" + userId);
        UserEntity userEntity = userRepository.findById(userId);
        if (null == userEntity) {
            return new ResponseEntity<ErrorModel>(new ErrorModel("user not found", "userId error"), HttpStatus.BAD_REQUEST);
        }
        UserModel userModel = new UserModel();
        userModel.setId(userEntity.getId());
        userModel.setNickname(userEntity.getNickname());
        return userModel;
    }
}
