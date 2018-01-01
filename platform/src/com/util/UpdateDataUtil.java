package com.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dbengine.dao.SqlDao;

@SuppressWarnings("rawtypes")
public class UpdateDataUtil {

	public static boolean updateData(String sourceId, String tableName, Map<String, Object> dataMap, String fieldName, Object fieldValue) {
		if (dataMap == null || sourceId == null || fieldName == null || "".equals(fieldName) || fieldValue == null || "".equals(fieldValue)) {
			return false;// 参数错误
		}
		SqlDao sqldao = new SqlDao();
		StringBuilder updateSql = new StringBuilder();
		updateSql.append("update ").append("`").append(tableName).append("`");
		updateSql.append(" set ");
			Iterator<String> iter = dataMap.keySet().iterator();
			String value = "";
			while (iter.hasNext()) {
				String key = iter.next();
				updateSql.append(key);
				value = (String) dataMap.get(key);
				if (value == null || "".equals(value)) {
					value = "";
				}
				updateSql.append(" = '"+value +"',");
			}
		updateSql.replace(updateSql.lastIndexOf(","), updateSql.length(), "");
		updateSql.append(" where ").append(fieldName).append(" = '").append(fieldValue).append("'");
		String totalSql = updateSql.toString();
		sqldao.executeSql("jdbcread", totalSql, false, null);
		return true;
	}
	public static void main(String[] args){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("unitName", "贵州云众之乐");
		dataMap.put("userMobile", "88888888");
		dataMap.put("userTel", "999999999");
		UpdateDataUtil.updateData("jdbcwrite", "user_info", dataMap, "userUUID", "bcdf7653-cf18-4949-af97-df929e26dfbc");
	}
}
