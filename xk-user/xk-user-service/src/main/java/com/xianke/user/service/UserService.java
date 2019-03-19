package com.xianke.user.service;

import com.xianke.common.vo.PageResult;
import com.xianke.user.pojo.SysUser;

public interface UserService {

    PageResult<SysUser> queryUserByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key);
}
