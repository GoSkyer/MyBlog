package org.gosky.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AboutMapper {

    int addContact(@Param("name") String name,
                   @Param("email") String email,
                   @Param("title") String title,
                   @Param("content") String content);

}
