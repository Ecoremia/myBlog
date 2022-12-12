package com.corely;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.corely.entity.Type;
import com.corely.service.BlogService;
import com.corely.service.TypeService;
import com.corely.vo.BlogQuery;
import com.corely.vo.BlogSearch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.List;

@SpringBootTest
class MyblogApplicationTests {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;
    //测试md5加密
    @Test
    public void testMD5(){
        String s = DigestUtils.md5DigestAsHex("corely".getBytes());
        System.out.println(s);
    }
    //测试type类的简单page分页查询插件
    @Test
    public void testSelectTypeByPage(){
        Page<Type> page = new Page<>();
        page.setSize(3);
        page.setCurrent(1);
        Page<Type> iPage = typeService.getPage(page);
        System.out.println("是否有下一页"+iPage.hasNext());
        System.out.println("是否有上一页"+iPage.hasPrevious());
        System.out.println("记录为"+iPage.getRecords());
        System.out.println("当前页数为"+iPage.getCurrent());
        System.out.println("总页数为"+iPage.getPages());
        System.out.println("大小为"+iPage.getSize());
        System.out.println("为"+iPage.getTotal());
    }
    //测试自定义的blog分页查询
    //测试type类的简单page分页查询插件
    @Test
    public void testSelectBlogQueryByPage(){
        Page<BlogSearch> page = new Page<>();
        page.setSize(3);
        page.setCurrent(1);
        BlogSearch blogSearch = new BlogSearch();
        Page<BlogQuery> iPage = blogService.getBlogList(page, blogSearch);
        System.out.println("是否有下一页"+iPage.hasNext());
        System.out.println("是否有上一页"+iPage.hasPrevious());
        System.out.println("记录为"+iPage.getRecords());
        System.out.println("当前页数为"+iPage.getCurrent());
        System.out.println("总页数为"+iPage.getPages());
        System.out.println("大小为"+iPage.getSize());
        System.out.println("为"+iPage.getTotal());
    }
}
