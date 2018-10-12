package org.gosky.blog.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.gosky.blog.bean.ContentBean;
import org.gosky.blog.mapper.ContentMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("content")
public class ContentService {

    @Resource
    private ContentMapper contentMapper;

    @RequestMapping(value = "/page")
    public PageInfo<ContentBean> page(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<ContentBean> contentList = contentMapper.page();

        return new PageInfo<>(contentList);
    }

    @RequestMapping(value = "/page/group")
    public PageInfo<ContentBean> pageByGroup(int groupId, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<ContentBean> contentList = contentMapper.pageByGroup(groupId);

        return new PageInfo<>(contentList);
    }

    @RequestMapping(value = "/list/new")
    public List<ContentBean> getByNewOrder() {
        return contentMapper.getByNewOrder();
    }

    @RequestMapping(value = "/detail/{id}")
    public List<ContentBean> contentDetail(@PathVariable int id) {

        List<ContentBean> contentList = contentMapper.getById(id);

        return contentList;
    }

    @RequestMapping(value = "/list/group")
    public List<Map<String, String>> getByGroup() {
        return contentMapper.getByGroup();
    }

    @RequestMapping(value = "/add")
    public int addContent(ContentBean contentBean) {

        int count = contentMapper.addContent(contentBean);

        return count > 0 ? contentBean.getId() : 0;
    }

}
