package com.smart.ioc;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class TwoPlugin implements  Plugin {


}
