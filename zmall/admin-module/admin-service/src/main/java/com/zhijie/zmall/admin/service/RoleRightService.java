package com.zhijie.zmall.admin.service;

import java.util.List;

import com.zhijie.zmall.admin.vo.RoleRightVO;
import com.zhijie.zmall.admin.qo.RoleRightQO;

/**
 * @Description: RoleRightService
 * @author: sangaizhi
 * @date: 2017-01-10 23:27:51
 */
public interface RoleRightService {
    /**
     * 根据Id查询对象信息。单表查询，无连表操作
     * @param id 对象Id
     * @return RoleRightVO 对象信息
     * @author: sangaizhi
     * @date: 2017-01-10 23:27:51
     */
    RoleRightVO getById(Long id);

    /**
     * 根据条件查询对象信息。单表查询，无连表操作
     * @param qo RoleRightQO查询对象
     * @return RoleRightVO 对象信息
     * @author: sangaizhi
     * @date: 2017-01-10 23:27:51
     */
    RoleRightVO getByCondition(RoleRightQO qo);
    
    /**
     * 根据条件查询对象列表。单表查询，无连表操作
     * 
     * @param qo RoleRightQO查询对象
     * @return List<RoleRightVO> RoleRightVO对象列表
     * @author: sangaizhi
     * @date: 2017-01-10 23:27:51
     */
    List<RoleRightVO> queryList(RoleRightQO qo);
    
    /**
     * 根据条件统计。单表查询，无连表操作
     * @param qo RoleRightQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-01-10 23:27:51
     */
    long count(RoleRightQO qo);
    
    /**
     * 根据条件分页查询对象列表。单表查询，无连表操作
     * 
     * @param qo RoleRightQO查询对象
     * @return List<RoleRightVO> RoleRightVO对象列表
     * @author: sangaizhi
     * @date: 2017-01-10 23:27:51
     */
    List<RoleRightVO> queryPage(RoleRightQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo RoleRightVO对象信息
     * @return int 保存成功的记录条数
     * @author: sangaizhi
     * @date: 2017-01-10 23:27:51
     */
    int save(RoleRightVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList RoleRightVO对象列表
     * @return int 保存成功的记录条数
     * @author: sangaizhi
     * @date: 2017-01-10 23:27:51
     */
    int saveBatch(List<RoleRightVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo RoleRightVO对象
     * @return int 修改成功的记录条数
     * @author: sangaizhi
     * @date: 2017-01-10 23:27:51
     */
    int updateById(RoleRightVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id RoleRightVO对象Id
     * @return int 删除成功的记录条数
     * @author: sangaizhi
     * @date: 2017-01-10 23:27:51
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids RoleRightVO对象Id集合
     * @return int 删除成功的记录条数
     * @author: sangaizhi
     * @date: 2017-01-10 23:27:51
     */
    int deleteBatchByIds(List<Long> ids);
    
    /**
     * 根据Id查询对象信息。多表连表查询
     * @param id 对象Id
     * @return RoleRightVO 对象信息
     * @author: sangaizhi
     * @date: 2017-01-10 23:27:51
     */
    RoleRightVO getDetailById(Long id);

    /**
     * 根据条件查询对象信息。多表连表查询
     * @param qo RoleRightQO查询对象
     * @return RoleRightVO 对象信息
     * @author: sangaizhi
     * @date: 2017-01-10 23:27:51
     */
    RoleRightVO getDetailByCondition(RoleRightQO qo);
    
    /**
     * 根据条件查询对象列表。多表连表查询
     * 
     * @param qo RoleRightQO查询对象
     * @return List<RoleRightVO> RoleRightVO对象列表
     * @author: sangaizhi
     * @date: 2017-01-10 23:27:51
     */
    List<RoleRightVO> queryDetailList(RoleRightQO qo);
    
    /**
     * 根据条件统计。多表连表查询
     * @param qo RoleRightQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-01-10 23:27:51
     */
    long countDetail(RoleRightQO qo);
    
    /**
     * 根据条件分页查询对象列表。多表连表查询
     * 
     * @param qo RoleRightQO查询对象
     * @return List<RoleRightVO> RoleRightVO对象列表
     * @author: sangaizhi
     * @date: 2017-01-10 23:27:51
     */
    List<RoleRightVO> queryDetailPage(RoleRightQO qo);
}
