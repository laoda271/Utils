import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by chenminghe on 2017/6/16.
 */
public class HttpClientTest {

    @Test
    public void test_ADJUST_POSISTION() throws Exception {

        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://10.13.16.153/signal");
        post.addHeader("Content-Type","application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sceneId","1");
        jsonObject.put("requestId","11");
        jsonObject.put("type","PROFILE_USERS");
        jsonObject.put("action","set");
        JSONObject dataJSON = new JSONObject();

//        String path = "d:/u1.png";
        String path = "d:/u2.jpg";
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        // base64的常量串太长,通过文件进行读取
        String image = new BASE64Encoder().encode(buffer);
        dataJSON.put("code","1144");
        dataJSON.put("message","AA");
        dataJSON.put("image",image);
        dataJSON.put("count","1");
        jsonObject.put("data",dataJSON);

        StringEntity stringEntity = new StringEntity(jsonObject.toString(),"UTF-8");
        post.setEntity(stringEntity);
        CloseableHttpResponse response = client.execute(post);

        System.out.println(response.getStatusLine().getStatusCode());
    }
}
