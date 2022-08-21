package com.negen.utils;

import com.negen.vo.ListTreePermissionVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Negen
 * @date ：2022/8/21 17:19
 * @description：生成树形结构的权限列表
 */
public class List2Tree {
    /**
     * 生成树形结构的权限列表
     * @param list
     * @return
     */
    public static List<ListTreePermissionVo> listToTree(List<ListTreePermissionVo> list) {
        List<ListTreePermissionVo> tree = new ArrayList<>();
        for (ListTreePermissionVo listTreePermissionVo : list) {
            //找到根节点
            if (listTreePermissionVo.getParentId().equals(0)) {
                tree.add(findChildren(listTreePermissionVo, list));
            }
        }
        return tree;
    }

    /**
     * 查找ReportTemplateVo的子节点
     * @param listTreePermissionVo
     * @param list
     * @return
     */
    private static ListTreePermissionVo findChildren(ListTreePermissionVo listTreePermissionVo
            , List<ListTreePermissionVo> list) {
        List<ListTreePermissionVo> children = new ArrayList<>();
        for (ListTreePermissionVo node : list) {
            if (node.getParentId().equals(listTreePermissionVo.getId())) {
                //递归调用
                children.add(findChildren(node, list));
            }
        }
        listTreePermissionVo.setChildren(children);
        return listTreePermissionVo;
    }
}
