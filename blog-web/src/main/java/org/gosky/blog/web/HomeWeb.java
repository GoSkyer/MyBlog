package org.gosky.blog.web;

import com.github.pagehelper.PageInfo;
import org.gosky.blog.ContentFeign;
import org.gosky.blog.bean.ContentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class HomeWeb {

    @Autowired
    private ContentFeign contentFeign;

    @RequestMapping("/index")
    public String index(ModelMap map, @RequestParam(name = "p", defaultValue = "1") int pageNum) {

        PageInfo<ContentBean> pages = contentFeign.page(pageNum, 3);
        List<ContentBean> newList = contentFeign.getByNewOrder();
        List<Map<String, String>> groupList = contentFeign.getByGroup();

        map.addAttribute("contentList", pages.getList());
        map.addAttribute("newList", newList);
        map.addAttribute("groupList", groupList);
        map.addAttribute("page", pages);

        return "home";
    }

}
