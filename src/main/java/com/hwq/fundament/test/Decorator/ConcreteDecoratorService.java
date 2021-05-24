package com.hwq.fundament.test.Decorator;

/**
 * @author hwq
 * @date 2019/04/05
 * <p>
 * 具体的装饰角色    原有的登录功能增加了发送短信的功能
 * </p>
 */
public class ConcreteDecoratorService implements DecoratorService {

    private ComponentSerevice componentSerevice;


    public ConcreteDecoratorService(ComponentSerevice componentSerevice) {
        this.componentSerevice = componentSerevice;
    }

    @Override
    public String login(String username, String password) {
        if (username.equalsIgnoreCase("fox") && password.equalsIgnoreCase("123")) {
            String msg = componentSerevice.login(username, password);
            if (msg.equalsIgnoreCase("SUCCESS")) {
                return sendShortMessage(username);
            }
            return "";
        } else
            return "用户名或者密码有误";
    }

    @Override
    public String sendShortMessage(String msg) {
        return ("恭喜用户：" + msg + "发送短信成功");
    }
}
