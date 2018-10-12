package org.gosky.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.gosky.blog.bean.CommentDto;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<CommentDto> getCommentByBlogId(@Param("blogId") int blogId);

    int addComment(CommentDto commentDto);

}
