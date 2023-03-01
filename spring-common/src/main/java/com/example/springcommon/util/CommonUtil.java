package com.example.springcommon.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author brian
 */
@Slf4j
public class CommonUtil {

    public static String generateUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getTrace(Throwable t) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        return String.valueOf(stringWriter.getBuffer());
    }

    public static String getHostByUrl(String url) {

        URL urlTemp;
        try {
            urlTemp = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Bad request, invalid url");
        }
        return urlTemp.getHost();

    }

    public static String getDefaultStringValue(String originValue, String defaultValue) {
        if (StrUtil.isEmpty(originValue)) {
                return defaultValue;
            }
            return originValue;
    }
    public static <T> T getDefaultObjectValue(T originValue, T defaultValue) {
        if (originValue == null) {
            return defaultValue;
        }
        return originValue;
    }

    public static String[] getNullProperties(Object o1) throws IllegalAccessException {
        Field[] declaredFields = o1.getClass().getDeclaredFields();
        List<String> nullProperties = new ArrayList<>();
        for (Field declaredField : declaredFields) {
            //设置可以对private属性的对象进行访问
            declaredField.setAccessible(true);
            if (declaredField.get(o1) == null) {
                // 将为空的属性添加到list中
                nullProperties.add(declaredField.getName());
            }
        }
        return nullProperties.toArray(new String[0]);
    }

}
