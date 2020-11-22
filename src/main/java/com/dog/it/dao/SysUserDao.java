package com.dog.it.dao;

import com.dog.it.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-20 20:55:26
 */
@Mapper
public interface SysUserDao {

    SysUser queryById(int id);

    SysUser queryByName(String UserName);

    List<String> getUserPermissions(int id);

}