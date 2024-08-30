package com.omega.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class TestController
 *
 * @author KennySo
 * @date 2024/8/30
 */
@Controller
public class TestController {

    @RequestMapping("/hi")
    public String hi() {
        System.out.println("TestController-hi");
        return "hi";
    }
}
