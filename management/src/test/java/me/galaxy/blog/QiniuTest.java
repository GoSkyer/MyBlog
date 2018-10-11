package me.galaxy.blog;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import me.galaxy.blog.utils.QiniuUploadUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManagementApplication.class)
public class QiniuTest {

    @Test
    public void test(){
        QiniuUploadUtils utils = new QiniuUploadUtils();
        utils.test();
    }

}
