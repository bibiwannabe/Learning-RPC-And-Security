package com.bibi.dnwtd.web.service;

import com.bibi.dnwtd.web.dto.UserInfoDto;
import com.bibi.dnwtd.web.vo.UserInfoVo;

import javax.servlet.http.HttpSession;

public interface UserInfoService {

    UserInfoVo register(UserInfoDto userInfoDto);

    UserInfoVo login(UserInfoDto userInfoDto, HttpSession httpSession);
}
