package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.exception.BusinessException;
import org.example.mapper.ClazzMapper;
import org.example.mapper.StudentMapper;
import org.example.pojo.Clazz;
import org.example.pojo.PageResult;
import org.example.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult<Clazz> page(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Clazz> rows= clazzMapper.list(name,begin,end);
        Page<Clazz> p = (Page<Clazz>) rows;
        return new PageResult<Clazz>(p.getTotal(),p.getResult());
    }

    @Override
    public void delete(Integer id) {
        Integer count=studentMapper.countByClazzId(id);
        if(count>0){
            throw new BusinessException("该班级下有学生，不能删除");
        }
        clazzMapper.deleteById(id);
    }

    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz getInfo(Integer id) {
        return clazzMapper.getById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> findAll() {
        return clazzMapper.findAll();
    }
}
