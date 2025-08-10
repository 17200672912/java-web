package org.example.service;

import org.example.pojo.PageResult;
import org.example.pojo.Student;

import java.util.List;

public interface StudentService {
    PageResult<Student> page(String name, Integer degree, Integer clazzId, Integer page, Integer pageSize);

    void delete(List<Integer> ids);

    void save(Student student);

    Student getInfo(Integer id);

    void update(Student student);

    void violationHandle(Integer id, Integer scoreNum);

}
