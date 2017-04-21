/**
 * 文件名称: UserServiceTest
 * 系统名称: zmall
 * 模块名称:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/1/7 10:56
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.user.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Name UserServiceTest
 * @Author sangaizhi
 * @Date 2017/1/7  10:56
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml", "classpath:spring.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testQueryList(){
//        UserQO qo = new UserQO();
//        userService.queryList(qo);
    }
}
