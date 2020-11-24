package com.dog.it;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dog.it.until.JwtUntil;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//
//        String encoder =  bCryptPasswordEncoder.encode("123456");
//
//        System.out.println(encoder);

        //String token = JwtUntil.issue("Admin",1);
       // System.out.println(token);
        //Algorithm algorithm = Algorithm.HMAC256("it.dog_ps");
       ///JWTVerifier build = JWT.require(algorithm).withIssuer("zhfps").build();
        String userName = null;
        try {
            userName = JwtUntil.getUserName("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ6aGZwcyIsInVzZXJOYW1lIjoiQWRtaW4iLCJleHAiOjE2MDYxNDE2MDIsImlhdCI6MTYwNjE0MTYwMSwidXNlcklkIjoxfQ.FIl2Frr5rF3tFTQ9ZQCW27RUp2BpFgxhNq05mX_VmEQ");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(userName);



    }

}
