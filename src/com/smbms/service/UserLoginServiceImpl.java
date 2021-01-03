package com.smbms.service;

import com.smbms.mapper.UserLoginMapper;
import com.smbms.pojo.SmbmsUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    private UserLoginMapper userLoginMapper;
    @Override
    public SmbmsUser login(String userCode, String userPassword) {
        return userLoginMapper.login(userCode,userPassword);
    }
}
