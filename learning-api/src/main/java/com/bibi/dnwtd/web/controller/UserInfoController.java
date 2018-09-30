package com.bibi.dnwtd.web.controller;

import com.bibi.dnwtd.web.commons.Code;
import com.bibi.dnwtd.web.commons.Result;
import com.bibi.dnwtd.web.dto.UserInfoDto;
import com.bibi.dnwtd.web.exception.DataIncorrectException;
import com.bibi.dnwtd.web.exception.DuplicateException;
import com.bibi.dnwtd.web.service.UserInfoService;
import com.bibi.dnwtd.web.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/")
    @ResponseBody
    public Result<UserInfoVo> register(@RequestBody UserInfoDto userInfoDto){
        Result<UserInfoVo> result;
        UserInfoVo userInfoVo = new UserInfoVo();
        try {
            userInfoVo = userInfoService.register(userInfoDto);
        } catch (DuplicateException e){
            return new Result.Builder<UserInfoVo>(userInfoVo).setCode(Code.DUPLICATE_DATA).setDesc("用户名重复").build();
        }
        result = new Result.Builder<UserInfoVo>(userInfoVo).setCode(Code.SUCCESS)
                .setDesc("注册成功").build();
        return result;
    }
    @PostMapping("/login")
    @ResponseBody
    public Result<UserInfoVo> login(@RequestBody UserInfoDto userInfoDto, HttpSession httpSession){
        Result<UserInfoVo> result;
        UserInfoVo userInfoVo = new UserInfoVo();
        try {
            userInfoVo = userInfoService.login(userInfoDto, httpSession);
        } catch (DataIncorrectException e){
            return new Result.Builder<UserInfoVo>(userInfoVo).setCode(Code.DATA_INCORRECT).setDesc("用户名或密码不正确").build();
        }
        result = new Result.Builder<UserInfoVo>(userInfoVo).setCode(Code.SUCCESS)
                .setDesc("登录成功").build();
        return result;
    }
}
