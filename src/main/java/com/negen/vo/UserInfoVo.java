package com.negen.vo;

import lombok.Data;

import java.util.List;

/**
 * @author ：Negen
 * @date ：2022/8/2 21:03
 * @description：
 *
 * {
 * 	"data": {
 * 		"roles": [
 * 			"admin"
 * 		],
 * 		"introduction": "I am a super administrator",
 * 		"avatar": "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
 * 		"name": "Super Admin"
 *        }
 * }
 */
@Data
public class UserInfoVo {
    List<String> roles;
    String introduction;
    String avatar;
    String name;
}
