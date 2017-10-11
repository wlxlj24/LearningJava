package com.taillab.day01._01_reflect;

//遵循USB规范的鼠标
public class Mouse implements IUSB {

	@Override
	public void swapData() {
		System.out.println("鼠标在移动.....");

	}

}
