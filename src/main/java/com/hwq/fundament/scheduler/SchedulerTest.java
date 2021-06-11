package com.hwq.fundament.scheduler;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SchedulerTest {
    @Scheduled(fixedRate = 2000)
    public void scheduledTask() {
        String url = "https://zhibo.2020kj.com:777/js/i1i1i1i1i1l1l1l1l0.js?_=1622046708002";
        String resultApi = HttpRequest.get(url)
                .header(Header.USER_AGENT,
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.111 Safari/537.36")
                .execute()
                .body();
        if (resultApi.contains("502 Bad Gateway")) {
        }
        JSONObject jsonObject = JSONUtil.parseObj(resultApi);
        String[] str = jsonObject.getStr("k").split(",");
        String openCode = str[1] + "," + str[2] + "," + str[3] + "," + str[4] + "," + str[5] + "," + str[6] + "," + str[7];
        if(StrUtil.isNotEmpty(openCode)){
            log.info("openCode={}",openCode);
        }
    }
}
