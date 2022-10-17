package com.huangxuan.service;

import com.huangxuan.po.User;

public interface UserService {
    User selectUsernameAndPassword(String username,String password);
}
