package me.xhw.service.impl;

import me.xhw.config.RabbitmqConfig;
import me.xhw.service.RabbitmqService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author xiaoheiwow
 */
@Service
public class RabbitmqServiceImpl implements RabbitmqService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public String sendMsg(String msg) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String msgId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
            String sendTime = sdf.format(new Date());
            Map<String, Object> map = new HashMap<>(16);
            map.put("msgId", msgId);
            map.put("sendTime", sendTime);
            map.put("msg", msg);
            rabbitTemplate.convertAndSend(RabbitmqConfig.RABBITMQ_DEMO_DIRECT_EXCHANGE, RabbitmqConfig.RABBITMQ_DEMO_DIRECT_ROUTING, map);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public String getMsg() {
        Object o = rabbitTemplate.receiveAndConvert("rabbitmq.demo.direct");
        if(ObjectUtils.isEmpty(o)){
            return "queue is empty now !";
        }
        return o.toString();
    }
}
