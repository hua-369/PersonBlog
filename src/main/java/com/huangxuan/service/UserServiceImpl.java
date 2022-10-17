package com.huangxuan.service;

import com.huangxuan.dao.UserRepository;
import com.huangxuan.po.User;
import com.huangxuan.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User selectUsernameAndPassword(String username, String password) {
        User user=userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
