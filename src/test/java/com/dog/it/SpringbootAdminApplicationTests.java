package com.dog.it;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootAdminApplicationTests {

    @Autowired
    private Gson gson;



    @Test
    void Test(){
        com.dog.it.test.Test test1 = new com.dog.it.test.Test("A");
        com.dog.it.test.Test test2 = new com.dog.it.test.Test("A");
        System.out.println(test1.equals(test2));
    }


    @Test
    void contextLoads() {
    }

}
