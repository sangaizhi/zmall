package com.zhijie.zmall.admin.service;

import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zhijie.zmall.admin.qo.AdminRoleQO;
import com.zhijie.zmall.admin.vo.AdminRoleVO;
import com.zhijie.zmall.admin.service.AdminRoleService;
import com.zhijie.zmall.admin.dao.AdminRoleDao;

/**
 * @Description: AdminRoleService 实现类
 * @author: sangaizhi
 * @date: 2017-03-31 21:37:44
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleDao adminRoleDao;

    @Override
    @Transactional(readOnly = true)
    public AdminRoleVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return adminRoleDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public AdminRoleVO getByCondition(AdminRoleQO qo) {
        if (qo == null) {
            return null;
        }
        return adminRoleDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdminRoleVO> queryList(AdminRoleQO qo) {
        if (qo == null) {
            return null;
        }
        return adminRoleDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(AdminRoleQO qo) {
        if (qo == null) {
            return 0;
        }
        return adminRoleDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<AdminRoleVO> queryPage(AdminRoleQO qo) {
        if (qo == null) {
            return null;
        }
        return adminRoleDao.queryPage(qo); 
    }

    @Override
    public int save(AdminRoleVO vo) {
        if (vo == null) {
            return 0;
        }
        return adminRoleDao.save(vo);
    }

    @Override
    public int saveBatch(List<AdminRoleVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return 0;
        }
        return adminRoleDao.saveBatch(voList);
    }

    @Override
    public int updateById(AdminRoleVO vo) {
        if (vo == null) {
            return 0;
        }
        return adminRoleDao.updateById(vo);
    }

    @Override
    public int deleteById(Long id) {
        if (id == null) {
            return 0;
        }
        return adminRoleDao.deleteById(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return adminRoleDao.deleteBatchByIds(ids);
    }
    
    @Override
    @Transactional(readOnly = true)
    public AdminRoleVO getDetailById(Long id) {
        if (id == null) {
            return null;
        }
        return adminRoleDao.getDetailById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public AdminRoleVO getDetailByCondition(AdminRoleQO qo) {
        if (qo == null) {
            return null;
        }
        return adminRoleDao.getDetailByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdminRoleVO> queryDetailList(AdminRoleQO qo) {
        if (qo == null) {
            return null;
        }
        return adminRoleDao.queryDetailList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long countDetail(AdminRoleQO qo) {
        if (qo == null) {
            return 0;
        }
        return adminRoleDao.countDetail(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<AdminRoleVO> queryDetailPage(AdminRoleQO qo) {
        if (qo == null) {
            return null;
        }
        return adminRoleDao.queryDetailPage(qo); 
    }
}
