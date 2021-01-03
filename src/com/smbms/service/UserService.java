package com.smbms.service;

import com.smbms.pojo.SmbmsRole;
import com.smbms.pojo.SmbmsUser;
import com.smbms.utils.PageBean;

import java.util.List;

public interface UserService {
    PageBean<SmbmsUser> findUserPage(Integer pageIndex, Integer pageSize,String queryname,Integer queryUserRole);

    List<SmbmsRole> findRoleList();

    boolean addUserSave(SmbmsUser user);

    SmbmsUser finduserByUserCode(String userCode);

    SmbmsUser finUserByid(Integer id);

    boolean findchangepassword(String newpassword, long id);
}
