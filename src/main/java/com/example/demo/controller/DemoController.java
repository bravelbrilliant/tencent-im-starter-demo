package com.example.demo.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSON;
import cn.zhoushilan.im.entity.request.friend.CheckUser;
import cn.zhoushilan.im.helper.TencentIMHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private TencentIMHelper helper;

    @GetMapping(value = "/demo")
    public String demo() {

        CheckUser checkUser = new CheckUser();
        checkUser.setIsNeedDetail("1");
        checkUser.setToAccount(CollectionUtil.toList("1466589063648923649"));
        JSON imActionResponse = helper.queryOnlineStatus(checkUser);
        return imActionResponse.toJSONString(0);
    }
}