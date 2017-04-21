package com.zhijie.zmall.admin.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.zhijie.zmall.admin.qo.RightQO;
import com.zhijie.zmall.admin.vo.RightVO;

/**
 * @Description: RightDao
 * @author: sangaizhi
 * @date: 2017-01-10 23:16:18
 */
@Repository
public interface RightDao {
    /**
     * 根据Id查询对象信息。单表查询，无连表操作
     * @param id 对象Id
     * @return RightVO 对象信息
     * @author: sangaizhi
     * @date: 2017-01-10 23:16:18
     */
    RightVO getById(Long id);

    /**
     * 根据条件查询对象信息。单表查询，无连表操作
     * @param qo RightQO查询对象
     * @return RightVO 对象信息
     * @author: sangaizhi
     * @date: 2017-01-10 23:16:18
     */
    RightVO getByCondition(RightQO qo);
    
    /**
     * 根据条件统计。单表查询，无连表操作
     * @param qo RightQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-01-10 23:16:18
     */
    long count(RightQO qo);

    /**
     * 根据条件查询对象列表。单表查询，无连表操作
     * 
     * @param qo RightQO查询对象
     * @return List<RightVO> RightVO对象列表
     * @author: sangaizhi
     * @date: 2017-01-10 23:16:18
     */
    List<RightVO> queryList(RightQO qo);
    
    /**
     * 根据条件分页查询对象列表。单表查询，无连表操作
     * 
     * @param qo RightQO查询对象
     * @return List<RightVO> RightVO对象列表
     * @author: sangaizhi
     * @date: 2017-01-10 23:16:18
     */
    List<RightVO> queryPage(RightQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo RightVO对象信息
     * @return int 保存成功的记录条数
     * @author: sangaizhi
     * @date: 2017-01-10 23:16:18
     */
    int save(RightVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList RightVO对象列表
     * @return int 保存成功的记录条数
     * @author: sangaizhi
     * @date: 2017-01-10 23:16:18
     */
    int saveBatch(List<RightVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo RightVO对象
     * @return int 修改成功的记录条数
     * @author: sangaizhi
     * @date: 2017-01-10 23:16:18
     */
    int updateById(RightVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id RightVO对象Id
     * @return int 删除成功的记录条数
     * @author: sangaizhi
     * @date: 2017-01-10 23:16:18
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids RightVO对象Id集合
     * @return int 删除成功的记录条数
     * @author: sangaizhi
     * @date: 2017-01-10 23:16:18
     */
    int deleteBatchByIds(List<Long> ids);
    
    /**
     * 根据Id查询对象信息。多表连表查询
     * @param id 对象Id
     * @return RightVO 对象信息
     * @author: sangaizhi
     * @date: 2017-01-10 23:16:18
     */
    RightVO getDetailById(Long id);

    /**
     * 根据条件查询对象信息。多表连表查询
     * @param qo RightQO查询对象
     * @return RightVO 对象信息
     * @author: sangaizhi
     * @date: 2017-01-10 23:16:18
     */
    RightVO getDetailByCondition(RightQO qo);
    
    /**
     * 根据条件查询对象列表。多表连表查询
     * 
     * @param qo RightQO查询对象
     * @return List<RightVO> RightVO对象列表
     * @author: sangaizhi
     * @date: 2017-01-10 23:16:18
     */
    List<RightVO> queryDetailList(RightQO qo);
    
    /**
     * 根据条件统计。多表连表查询
     * @param qo RightQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-01-10 23:16:18
     */
    long countDetail(RightQO qo);
    
    /**
     * 根据条件分页查询对象列表。多表连表查询
     * 
     * @param qo RightQO查询对象
     * @return List<RightVO> RightVO对象列表
     * @author: sangaizhi
     * @date: 2017-01-10 23:16:18
     */
    List<RightVO> queryDetailPage(RightQO qo);
}
