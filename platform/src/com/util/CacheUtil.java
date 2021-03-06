package com.util;

import java.util.Date;
import java.util.Map;

import javolution.util.FastMap;

/**
 * 缓存工具类，将一些经常调用的数据放入缓存中
 * 
 * @author hshzh
 * 
 */
public class CacheUtil {
	private final static FastMap<String, Object> cache = new FastMap<String, Object>().shared();
	/**
	 * 基础缓存，存大部份通用缓存对象（如字典表，常用参数等）
	 */
	private final static FastMap<String, Object> baseCache = new FastMap<String, Object>().shared();	
	/**
	 * 令牌对象数据缓存(登陆后的信息，ecinfo,userinfo,roleinfo,menuinfo)
	 */
	private final static FastMap<String, Object> tokenCache = new FastMap<String, Object>().shared();	
	/**
	 * 令牌时间缓存(设置存在令牌时的当前请求时间，为后续设置操作过期做准备,token为登陆名,value为登陆时的时间对象)
	 */
	private final static FastMap<String, Object> tokenTime = new FastMap<String, Object>().shared();
	/**
	 * 存放短信验证码信息
	 */
	private final static FastMap<String,Map<String, Object>> smsPassCodeCache = new FastMap<String,Map<String, Object>>().shared();	
	
	/**
	 * 存放短信验证码信息(key手机号,value为验证码字符串)
	 */
	private final static FastMap<String,String> smsPassCodeCaches = new FastMap<String,String>().shared();	
	
	/**
	 * 放短信验证码信息时间缓存(设置存在放短信验证码信息时的当前请求时间，为后续设置操作过期做准备,mobile为登陆手机号,value为生成验证码时的时间对象)
	 */
	private final static FastMap<String, Object> smsPassCodeTime = new FastMap<String, Object>().shared();
	
	
	
	private final static CacheUtil instance = new CacheUtil();

	private CacheUtil() {
	}

	public static CacheUtil getInstance() {
		return instance;
	}

	/**
	 * 获取通用缓存对象对象
	 * 
	 * @return
	 */
	public FastMap<String, Object> getCache() {
		return cache;
	}
	/**
	 * 获取通用缓存对象
	 * 
	 * @return
	 */
	public FastMap<String, Object> getBaseCache() {
		return baseCache;
	}
    /**
     * 获取令牌对象数据缓存对象
     * @return
     */
	public FastMap<String, Object> getTokenCache() {
		return tokenCache;
	}
	
    /**
     * 获取令牌时间缓存对象
     * @return
     */
	public FastMap<String, Object> getTokenTime() {
		return tokenTime;
	}
	/**
     * 获取短信缓存对象（Map<String, Object>）
     * @return
     */
	public FastMap<String, Map<String, Object>> getSmsPassCodeCache() {
		return smsPassCodeCache;
	}
	/**
     * 获取短信缓存对象（String）
     * @return
     */
	public FastMap<String, String> getSmsPassCodeCaches() {
		return smsPassCodeCaches;
	}
	/**
     * 获取短信时间缓存对象
     * @return
     */
	public FastMap<String, Object> getSmsPassCodeTime() {
		return smsPassCodeTime;
	}
	/**
	 * 设置登陆账号令牌map对象
	 * @param token 缓存Map中的key
	 * @param map 存放登陆后的相关信息(权限字符串、公司或单位对象、用户对象（可为空）、会员对象（可为空）)
	 * @return
	 */
	public boolean setTokenObject(String token,Map<String,Object> map){
		if(token!=null && !"".equals(token) && map!=null){
			tokenCache.put(token, map);
			return true;
		}
		return false;
	}
	/**
	 *获取令牌对象
	 * @param token
	 * @return
	 */
	public Map<String,Object> getTokenObject(String token){
		if(token==null || "".equals(token)){
			return null;
		}
		return (Map<String, Object>) tokenCache.get(token);
	}
	/**
	 * 验证令牌对象
	 * @param key
	 * @param token
	 * @return
	 */
	public boolean verifier(String key, String token){
		@SuppressWarnings("unchecked")
		Map<String, Object> v = (Map<String, Object>) tokenCache.get(key);
		return v == null || !v.equals(token) ? false : true;
		
	}
	/**
	 * 清空缓存
	 * @param key
	 */
	public void remove(String key) {
		tokenCache.remove(key);
	}
	
	/**
	 * 设置令牌生成时间
	 * @param loginName
	 * @param date
	 * @return
	 */
	public boolean setTokenTime(String token,Date date ){
		if(token==null || "".equals(token) || date==null || "".equals(date)){
			return false;
		}
		tokenTime.put(token,date);
		return true;
	}
	/**
	 * 获取令牌生成时间
	 * @param token
	 * @return
	 */
	public Map<String, Object> getTokenTime(String token){
		if(token==null || "".equals(token)){
			return null;
		}
		Map<String, Object> v = (Map<String, Object>) tokenTime.get(token);
		return v == null || !v.equals(token) ? null : v;
	}
	
	/**
	 * 设置短信验证码缓存
	 * @param mobile
	 * @param passCode
	 * @return
	 */
	public boolean setSmsPassCode(String mobile,String passCode){
		smsPassCodeCaches.put(mobile, passCode);
		return true;
	}
	
	/**
	 * 获取短信验证码缓存
	 * @param mobile
	 * @return
	 */
	public String getSmsPassCode(String mobile){
		return smsPassCodeCaches.get(mobile);
	}
	/**
	 * 设置短信验证码时间
	 * @param mobile
	 * @param date
	 * @return
	 */
	public boolean setSmsPassCodeTime(String mobile,Date date){
		smsPassCodeTime.put(mobile, date);
		return true;
	}
}
