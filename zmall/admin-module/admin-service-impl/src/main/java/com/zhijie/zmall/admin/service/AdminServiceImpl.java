package com.zhijie.zmall.admin.service;

import java.util.List;

import com.zhijie.zmall.commons.util.validate.RegularUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zhijie.zmall.admin.qo.AdminQO;
import com.zhijie.zmall.admin.vo.AdminVO;
import com.zhijie.zmall.admin.dao.AdminDao;
import org.springframework.util.DigestUtils;

/**
 * @Description: AdminService 实现类
 * @author: sangaizhi
 * @date: 2017-03-30 22:12:01
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    @Transactional(readOnly = true)
    public AdminVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return adminDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public AdminVO getByCondition(AdminQO qo) {
        if (qo == null) {
            return null;
        }
        return adminDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdminVO> queryList(AdminQO qo) {
        if (qo == null) {
            return null;
        }
        return adminDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(AdminQO qo) {
        if (qo == null) {
            return 0;
        }
        return adminDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<AdminVO> queryPage(AdminQO qo) {
        if (qo == null) {
            return null;
        }
        return adminDao.queryPage(qo); 
    }

    @Override
    public int save(AdminVO vo) {
        if (vo == null) {
            return 0;
        }
        return adminDao.save(vo);
    }

    @Override
    public int saveBatch(List<AdminVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return 0;
        }
        return adminDao.saveBatch(voList);
    }

    @Override
    public int updateById(AdminVO vo) {
        if (vo == null) {
            return 0;
        }
        return adminDao.updateById(vo);
    }

    @Override
    public int deleteById(Long id) {
        if (id == null) {
            return 0;
        }
        return adminDao.deleteById(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return adminDao.deleteBatchByIds(ids);
    }
    
    @Override
    @Transactional(readOnly = true)
    public AdminVO getDetailById(Long id) {
        if (id == null) {
            return null;
        }
        return adminDao.getDetailById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public AdminVO getDetailByCondition(AdminQO qo) {
        if (qo == null) {
            return null;
        }
        return adminDao.getDetailByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdminVO> queryDetailList(AdminQO qo) {
        if (qo == null) {
            return null;
        }
        return adminDao.queryDetailList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long countDetail(AdminQO qo) {
        if (qo == null) {
            return 0;
        }
        return adminDao.countDetail(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<AdminVO> queryDetailPage(AdminQO qo) {
        if (qo == null) {
            return null;
        }
        return adminDao.queryDetailPage(qo); 
    }

}
