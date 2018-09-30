package com.bibi.dnwtd.web.commons;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
public enum DatabaseEnum {

    NO_DELETED(0,"未删除"),

    DELETED(1,"已删除");

    private Integer code;

    private String desc;

    public Integer of (DatabaseEnum databaseEnum){
        switch (databaseEnum){
            case DELETED:
                return 1;
            case NO_DELETED:
                return 0;
            default:
                return 0;
        }
    }
}
