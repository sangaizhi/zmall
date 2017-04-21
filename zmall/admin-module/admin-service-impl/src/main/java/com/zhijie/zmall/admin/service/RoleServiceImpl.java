package com.zhijie.zmall.admin.service;

import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zhijie.zmall.admin.qo.RoleQO;
import com.zhijie.zmall.admin.vo.RoleVO;
import com.zhijie.zmall.admin.service.RoleService;
import com.zhijie.zmall.admin.dao.RoleDao;

/**
 * @Description: RoleService 实现类
 * @author: sangaizhi
 * @date: 2017-03-31 21:35:22
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public RoleVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return roleDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public RoleVO getByCondition(RoleQO qo) {
        if (qo == null) {
            return null;
        }
        return roleDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleVO> queryList(RoleQO qo) {
        if (qo == null) {
            return null;
        }
        return roleDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(RoleQO qo) {
        if (qo == null) {
            return 0;
        }
        return roleDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<RoleVO> queryPage(RoleQO qo) {
        if (qo == null) {
            return null;
        }
        return roleDao.queryPage(qo); 
    }

    @Override
    public int save(RoleVO vo) {
        if (vo == null) {
            return 0;
        }
        return roleDao.save(vo);
    }

    @Override
    public int saveBatch(List<RoleVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return 0;
        }
        return roleDao.saveBatch(voList);
    }

    @Override
    public int updateById(RoleVO vo) {
        if (vo == null) {
            return 0;
        }
        return roleDao.updateById(vo);
    }

    @Override
    public int deleteById(Long id) {
        if (id == null) {
            return 0;
        }
        return roleDao.deleteById(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return roleDao.deleteBatchByIds(ids);
    }
    
    @Override
    @Transactional(readOnly = true)
    public RoleVO getDetailById(Long id) {
        if (id == null) {
            return null;
        }
        return roleDao.getDetailById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public RoleVO getDetailByCondition(RoleQO qo) {
        if (qo == null) {
            return null;
        }
        return roleDao.getDetailByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleVO> queryDetailList(RoleQO qo) {
        if (qo == null) {
            return null;
        }
        return roleDao.queryDetailList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long countDetail(RoleQO qo) {
        if (qo == null) {
            return 0;
        }
        return roleDao.countDetail(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<RoleVO> queryDetailPage(RoleQO qo) {
        if (qo == null) {
            return null;
        }
        return roleDao.queryDetailPage(qo); 
    }
}
