package com.zhijie.zmall.cas.dao.impl;

import com.zhijie.zmall.cas.dao.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

//@Repository
public class JedisClientSingle implements JedisClient {

	@Autowired
	private JedisPool  jedisClient;
	
	
	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisClient.getResource();
		String value = jedis.get(key);
		jedis.close();
		return value;
	}

	@Override
	public String set(String key, String value) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisClient.getResource();
		String result = jedis.set(key, value);
		jedis.close();
		return result;
	}

	@Override
	public String hget(String hKey, String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisClient.getResource();
		String value = jedis.hget(hKey, key);
		jedis.close();
		return value;
	}

	@Override
	public Long hset(String hKey, String key, String value) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisClient.getResource();
		Long result = jedis.hset(hKey, key, value);
		jedis.close();
		return result;
	}

	@Override
	public long incr(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisClient.getResource();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}

	@Override
	public long expire(String key, int second) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisClient.getResource();
		Long result = jedis.expire(key, second);
		jedis.close();
		return result;
	}

	@Override
	public long ttl(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisClient.getResource();
		Long result = jedis.ttl(key);
		jedis.close();
		return result;
	}

	@Override
	public long del(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisClient.getResource();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}

	@Override
	public long hdel(String hkey, String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisClient.getResource();
		Long result = jedis.hdel(hkey, key);
		jedis.close();
		return 0;
	}

}
