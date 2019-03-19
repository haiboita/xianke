package com.xianke.news.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体类
 * @author Administrator
 *
 */
@Table(name="sys_user")
@Data
public class User {

	@Id
	@KeySql(useGeneratedKeys = true)
	private Integer id;//用户id


	
	private String username;//用户名
	private String password;//用户密码
	private String nickname;//昵称
	private String head_img_url;//头像地址
	private String phone;//电话
	private String telephone;//手机
	private String email;//邮箱
	private java.util.Date birthday;//生日
	private Integer sex;//性别
	private Integer status;//状态
	private java.util.Date createTime;//创建时间
	private java.util.Date updateTime;//更新时间

	


	
}
