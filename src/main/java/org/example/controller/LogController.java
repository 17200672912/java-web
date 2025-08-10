package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Clazz;
import org.example.pojo.OperateLog;
import org.example.pojo.PageResult;
import org.example.pojo.Result;
import org.example.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log/page")
public class LogController {
    @Autowired
    private LogService logService;
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize){
    log.info("分页查询：{},{}",page,pageSize);
        PageResult<OperateLog> pageResult=logService.page(page,pageSize);
    return Result.success(pageResult);
    }
}
