package org.gosky.blog;


import com.github.pagehelper.PageInfo;

import org.gosky.blog.bean.ContentBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "blog-service")
public interface ContentFeign {

    @RequestMapping("/content/page")
    PageInfo<ContentBean> page(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    @RequestMapping(value = "/content/page/group")
    PageInfo<ContentBean> pageByGroup(@RequestParam("groupId") int groupId, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    @RequestMapping(value = "/content/list/new")
    List<ContentBean> getByNewOrder();

    @RequestMapping(value = "/content/list/group")
    List<Map<String, String>> getByGroup();

    @RequestMapping("/content/detail/{id}")
    List<ContentBean> getById(@PathVariable("id") int id);

    @RequestMapping("/content/add")
    int addContent(ContentBean contentBean);



}
