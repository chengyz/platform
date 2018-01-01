package spark.utils.DownloadAndUploadFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <li>读取配置文件中的值类</li>
 * <li>根据传入的参数(键值),获得配置文件中的该键所对应的值</li>
 * 
 * @author LuoFuhai
 * @version 1.0
 * @since jdk1.6
 * @createDate 2011年11月22日 14:50:12
 * 
 */

public class ReadProperties {
	/* 配置文件路径*/
	private static String scipconfig = "/config.properties";
//	private static String sjlm_sql = "/com/chinaboxun/appportal/config/appportal_sql.properties";
	
	
	private static Properties properties = null;
	private static InputStream in = null;
	private static Class<ReadProperties> c = ReadProperties.class;

	/**
	 * 初始化配置文件
	 * 
	 * @author LuoFuhai
	 * @createDate 2011年11月22日 14:52:35
	 * @param fileName 文件名
	 */
	public static Properties initProperties(String fileName) {
		if (null == properties) {
			properties = new Properties();
		}
		try {
			in = (InputStream) c.getResourceAsStream(fileName);
			properties.load(in);
			return properties;
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * <li>读取mms_config配置文件中的值</li>
	 * 
	 * @param param
	 *            配置文件中的键
	 * @return String 配置文件中的键所对应的值
	 */
	public static String getSJLMConfig(String param) {
		try {
			initProperties(scipconfig);
			return properties.getProperty(param.trim());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	
	public static String getProperty(String propertyFile,String param) {
		try {
			
			initProperties(propertyFile);
			return properties.getProperty(param);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public static String getValue(String param) {
		try {
			initProperties(scipconfig);
			return properties.getProperty(param);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
}
