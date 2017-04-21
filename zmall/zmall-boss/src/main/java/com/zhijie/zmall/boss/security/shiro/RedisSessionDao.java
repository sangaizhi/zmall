/**
 * 文件名称: RedisSessionDao
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/4/16 10:25
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.boss.security.shiro;

import com.zhijie.zmall.commons.constants.LogTemplate;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @name RedisSessionDao
 * @author sangaizhi
 * @date 2017/4/16  10:25
 * @version 1.0
 */
public class RedisSessionDao extends AbstractSessionDAO{


    @Value("${SHIRO_SESSION_PREFIX}")
    private String SHIRO_SESSION_PREFIX;
    @Value("${SHIRO_SESSION_PREFIX_KEYS}")
    private String SHIRO_SESSION_PREFIX_KEYS;
    @Value("${EXPIRE_SECONDS}")
    public Long expireSeconds;

    @Autowired
    private  RedisTemplate<Serializable, Session> redisTemplate;

    private  Logger logger = LoggerFactory.getLogger(RedisSessionDao.class);

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = SHIRO_SESSION_PREFIX + UUID.randomUUID().toString();
        assignSessionId(session, sessionId);
        redisTemplate.opsForValue().set(sessionId, session, expireSeconds, TimeUnit.SECONDS);
        logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS, "创建 shiro session,sessionId:{}", sessionId, sessionId);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS, "read shiro session ,sessionId is :{}", sessionId.toString(), sessionId.toString());
        return redisTemplate.opsForValue().get(sessionId);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS, "update shiro session ,sessionId is :{}", session.getId().toString(), session.getId().toString());
        redisTemplate.opsForValue().set(session.getId(), session, expireSeconds, TimeUnit.SECONDS);
    }

    @Override
    public void delete(Session session) {
        logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS, "delete shiro session ,sessionId is :{}", session.getId().toString(), session.getId().toString());
        redisTemplate.opsForValue().getOperations().delete(session.getId());
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<Serializable> keys = redisTemplate.keys(SHIRO_SESSION_PREFIX_KEYS);
        if (keys.size() == 0) {
            return Collections.emptySet();
        }
        List<Session> sessions = redisTemplate.opsForValue().multiGet(keys);
        return Collections.unmodifiableCollection(sessions);
    }
}
