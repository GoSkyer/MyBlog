package me.galaxy.blog.service;

import me.galaxy.blog.mapper.AboutMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/about")
public class AboutService {

    @Resource
    private AboutMapper aboutMapper;

    @RequestMapping("/contact/add")
    @ResponseBody
    public int contactUs(String name, String email, String title, String content) {
        return aboutMapper.addContact(name, email, title, content);
    }

}
