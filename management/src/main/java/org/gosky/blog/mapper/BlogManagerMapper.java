package org.gosky.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.gosky.blog.bean.ContentBean;
import org.springframework.stereotype.Repository;

/**
 * Created by guo on 2018/10/17.
 * desc:
 */
@Mapper
@Repository
public interface BlogManagerMapper {

    public int postBlog(ContentBean contentBean);
}
