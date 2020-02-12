package com.neuedu.busines.service.impl;

import com.neuedu.busines.common.RoleEnum;
import com.neuedu.busines.common.ServerResponse;
import com.neuedu.busines.common.StatusEnum;
import com.neuedu.busines.dao.UserMapper;
import com.neuedu.busines.pojo.User;
import com.neuedu.busines.service.UserService;
import com.neuedu.busines.utils.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public ServerResponse resgister(User user) {
        if (user.getUsername().equals("") && user.getUsername() == null) {
            return ServerResponse.serverResponseByFail(StatusEnum.USERNAME_NULL.getCode(),StatusEnum.USERNAME_NULL.getMsg());
        }
        if (user.getPassword().equals("") && user.getPassword() == null) {
            return ServerResponse.serverResponseByFail(StatusEnum.PASSWORD_NULL.getCode(),StatusEnum.PASSWORD_NULL.getMsg());
        }
        if (user.getEmail().equals("") && user.getEmail() == null) {
            return ServerResponse.serverResponseByFail(StatusEnum.EMAIL_NULL.getCode(),StatusEnum.EMAIL_NULL.getMsg());
        }
        if (user.getPhone().equals("") && user.getPhone() == null) {
            return ServerResponse.serverResponseByFail(StatusEnum.PHONE_NULL.getCode(),StatusEnum.PHONE_NULL.getMsg());
        }
        if (user.getQuestion().equals("") && user.getQuestion() == null) {
            return ServerResponse.serverResponseByFail(StatusEnum.QUESTION_NULL.getCode(),StatusEnum.QUESTION_NULL.getMsg());
        }
        if (user.getAnswer().equals("") && user.getAnswer() == null) {
            return ServerResponse.serverResponseByFail(StatusEnum.ANSWER_NULL.getCode(),StatusEnum.ANSWER_NULL.getMsg());
        }

        int countUsername = userMapper.countUsername(user.getUsername());
        if(countUsername>0){
            return ServerResponse.serverResponseByFail(StatusEnum.USER_NOT_ONLY.getCode(),StatusEnum.USER_NOT_ONLY.getMsg());
        }
        int countEmail = userMapper.countEmail(user.getEmail());
        if(countEmail>0){
            return ServerResponse.serverResponseByFail(StatusEnum.EMAIL_NOT_ONLY.getCode(),StatusEnum.EMAIL_NOT_ONLY.getMsg());
        }
        String password = MD5Utils.getMD5Code(user.getPassword());
        user.setPassword(password);
        user.setRole(RoleEnum.USER.getRole());
        int insert = userMapper.insert(user);
        if(insert==0){
            return ServerResponse.serverResponseByFail(StatusEnum.RESGISTER_FAILED.getCode(),StatusEnum.RESGISTER_FAILED.getMsg());
        }
        return ServerResponse.serverResponseBySucess("注册成功",null);
    }

    @Override
    public ServerResponse login(String username, String password) {
        if(username==null&&username.equals("")){
            return ServerResponse.serverResponseByFail(StatusEnum.USER_NOT_EMPTY.getCode(),StatusEnum.USER_NOT_EMPTY.getMsg());
        }
        if(password==null&&password.equals("")){
            return ServerResponse.serverResponseByFail(StatusEnum.PASSWORD_NOT_EMPTY.getCode(),StatusEnum.PASSWORD_NOT_EMPTY.getMsg());
        }

        int countUsername = userMapper.countUsername(username);
        if (countUsername==0){
            return ServerResponse.serverResponseByFail(StatusEnum.USER_NOT_EXIST.getCode(),StatusEnum.USER_NOT_EXIST.getMsg());
        }
        String _password = MD5Utils.getMD5Code(password);
        User user = userMapper.findByUsernameAndPassword(username, _password);
        return ServerResponse.serverResponseBySucess("登陆成功",user);
    }
}
