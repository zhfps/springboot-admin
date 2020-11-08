package com.dog.it;

import com.dog.it.entity.User;
import com.google.gson.Gson;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SpringbootAdminApplicationTests {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    @Autowired
    private Gson gson;

    /**
     * 创建Index
     * @throws IOException
     */
    @Test
    void CreateIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("it_dog_zhang");
        CreateIndexResponse res = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(res);
    }

    /**
     * 判定Index是否存在
     * @throws IOException
     */
    @Test
    void GetIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("it_dog_zhang");

        boolean exists = client.indices().exists(request,RequestOptions.DEFAULT);

        System.out.println(exists);
    }

    /**
     * 删除index
     * @throws IOException
     */
    @Test
    void DeleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("it_dog_zhang");
        AcknowledgedResponse res = client.indices().delete(request,RequestOptions.DEFAULT);
        System.out.println(res);
    }

    /**
     * Gson测试
     */
    @Test
    void GsonTest(){
       User user= new User("zhang",12);
       String json = gson.toJson(user);
        System.out.println(json);
    }

    @Test
    void contextLoads() {
    }

}
