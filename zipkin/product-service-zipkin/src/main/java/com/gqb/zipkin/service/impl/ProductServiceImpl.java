package com.gqb.zipkin.service.impl;


import com.gqb.zipkin.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {


    @Override
    public Map getProduct() {

        Map map = new HashMap();
        map.put("name","手机");
        map.put("price","1000");
        return map;
    }
}
