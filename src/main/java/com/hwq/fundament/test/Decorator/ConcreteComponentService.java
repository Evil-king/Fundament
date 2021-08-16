package com.hwq.fundament.test.Decorator;

/**
 * @author hwq
 * @date 2019/04/05
 * <p>
 * 具体构件角色    登录的具体实现
 * </P>
 */
public class ConcreteComponentService implements ComponentSerevice {

    @Override
    public String login(String username, String password) {
        return "SUCCESS";
    }
}
