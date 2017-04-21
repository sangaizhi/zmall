/**
 * 文件名称: JedisServiceImpl
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/4/6 21:21
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.boss.service.impl;

import com.zhijie.zmall.boss.dao.JedisClient;
import com.zhijie.zmall.boss.service.JedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @name JedisServiceImpl
 * @author sangaizhi
 * @date 2017/4/6  21:21
 * @version 1.0
 */
@Service
public class JedisServiceImpl implements JedisService {

    @Autowired
    private JedisClient jedisClient;

    @Override
    public String get(String key) {
        return jedisClient.get(key);
    }

    @Override
    public String set(String key, String value) {
        return jedisClient.set(key, value);
    }

    @Override
    public String hget(String hKey, String key) {
        return jedisClient.hget(hKey, key);
    }

    @Override
    public Long hset(String hKey, String key, String value) {
        return jedisClient.hset(hKey, key, value);
    }

    @Override
    public long incr(String key) {
        return jedisClient.incr(key);
    }

    @Override
    public long expire(String key, int second) {
        return jedisClient.expire(key, second);
    }

    @Override
    public long ttl(String key) {
        return jedisClient.ttl(key);
    }

    @Override
    public long del(String key) {
        return jedisClient.del(key);
    }

    @Override
    public long hdel(String hkey, String key) {
        return jedisClient.hdel(hkey, key);
    }
}
