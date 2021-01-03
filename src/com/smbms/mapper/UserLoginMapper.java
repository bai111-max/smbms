package com.smbms.mapper;

import com.smbms.pojo.SmbmsUser;
import org.apache.ibatis.annotations.Param;

public interface UserLoginMapper {
    SmbmsUser login(@Param("userCode") String userCode,@Param("userPassword") String userPassword);
}
