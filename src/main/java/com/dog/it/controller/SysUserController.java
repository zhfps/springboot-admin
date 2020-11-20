package com.dog.it.controller;

import com.dog.it.entity.SysUser;
import com.dog.it.service.SysUserService;
import com.dog.it.until.RequestResponse;
import com.dog.it.until.RequestResponseBuilder;
import com.dog.it.until.RequestResponseCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class SysUserController {
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
    @GetMapping("/get/{id}")
    public RequestResponse<SysUser> getSysUserById(@PathVariable("id") int id) {
        RequestResponse<SysUser> result = RequestResponseBuilder.success(this.sysUserService.queryById(id), RequestResponseCode.SUCCESS);
        return result;
    }
    @GetMapping("/getPermissions/{id}")
    public RequestResponse<List<String>> getUserPermisions(@PathVariable("id") int id) {
        RequestResponse<List<String>> result = RequestResponseBuilder.success(this.sysUserService.getUserPermissions(id), RequestResponseCode.SUCCESS);
        return result;
    }

}