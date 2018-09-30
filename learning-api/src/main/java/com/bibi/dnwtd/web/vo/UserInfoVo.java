package com.bibi.dnwtd.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class UserInfoVo {
    private Integer id;
    private String userName;
}
