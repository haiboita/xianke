package com.xianke.news.service.web;

import com.xianke.common.vo.PageResult;
import com.xianke.news.pojo.News;
import com.xianke.news.service.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    /**
     * 分页查询新闻信息
     *
     * @param page
     * @param rows
     * @param key
     * @param status
     * @return
     */
    @GetMapping("information/page")
    public ResponseEntity<PageResult<News>> queryInformationByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "status", required = false) Boolean status,
            @RequestParam(value = "type", defaultValue = "1") Integer type
    ) {
        return ResponseEntity.ok(newsService.queryInformationByPage(page, rows, key, status,type));
    }


    /**
     * 新增新闻
     *
     * @param news
     * @return
     */
    @PostMapping("add")
    private ResponseEntity<Void> addNews(@RequestBody News news) {
        newsService.addNews(news);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 更新新闻
     *
     * @param news
     * @return
     */
    @PutMapping("update")
    public ResponseEntity<Void> updateNews(@RequestBody News news) {
        newsService.updateNews(news);
        return ResponseEntity.ok().build();
    }

    /**
     * 删除新闻
     *
     * @param ids
     * @return
     */
    @DeleteMapping("del/ids")
    public ResponseEntity<Void> delNewsById(@RequestParam("ids") Integer[] ids) {
        newsService.delNewsById(ids);
        return ResponseEntity.ok().build();
    }

    /**
     * 删除单个新闻
     *
     * @param id
     * @return
     */
    @DeleteMapping("del/{id}")
    public ResponseEntity<Void> delOneNewsById(@PathVariable("id") Integer id) {
        newsService.delOneNewsById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("statusEnable/ids")
    public ResponseEntity<Void> updateStautsEnable(@RequestParam("ids") Integer[] ids) {
        newsService.updateStautsEnable(ids);
        return ResponseEntity.ok().build();
    }

    @PostMapping("statusDisable/ids")
    public ResponseEntity<Void> updateStautsDisable(@RequestParam("ids") Integer[] ids) {
        newsService.updateStautsDisable(ids);
        return ResponseEntity.ok().build();
    }

}