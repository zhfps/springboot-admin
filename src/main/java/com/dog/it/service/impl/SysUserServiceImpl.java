package com.dog.it.service.impl;

import com.dog.it.dao.SysUserDao;
import com.dog.it.entity.LoginUser;
import com.dog.it.entity.SysUser;
import com.dog.it.service.SysUserService;
import com.dog.it.until.JwtUntil;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-11-20 20:55:26
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService, UserDetailsService {
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
    public SysUser queryByName(String UserName) {
        return this.sysUserDao.queryByName(UserName);
    }

    @Override
    public List<String> getUserPermissions(int id) {
        return this.sysUserDao.getUserPermissions(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = this.sysUserDao.queryByName(username);

        LoginUser loginUser = new LoginUser();

        loginUser.setPermissions(this.sysUserDao.getUserPermissions(user.getId()));

        loginUser.setToken(JwtUntil.issue(user.getUserName(),user.getId()));

        BeanUtils.copyProperties(user, loginUser);

        return loginUser;
    }
}