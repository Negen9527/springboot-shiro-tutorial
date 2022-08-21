package com.negen.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ：Negen
 * @date ：2022/8/21 16:29
 * @description：
 * {
 *         id: 1,
 *         label: '一级 1',
 *         children: [{
 *           id: 4,
 *           label: '二级 1-1',
 *           children: [{
 *             id: 9,
 *             label: '三级 1-1-1'
 *           }, {
 *             id: 10,
 *             label: '三级 1-1-2'
 *           }]
 *         }]
 *       }
 */
@Data
public class ListTreePermissionVo {
    private Integer id;
    /**
     * 父节点ID
     */
    private Integer parentId;
    private String label;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    private Integer status;
    private List<ListTreePermissionVo> children;
}
