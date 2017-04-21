package com.zhijie.zmall.admin.service;

import java.util.List;

import com.zhijie.zmall.admin.vo.AdminRoleVO;
import com.zhijie.zmall.admin.qo.AdminRoleQO;

/**
 * @Description: AdminRoleService
 * @author: sangaizhi
 * @date: 2017-03-31 21:37:44
 */
public interface AdminRoleService {
    /**
     * 根据Id查询对象信息。单表查询，无连表操作
     * @param id 对象Id
     * @return AdminRoleVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-31 21:37:44
     */
    AdminRoleVO getById(Long id);

    /**
     * 根据条件查询对象信息。单表查询，无连表操作
     * @param qo AdminRoleQO查询对象
     * @return AdminRoleVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-31 21:37:44
     */
    AdminRoleVO getByCondition(AdminRoleQO qo);
    
    /**
     * 根据条件查询对象列表。单表查询，无连表操作
     * 
     * @param qo AdminRoleQO查询对象
     * @return List<AdminRoleVO> AdminRoleVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-31 21:37:44
     */
    List<AdminRoleVO> queryList(AdminRoleQO qo);
    
    /**
     * 根据条件统计。单表查询，无连表操作
     * @param qo AdminRoleQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-03-31 21:37:44
     */
    long count(AdminRoleQO qo);
    
    /**
     * 根据条件分页查询对象列表。单表查询，无连表操作
     * 
     * @param qo AdminRoleQO查询对象
     * @return List<AdminRoleVO> AdminRoleVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-31 21:37:44
     */
    List<AdminRoleVO> queryPage(AdminRoleQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo AdminRoleVO对象信息
     * @return int 保存成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-31 21:37:44
     */
    int save(AdminRoleVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList AdminRoleVO对象列表
     * @return int 保存成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-31 21:37:44
     */
    int saveBatch(List<AdminRoleVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo AdminRoleVO对象
     * @return int 修改成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-31 21:37:44
     */
    int updateById(AdminRoleVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id AdminRoleVO对象Id
     * @return int 删除成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-31 21:37:44
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AdminRoleVO对象Id集合
     * @return int 删除成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-31 21:37:44
     */
    int deleteBatchByIds(List<Long> ids);
    
    /**
     * 根据Id查询对象信息。多表连表查询
     * @param id 对象Id
     * @return AdminRoleVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-31 21:37:44
     */
    AdminRoleVO getDetailById(Long id);

    /**
     * 根据条件查询对象信息。多表连表查询
     * @param qo AdminRoleQO查询对象
     * @return AdminRoleVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-31 21:37:44
     */
    AdminRoleVO getDetailByCondition(AdminRoleQO qo);
    
    /**
     * 根据条件查询对象列表。多表连表查询
     * 
     * @param qo AdminRoleQO查询对象
     * @return List<AdminRoleVO> AdminRoleVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-31 21:37:44
     */
    List<AdminRoleVO> queryDetailList(AdminRoleQO qo);
    
    /**
     * 根据条件统计。多表连表查询
     * @param qo AdminRoleQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-03-31 21:37:44
     */
    long countDetail(AdminRoleQO qo);
    
    /**
     * 根据条件分页查询对象列表。多表连表查询
     * 
     * @param qo AdminRoleQO查询对象
     * @return List<AdminRoleVO> AdminRoleVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-31 21:37:44
     */
    List<AdminRoleVO> queryDetailPage(AdminRoleQO qo);
}
