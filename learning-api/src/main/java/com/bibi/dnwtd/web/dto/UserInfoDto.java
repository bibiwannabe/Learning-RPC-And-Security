package com.bibi.dnwtd.web.dto;

import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.io.Serializable;

@Log4j
@Data
public class UserInfoDto implements Serializable {
    private String userName;
    private String userPassword;
}
