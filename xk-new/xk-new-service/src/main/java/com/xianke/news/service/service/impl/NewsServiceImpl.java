package com.xianke.news.service.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xianke.common.enums.ExceptionEnum;
import com.xianke.common.exception.XkException;
import com.xianke.common.vo.PageResult;
import com.xianke.news.pojo.News;
import com.xianke.news.pojo.User;
import com.xianke.news.service.mapper.NewsMapper;
import com.xianke.news.service.mapper.UserMapper;
import com.xianke.news.service.service.NewsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询新闻
     * @param page
     * @param rows
     * @param key
     * @param status
     * @return
     */
    @Override
    public PageResult<News> queryInformationByPage(Integer page, Integer rows, String key, Boolean status,Integer type) {
        //分页
        PageHelper.startPage(page,rows);

        Example example = new Example(News.class);
        Example.Criteria criteria = example.createCriteria();
        //过滤
        if(StringUtils.isNotBlank(key)){
            //搜索关键字
            criteria.andLike("title","%"+key+"%");
        }
        if(status!=null){
            criteria.andEqualTo("status",status);
        }
        if(type!=null){
            if(type==1){
                criteria.andEqualTo("type",1);
            }
            if(type==2){
                criteria.andEqualTo("type",2);
            }
        }
        //排序
        //默认以排序冗余排序
        example.setOrderByClause("priority_sort desc");

        //只查询公司新闻
       // criteria.andEqualTo("type",1);

        //查询
        List<News> newsList = newsMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(newsList)){
            throw new XkException(ExceptionEnum.NEWS_NOT_FONUND);
        }
        //对查询结果中的发布者进行处理
        handleAuthor_id(newsList);
        PageInfo<News> info = new PageInfo<>(newsList);
        return new PageResult<>(info.getTotal(),newsList);
    }

    /**
     * 新增新闻
     * @param news
     */
    @Transactional
    @Override
    public void addNews(News news) {
        //新闻类型
        news.setType(1);
        //时间
        news.setUpdate_time(new Date());
        news.setCreate_time(new Date());
        int count = newsMapper.insert(news);
        if(count!=1){
            throw new XkException(ExceptionEnum.NEWS_ADD_ERROR);
        }
        //插入user
       // news.setAuthor_id();
       // news.setPriority(news.getId());
    }



    /**
     * 更新新闻
     * @param news
     */
    @Transactional
    @Override
    public void updateNews(News news) {

        int count = newsMapper.updateByPrimaryKey(news);
        if(count==0){
            throw  new XkException(ExceptionEnum.NEWS_UPDATE_ERROR);
        }

    }

    /**
     * 查询会员
     * @param id
     * @return
     */
    @Override
    public News queryNewsById(Integer id) {
        News news = new News();
        news.setId(id);
        News news1 = newsMapper.selectByPrimaryKey(news);
        if(news1==null){
            throw new XkException(ExceptionEnum.NEWS_NOT_FONUND);
        }
        return news1;
    }

    /**
     * 删除品牌
     * @param ids
     */
    @Transactional
    @Override
    public void delNewsById(Integer[] ids) {
        for (Integer id : ids) {
            int count = newsMapper.deleteByPrimaryKey(id);
            if(count==0){
                throw new XkException(ExceptionEnum.NEWS_DELETE_ERROR);
            }
        }

    }

    @Override
    public void delOneNewsById(Integer id) {
        int count = newsMapper.deleteByPrimaryKey(id);
        if(count==0){
            throw new XkException(ExceptionEnum.NEWS_DELETE_ERROR);
        }
    }

    /**
     * 启用
     * @param ids
     */
    @Override
    public void updateStautsEnable(Integer[] ids) {
        for (Integer id : ids) {
            News news = new News();
            news.setStatus(1);
            int count = newsMapper.updateByPrimaryKey(news);
            if(count==0){
                throw  new XkException(ExceptionEnum.NEWS_UPDATE_ERROR);
            }
        }
    }
    /**
     * 禁用
     * @param ids
     */
    @Override
    public void updateStautsDisable(Integer[] ids) {
        for (Integer id : ids) {
            News news = new News();
            news.setStatus(0);
            int count = newsMapper.updateByPrimaryKey(news);
            if(count==0){
                throw  new XkException(ExceptionEnum.NEWS_UPDATE_ERROR);
            }
        }
    }


    /**
     * 处理发布者id
     * @param newsList
     */
    private void handleAuthor_id(List<News> newsList) {
        for (News news : newsList) {
            //查询发布者名称
            news.setAuthor_name(userMapper.selectByPrimaryKey(news.getAuthor_id()).getUsername());
        }
    }
}
