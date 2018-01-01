/**
 * 
 */
package com.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * 说明 map和object互转
 * @author zhangmeng
 * 添加时间 2016年5月18日 下午1:07:37
 *
 */
public class MapUtil {
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass){    
        if (map == null)  
            return null; 
        Object obj = null;
        try {
        	obj = beanClass.newInstance();  
            Field[] fields = obj.getClass().getDeclaredFields();   
            for (Field field : fields) {    
                int mod = field.getModifiers();    
                if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){    
                    continue;    
                }    
      
                field.setAccessible(true);    
                field.set(obj, map.get(field.getName()));   
            }  
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return obj;   
    }    
  
    public static Map<String, Object> objectToMap(Object obj){
    	if(obj == null){    
    		return null;    
    	}   
    	Map<String, Object> map = new HashMap<String, Object>();    
    	try {
    		Field[] declaredFields = obj.getClass().getDeclaredFields();    
    		for (Field field : declaredFields) {    
    			field.setAccessible(true);  
    			map.put(field.getName(), field.get(obj));  
    		}    

    	} catch (Exception e) {
    		e.printStackTrace();
    	}

    	return map;  
    }
}
