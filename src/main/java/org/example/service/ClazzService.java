package org.example.service;

import org.example.pojo.Clazz;
import org.example.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface ClazzService {
    PageResult<Clazz> page(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    void delete(Integer id);

    void save(Clazz clazz);

    Clazz getInfo(Integer id);

    void update(Clazz clazz);

    List<Clazz> findAll();
}
