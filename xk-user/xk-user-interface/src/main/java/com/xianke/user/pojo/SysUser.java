package com.xianke.user.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Table(name="sys_user")
@Data
public class SysUser{

	private static final long serialVersionUID = -6525908145032868837L;
	@Id
	@KeySql(useGeneratedKeys = true)
	private Integer id;
	private String username;
	private String password;
	private String nickname;
	private String headImgUrl;
	private String phone;
	private String telephone;
	private String email;
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private Integer sex;
	private Integer status;
	//private String intro;


}
