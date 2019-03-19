package com.xianke.news.service.service;

import com.xianke.common.vo.PageResult;
import com.xianke.news.pojo.News;

public interface NewsService {
    PageResult<News> queryInformationByPage(Integer page, Integer rows,  String key, Boolean status,Integer type);

    void addNews(News news);

    void updateNews(News news);

    News queryNewsById(Integer id);

    void delNewsById(Integer[] ids);

    void delOneNewsById(Integer id);

    void updateStautsEnable(Integer[] ids);

    void updateStautsDisable(Integer[] ids);
}
