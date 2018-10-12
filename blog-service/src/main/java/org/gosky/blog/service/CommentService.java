package org.gosky.blog.service;

import me.galaxy.blog.bean.CommentDto;
import me.galaxy.blog.mapper.CommentMapper;
import me.galaxy.blog.mapper.ContentMapper;

import org.gosky.blog.mapper.CommentMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private ContentMapper contentMapper;

    @RequestMapping("/list")
    public List<CommentDto> getCommentByBlogId(@RequestParam(name = "blog") int blogId) {
        return commentMapper.getCommentByBlogId(blogId);
    }

    @RequestMapping("/add")
    public CommentDto addComment(int blogId, String blogName, int userId, String userName, String content) {

        CommentDto comment = new CommentDto();
        comment.setBlogId(blogId);
        comment.setBlogName(blogName);
        comment.setUserId(userId);
        comment.setUserName(userName);
        comment.setContent(content);

        int count = commentMapper.addComment(comment);

        if (count > 0) {
            contentMapper.updateCommentCount(blogId, count);
        }

        return comment;

    }

}
