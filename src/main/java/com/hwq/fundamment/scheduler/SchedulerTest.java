package com.hwq.fundamment.scheduler;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.hwq.fundamment.pojo.PublicLotteryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SchedulerTest {
    @Scheduled(fixedRate = 3000)
    public void scheduledTask() {
        String url = HttpUtil.get("https://backs.qdruibo.com/lottery-client-api/races/min/10002?issue=0");
        try {
            JSONObject jsonObject = JSONUtil.parseObj(url);
            int code = Integer.parseInt(jsonObject.getStr("code"));
            if (code == 0) {
                JSONObject jsonObject1 = JSONUtil.parseObj(jsonObject.getStr("content"));
                PublicLotteryDto publicLotteryDto = new PublicLotteryDto();
                publicLotteryDto.setDrawDate(jsonObject1.getDate("pdd"));//开奖日期
                publicLotteryDto.setGameCode("jspk10");
                publicLotteryDto.setModelCode("PK10");
                publicLotteryDto.setNextOpenIssue(jsonObject1.getStr("di"));//下期开奖期号
                publicLotteryDto.setNextOpenTime(jsonObject1.getDate("dt"));//下期开奖时间
                publicLotteryDto.setDrawTime(jsonObject1.getDate("pdt"));//开奖时间
                publicLotteryDto.setOutNumber(dealWithToStr(jsonObject1.getStr("pdc").replace("[","").replace("]",""), "PK10"));//开出号码
                publicLotteryDto.setPeriodNum(jsonObject1.getStr("pdi"));//当前期号
                publicLotteryDto.setStatus("waiting");
                log.info("publicLotteryDto={}", com.alibaba.fastjson.JSONObject.toJSONString(publicLotteryDto));

            }
        } catch (Exception e) {
            log.info("e={}",e);
        }
    }

    //处理api抓去回来的开奖号码
    public String dealWithToStr(String outNum, String modelCode) {
        StringBuilder resultList = new StringBuilder();
        String[] split = outNum.replace("", "").split(",");
        if ("PK10".equals(modelCode)) {  //PK10模型
            for (int i = 0; i < split.length; i++) {
                if (i == split.length - 1) {
                    if ("0".equals(split[i].substring(0, 1))) {
                        resultList.append(split[i].substring(1, 2));
                    } else {
                        resultList.append(split[i]);
                    }
                } else {
                    if ("0".equals(split[i].substring(0, 1))) {
                        resultList.append(split[i].substring(1, 2)).append(",");
                    } else {
                        resultList.append(split[i]).append(",");
                    }
                }
            }
        } else if ("PC28".equals(modelCode) || "11X5".equals(modelCode) || "SSC".equals(modelCode)) {
            for (int i = 0; i < split.length; i++) {
                if (i == split.length - 1) {
                    resultList.append(split[i]);
                } else {
                    resultList.append(split[i]).append(",");
                }
            }
        } else if ("Lottery".equals(modelCode)) { //香港六合彩、新加坡多多、澳门六合彩
            for (int i = 0; i < split.length; i++) {
                if (i == split.length - 1) {
                    if (1 == split[i].length()) {
                        split[i] = "0" + split[i];
                        resultList.append(split[i]);
                    } else {
                        resultList.append(split[i]);
                    }
                } else {
                    if (1 == split[i].length()) {
                        split[i] = "0" + split[i];
                        resultList.append(split[i]).append(",");
                    } else {
                        resultList.append(split[i]).append(",");
                    }
                }
            }
        } else if ("FT".equals(modelCode)) {
            int dealWithNum = Integer.parseInt(split[7]) + Integer.parseInt(split[8]) + Integer.parseInt(split[9]);
            if (dealWithNum % 4 == 0) {
                resultList.append("4");
            } else {
                resultList.append(dealWithNum % 4 + "");
            }
        }
        return resultList.toString();
    }
}
