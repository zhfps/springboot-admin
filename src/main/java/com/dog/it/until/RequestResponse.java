package com.dog.it.until;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RequestResponse<T> {
    private int code;
    private String msg;
    private T data;// 数据
    private String error;//错误详情
}
