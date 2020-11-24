package com.dog.it.until;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;

public class JwtUntil {

    /**
     * 15分钟过期
     */
    private static final long EXPIRE_TIME =15*60*1000;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "it.dog_ps";

    /**
     * 签发token
     * @param userName
     * @param userId
     * @return
     */
    public static String issue(String userName,int userId){

        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Date now = new Date(System.currentTimeMillis());
        //私钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        //附带username和userID生成签名
        return JWT.create()
                .withHeader(header)
                .withIssuedAt(now)
                .withIssuer("zhfps")
                .withClaim("userName",userName)
                .withClaim("userId",userId)
                .withExpiresAt(date)
                .sign(algorithm);

    }

    /**
     * 解密
     * @param token
     * @return
     */
    public static String getUserName(String token)throws JWTVerificationException,Exception{
        Algorithm algorithm = Algorithm.HMAC256("it.dog_ps");
        JWTVerifier build = JWT.require(algorithm).withIssuer("zhfps").build();
        try {
            DecodedJWT decode = build.verify(token);
            String userName =decode.getClaim("userName").asString();
            return userName;
        }catch (JWTVerificationException e){
            throw e;
        }
        catch (Exception e){
           throw e;
        }

    }
    /**
     * 解密
     * @param token
     * @return
     */
    public static int getUserId(String token)throws Exception{
        Algorithm algorithm = Algorithm.HMAC256("it.dog_ps");
        JWTVerifier build = JWT.require(algorithm).withIssuer("zhfps").build();
        try {
            DecodedJWT decode = build.verify(token);
            int userId =decode.getClaim("userId").asInt();
            return userId;
        }catch (JWTVerificationException e){
            throw e;
        }
        catch (Exception e){
           throw e;
        }

    }

    /**
     * 过期时间
     * @param token
     * @return
     */
    public static Date getExpireDate(String token){
        Algorithm algorithm = Algorithm.HMAC256("it.dog_ps");
        JWTVerifier build = JWT.require(algorithm).withIssuer("zhfps").build();
        try {
            DecodedJWT decode = build.verify(token);
            Date expiresAt = decode.getExpiresAt();
            return expiresAt;
        }catch (JWTVerificationException e){
            throw e;
        }
        catch (Exception e){
            throw e;
        }
    }
}
