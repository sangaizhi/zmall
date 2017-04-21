package com.zhijie.zmall.commons.util;/**
 * 文件名称: PageUtil
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/4/5 23:34
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */

/**
 * 分页参数工具
 * @name PageUtil
 * @author sangaizhi
 * @date 2017/4/5  23:34
 * @version 1.0
 */
public class PageUtil {
    private static final long serialVersionUID = -3388904422054043326L;

    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 每页记录条数
     */
    private Integer pageSize = 10;

    /**
     * 分页的起始位置
     */
    private Integer startPosition = 0;

    /**
     * 分页总大小
     */
    private Integer pageCount;

    /**
     * 总记录条数
     */
    private Long recordCount = 0L;

    public PageUtil(){}

    public  PageUtil(Integer pageNum, Integer pageSize){
        this.setPageNum(pageNum);
        this.setPageSize(pageSize);
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if(null == pageNum){
            pageNum = 1;
        }
        if (pageNum > 10000 || pageNum < 1) {
            pageNum = 1;
        }
        this.pageNum = pageNum;
        this.startPosition = (pageNum - 1) * pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if(null == pageSize){
            pageSize = 10;
        }
        if (pageSize > 10000 || pageSize < 1) {
            pageSize = 10000;
        }
        this.pageSize = pageSize;
        this.startPosition = (pageNum - 1) * pageSize;
    }

    public Integer getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Integer startPosition) {
        this.startPosition = startPosition;
    }

    public Integer getPageCount() {
        if (pageSize == 0 || recordCount == 0) {
            return 0;
        }
        this.pageCount = (int)Math.ceil(recordCount / (float)pageSize);
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }
}
