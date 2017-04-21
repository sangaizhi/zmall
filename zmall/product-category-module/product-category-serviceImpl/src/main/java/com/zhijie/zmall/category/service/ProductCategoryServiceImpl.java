package com.zhijie.zmall.category.service;

import java.util.Date;
import java.util.List;

import com.zhijie.zmall.commons.constants.EnableDisableEnum;
import com.zhijie.zmall.commons.constants.IsParentEnum;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zhijie.zmall.category.qo.ProductCategoryQO;
import com.zhijie.zmall.category.vo.ProductCategoryVO;
import com.zhijie.zmall.category.dao.ProductCategoryDao;

/**
 * @Description: ProductCategoryService 实现类
 * @author: sangaizhi
 * @date: 2017-03-22 21:56:59
 */
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    @Transactional(readOnly = true)
    public ProductCategoryVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return productCategoryDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ProductCategoryVO getByCondition(ProductCategoryQO qo) {
        if (qo == null) {
            return null;
        }
        return productCategoryDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductCategoryVO> queryList(ProductCategoryQO qo) {
        if (qo == null) {
            return null;
        }
        return productCategoryDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(ProductCategoryQO qo) {
        if (qo == null) {
            return 0;
        }
        return productCategoryDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<ProductCategoryVO> queryPage(ProductCategoryQO qo) {
        if (qo == null) {
            return null;
        }
        return productCategoryDao.queryPage(qo); 
    }

    @Override
    public int save(ProductCategoryVO vo) {
        if (vo == null) {
            return 0;
        }
        ProductCategoryQO qo = new ProductCategoryQO();
        qo.setParentId(vo.getParentId());
        long count = this.count(qo);
        vo.setState(EnableDisableEnum.ENABLE.getValue());
        vo.setBoolParent(IsParentEnum.NO.getValue());
        vo.setSort((short)((Long.valueOf(count).intValue()+1)));
        vo.setCreateTime(new Date());
        vo.setEditTime(new Date());
        return productCategoryDao.save(vo);
    }

    @Override
    public int saveBatch(List<ProductCategoryVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return 0;
        }
        return productCategoryDao.saveBatch(voList);
    }

    @Override
    public int updateById(ProductCategoryVO vo) {
        if (vo == null) {
            return 0;
        }
        return productCategoryDao.updateById(vo);
    }

    @Override
    public int deleteById(Long id) {
        if (id == null) {
            return 0;
        }
        ProductCategoryQO qo = new ProductCategoryQO();
        qo.setParentId(id);
        List<ProductCategoryVO> list = productCategoryDao.queryList(qo);
        if(CollectionUtils.isNotEmpty(list)){
            for(ProductCategoryVO vo : list){
                productCategoryDao.deleteById(vo.getId());
            }
        }
        return productCategoryDao.deleteById(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return productCategoryDao.deleteBatchByIds(ids);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ProductCategoryVO getDetailById(Long id) {
        if (id == null) {
            return null;
        }
        return productCategoryDao.getDetailById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ProductCategoryVO getDetailByCondition(ProductCategoryQO qo) {
        if (qo == null) {
            return null;
        }
        return productCategoryDao.getDetailByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductCategoryVO> queryDetailList(ProductCategoryQO qo) {
        if (qo == null) {
            return null;
        }
        return productCategoryDao.queryDetailList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long countDetail(ProductCategoryQO qo) {
        if (qo == null) {
            return 0;
        }
        return productCategoryDao.countDetail(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<ProductCategoryVO> queryDetailPage(ProductCategoryQO qo) {
        if (qo == null) {
            return null;
        }
        return productCategoryDao.queryDetailPage(qo); 
    }
}
