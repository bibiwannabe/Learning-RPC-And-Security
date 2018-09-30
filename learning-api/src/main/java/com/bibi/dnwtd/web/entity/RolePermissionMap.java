package com.bibi.dnwtd.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Log4j
public class RolePermissionMap {
    private Integer id;
    private Integer roleId;
    private Integer permissionId;
    private Integer deleted;
    private Timestamp createTime;
    private Timestamp updateTime;
}
