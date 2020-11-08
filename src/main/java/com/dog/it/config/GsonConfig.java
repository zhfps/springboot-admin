package com.dog.it.config;
import com.google.gson.GsonBuilder;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.stereotype.Component;
@Component
public class GsonConfig implements GsonBuilderCustomizer {
    @Override
    public void customize(GsonBuilder gsonBuilder) {
        //设置项
        gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        gsonBuilder.serializeNulls();
    }
}
