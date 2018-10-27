package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Proxy;

/**
 * 定义一种女人类型的王婆
 * 因为王婆太老  她需要找一个代理来为她去做事情
 */
public class WangPo implements KindWomen {

    private KindWomen kindWomen;


    public WangPo() {//默认的话，是潘金莲的代理
        this.kindWomen = new PanJinLian();
    }

    //她可以是KingWomen的任何一个女人的代理，只要你是这一类型
    public WangPo(KindWomen kindWomen) {
        this.kindWomen = kindWomen;
    }

    @Override
    public void makeEyesWithMen() {
        this.kindWomen.makeEyesWithMen();
    }

    @Override
    public void happyWithMan() {
        this.kindWomen.happyWithMan();
    }
}
