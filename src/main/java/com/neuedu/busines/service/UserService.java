package com.neuedu.busines.service;

import com.neuedu.busines.common.ServerResponse;
import com.neuedu.busines.pojo.User;

public interface UserService {
    public ServerResponse resgister(User user);

    ServerResponse login(String username,String password);

    ServerResponse updateInfo(String username,String email,
                              String phone,
                              String question,
                              String answer);
}
