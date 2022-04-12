package com.example.demo.util;

import cn.hutool.core.util.StrUtil;
import org.beetl.core.Context;
import org.beetl.core.Function;

public class ExtractFieldFnUtil implements Function {

    public String call(Object[] paras, Context ctx) {
        Object o = paras[0];
        if (o != null) {
            if (StrUtil.contains(o.toString(), ":")) {
                return StrUtil.subBefore(o.toString(), ":", false);
            }
            if (StrUtil.contains(o.toString(), "：")) {
                return StrUtil.subBefore(o.toString(), "：", false);
            }
            if (StrUtil.contains(o.toString(), "(")) {
                return StrUtil.subBefore(o.toString(), "(", false);
            }
            if (StrUtil.contains(o.toString(), "（")) {
                return StrUtil.subBefore(o.toString(), "（", false);
            }
            return o.toString();
        }
        return "";
    }
}
