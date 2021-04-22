package com.hwq.fundamment.tools;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.sun.deploy.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class NoUtil {

    private static final Random random = new Random();

    /**
     * 线程安全的日期格式类
     */
    private static ThreadLocal<DateFormat> yyyyMMddHHmmss = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmss");
        }
    };

    private static ThreadLocal<DateFormat> yyMMdd = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyMMdd");
        }
    };

    public static String getPeriodNumFormat() {
        return yyMMdd.get().format(new Date());
    }

    public static String getPeriodNum(String flag, String periodNum, String gameCode) {
        if ("true".equals(flag)) {
            LocalDate date = LocalDate.now();
            periodNum = gameCode + date.toString().replace("-", "").substring(2);
            String initNum = "0001";
            return periodNum + initNum;
        } else {
            int dayStr = Integer.parseInt(periodNum.substring(3, 9));
            int nowStr = Integer.parseInt(getPeriodNumFormat());
            if (nowStr > dayStr) {
                return gameCode + NoUtil.getPeriodNumFormat() + "0001";
            } else {
                int num = Integer.parseInt(periodNum.substring(9));
                num++;
                if (String.valueOf(num).length() == 1) {
                    return gameCode + NoUtil.getPeriodNumFormat() + "000" + num;
                } else if (String.valueOf(num).length() == 2) {
                    return gameCode + NoUtil.getPeriodNumFormat() + "00" + num;
                } else if (String.valueOf(num).length() == 3) {
                    return gameCode + NoUtil.getPeriodNumFormat() + "0" + num;
                } else {
                    return gameCode + NoUtil.getPeriodNumFormat() + num;
                }
            }
        }
    }

    public static String addPeriodNum(String periodNum, String gameCode) {
        int dayStr = Integer.parseInt(periodNum.substring(3, 9));
        int nowStr = Integer.parseInt(getPeriodNumFormat());
        int num = Integer.parseInt(periodNum.substring(9));
        if (nowStr > dayStr) {
            return gameCode + NoUtil.getPeriodNumFormat() + "0001";
        } else {
            num++;
            if (String.valueOf(num).length() == 1) {
                return gameCode + NoUtil.getPeriodNumFormat() + "000" + num;
            } else if (String.valueOf(num).length() == 2) {
                return gameCode + NoUtil.getPeriodNumFormat() + "00" + num;
            } else if (String.valueOf(num).length() == 3) {
                return gameCode + NoUtil.getPeriodNumFormat() + "0" + num;
            } else {
                return gameCode + NoUtil.getPeriodNumFormat() + num;
            }
        }
    }

    public static String LastIssuePeriodNum(String periodNum, String gameCode){
        int num = Integer.parseInt(periodNum.substring(9));
        num--;
        if (String.valueOf(num).length() == 1) {
            return gameCode + NoUtil.getPeriodNumFormat() + "000" + num;
        } else if (String.valueOf(num).length() == 2) {
            return gameCode + NoUtil.getPeriodNumFormat() + "00" + num;
        } else if (String.valueOf(num).length() == 3) {
            return gameCode + NoUtil.getPeriodNumFormat() + "0" + num;
        } else {
            return gameCode + NoUtil.getPeriodNumFormat() + num;
        }
    }


    public static String addPeriodNum1(String gameCode, int num) {
        LocalDate date = LocalDate.now();
        String periodNum = gameCode + date.toString().replace("-", "").substring(2);
        if (num == 1 && StrUtil.isBlank(periodNum)) {
            String initNum = "0001";
            return periodNum + initNum;
        } else {
            if (String.valueOf(num).length() == 1) {
                return gameCode + NoUtil.getPeriodNumFormat() + "000" + num;
            } else if (String.valueOf(num).length() == 2) {
                return gameCode + NoUtil.getPeriodNumFormat() + "00" + num;
            } else if (String.valueOf(num).length() == 3) {
                return gameCode + NoUtil.getPeriodNumFormat() + "0" + num;
            } else {
                return gameCode + NoUtil.getPeriodNumFormat() + num;
            }
        }
    }


    public static String getPeriodNumDesc(String gameCode, int num){
        LocalDate date = LocalDate.now();
        String periodNum = gameCode + date.toString().replace("-", "").substring(2);
        if (num == 1 && StrUtil.isBlank(periodNum)) {
            return periodNum + "0001";
        } else {
            if (String.valueOf(num).length() == 1) {
                return gameCode + NoUtil.getPeriodNumFormat() + "000" + num;
            } else if (String.valueOf(num).length() == 2) {
                return gameCode + NoUtil.getPeriodNumFormat() + "00" + num;
            } else if (String.valueOf(num).length() == 3) {
                return gameCode + NoUtil.getPeriodNumFormat() + "0" + num;
            } else {
                return gameCode + NoUtil.getPeriodNumFormat() + num;
            }
        }
    }

    public static String getPeriodNumDesc(String flag, String periodNum, String gameCode) {
        if ("true".equals(flag)) {
            LocalDate date = LocalDate.now();
            periodNum = gameCode + date.toString().replace("-", "").substring(2);
            String initNum = "0001";
            return periodNum + initNum;
        } else {
            int dayStr = Integer.parseInt(periodNum.substring(3, 9));
            int nowStr = Integer.parseInt(getPeriodNumFormat());
            if (nowStr > dayStr) {
                return gameCode + NoUtil.getPeriodNumFormat() + "0001";
            } else {
                int num = Integer.parseInt(periodNum.substring(9));
                num--;
                if (String.valueOf(num).length() == 1) {
                    return gameCode + NoUtil.getPeriodNumFormat() + "000" + num;
                } else if (String.valueOf(num).length() == 2) {
                    return gameCode + NoUtil.getPeriodNumFormat() + "00" + num;
                } else if (String.valueOf(num).length() == 3) {
                    return gameCode + NoUtil.getPeriodNumFormat() + "0" + num;
                } else {
                    return gameCode + NoUtil.getPeriodNumFormat() + num;
                }
            }
        }
    }


    /**
     * 获取随机15位订单号
     *
     * @return
     */
    public static String getRamdomOrderNo() {
        return randomNumbers(15);
    }

    public static String randomNumbers(int length) {
        return randomString("0123456789", length);
    }

    public static String randomString(String baseString, int length) {
        StringBuffer sb = new StringBuffer();
        if (length < 1) {
            length = 1;
        }
        int baseLength = baseString.length();
        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(baseLength);
            sb.append(baseString.charAt(number));
        }
        return sb.toString();
    }

    public static String randomBigString() {
        String str = "";
        for (int i = 1; i <= 3; i++) {
            str = str + (char) (Math.random() * 26 + 'A');
        }
        return str;
    }



    public static void main(String[] args) {

        String str = "WUO2104211000";

        String gameCode = "WUO";


        String periodNumDesc1 = getPeriodNumDesc("", str, gameCode);
        System.out.println(periodNumDesc1);


        for (int i = 1000;i>=1;i--){
            String periodNumDesc = getPeriodNumDesc(gameCode, i);
//            System.out.println(periodNumDesc);
        }
    }
}
