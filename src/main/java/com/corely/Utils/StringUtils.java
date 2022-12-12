package com.corely.Utils;

import org.springframework.util.DigestUtils;

public class StringUtils {
    public static String myMd5(String s){
        return DigestUtils.md5DigestAsHex(s.getBytes());
    }
}
