package com.bibi.dnwtd.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.sql.Timestamp;

@Data
@Log4j
@NoArgsConstructor
public class Permission {
    private Integer id;
    private String permissionDesc;
    private Integer deleted;
    private Timestamp createTime;
    private Timestamp updateTime;
}
