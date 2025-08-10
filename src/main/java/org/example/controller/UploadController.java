package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.anno.Log;
import org.example.pojo.Result;
import org.example.utils.AliyunOSSOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class UploadController {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
//    @PostMapping("/upload")
//    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
//        log.info("接收参数:{},{},{}",name,age,file);
//        //获取原始文件名
//        String originalFilename = file.getOriginalFilename();
//        //新文件名
//        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
//        String newFileName = UUID.randomUUID().toString()+extension;
//        //保存文件
//        file.transferTo(new File("D:/zzzzzzzz/"+newFileName));
//        return Result.success();
//    }
    @Log
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件上传:{}",file.getOriginalFilename());
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("文件上传OSS，url：{}",url);
        return Result.success(url);
    }
}
