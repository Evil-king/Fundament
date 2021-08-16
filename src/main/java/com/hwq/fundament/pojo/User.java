package com.hwq.fundament.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Auther: Administrator
 * @Date: 2020/2/5 0005 10:12
 * @Description:
 */
@Data
@Accessors(chain = true)
public class User {
    private int id;
    private String username;
}
