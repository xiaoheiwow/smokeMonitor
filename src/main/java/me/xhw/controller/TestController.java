package me.xhw.controller;

import me.xhw.service.RabbitmqService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaoheiwow
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private RabbitmqService rabbitmqService;
    /**
     * 发送消息
     */
    @PostMapping("/sendMsg")
    public String sendMsg(@RequestParam(name = "msg") String msg) throws Exception {
        return rabbitmqService.sendMsg(msg);
    }

}
