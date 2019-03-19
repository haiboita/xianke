package com.xianke.news.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 新闻实体类
 */
@Table(name="xk_news")
@Data
public class News {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;//id

    private Integer author_id;//发布者id
    private String title;//新闻标题
    private String description;//新闻描述
    private String  content;//新闻内容
    private Integer type;//新闻类型
    private Integer priority;//新闻排序
    private double priority_sort;//排序冗余
    private java.util.Date create_time;//新闻创建时间
    private java.util.Date update_time;//新闻最后更新时间
    private java.util.Date deadline;//新闻截至时间
    private Integer status;//新闻状态 0 不显示  1显示
    private Integer pageview;//浏览量
    private Integer collect;//收藏数
    private Integer comment;//评论数
    private Integer goodcount;//点赞数

    //新闻发布者

    @Transient
    private String author_name;
}
