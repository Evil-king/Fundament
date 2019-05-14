package com.hwq.fundamment.Java_Desgin_Pattern.desginPattern_AbstractFactoryMethod;


public abstract class AbstractHumanFactory implements HumanFactory {


    protected Human createHuman(HumanEnum humanEnum) {
        Human human = null;

        if (!humanEnum.getValue().equals("")) {
            try {
                //直接产生一个实例
                human = (Human) Class.forName(humanEnum.getValue()).newInstance();
            } catch (Exception e) {
                //因为使用enum，这种异常情况不会产生，除非你的enum有问题
            }
        }
        return human;
    }
}

