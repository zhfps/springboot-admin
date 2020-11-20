package com.dog.it.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class SysUser implements Serializable {
    private static final long serialVersionUID = -78722816892016393L;

    private int Id;

    private String UserName;

    private String NickName;

    private String Password;

}