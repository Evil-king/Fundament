package Java8.Function;

import com.hwq.fundamment.Java8.Function.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hwq
 * @date 2018/10/18
 * <p>
 *     什么是方法引用
 *    方法引用是只需要使用方法的名字，而具体调用交给函数式接口，需要和Lambda表达式配合使用
 *    方法引用分类
 *
 *    1、构造器方法引用
 *    格式： Class::new，调用默认构造器
 *    2、静态类方法引用
 *    格式： Class::static_method
 *    3、类普通方法引用
 *    格式： Class::method，方法不能带参数
 *    4、实例方法引用
 *    格式： instance::method
 * </p>
 */
public class Main {

    public static void main(String[] args) {
        List<User> list = intList();
        //1、构造器引用
        User newUser = User.create(User::new);
        newUser.setAge(1);
        newUser.setName("new");
        //2、静态类方法引用
        list.forEach(User::updateUsername);
        //3、类普通方法引用
        list.forEach(User::updateAge);
        //4、实例方法引用
        User user = new User();
        list.forEach(user :: changeAge);
        list.forEach(System.out::println);
    }

    private static List<User> intList() {
        List<User> list = new ArrayList<>();
        list.add(new User("zhangsan",18));
        list.add(new User("lisi",29));
        list.add(new User("fox",25));
        list.add(new User("Sb",23));
        list.add(new User("Daa",28));
        list.add(new User("XXX",19));
        return list;
    }

}
