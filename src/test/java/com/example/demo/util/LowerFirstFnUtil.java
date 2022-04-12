package com.example.demo.util;

import cn.hutool.core.util.StrUtil;
import org.beetl.core.Context;
import org.beetl.core.Function;

public class LowerFirstFnUtil implements Function {

    public String call(Object[] paras, Context ctx) {
        Object o = paras[0];
        if (o != null) {
            return StrUtil.lowerFirst(o.toString());
        }
        return "";
    }
}
