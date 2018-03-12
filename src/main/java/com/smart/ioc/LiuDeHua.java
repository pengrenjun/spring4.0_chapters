package com.smart.ioc;


public class LiuDeHua implements GeLi {
   @Override
	public void responseAsk(String saying) {
		System.out.println("刘德华:"+saying);
	}
}
