package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_State;

/**
 * @author hwq
 * @date 2018/10/18
 */
public class StateTest {

    public static void main(String args[]){
        Context context=new Context();
        context.setState(new Rain());
        System.out.println(context.stateMessage());
        context.setState(new Sunshine());
        System.out.println(context.stateMessage());
    }
}
