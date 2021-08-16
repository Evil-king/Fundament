package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Proxy;

/**
 * 男人出场
 */
public class XiMenQing {

    public static void main(String[] args) {


        //把王婆叫出来
        WangPo wangPo = new WangPo();

        //然后男人就说，我要和潘金莲happy，然后王婆就安排男人丢筷子那出戏
        wangPo.makeEyesWithMen();//虽然表面上是王婆在做，实际是她的代理潘金莲在做
        wangPo.happyWithMan();

//        JiaShi jiaShi = new JiaShi();
//        //还是王婆做代理
//        wangPo = new WangPo(jiaShi);
//
//        wangPo.happyWithMan();
//        wangPo.makeEyesWithMen();
    }
}
