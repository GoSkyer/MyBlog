package org.gosky.blog.mapper;

import me.galaxy.blog.bean.CommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<CommentDto> getCommentByBlogId(@Param("blogId") int blogId);

    int addComment(CommentDto commentDto);

}
