/**
 * 文件名称: RedisCacheManager
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/4/16 10:12
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.boss.security.shiro;

import com.zhijie.zmall.commons.constants.LogTemplate;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

/**
 * @name RedisCacheManager
 * @author sangaizhi
 * @date 2017/4/16  10:12
 * @version 1.0
 */
public class RedisCacheManager implements CacheManager,Serializable {

    private static final long serialVersionUID = -4532860039270278049L;
    @Value("${SHIRO_CACHE_PREFIX}")
    public  String SHIRO_CACHE_PREFIX;

    @Value("${SHIRO_CACHE_PREFIX_KEYS}")
    public  String SHIRO_CACHE_PREFIX_KEYS;

    private  Logger logger = LoggerFactory.getLogger(RedisCacheManager.class);

    private  RedisTemplate<Object, Object> redisTemplate;

    public RedisCacheManager() {
    }

    public RedisCacheManager(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("Cache name cannot be null or empty.");
        }
        logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS, "redis shiro 緩存管理器获取缓存",  name);
        Cache cache = (Cache) redisTemplate.opsForValue().get(name);
        if (cache == null) {
            cache = new RedisCache<>(redisTemplate);
            redisTemplate.opsForValue().set(SHIRO_CACHE_PREFIX + name, cache);
        }
        return cache;
    }

    public RedisTemplate<Object, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
