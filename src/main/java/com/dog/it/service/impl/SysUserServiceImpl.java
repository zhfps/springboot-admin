package com.dog.it.service.impl;

import com.dog.it.dao.SysUserDao;
import com.dog.it.entity.SysUser;
import com.dog.it.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-11-20 20:55:26
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(int id) {
        return this.sysUserDao.queryById(id);
    }

    @Override
    public List<String> getUserPermissions(int id) {
        return this.sysUserDao.getUserPermissions(id);
    }

}