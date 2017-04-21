package com.zhijie.zmall.sso.dao;

import java.util.List;

import com.zhijie.zmall.sso.condition.UserQO;
import com.zhijie.zmall.sso.model.UserVO;
import org.springframework.stereotype.Repository;

/**
 * @Description: UserDao
 * @author: sangaizhi
 * @date: 2017-03-28 22:51:09
 */
@Repository
public interface UserDao {
    /**
     * 根据Id查询对象信息。单表查询，无连表操作
     * @param id 对象Id
     * @return UserVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-28 22:51:09
     */
    UserVO getById(Long id);

    /**
     * 根据条件查询对象信息。单表查询，无连表操作
     * @param qo UserQO查询对象
     * @return UserVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-28 22:51:09
     */
    UserVO getByCondition(UserQO qo);
    
    /**
     * 根据条件统计。单表查询，无连表操作
     * @param qo UserQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-03-28 22:51:09
     */
    long count(UserQO qo);

    /**
     * 根据条件查询对象列表。单表查询，无连表操作
     * 
     * @param qo UserQO查询对象
     * @return List<UserVO> UserVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-28 22:51:09
     */
    List<UserVO> queryList(UserQO qo);
    
    /**
     * 根据条件分页查询对象列表。单表查询，无连表操作
     * 
     * @param qo UserQO查询对象
     * @return List<UserVO> UserVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-28 22:51:09
     */
    List<UserVO> queryPage(UserQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo UserVO对象信息
     * @return int 保存成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-28 22:51:09
     */
    int save(UserVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList UserVO对象列表
     * @return int 保存成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-28 22:51:09
     */
    int saveBatch(List<UserVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo UserVO对象
     * @return int 修改成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-28 22:51:09
     */
    int updateById(UserVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id UserVO对象Id
     * @return int 删除成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-28 22:51:09
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids UserVO对象Id集合
     * @return int 删除成功的记录条数
     * @author: sangaizhi
     * @date: 2017-03-28 22:51:09
     */
    int deleteBatchByIds(List<Long> ids);
    
    /**
     * 根据Id查询对象信息。多表连表查询
     * @param id 对象Id
     * @return UserVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-28 22:51:09
     */
    UserVO getDetailById(Long id);

    /**
     * 根据条件查询对象信息。多表连表查询
     * @param qo UserQO查询对象
     * @return UserVO 对象信息
     * @author: sangaizhi
     * @date: 2017-03-28 22:51:09
     */
    UserVO getDetailByCondition(UserQO qo);
    
    /**
     * 根据条件查询对象列表。多表连表查询
     * 
     * @param qo UserQO查询对象
     * @return List<UserVO> UserVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-28 22:51:09
     */
    List<UserVO> queryDetailList(UserQO qo);
    
    /**
     * 根据条件统计。多表连表查询
     * @param qo UserQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-03-28 22:51:09
     */
    long countDetail(UserQO qo);
    
    /**
     * 根据条件分页查询对象列表。多表连表查询
     * 
     * @param qo UserQO查询对象
     * @return List<UserVO> UserVO对象列表
     * @author: sangaizhi
     * @date: 2017-03-28 22:51:09
     */
    List<UserVO> queryDetailPage(UserQO qo);
}
