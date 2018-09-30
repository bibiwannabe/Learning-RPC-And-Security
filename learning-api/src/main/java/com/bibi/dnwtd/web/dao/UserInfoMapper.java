package com.bibi.dnwtd.web.dao;

import com.bibi.dnwtd.web.dto.UserInfoDto;
import com.bibi.dnwtd.web.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoMapper {

    Integer insertUserInfo(@Param("userInfoDto") UserInfoDto userInfoDto);

    UserInfo findByUserName(@Param("userName") String userName);

    Integer checkUserNameDuplicate(@Param("userName") String userName);

    UserInfo findByUserNameAndPassword(@Param("userName") String userName, @Param("userPassword") String userPassword);
}
