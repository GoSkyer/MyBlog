package org.gosky.blog;

import org.gosky.blog.bean.CommentDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "blog-service")
public interface CommentFeign {

    @RequestMapping(value = "/comment/list")
    List<CommentDto> getCommentByBlogId(@RequestParam(name = "blog") int blogId);

    @RequestMapping("/comment/add")
    CommentDto addContent(@RequestParam(name = "blogId") int blogId,
                          @RequestParam(name = "blogName") String blogName,
                          @RequestParam(name = "userId") int userId,
                          @RequestParam(name = "userName") String userName,
                          @RequestParam(name = "content") String content);

}
