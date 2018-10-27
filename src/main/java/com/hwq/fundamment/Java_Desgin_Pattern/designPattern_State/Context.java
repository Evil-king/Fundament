package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_State;

/**
 * @author hwq
 * @date 2018/10/18
 */
public class Context {

    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    public String stateMessage(){
        return state.getState();
    }
}
