package com.zhijie.zmall.cas.dao.impl;

import com.zhijie.zmall.cas.dao.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

/**
 * jedis  集群版实现类
 * @ClassName: JedisClientCluster 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author sangaizhi 
 * @date 2017年3月7日   下午11:33:03 
 *
 */
public class JedisClientCluster implements JedisClient {

	@Autowired
	private JedisCluster jedisCluster;
	
	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		return jedisCluster.get(key);
	}

	@Override
	public String set(String key, String value) {
		// TODO Auto-generated method stub
		return jedisCluster.set(key, value);
	}

	@Override
	public String hget(String hKey, String key) {
		// TODO Auto-generated method stub
		return jedisCluster.hget(hKey, key);
	}

	@Override
	public Long hset(String hKey, String key, String value) {
		// TODO Auto-generated method stub
		return jedisCluster.hset(hKey, key, value);
	}

	@Override
	public long incr(String key) {
		// TODO Auto-generated method stub
		return jedisCluster.incr(key);
	}

	@Override
	public long expire(String key, int second) {
		// TODO Auto-generated method stub
		return jedisCluster.expire(key, second);
	}

	@Override
	public long ttl(String key) {
		// TODO Auto-generated method stub
		return jedisCluster.ttl(key);
	}

	@Override
	public long del(String key) {
		// TODO Auto-generated method stub
		
		return jedisCluster.del(key);
	}

	@Override
	public long hdel(String hkey, String key) {
		// TODO Auto-generated method stub
		return jedisCluster.hdel(hkey, key);
	}

}
