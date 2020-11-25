package com.dog.it.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LoginUser implements UserDetails {

    public LoginUser() {
    }
    private int Id;

    private String UserName;

    private String NickName;

    private String Password;

    private String Token;

    private List<String> Permissions;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return Permissions.parallelStream().filter(p -> !StringUtils.isEmpty(p))
                .map(p -> new SimpleGrantedAuthority(p)).collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public String getUsername() {
        return UserName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public List<String> getPermissions() {
        return Permissions;
    }

    public void setPermissions(List<String> permissions) {
        Permissions = permissions;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
