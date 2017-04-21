package com.zhijie.zmall.category.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.zhijie.zmall.category.qo.ProductCategoryQO;
import com.zhijie.zmall.category.vo.ProductCategoryVO;

/**
 * @Description: ProductCategoryDao
 * @author: sangaizhi
 * @date: 2017-03-22 21:56:59
 */
@Repository
public interface ProductCategoryDao {
    /**
     * 根据Id查询对象信息。单表查询，无连表操作
     * @param id 对象Id
     * @return ProductCategoryVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-22 21:56:59
     */
    ProductCategoryVO getById(Long id);

    /**
     * 根据条件查询对象信息。单表查询，无连表操作
     * @param qo ProductCategoryQO查询对象
     * @return ProductCategoryVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-22 21:56:59
     */
    ProductCategoryVO getByCondition(ProductCategoryQO qo);
    
    /**
     * 根据条件统计。单表查询，无连表操作
     * @param qo ProductCategoryQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-03-22 21:56:59
     */
    long count(ProductCategoryQO qo);

    /**
     * 根据条件查询对象列表。单表查询，无连表操作
     * 
     * @param qo ProductCategoryQO查询对象
     * @return List<ProductCategoryVO> ProductCategoryVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-22 21:56:59
     */
    List<ProductCategoryVO> queryList(ProductCategoryQO qo);
    
    /**
     * 根据条件分页查询对象列表。单表查询，无连表操作
     * 
     * @param qo ProductCategoryQO查询对象
     * @return List<ProductCategoryVO> ProductCategoryVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-22 21:56:59
     */
    List<ProductCategoryVO> queryPage(ProductCategoryQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo ProductCategoryVO对象信息
     * @return int 保存成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-22 21:56:59
     */
    int save(ProductCategoryVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList ProductCategoryVO对象列表
     * @return int 保存成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-22 21:56:59
     */
    int saveBatch(List<ProductCategoryVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo ProductCategoryVO对象
     * @return int 修改成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-22 21:56:59
     */
    int updateById(ProductCategoryVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id ProductCategoryVO对象Id
     * @return int 删除成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-22 21:56:59
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids ProductCategoryVO对象Id集合
     * @return int 删除成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-22 21:56:59
     */
    int deleteBatchByIds(List<Long> ids);
    
    /**
     * 根据Id查询对象信息。多表连表查询
     * @param id 对象Id
     * @return ProductCategoryVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-22 21:56:59
     */
    ProductCategoryVO getDetailById(Long id);

    /**
     * 根据条件查询对象信息。多表连表查询
     * @param qo ProductCategoryQO查询对象
     * @return ProductCategoryVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-22 21:56:59
     */
    ProductCategoryVO getDetailByCondition(ProductCategoryQO qo);
    
    /**
     * 根据条件查询对象列表。多表连表查询
     * 
     * @param qo ProductCategoryQO查询对象
     * @return List<ProductCategoryVO> ProductCategoryVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-22 21:56:59
     */
    List<ProductCategoryVO> queryDetailList(ProductCategoryQO qo);
    
    /**
     * 根据条件统计。多表连表查询
     * @param qo ProductCategoryQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-03-22 21:56:59
     */
    long countDetail(ProductCategoryQO qo);
    
    /**
     * 根据条件分页查询对象列表。多表连表查询
     * 
     * @param qo ProductCategoryQO查询对象
     * @return List<ProductCategoryVO> ProductCategoryVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-22 21:56:59
     */
    List<ProductCategoryVO> queryDetailPage(ProductCategoryQO qo);
}
