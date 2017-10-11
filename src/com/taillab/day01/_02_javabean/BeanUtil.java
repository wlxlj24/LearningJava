package com.taillab.day01._02_javabean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;

public class BeanUtil {
	
	public static HashMap<String, Object> bean2Map(Object bean) throws Exception {
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		//get javabean all property name and value
		BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
		PropertyDescriptor[] propertyDescriptor = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : propertyDescriptor) {
			String propertyName = pd.getName();
			Object propertyValue = pd.getReadMethod().invoke(bean);
			map.put(propertyName, propertyValue);
		}
		
		return map;
	}
	
	public static <T>T map2bean(HashMap<String, Object> map,Class<T> beanType) throws Exception {
		T object = beanType.newInstance();
		
		BeanInfo beanInfo = Introspector.getBeanInfo(beanType);
		PropertyDescriptor[] propertyDescriptor = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : propertyDescriptor) {
			String propertyName = pd.getName();
			Object propertyValure = map.get(propertyName);
			pd.getWriteMethod().invoke(object, propertyValure);
			
		}
		
		return object;
	}
	
	public static void main(String[] args) throws Exception {
		
		Person person = new Person(0, "Chris", 11, true);
		HashMap<String, Object> map = BeanUtil.bean2Map(person);
//		System.out.println(map);
		
		Person person2 = BeanUtil.map2bean(map, Person.class);
		System.out.println(person2);
		
	}
}
