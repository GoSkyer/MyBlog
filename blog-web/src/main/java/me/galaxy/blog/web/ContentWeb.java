package me.galaxy.blog.web;

import com.github.pagehelper.PageInfo;
import me.galaxy.blog.ContentFeign;
import me.galaxy.blog.bean.ContentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/content")
public class ContentWeb {

    @Autowired
    private ContentFeign contentFeign;

    @RequestMapping("/index")
    public String index(ModelMap map,
                        @RequestParam(name = "p", defaultValue = "1") int pageNum,
                        @RequestParam(name = "g", defaultValue = "0") int groupId,
                        @RequestParam(name = "t", defaultValue = "0") int tagId,
                        @RequestParam(name = "d", defaultValue = "0") int date) {

        PageInfo<ContentBean> pages;

        if (groupId > 0) {
            pages = contentFeign.pageByGroup(groupId, pageNum, 5);
        } else {
            pages = contentFeign.page(pageNum, 5);
        }

        map.addAttribute("contentList", pages.getList());
        map.addAttribute("page", pages);
        map.addAttribute("groupId", groupId);

        return "content";
    }

}
