package com.zhijie.zmall.admin.service;

import java.util.List;

import com.zhijie.zmall.admin.vo.AdminVO;
import com.zhijie.zmall.admin.qo.AdminQO;

/**
 * @Description: AdminService
 * @author: sangaizhi
 * @date: 2017-03-30 22:12:01
 */
public interface AdminService {
    /**
     * 根据Id查询对象信息。单表查询，无连表操作
     * @param id 对象Id
     * @return AdminVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-30 22:12:01
     */
    AdminVO getById(Long id);

    /**
     * 根据条件查询对象信息。单表查询，无连表操作
     * @param qo AdminQO查询对象
     * @return AdminVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-30 22:12:01
     */
    AdminVO getByCondition(AdminQO qo);
    
    /**
     * 根据条件查询对象列表。单表查询，无连表操作
     * 
     * @param qo AdminQO查询对象
     * @return List<AdminVO> AdminVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-30 22:12:01
     */
    List<AdminVO> queryList(AdminQO qo);
    
    /**
     * 根据条件统计。单表查询，无连表操作
     * @param qo AdminQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-03-30 22:12:01
     */
    long count(AdminQO qo);
    
    /**
     * 根据条件分页查询对象列表。单表查询，无连表操作
     * 
     * @param qo AdminQO查询对象
     * @return List<AdminVO> AdminVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-30 22:12:01
     */
    List<AdminVO> queryPage(AdminQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo AdminVO对象信息
     * @return int 保存成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-30 22:12:01
     */
    int save(AdminVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList AdminVO对象列表
     * @return int 保存成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-30 22:12:01
     */
    int saveBatch(List<AdminVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo AdminVO对象
     * @return int 修改成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-30 22:12:01
     */
    int updateById(AdminVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id AdminVO对象Id
     * @return int 删除成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-30 22:12:01
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AdminVO对象Id集合
     * @return int 删除成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-30 22:12:01
     */
    int deleteBatchByIds(List<Long> ids);
    
    /**
     * 根据Id查询对象信息。多表连表查询
     * @param id 对象Id
     * @return AdminVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-30 22:12:01
     */
    AdminVO getDetailById(Long id);

    /**
     * 根据条件查询对象信息。多表连表查询
     * @param qo AdminQO查询对象
     * @return AdminVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-30 22:12:01
     */
    AdminVO getDetailByCondition(AdminQO qo);
    
    /**
     * 根据条件查询对象列表。多表连表查询
     * 
     * @param qo AdminQO查询对象
     * @return List<AdminVO> AdminVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-30 22:12:01
     */
    List<AdminVO> queryDetailList(AdminQO qo);
    
    /**
     * 根据条件统计。多表连表查询
     * @param qo AdminQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-03-30 22:12:01
     */
    long countDetail(AdminQO qo);
    
    /**
     * 根据条件分页查询对象列表。多表连表查询
     * 
     * @param qo AdminQO查询对象
     * @return List<AdminVO> AdminVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-30 22:12:01
     */
    List<AdminVO> queryDetailPage(AdminQO qo);


}
