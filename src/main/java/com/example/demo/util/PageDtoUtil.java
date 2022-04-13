package com.example.demo.util;

import com.example.demo.vo.PageQueryVo;
import org.beetl.sql.core.page.DefaultPageRequest;
import org.beetl.sql.core.page.PageRequest;

public class PageDtoUtil {

    public static PageRequest convert(PageQueryVo pageQueryVo) {
        return DefaultPageRequest.of(pageQueryVo.getPageNumber(), pageQueryVo.getPageSize());
    }
}
