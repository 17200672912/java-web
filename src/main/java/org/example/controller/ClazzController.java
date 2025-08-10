package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.anno.Log;
import org.example.pojo.Clazz;
import org.example.pojo.PageResult;
import org.example.pojo.Result;
import org.example.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @GetMapping
    public Result page(String name,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页查询:{},{},{},{},{}",name,begin,end,page,pageSize);
        PageResult<Clazz> pageResult=clazzService.page(name,begin,end,page,pageSize);
        return Result.success(pageResult);
    }
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除员工:{}", id);
        clazzService.delete(id);
        return  Result.success();
    }
   @Log
    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        log.info("新增员工:{}",clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询员工:{}",id);
        Clazz clazz=clazzService.getInfo(id);
        return Result.success(clazz);
    }
    @Log
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("更新员工:{}",clazz);
        clazzService.update(clazz);
        return Result.success();
    }
    @GetMapping("/list")
    public Result findAll(){
        log.info("查询所有班级");
        List<Clazz> clazzList=clazzService.findAll();
        return Result.success(clazzList);
    }
}
