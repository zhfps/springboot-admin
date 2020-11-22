package com.dog.it.service;

import com.dog.it.entity.SysUser;

import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-11-20 20:55:26
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(int id);

    SysUser queryByName(String UserName);

    List<String> getUserPermissions(int id);

}