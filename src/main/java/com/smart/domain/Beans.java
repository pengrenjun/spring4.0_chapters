package com.smart.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*配置信息提供类*/
@Configuration
public class Beans {

    /*定义一个bean*/
    @Bean(name="car")
    public Car buildCar(){

        Car car=new Car();
        car.setBrand("奔驰");
        car.setColor("red");
        car.setMaxSpeed(1000);

        return  car;
    }


}
