package com.taillab.day01._01_reflect;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class MotherBoard {

	private static Properties p = new Properties();
	private static HashMap<String, IUSB> plugins = new HashMap<String, IUSB>();
	
	static {
		try {
//			ClassLoader loader = MotherBoard.class.getClassLoader();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			//从classpath的根目录去寻找plugins.properties
			InputStream inputStream = loader.getResourceAsStream("plugins.properties");
			p.load(inputStream);
			System.out.println("xxx"+p);
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//创建plugins.properties中配置的插件对象,把插件对象存储起来
	private static void init() throws Exception{
		Set<Object> keys = p.keySet();
		for (Object object : keys) {
			String name = (String)object;
			String className = p.getProperty(name);
			
			//使用反射创建对象,保证存在公共无参数的构造器
			Object obj = Class.forName(className).newInstance();
			
			//判断当前对象是否实现了IUSB规范
			if (!(obj instanceof IUSB)) {
				throw new RuntimeException(name+"not implument IUSB");
			}
			
			plugins.put(name, (IUSB)obj);
			
		}
		
	}
	
	public static void work() {
		for (IUSB iterable_element : plugins.values()) {
			iterable_element.swapData();
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(plugins);
	}
	

}
