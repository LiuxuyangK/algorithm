package com.springmvc.lxy.service.impl;

import com.springmvc.lxy.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 描述: ${description}
 * <p>
 *
 * @author: harry
 * @date: 2018-08-31
 **/
@Service
public class UserServiceImple implements UserService {
    @Override
    public String getUser1() {
        System.out.println("use1");
        return "user1";
    }
}
