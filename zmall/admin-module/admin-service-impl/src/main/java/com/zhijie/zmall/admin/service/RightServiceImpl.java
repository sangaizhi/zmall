package com.zhijie.zmall.admin.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zhijie.zmall.admin.qo.RightQO;
import com.zhijie.zmall.admin.vo.RightVO;
import com.zhijie.zmall.admin.dao.RightDao;

/**
 * @Description: RightService 实现类
 * @author: sangaizhi
 * @date: 2017-01-10 23:16:18
 */
@Service
public class RightServiceImpl implements RightService {

    @Autowired
    private RightDao rightDao;

    @Override
    @Transactional(readOnly = true)
    public RightVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return rightDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public RightVO getByCondition(RightQO qo) {
        if (qo == null) {
            return null;
        }
        return rightDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RightVO> queryList(RightQO qo) {
        if (qo == null) {
            return null;
        }
        return rightDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(RightQO qo) {
        if (qo == null) {
            return 0;
        }
        return rightDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<RightVO> queryPage(RightQO qo) {
        if (qo == null) {
            return null;
        }
        return rightDao.queryPage(qo); 
    }

    @Override
    public int save(RightVO vo) {
        if (vo == null) {
            return 0;
        }
        return rightDao.save(vo);
    }

    @Override
    public int saveBatch(List<RightVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return 0;
        }
        return rightDao.saveBatch(voList);
    }

    @Override
    public int updateById(RightVO vo) {
        if (vo == null) {
            return 0;
        }
        return rightDao.updateById(vo);
    }

    @Override
    public int deleteById(Long id) {
        if (id == null) {
            return 0;
        }
        return rightDao.deleteById(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return rightDao.deleteBatchByIds(ids);
    }
    
    @Override
    @Transactional(readOnly = true)
    public RightVO getDetailById(Long id) {
        if (id == null) {
            return null;
        }
        return rightDao.getDetailById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public RightVO getDetailByCondition(RightQO qo) {
        if (qo == null) {
            return null;
        }
        return rightDao.getDetailByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RightVO> queryDetailList(RightQO qo) {
        if (qo == null) {
            return null;
        }
        return rightDao.queryDetailList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long countDetail(RightQO qo) {
        if (qo == null) {
            return 0;
        }
        return rightDao.countDetail(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<RightVO> queryDetailPage(RightQO qo) {
        if (qo == null) {
            return null;
        }
        return rightDao.queryDetailPage(qo); 
    }
}
