package com.xianke.demo.service;

import com.xianke.demo.mapper.CategoryMapper;
import com.xianke.common.enums.ExceptionEnum;
import com.xianke.common.exception.XkException;
import com.xianke.demo.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import java.util.List;

@Service
public class CategoryService {

    /**
     *示例demo
     */
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByPid(Long pid) {
        //查询条件,mapper会把对象中的非空属性作为查询条件
        Category category = new Category();
        category.setParentId(pid);
        List<Category> categoryList = categoryMapper.select(category);
        //判断结果
        if(CollectionUtils.isEmpty(categoryList)){
            throw new XkException(ExceptionEnum.USER_NOT_EXIST);
        }
        return categoryList;
    }
}
