package com.example.demo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PageQueryVo {
    @NotNull(message = "页码不能为空")
    private Integer pageNumber;
    @NotNull(message = "每页数量不能为空")
    private Integer pageSize;
}
