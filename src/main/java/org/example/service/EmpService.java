package org.example.service;

import org.example.pojo.Emp;
import org.example.pojo.EmpQueryParam;
import org.example.pojo.LoginInfo;
import org.example.pojo.PageResult;

import java.util.List;

public interface EmpService {
     PageResult<Emp> page(EmpQueryParam empQueryParam) ;

     void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getById(Integer id);

    void update(Emp emp);

    LoginInfo login(Emp emp);
}
