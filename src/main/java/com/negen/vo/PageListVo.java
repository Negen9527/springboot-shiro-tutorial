package com.negen.vo;

import lombok.Data;

import java.util.List;

/**
 * @author ：Negen
 * @date ：2022/8/4 21:14
 * @description：
 */
@Data
public class PageListVo<T> {
    long total;
    List<T> items;
}
