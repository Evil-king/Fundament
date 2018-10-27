package com.hwq.fundamment.Java_Desgin_Pattern.designPatten_FactoryMethod;


import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *     工程方法模式还有一个非常重要的应用，就是延迟初始化(Lazy initialization)，什么是延迟初始化呢？
 * 一个对象初始化完毕后就不释放，等到再次用得到就不用再初始化了，直接从内存种拿过来就可以了。
 */
public class HumanFactory {

    //定义一个Map,初始化过的human对象都放这里
    private  static HashMap<String, Human> humans = new HashMap<String, Human>();

    public static Human createHuman(Class c){
        Human human = null;//定义一个类型的人类

        try {
            //如果Map中有，则直接从里面取出来，不用初始化了
            if(humans.containsKey(c.getSimpleName())){
                human = humans.get(c.getSimpleName());
            } else {
                human = (Human) Class.forName(c.getName()).newInstance();
                //放到Map中
                humans.put(c.getSimpleName(), human);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.out.println("必须制定人种的颜色");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("人种定义错误");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("混蛋，你指定的人种找不到");
        }
        return human;
    }

    //一个创建人类的方法
    public static Human createHuman(){
        Human human = null; //定义一个类型的人类
        //首先是获得又多少个实现类，多少个人种
        List<Class<?>> classList = ClassUtils.getAllClassByInterface(Human.class);//定义多少人种
        //八卦炉自己开始想烧出什么人就什么人
        Random random  = new Random();
        int rand= random.nextInt(classList.size());
        human =createHuman(classList.get(rand));

        return human;
    }
}
