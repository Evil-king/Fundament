package com.hwq.fundamment.Java_Desgin_Pattern.desginPattern_ChainOfResponsibility;


/**
 * @author hwq
 * @date 2018/10/18
 * <p>
 * 项目经理
 * </p>
 */
public class ProjectHandler extends ConsumeHandler {
    @Override
    public void doHandler(String user, double free) {
        if (free < 500) {

            if (user.equals("lwx")) {
                System.out.println("给予报销:" + free);
            } else {
                System.out.println("报销不通过");
            }

        } else {
            if (getNextHandler() != null) {

                getNextHandler().doHandler(user, free);
            }
        }

    }
}
