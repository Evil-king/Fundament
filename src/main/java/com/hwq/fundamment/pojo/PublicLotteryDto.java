package com.hwq.fundamment.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class PublicLotteryDto {
    private String modelCode;
    private String gameCode;
    private String periodNum;
    private Date drawTime;
    private Date drawDate;
    private String outNumber;
    private String nextOpenIssue;
    private Date nextOpenTime;
    private String secondOpenIssue;
    private Date secondOpenTime;
    private String status;
}
