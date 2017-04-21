package com.zhijie.zmall.admin.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.zhijie.zmall.admin.qo.RoleQO;
import com.zhijie.zmall.admin.vo.RoleVO;

/**
 * @Description: RoleDao
 * @author: sangaizhi
 * @date: 2017-03-31 21:35:22
 */
@Repository
public interface RoleDao {
    /**
     * 根据Id查询对象信息。单表查询，无连表操作
     * @param id 对象Id
     * @return RoleVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-31 21:35:22
     */
    RoleVO getById(Long id);

    /**
     * 根据条件查询对象信息。单表查询，无连表操作
     * @param qo RoleQO查询对象
     * @return RoleVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-31 21:35:22
     */
    RoleVO getByCondition(RoleQO qo);
    
    /**
     * 根据条件统计。单表查询，无连表操作
     * @param qo RoleQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-03-31 21:35:22
     */
    long count(RoleQO qo);

    /**
     * 根据条件查询对象列表。单表查询，无连表操作
     * 
     * @param qo RoleQO查询对象
     * @return List<RoleVO> RoleVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-31 21:35:22
     */
    List<RoleVO> queryList(RoleQO qo);
    
    /**
     * 根据条件分页查询对象列表。单表查询，无连表操作
     * 
     * @param qo RoleQO查询对象
     * @return List<RoleVO> RoleVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-31 21:35:22
     */
    List<RoleVO> queryPage(RoleQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo RoleVO对象信息
     * @return int 保存成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-31 21:35:22
     */
    int save(RoleVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList RoleVO对象列表
     * @return int 保存成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-31 21:35:22
     */
    int saveBatch(List<RoleVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo RoleVO对象
     * @return int 修改成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-31 21:35:22
     */
    int updateById(RoleVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id RoleVO对象Id
     * @return int 删除成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-31 21:35:22
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids RoleVO对象Id集合
     * @return int 删除成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-31 21:35:22
     */
    int deleteBatchByIds(List<Long> ids);
    
    /**
     * 根据Id查询对象信息。多表连表查询
     * @param id 对象Id
     * @return RoleVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-31 21:35:22
     */
    RoleVO getDetailById(Long id);

    /**
     * 根据条件查询对象信息。多表连表查询
     * @param qo RoleQO查询对象
     * @return RoleVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-31 21:35:22
     */
    RoleVO getDetailByCondition(RoleQO qo);
    
    /**
     * 根据条件查询对象列表。多表连表查询
     * 
     * @param qo RoleQO查询对象
     * @return List<RoleVO> RoleVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-31 21:35:22
     */
    List<RoleVO> queryDetailList(RoleQO qo);
    
    /**
     * 根据条件统计。多表连表查询
     * @param qo RoleQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-03-31 21:35:22
     */
    long countDetail(RoleQO qo);
    
    /**
     * 根据条件分页查询对象列表。多表连表查询
     * 
     * @param qo RoleQO查询对象
     * @return List<RoleVO> RoleVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-31 21:35:22
     */
    List<RoleVO> queryDetailPage(RoleQO qo);
}
