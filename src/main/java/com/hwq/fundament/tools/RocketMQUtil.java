//package com.hwq.fundament.tools;
//
//import cn.hutool.core.exceptions.ExceptionUtil;
//import com.alibaba.fastjson.JSON;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.common.message.Message;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.io.UnsupportedEncodingException;
//import java.nio.charset.StandardCharsets;
//
///**
// * @author:
// * @description: RocketMQ工具类
// */
//@Component
//@Slf4j
//public class RocketMQUtil {
//
//    public RocketMQUtil() {
//        log.info("RocketMQUtil started.");
//    }
//
//    // 消息发送成功状态
//    public static final String SUCCESS = "success";
//    // 消息发送失败状态
//    public static final String FAIL = "fail";
//    // 处理状态，待处理
//    public static final String WAIT = "wait";
//    // 处理状态：已处理
//    public static final String PROCESSED = "processed";
//
//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;
////    @Autowired
////    private IRocketmqMsgService rocketmqMsgService;
//
//
//    /**
//     * 发送事务消息
//     *
//     * @param txProducerGroup
//     * @param topics
//     * @param msg
//     * @param keys
//     */
//    public void sendMessageInTransaction(String txProducerGroup, String topics, String msg, String keys) {
//        sendMessageInTransaction(txProducerGroup, topics, msg, null, keys);
//    }
//
//    /**
//     * 发送事务消息
//     *
//     * @param txProducerGroup
//     * @param topics
//     * @param msg
//     * @param keys
//     */
//    public void sendMessageInTransaction2(String txProducerGroup, String topics, String msg, String keys, String arg) {
//        sendMessageInTransaction2(txProducerGroup, topics, msg, null, keys,arg);
//    }
//
//    /**
//     * 发送事务消息
//     *
//     * @param txProducerGroup
//     * @param topics
//     * @param msg
//     * @param keys
//     */
//    public void sendMessageInTransaction(String txProducerGroup, String topics, String msg, String tags, String keys) {
//        if (StringUtils.isEmpty(topics)) {
//            throw new IllegalArgumentException("topics cannot be null");
//        }
//        if (StringUtils.isEmpty(msg)) {
//            throw new IllegalArgumentException("msg cannot be null");
//        }
//        Message sendMsg = new Message(topics, msg.getBytes());
//        // 设置消息tags
//        if (!StringUtils.isEmpty(tags)) {
//            sendMsg.setTags(tags);
//        }
//        // 设置消息key，要求唯一
//        if (!StringUtils.isEmpty(keys)) {
//            sendMsg.setKeys(keys);
//        }
//        org.springframework.messaging.Message<?> message = org.apache.rocketmq.spring.support.RocketMQUtil.convertToSpringMessage(sendMsg);
//        SendResult sendResult = rocketMQTemplate.sendMessageInTransaction(txProducerGroup, topics, message,null);
//        log.info("RocketMQ sendMessageInTransaction，topics={}，tags={}，keys={}，msg={}，sendResult={}", topics, tags, keys, msg, JSON.toJSONString(sendResult));
//    }
//
//
//    /**
//     * 发送事务消息
//     *
//     * @param txProducerGroup
//     * @param topics
//     * @param msg
//     * @param keys
//     */
//    public void sendMessageInTransaction2(String txProducerGroup, String topics, String msg, String tags, String keys, String arg) {
//        if (StringUtils.isEmpty(topics)) {
//            throw new IllegalArgumentException("topics cannot be null");
//        }
//        if (StringUtils.isEmpty(msg)) {
//            throw new IllegalArgumentException("msg cannot be null");
//        }
//        Message sendMsg = new Message(topics, msg.getBytes());
//        // 设置消息tags
//        if (!StringUtils.isEmpty(tags)) {
//            sendMsg.setTags(tags);
//        }
//        // 设置消息key，要求唯一
//        if (!StringUtils.isEmpty(keys)) {
//            sendMsg.setKeys(keys);
//        }
//        org.springframework.messaging.Message message = org.apache.rocketmq.spring.support.RocketMQUtil.convertToSpringMessage(sendMsg);
//        SendResult sendResult = rocketMQTemplate.sendMessageInTransaction(txProducerGroup, topics, message, arg);
//        log.info("RocketMQ sendMessageInTransaction，topics={}，tags={}，keys={}，msg={}，sendResult={}", topics, tags, keys, msg, JSON.toJSONString(sendResult));
//    }
//
//
//    /**
//     * 发送消息
//     *
//     * @param topics
//     * @param msg
//     * @param keys
//     */
//    public void sendMsg(String topics, String msg, String keys) {
//        sendMsg(topics, msg, null, keys, null);
//    }
//
//    /**
//     * 发送消息
//     *
//     * @param topics
//     * @param msg
//     * @param keys
//     * @param delayLevel
//     */
//    public void sendMsg(String topics, String msg, String keys, Integer delayLevel) {
//        sendMsg(topics, msg, null, keys, delayLevel);
//    }
//
//    /**
//     * 发送消息
//     *
//     * @param topics
//     * @param msg
//     * @param tags
//     * @param keys
//     */
//    public void sendMsg(String topics, String msg, String tags, String keys) {
//        sendMsg(topics, msg, tags, keys, null);
//    }
//
//
//    /**
//     * 发送消息
//     * Notice：消息发送异常不对外抛出，定时任务轮询tbl_rocketmq_msg消息表，获取发送失败的消息进行重发
//     *
//     * @param topics
//     * @param msg
//     * @param tags
//     * @param keys
//     * @param delayLevel
//     */
//    public void sendMsg(String topics, String msg, String tags, String keys, Integer delayLevel) {
//        if (StringUtils.isEmpty(topics)) {
//            throw new IllegalArgumentException("topics cannot be null");
//        }
//        if (StringUtils.isEmpty(msg)) {
//            throw new IllegalArgumentException("msg cannot be null");
//        }
//        Message sendMsg = new Message(topics, msg.getBytes());
//        // 设置消息tags
//        if (!StringUtils.isEmpty(tags)) {
//            sendMsg.setTags(tags);
//        }
//        if (!StringUtils.isEmpty(keys)) {
//            // 设置消息key，要求唯一
//            sendMsg.setKeys(keys);
//        }
//        //设置延迟的级别，messageDelayLevel=1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
//        if (delayLevel != null && delayLevel > 0) {
//            sendMsg.setDelayTimeLevel(delayLevel);
//        }
//        String sendStatus = SUCCESS;
//        String reason = "";
//        SendResult sendResult = null;
//        try {
//            sendResult = rocketMQTemplate.getProducer().send(sendMsg);
//        } catch (Exception e) {
//            log.info("==> RocketMQ sendMsg fail，topics:{}, msg:{} ", topics, msg);
//            sendStatus = FAIL;
//            reason = ExceptionUtil.getMessage(e);
//        }
//        log.info("==> RocketMQ sendMsg {}，topics={}，tags={}，keys={}，msg={}，sendResult={}", sendStatus, topics, tags, keys, msg, JSON.toJSONString(sendResult));
//        // 消息入库
////        RocketmqMsg rocketmqMsg = new RocketmqMsg();
////        rocketmqMsg.setId(IdWorker.getId());
////        rocketmqMsg.setTopic(topics);
////        rocketmqMsg.setTags(tags);
////        rocketmqMsg.setMessageKey(keys);
////        rocketmqMsg.setMessageContent(msg);
////        rocketmqMsg.setSendStatus(sendStatus);
////        rocketmqMsg.setReason(reason);
////        rocketmqMsg.setCreateTime(new Date());
////        rocketmqMsgService.save(rocketmqMsg);
//    }
//
//
//    /**
//     * 传入秒，获取延迟级别的值
//     *
//     * @param second
//     * @return
//     */
//    public Integer getDelayLevelBySecond(int second) {
//        switch (second) {
//            case 1: // 1s
//                return 1;
//            case 5: // 5s
//                return 2;
//            case 10: // 10s
//                return 3;
//            case 30: // 30s
//                return 4;
//            case 60: // 1m
//                return 5;
//            case 120: // 2m
//                return 6;
//            case 180: // 3m
//                return 7;
//            case 240: // 4m
//                return 8;
//            case 300: // 5m
//                return 9;
//            case 360: // 6m
//                return 10;
//            case 420: // 7m
//                return 11;
//            case 480: // 8m
//                return 12;
//            case 540: // 9m
//                return 13;
//            case 600: // 10m
//                return 14;
//            case 1200: // 20m
//                return 15;
//            case 1800: // 30m
//                return 16;
//            case 3600: // 1h
//                return 17;
//            case 7200:
//                return 18;
//            default:
//                return null;
//        }
//    }
//
//    public static String getStrFromByte(byte[] val) {
//        String result = null;
//        result = new String(val, StandardCharsets.UTF_8);
//        return result;
//    }
//
//    /**
//     * 从org.springframework.messaging.Message获取消息对象
//     *
//     * @param message
//     * @param clazz
//     * @param <T>
//     * @return
//     * @throws UnsupportedEncodingException
//     */
//    public static <T> T getObjFromMessage(org.springframework.messaging.Message message, Class<T> clazz) {
//        if (message == null || message.getPayload() == null) {
//            return null;
//        }
//        String s = getStrFromByte((byte[]) message.getPayload());
//        if (StringUtils.isEmpty(s)) {
//            return null;
//        }
////        return JacksonUtil.jsonToBean(s, clazz);
//        return null;
//    }
//}