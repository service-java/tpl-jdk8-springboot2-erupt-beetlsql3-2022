package com.example.demo.util;

import cn.hutool.core.util.StrUtil;

public class ExtractFieldUtil  {

    public static String call(String o) {
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
