package com.smbms.service;

import com.smbms.pojo.SmbmsUser;

public interface UserLoginService {
    SmbmsUser login(String userCode, String userPassword);
}
