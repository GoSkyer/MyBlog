package me.galaxy.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.galaxy.blog.utils.QiniuUploadUtils;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private QiniuUploadUtils uploadUtils;

    @RequestMapping("upload")
    public String upload(){
        return "ok";
    }

}
