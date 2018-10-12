package org.gosky.blog.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QiniuUploadUtils {

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucket}")
    private String bucket;

    @Value("${qiniu.path}")
    private String path;

    // 上传到华北机房
    private Configuration mCfg = new Configuration(Zone.zone1());

    private UploadManager mUploadManager = new UploadManager(mCfg);

    public void test() {
        System.out.println(accessKey);
        System.out.println(secretKey);
        System.out.println(bucket);
        System.out.println(path);
    }

    public void upload(byte[] file, String fileName) {

        Auth auth = Auth.create(accessKey, secretKey);
        String token = auth.uploadToken(bucket);

        try {

            Response response = mUploadManager.put(file, fileName, token);

            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);

        } catch (QiniuException e) {
            e.printStackTrace();
        }

    }

}
