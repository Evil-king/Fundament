package com.hwq.fundamment.test.Decorator;

/**
 * @author hwq
 * @date 2019/04/05
 * <p>
 *     装饰角色    拓展了发送短信的功能
 * </p>
 */
public interface DecoratorService extends ComponentSerevice{
    @Override
    String login(String username, String password);

    String sendShortMessage(String msg);
}
