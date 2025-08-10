package org.example.service;

import org.example.pojo.OperateLog;
import org.example.pojo.PageResult;
import org.springframework.stereotype.Service;


public interface LogService {
    PageResult<OperateLog> page(Integer page, Integer pageSize);
}
