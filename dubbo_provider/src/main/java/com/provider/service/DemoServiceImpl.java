package com.provider.service;


import com.api.service.DemoService;

/**
 * @author-liudongxu
 * @created 2018-11-13 17:00
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello"+name;
    }
}
