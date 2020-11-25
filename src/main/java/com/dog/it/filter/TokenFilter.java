package com.dog.it.filter;

import com.auth0.jwt.JWT;
import com.dog.it.entity.LoginUser;
import com.dog.it.until.JwtUntil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component("tokenFilter")
public class TokenFilter extends OncePerRequestFilter {

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            parsingToken(request);
        }catch (Exception e) {
            // 2. 捕获步骤1中校验出现异常，交给失败处理类进行进行处理
            filterChain.doFilter(request, response);
            return;
        }
        // 3. 校验通过，就放行
        filterChain.doFilter(request, response);
    }

    private void parsingToken(HttpServletRequest request) throws Exception {
        // 1. 获取请求中的Token
        String token = request.getHeader("token");
        // 2. 校验空值情况
        if(StringUtils.isEmpty(token)) {
            throw new Exception("not token");
        }
        // 5. token 解析
        try {

            String userName = JwtUntil.getUserName(token);
            Date date = JwtUntil.getExpireDate(token);
            Date now = new Date(System.currentTimeMillis());
            long expire = (date.getTime() - now.getTime())/(1000 * 60);
            if(expire<=3 && expire>0 && SecurityContextHolder.getContext().getAuthentication() != null){
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                LoginUser loginUser = (LoginUser) authentication.getDetails();
                loginUser.setToken(JwtUntil.issue(loginUser.getNickName(),loginUser.getId()));
                UsernamePasswordAuthenticationToken n_authentication = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(n_authentication);
            } else if(!StringUtils.isEmpty(userName) && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
                LoginUser loginUser = (LoginUser)userDetails;
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginUser, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
