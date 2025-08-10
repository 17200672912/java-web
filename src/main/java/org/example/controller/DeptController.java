package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.anno.Log;
import org.example.pojo.Dept;
import org.example.pojo.Result;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    //@RequestMapping(value="/depts",method= RequestMethod.GET)
    @GetMapping
    public Result list(){
        List<Dept>deptList= deptService.findAll();
        log.info("查询表信息");
        return Result.success(deptList);
    }
    @Log
    @DeleteMapping
    public Result deleteById(Integer id){
        log.info("根据ID删除:{}",id);
        deptService.deleteById(id);
        return Result.success();
    }
    @Log
    @PostMapping
    public Result insert(@RequestBody Dept dept){
        log.info("添加数据:{}",dept);
        deptService.insert(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据ID查询:{}",id);
        Dept dept=deptService.getById(id);
        return Result.success(dept);
    }
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改数据:{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}
