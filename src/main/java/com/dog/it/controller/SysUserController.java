package com.dog.it.controller;

import com.dog.it.entity.LoginUser;
import com.dog.it.entity.SysUser;
import com.dog.it.service.SysUserService;
import com.dog.it.until.RequestResponse;
import com.dog.it.until.RequestResponseBuilder;
import com.dog.it.until.RequestResponseCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Api(tags = "用户相关接口")
@RestController
@RequestMapping("/api/user")
public class SysUserController {

    @Resource
    private AuthenticationManager authenticationManager;
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "获取用户")
    @GetMapping("/get/{id}")
    public RequestResponse<SysUser> getSysUserById(@PathVariable("id") int id) {
        RequestResponse<SysUser> result = RequestResponseBuilder.success(this.sysUserService.queryById(id), RequestResponseCode.SUCCESS);
        return result;
    }

    @ApiOperation(value = "获取用户权限")
    @GetMapping("/getPermissions/{id}")
    public RequestResponse<List<String>> getUserPermissions(@PathVariable("id") int id) {
        RequestResponse<List<String>> result = RequestResponseBuilder.success(this.sysUserService.getUserPermissions(id), RequestResponseCode.SUCCESS);
        return result;
    }

    @ApiOperation(value ="登录" )
    @PostMapping(value = "/api/login")
    @ResponseBody
    public RequestResponse<Authentication> login(
            @RequestParam(name = "userName",required = true)String userName,
            @RequestParam(name = "password",required = true)String password,
           HttpServletRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, password)
        );

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);


        return RequestResponseBuilder.success(authentication, RequestResponseCode.SUCCESS);
    }

    @ApiOperation(value ="获取当前用户信息" )
    @GetMapping(value = "/api/info")
    @ResponseBody
    public RequestResponse<Authentication> Info(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return RequestResponseBuilder.success(authentication, RequestResponseCode.SUCCESS);
    }
}