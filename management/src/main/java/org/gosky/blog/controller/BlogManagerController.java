package org.gosky.blog.controller;

import org.gosky.blog.bean.ContentBean;
import org.gosky.blog.mapper.BlogManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guo on 2018/10/17.
 * desc:
 */
@RestController
@RequestMapping("/management")
public class BlogManagerController {
    @Autowired
    private BlogManagerMapper blogManagerMapper;

    @RequestMapping(value = "/post")
    public int addContent(ContentBean contentBean) {

        int count = blogManagerMapper.postBlog(contentBean);

        return count > 0 ? contentBean.getId() : 0;
    }
}
