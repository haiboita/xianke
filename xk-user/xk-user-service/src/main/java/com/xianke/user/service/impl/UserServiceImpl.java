package com.xianke.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xianke.common.enums.ExceptionEnum;
import com.xianke.common.exception.XkException;
import com.xianke.common.vo.PageResult;
import com.xianke.user.mapper.UserMapper;
import com.xianke.user.pojo.SysUser;
import com.xianke.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageResult<SysUser> queryUserByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        //分页
        PageHelper.startPage(page,rows);
        //过滤
        Example example = new Example(SysUser.class);
        if(StringUtils.isNotBlank(key)){
            //过滤条件
            example.createCriteria().orLike("username","%+key+%")
                    .orLike("nickname", "%+key+%");
        }
        //排序
        if(StringUtils.isNotBlank(sortBy)){
            String orderByClause =sortBy +  (desc ? "DESC" : "ASC");
            example.setOrderByClause(orderByClause);
        }
        //查询
        List<SysUser> sysUserList = userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(sysUserList)){
            throw new XkException(ExceptionEnum.USER_NOT_FONUND);
        }
        //解析分页结果
        PageInfo<SysUser> info = new PageInfo<>(sysUserList);
        return new PageResult<>(info.getTotal(),sysUserList);
    }
}
