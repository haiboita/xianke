package com.xianke.user.web;

import com.xianke.common.vo.PageResult;
import com.xianke.user.pojo.SysUser;
import com.xianke.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("page")
    public ResponseEntity<PageResult<SysUser>> queryUserByPage(
            @RequestParam(value = "page",defaultValue = "1")Integer page, //当前页
            @RequestParam(value = "rows",defaultValue = "5")Integer rows,  //每页行数
            @RequestParam(value = "sortBy",required = false)String  sortBy,//是否排序
            @RequestParam(value = "desc",defaultValue = "false")Boolean desc,  //排序方式
            @RequestParam(value = "key",required = false)String  key    //搜说关键字 默认不传
    ){
            return ResponseEntity.ok(userService.queryUserByPage(page,rows,sortBy,desc,key));
    }
}
