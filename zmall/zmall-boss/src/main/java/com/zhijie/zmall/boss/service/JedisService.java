/**
 * 文件名称: JedisService
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
package com.zhijie.zmall.boss.service;

/**
 * @Name JedisService
 * @Author sangaizhi
 * @Date 2017/4/6  21:21
 * @Version 1.0
 */
public interface JedisService {

    String get(String key);

    String set(String key, String value);

    String hget(String hKey, String key);

    Long hset(String hKey, String key, String value);

    /**
     * 自增
     * @Title: incr
     * @Description:
     * @param @param key
     * @param @return
     * @return long
     * @throws
     *
     */
    long incr(String key);

    /**
     * 设置key的过期时间
     * @Title: expire
     * @Description:
     * @param @param key  设置的key
     * @param @param second  过期时间 秒为单位  -1 表示不过期
     * @return void
     * @throws
     *
     */
    long expire(String key, int second);

    /**
     * 查看key的剩余有效时间，单位为秒
     * @Title: ttl
     * @Description:
     * @param @param key
     * @param @return -1 表示不过期  -2 表示已过期删除
     * @return long
     * @throws
     *
     */
    long ttl(String key);

    /**
     * 删除某个key
     * @Title: del
     * @Description:
     * @param @param key
     * @param @return
     * @return long
     * @throws
     *
     */
    long del(String key);

    long hdel(String hkey, String key);

}
