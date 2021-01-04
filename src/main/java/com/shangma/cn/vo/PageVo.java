package com.shangma.cn.vo;

import lombok.Data;
import java.util.List;

@Data
public class PageVo<T> {
    private long total;
    private List<T> list;
}
