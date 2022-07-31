package com.negen.utils;

import com.negen.entity.User;
import io.jsonwebtoken.*;
import org.apache.shiro.authc.AuthenticationException;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.UUID;

/**
 * @author ：Negen
 * @date ：2022/7/31 16:50
 * @description：
 */
public class TokenUtil {
    private static final String SigningKey = "springboot-shiro-tutorial-springboot-shiro-tutorial-springboot-shiro-tutorial";
//    private static final String SigningKey = "imcode";

    private static final long EXPIRE_TIME = 1000 * 3600 * 24 * 10;

    /**
     * 生成token
     * @param user
     * @return
     */
    public static String  create(User user) {
        //Jwts.builder()生成
        //Jwts.parser()验证
        JwtBuilder jwtBuilder =  Jwts.builder()
                .setId(user.getId()+"")
                .setSubject(user.getUsername())    //用户名
                .setIssuedAt(new Date())//登录时间
                .signWith(SignatureAlgorithm.HS256, SigningKey).setExpiration(new Date(new
                        Date().getTime()+EXPIRE_TIME));
        //设置过期时间
        //前三个为载荷playload 最后一个为头部 header
        System.out.println(jwtBuilder.compact());
        return  jwtBuilder.compact();
    }

    /**
     * 验证token
     * @param token
     */
    public static Claims verify(String token){
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(SigningKey))
                    .parseClaimsJws(token)
                    .getBody();
        }catch (ExpiredJwtException e){
            throw new AuthenticationException("token 过期"+e.getMessage());
        }catch (UnsupportedJwtException e){
            throw new AuthenticationException("token 无效"+e.getMessage());
        }catch (MalformedJwtException e){
            throw new AuthenticationException("token 格式错误"+e.getMessage());
        }catch (SignatureException e){
            throw new AuthenticationException("token 签名无效"+e.getMessage());
        }catch (IllegalArgumentException e){
            throw new AuthenticationException("token 参数异常"+e.getMessage());
        }catch (Exception e){
            throw new AuthenticationException("token 令牌错误"+e.getMessage());
        }
        return claims;
    }

    public static String sign(String username) {
        JwtBuilder jwt = Jwts.builder();
        //设置token唯一标识
        jwt.setId(UUID.randomUUID().toString());
        //设置主题
        jwt.setSubject(username);
        //设置签发者
        jwt.setIssuer(SigningKey);
        //设置签发日期
        jwt.setIssuedAt(new Date());
        //设置过期时间
        jwt.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME));
        //私钥
        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SigningKey);
        //签名
        jwt.signWith(SignatureAlgorithm.HS256,secretKeyBytes);
        return jwt.compact();
    }

}
