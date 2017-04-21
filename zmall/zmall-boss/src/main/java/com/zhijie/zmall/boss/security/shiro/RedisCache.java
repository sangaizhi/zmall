/**
 * 文件名称: RedisCache
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/4/15 22:34
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * reids 实现 shiro的 缓存
 * @author sangaizhi
 * @version 1.0
 * @name RedisCache
 * @date 2017/4/15  22:34
 */
public class RedisCache<K, V> implements Cache<K, V>, Serializable {
    private static final long serialVersionUID = -9072373268556006622L;
    // shiro缓存 键
    @Value("${SHIRO_CACHE_PREFIX}")
    public  String SHIRO_CACHE_PREFIX;

    @Value("${SHIRO_CACHE_PREFIX_KEYS}")
    public  String SHIRO_CACHE_PREFIX_KEYS;

    @Value("${EXPIRE_SECONDS}")
    public Long expireSeconds;

    private static Logger logger = LoggerFactory.getLogger(RedisCache.class);

    private RedisTemplate<K, V> redisTemplate;


    public RedisCache() {
    }

    public RedisCache(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    ;

    @Override
    public V get(K key) throws CacheException {
        logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS, "根据key从redis中获取对象", key);
        return redisTemplate.opsForValue().get(SHIRO_CACHE_PREFIX + key);
    }

    @Override
    public V put(K key, V value) throws CacheException {
        logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS, "向redis插入对象", String.format("：key：{}, value:{}", key, value));
        redisTemplate.opsForValue().set((K)(SHIRO_CACHE_PREFIX + key), value, expireSeconds, TimeUnit.SECONDS);
        return value;
    }

    @Override
    public V remove(K key) throws CacheException {
        logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS, "根据key 从redis移除对象", key);
        V value = redisTemplate.opsForValue().get(key);
        redisTemplate.delete((K)(SHIRO_CACHE_PREFIX + key));
        return value;
    }

    @Override
    public void clear() throws CacheException {
        logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS, "清除redis 缓存的所有关于shiro的对象");
        Set<K> keys = redisTemplate.keys((K) SHIRO_CACHE_PREFIX_KEYS);
        redisTemplate.delete(keys);
    }

    @Override
    public int size() {
        logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS, "获取redis 缓存的所有关于shiro的对象数量");
        Set<K> keys = redisTemplate.keys((K) SHIRO_CACHE_PREFIX_KEYS);
        return keys.size();
    }

    @Override
    public Set<K> keys() {
        logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS, "获取redis 缓存的所有关于shiro的对象的key");
        Set<K> keys = redisTemplate.keys((K)SHIRO_CACHE_PREFIX_KEYS);
        if (keys.size() == 0) {
            return Collections.emptySet();
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS, "获取redis 缓存的所有关于shiro的对象的value");
        Set<K> keys = redisTemplate.keys((K) SHIRO_CACHE_PREFIX_KEYS);
        if (keys.size() == 0) {
            return Collections.emptySet();
        }
        List<V> vs = redisTemplate.opsForValue().multiGet(keys);

        return Collections.unmodifiableCollection(vs);
    }

    public RedisTemplate<K, V> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
