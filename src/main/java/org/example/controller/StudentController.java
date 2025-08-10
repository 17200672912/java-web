package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.anno.Log;
import org.example.pojo.PageResult;
import org.example.pojo.Result;
import org.example.pojo.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public Result page(String name,
                       Integer degree,
                       Integer clazzId,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页查询：{},{},{},{},{}",page,pageSize,name,degree,clazzId);
        PageResult<Student> pageResult=studentService.page(name,degree,clazzId,page,pageSize);
        return Result.success(pageResult);
    }
    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除学生:{}", ids);
        studentService.delete(ids);
        return Result.success();
    }
    @Log
    @PostMapping
    public Result save(@RequestBody Student student){
        log.info("保存学生:{}", student);
        studentService.save(student);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询学生:{}",id);
        Student student=studentService.getInfo(id);
        return Result.success(student);
    }
    @Log
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("更新学生:{}",student);
        studentService.update(student);
        return Result.success();
    }
    @Log
    @PutMapping("/violation/{id}/{score}")
    public Result violationHandle(@PathVariable Integer id,
                                  @PathVariable Integer score){
        log.info("处理学生违纪:{},{}",id,score);
        studentService.violationHandle(id,score);
        return Result.success();
    }
}
