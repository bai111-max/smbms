package com.smbms.mapper;

import com.smbms.pojo.SmbmsRole;
import com.smbms.pojo.SmbmsUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    Integer getUserCount(@Param("queryname") String queryname,
                         @Param("queryUserRole") Integer queryUserRole);

    List<SmbmsUser> findUserPage(@Param("startIndex") int startIndex,
                                 @Param("pageSize") Integer pageSize,
                                 @Param("queryname") String queryname,
                                 @Param("queryUserRole") Integer queryUserRole);

    List<SmbmsRole> findRoleList();

    boolean adduserSave(SmbmsUser user);

    SmbmsUser finUserByid(Integer id);

    SmbmsUser finduserByUserCode(String userCode);


    boolean findchangepassword(@Param("newpassword") String newpassword,@Param("id") long id);
}
