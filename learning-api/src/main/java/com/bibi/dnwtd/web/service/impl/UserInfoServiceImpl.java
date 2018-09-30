package com.bibi.dnwtd.web.service.impl;

import com.bibi.dnwtd.web.commons.SessionConstEnum;
import com.bibi.dnwtd.web.dao.UserInfoMapper;
import com.bibi.dnwtd.web.dto.UserInfoDto;
import com.bibi.dnwtd.web.entity.UserInfo;
import com.bibi.dnwtd.web.exception.DataIncorrectException;
import com.bibi.dnwtd.web.exception.DuplicateException;
import com.bibi.dnwtd.web.service.UserInfoService;
import com.bibi.dnwtd.web.vo.UserInfoVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoVo register(UserInfoDto userInfoDto) {
        int count = userInfoMapper.checkUserNameDuplicate(userInfoDto.getUserName());
        if(count>0){
            throw new DuplicateException();
        }
        userInfoDto.setUserPassword(new Md5Hash(userInfoDto.getUserPassword(), userInfoDto.getUserName()).toString());
        userInfoMapper.insertUserInfo(userInfoDto);
        UserInfo userInfo = userInfoMapper.findByUserName(userInfoDto.getUserName());
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setId(userInfo.getId());
        userInfoVo.setUserName(userInfo.getUserName());
        return userInfoVo;
    }

    @Override
    public UserInfoVo login(UserInfoDto userInfoDto, HttpSession httpSession) {
        String password = new Md5Hash(userInfoDto.getUserPassword(), userInfoDto.getUserName()).toString();
        UserInfo userInfo = userInfoMapper.findByUserNameAndPassword(userInfoDto.getUserName(), password);
        if(userInfo==null){
            throw new DataIncorrectException();
        }
        UserInfoVo userInfoVo = new UserInfoVo(userInfo.getId(),userInfo.getUserName());
        httpSession.setAttribute(SessionConstEnum.USER_LOGIN_INFO.of(SessionConstEnum.USER_LOGIN_INFO), userInfoVo);
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUserName(),userInfo.getUserPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return userInfoVo;
    }
}
