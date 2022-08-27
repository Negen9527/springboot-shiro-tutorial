package com.negen.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ：Negen
 * @date ：2022/8/27 22:20
 * @description：
 */
@Data
public class ListRoleTreeVo {
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
