package com.bibi.dnwtd.web.exception;

import com.bibi.dnwtd.web.commons.Code;
import lombok.Data;

@Data
public class DataIncorrectException extends RuntimeException{
    private final int code = Code.DATA_INCORRECT;
    private final String desc = Code.erroMessage.get(Code.DATA_INCORRECT);
}
