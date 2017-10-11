package com.taillab.day01._02_javabean;

public class Person {
	private long id;
	private String name;
	private Integer age;
	private boolean man;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public boolean isMan() {
		return man;
	}
	public void setMan(boolean man) {
		this.man = man;
	}
	public Person(long id, String name, Integer age, boolean man) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.man = man;
	}
	
}
