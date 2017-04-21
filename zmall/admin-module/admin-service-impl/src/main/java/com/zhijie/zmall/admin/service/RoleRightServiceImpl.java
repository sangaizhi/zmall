package com.zhijie.zmall.admin.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zhijie.zmall.admin.qo.RoleRightQO;
import com.zhijie.zmall.admin.vo.RoleRightVO;
import com.zhijie.zmall.admin.dao.RoleRightDao;

/**
 * @Description: RoleRightService 实现类
 * @author: sangaizhi
 * @date: 2017-01-10 23:27:51
 */
@Service
public class RoleRightServiceImpl implements RoleRightService {

    @Autowired
    private RoleRightDao roleRightDao;

    @Override
    @Transactional(readOnly = true)
    public RoleRightVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return roleRightDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public RoleRightVO getByCondition(RoleRightQO qo) {
        if (qo == null) {
            return null;
        }
        return roleRightDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleRightVO> queryList(RoleRightQO qo) {
        if (qo == null) {
            return null;
        }
        return roleRightDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(RoleRightQO qo) {
        if (qo == null) {
            return 0;
        }
        return roleRightDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<RoleRightVO> queryPage(RoleRightQO qo) {
        if (qo == null) {
            return null;
        }
        return roleRightDao.queryPage(qo); 
    }

    @Override
    public int save(RoleRightVO vo) {
        if (vo == null) {
            return 0;
        }
        return roleRightDao.save(vo);
    }

    @Override
    public int saveBatch(List<RoleRightVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return 0;
        }
        return roleRightDao.saveBatch(voList);
    }

    @Override
    public int updateById(RoleRightVO vo) {
        if (vo == null) {
            return 0;
        }
        return roleRightDao.updateById(vo);
    }

    @Override
    public int deleteById(Long id) {
        if (id == null) {
            return 0;
        }
        return roleRightDao.deleteById(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return roleRightDao.deleteBatchByIds(ids);
    }
    
    @Override
    @Transactional(readOnly = true)
    public RoleRightVO getDetailById(Long id) {
        if (id == null) {
            return null;
        }
        return roleRightDao.getDetailById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public RoleRightVO getDetailByCondition(RoleRightQO qo) {
        if (qo == null) {
            return null;
        }
        return roleRightDao.getDetailByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleRightVO> queryDetailList(RoleRightQO qo) {
        if (qo == null) {
            return null;
        }
        return roleRightDao.queryDetailList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long countDetail(RoleRightQO qo) {
        if (qo == null) {
            return 0;
        }
        return roleRightDao.countDetail(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<RoleRightVO> queryDetailPage(RoleRightQO qo) {
        if (qo == null) {
            return null;
        }
        return roleRightDao.queryDetailPage(qo); 
    }
}
