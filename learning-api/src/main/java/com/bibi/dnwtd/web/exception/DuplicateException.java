package com.bibi.dnwtd.web.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DuplicateException extends RuntimeException {
    private String desc = "数据库重复";
    private Integer code = 10005;
}
