package com.bibi.dnwtd.web.commons;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class Code {
    public final static int SUCCESS = 10000;
    public final static int FAIL = 10001;
    public final static int NO_LOGIN = 10003;
    public final static int DATA_INCORRECT = 10004;
    public final static int DUPLICATE_DATA = 10005;

    public final static Map<Integer,String> erroMessage = new ImmutableMap.Builder<Integer, String>()
            .put(SUCCESS, "成功")
            .put(FAIL, "失败")
            .put(NO_LOGIN, "未登录")
            .put(DATA_INCORRECT, "数据不正确")
            .put(DUPLICATE_DATA, "数据重复")
            .build();
}
