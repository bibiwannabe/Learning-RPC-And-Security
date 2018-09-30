package com.bibi.dnwtd.web.commons;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SessionConstEnum {
    USER_LOGIN_INFO("user_login_info");
    private String key;

    public String of(SessionConstEnum sessionConstEnum){
        switch (sessionConstEnum){
            case USER_LOGIN_INFO:
                return "user_login_info";
            default:
                return "user_login_info";
        }
    }
}
