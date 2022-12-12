package com.corely;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

public class test1 {
    @Test
    public void test11(){
        String str = "ABCDE";
        //方式二
        for(int i = str.length() - 1; i >= 0; i--){
            str += str.charAt(i);
        }
        System.out.println(str.substring(str.length()/2, str.length()));
        System.out.println(str);
    }
    //测试日期转换工具
//    @Test
//    public void test2() throws ParseException {
//        System.out.println(DateUtils.parseDate(new Date()));
//
//    }
}
