package me.galaxy.blog;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "blog-service")
public interface AboutFeign {

    @RequestMapping("/about/contact/add")
    int addContact(@RequestParam(name = "name") String name,
                          @RequestParam(name = "email") String email,
                          @RequestParam(name = "title") String title,
                          @RequestParam(name = "content") String content);

}
