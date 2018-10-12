package org.gosky.blog.web;

import org.gosky.blog.AboutFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/about")
public class AboutWeb {

    @Autowired
    private AboutFeign aboutFeign;

    @RequestMapping("/index")
    public String index() {
        return "about";
    }

    @RequestMapping("/contact/add")
    @ResponseBody
    public String contactUs(String name, String email, String title, String content) {

        int count = aboutFeign.addContact(name, email, title, content);

        if (count > 0) return "ok";
        else return "failed";

    }

}
