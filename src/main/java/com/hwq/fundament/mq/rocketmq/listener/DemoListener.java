package com.hwq.fundament.mq.rocketmq.listener;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
// notice：如果指定了tags，consumerGroup的值应该为：（topics名称）+（tags名称）+（-consumerGroup）
@RocketMQMessageListener(topic = "Topic-game", consumerGroup = "Topic-Game-consumerGroup")
public class DemoListener implements RocketMQListener<MessageExt> {
    // 消费失败最大重试次数
    @Value("1")
    private String maxReconsumeTimes;

    @Override
    public void onMessage(MessageExt message) {
        consumeMessage(message);
    }

    public ConsumeConcurrentlyStatus consumeMessage(MessageExt message){
        try {
            String body = new String(message.getBody(),"UTF-8");
            int reconsumeTimes = message.getReconsumeTimes();
            log.info("++++++++++++++++++++++++++++++reconsumeTimes={}", reconsumeTimes);
            if (reconsumeTimes > Integer.valueOf(maxReconsumeTimes)) {
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;  //超过最大重试次数 则不在重试
            }
            JSONObject parseObj = JSONUtil.parseObj(body);//这里能获取到所需要的参数
            //TODO doSome(parseObj) //处理业务逻辑
        } catch (Exception e){
            return ConsumeConcurrentlyStatus.RECONSUME_LATER; //重试消费
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}