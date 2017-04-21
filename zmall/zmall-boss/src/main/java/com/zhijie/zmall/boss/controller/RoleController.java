/**
 * 文件名称: RoleController
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/4/2 22:20
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.boss.controller;

import com.zhijie.zmall.admin.qo.RoleQO;
import com.zhijie.zmall.admin.service.RoleService;
import com.zhijie.zmall.admin.vo.RoleVO;
import com.zhijie.zmall.commons.constants.Constants;
import com.zhijie.zmall.commons.pojo.ZmallResult;
import com.zhijie.zmall.commons.util.CookieUtils;
import com.zhijie.zmall.commons.util.JsonUtils;
import com.zhijie.zmall.commons.util.PageUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author sangaizhi
 * @version 1.0
 * @name RoleController
 * @date 2017/4/2  22:20
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    private Logger logger = LoggerFactory.getLogger(RoleController.class);


    @RequestMapping("/add")
    public String add(){
        return "add-role";
    }

    @RequestMapping("/check")
    @ResponseBody
    public Boolean check(String name){
        if(StringUtils.isBlank(name)){
            return  false;
        }
        RoleQO roleQO = new RoleQO();
        roleQO.setName(name);
        List<RoleVO> list = roleService.queryList(roleQO);
        return CollectionUtils.isEmpty(list);
    }


    @RequestMapping("/addSubmit")
    @ResponseBody
    public ZmallResult addSubmit(RoleVO roleVO, HttpServletRequest request) {
        if (null == roleVO) {
            return ZmallResult.build(500, "新增角色失败");
        }
        try {
            String token = CookieUtils.getCookieValue(request, "");

            roleVO.setCreateTime(new Date());
            roleService.save(roleVO);
            return ZmallResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(Constants.LOG_EXCEPTION_MODEL, "新增角色异常", JsonUtils.objectToJson(roleVO));
            return ZmallResult.build(500, "新增角色失败");
        }
    }

    @RequestMapping("/list")
    public String list(RoleQO condition, PageUtil page, HttpServletRequest request, Model model) {
        if(null == condition){
            condition = new RoleQO();
        }
        if(null == page){
            page = new PageUtil();
        }
        condition.setStartPosition(page.getStartPosition());
        condition.setPageSize(page.getPageSize());
        List<RoleVO> list = roleService.queryDetailPage(condition);
        Long count = roleService.count(condition);
        condition.setRecordCount(count);
        page.setRecordCount(count);
        model.addAttribute("list", list);
        model.addAttribute("page", page);
        model.addAttribute("condition", condition);
        return "list-role";
    }
}
