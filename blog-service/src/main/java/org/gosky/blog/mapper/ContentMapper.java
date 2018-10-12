package org.gosky.blog.mapper;

import me.galaxy.blog.bean.ContentBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ContentMapper {

    List<ContentBean> page();

    List<ContentBean> pageByGroup(@Param("groupId") Integer groupId);

    List<ContentBean> getById(@Param("id") Integer id);

    List<ContentBean> getByNewOrder();

    List<Map<String, String>> getByGroup();

    int addContent(ContentBean contentBean);

    int updateCommentCount(@Param("id") Integer id, @Param("num") Integer num);

    int updateReadCount(@Param("id") Integer id, @Param("num") Integer num);

}
