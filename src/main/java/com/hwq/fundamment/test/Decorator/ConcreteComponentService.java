package com.hwq.fundamment.test.Decorator;

/**
 * @author hwq
 * @date 2019/04/05
 * <P>
 *     具体构件角色    登录的具体实现
 * </P>
 */
public class ConcreteComponentService implements ComponentSerevice{

    @Override
    public String login(String username, String password) {
        return "SUCCESS";
    }
}
