package com.zhijie.zmall.admin;/**
 * 文件名称: RoleServiceTest
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/4/9 13:07
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */

import com.zhijie.zmall.admin.qo.RoleQO;
import com.zhijie.zmall.admin.service.RoleService;
import com.zhijie.zmall.admin.vo.RoleVO;
import com.zhijie.zmall.commons.util.PageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author sangaizhi
 * @version 1.0
 * @name RoleServiceTest
 * @date 2017/4/9  13:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testQueryDetailPage(){
        System.out.println(roleService);
        RoleQO condition = new RoleQO();
        PageUtil pageUtil = new PageUtil();
        condition.setStartPosition(pageUtil.getStartPosition());
        condition.setPageSize(pageUtil.getPageSize());
        List<RoleVO> list = roleService.queryDetailPage(condition);
        for(RoleVO temp : list){
            if(null != temp && null != temp.getCreateUser()){
                System.out.print(temp.getCreateUser().getName());
            }
            if(null != temp && null != temp.getModifyUser()){
                System.out.print(temp.getModifyUser().getName());
            }
            System.out.println("");
        }
        Long count = roleService.count(condition);
        condition.setRecordCount(count);
    }
}
