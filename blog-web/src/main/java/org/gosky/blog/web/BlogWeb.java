package org.gosky.blog.web;

import me.galaxy.blog.CommentFeign;
import me.galaxy.blog.ContentFeign;
import me.galaxy.blog.bean.CommentDto;
import me.galaxy.blog.bean.ContentBean;
import org.markdownj.MarkdownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/blog")
public class BlogWeb {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ContentFeign contentFeign;

    @Autowired
    private CommentFeign commentFeign;

    @RequestMapping("/{id}")
    public String index(ModelMap map, @PathVariable int id) {

        List<ContentBean> result = contentFeign.getById(id);
        List<ContentBean> newList = contentFeign.getByNewOrder();
        List<Map<String, String>> groupList = contentFeign.getByGroup();
        List<CommentDto> commentList = commentFeign.getCommentByBlogId(id);

        ContentBean contentBean = result.get(0);

        String content = restTemplate.getForObject(contentBean.getContent(), String.class);

        MarkdownProcessor markdownProcessor = new MarkdownProcessor();
        String markdown = markdownProcessor.markdown(content);

        map.addAttribute("userId", "0");

        map.addAttribute("blog", contentBean);
        map.addAttribute("mdFile", markdown);
        map.addAttribute("newList", newList);
        map.addAttribute("groupList", groupList);
        map.addAttribute("commentCount", commentList.size());
        map.addAttribute("commentList", commentList);

        return "blog";
    }

    @RequestMapping("/comment/add")
    @ResponseBody
    public CommentDto addComment(int blogId, String blogName, @RequestParam(defaultValue = "0") int userId, String userName, String content) {
        return commentFeign.addContent(blogId, blogName, userId, userName, content);
    }

    @RequestMapping("/comment/list")
    @ResponseBody
    public List<CommentDto> getCommentList(int blogId) {

        List<CommentDto> list = commentFeign.getCommentByBlogId(blogId);

        return list;
    }

}
