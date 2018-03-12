package com.smart.reflect;

public class PrivateCar {
    /*private通过传统的类实例调用方式,只能在本类中使用*/
   private String color;
    /*protected 通过传统的类实例调用方式,只能在本类及其子类中使用*/
   protected void drive(String color){
	   System.out.println("drive private car! the color is:"+color);
   }

    public String getColor() {
        return color;
    }
}
