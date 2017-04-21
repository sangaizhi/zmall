package com.zhijie.zmall.boss.controller;/**
 * 文件名称: ProductCategoryCtr
 * 系统名称: zmall
 * 模块名称:
 * 软件版权: 深圳中云创科技有限公司
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/3/22 23:22
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */

import com.zhijie.zmall.category.qo.ProductCategoryQO;
import com.zhijie.zmall.category.service.ProductCategoryService;
import com.zhijie.zmall.category.vo.ProductCategoryVO;
import com.zhijie.zmall.commons.constants.Constants;
import com.zhijie.zmall.commons.exception.BusinessRuntimeException;
import com.zhijie.zmall.commons.pojo.ZmallResult;
import com.zhijie.zmall.commons.util.ExceptionUtil;
import com.zhijie.zmall.commons.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Name ProductCategoryCtr
 * @Author sangaizhi
 * @Date 2017/3/22  23:22
 * @Version 1.0
 */
@Controller
@RequestMapping("/category")
public class ProductCategoryCtr {

    private Logger logger = LoggerFactory.getLogger(ProductCategoryCtr.class);

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("/dubbo")
    @ResponseBody
    public Object testDubbo() {

        ProductCategoryQO qo = new ProductCategoryQO();
        List<ProductCategoryVO> list = productCategoryService.queryList(qo);
        return list.size();
    }

    @RequestMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public Object getCategoryList(Long parentId, String callback) {
        ProductCategoryQO qo = new ProductCategoryQO();
        qo.setParentId(parentId);
        List<ProductCategoryVO> list = productCategoryService.queryList(qo);
        if (StringUtils.isNotBlank(callback)) {
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        }
        return list;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ZmallResult addCategory(ProductCategoryVO category){
        ZmallResult result = null;
        if(null == category){
            return  ZmallResult.build(400, "新增分类失败");
        }
        try{
            productCategoryService.save(category);
            result = ZmallResult.ok();
        }catch (BusinessRuntimeException e){
            e.printStackTrace();
            logger.error(Constants.LOG_INFO_MODEL_ADD,"新增商品分类", JsonUtils.objectToJson(category));
            result = ZmallResult.build(500, e.getErrMsg());
        }catch (Exception e){
            e.printStackTrace();
            logger.error(Constants.LOG_INFO_MODEL_ADD,"新增商品分类", JsonUtils.objectToJson(category));
            result = ZmallResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return result;
    }

    @RequestMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public ZmallResult deleteCategory(@PathVariable Long id) {
        if (null == id) {
            return ZmallResult.build(400, "没有找到相应分类");
        }
        try {
            productCategoryService.deleteById(id);
            return ZmallResult.build(200,"删除成功");
        } catch (BusinessRuntimeException e) {
            e.printStackTrace();
            logger.error(Constants.LOG_EXCEPTION_MODEL_DELETE,"商品分类删除",id);
            return ZmallResult.build(500,e.getErrMsg());
        } catch (Exception e) {
            logger.error(Constants.LOG_EXCEPTION_MODEL_DELETE,"商品分类删除",id);
            return ZmallResult.build(500, ExceptionUtil.getStackTrace(e));
        }

    }


}
