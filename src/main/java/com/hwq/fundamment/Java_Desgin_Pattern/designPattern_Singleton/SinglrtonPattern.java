package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Singleton;

/**
 * 1、懒汉式，线程安全
 * 2、双重检验锁
 * 3、饿汉式 static final field
 * 4、静态内部类 static nested classAdapter
 * 5、枚举 Enum
 */
public class SinglrtonPattern {



    /**
     * 1、懒汉式，线程安全
     * 为了解决上面的问题，最简单的方法是将整个 getInstance() 方法设为同步（synchronized）
     */
//    private static SinglrtonPattern singlrtonPattern = null;
//
//    private SinglrtonPattern() {
//    }
//    public static synchronized SinglrtonPattern getInstance(){
//        if(singlrtonPattern == null){
//            singlrtonPattern = new SinglrtonPattern();
//        }
//        return singlrtonPattern;
//    }

    /**
     * 2、双重检验锁
     * 双重检验锁模式（double checked locking pattern），是一种使用同步块加锁的方法。
     * 程序员称其为双重检查锁，因为会有两次检查 instance == null，一次是在同步块外，一次是在同步块内。
     * 为什么在同步块内还要再检验一次？因为可能会有多个线程一起进入同步块外的 if，
     * 如果在同步块内不进行二次检验的话就会生成多个实例了
     *
     * 存在问题:
     * 这段代码看起来很完美，很可惜，它是有问题。主要在于instance = new Singleton()这句，这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情。
     *
     * 给 instance 分配内存
     * 调用 Singleton 的构造函数来初始化成员变量
     * 将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
     * 但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，
     * 最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，
     * 这时 instance 已经是非 null 了（但却没有初始化），所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。
     */

//    private static SinglrtonPattern singlrtonPattern = null;
//
//    private SinglrtonPattern() {
//    }
//    private static volatile  SinglrtonPattern singlrtonPattern = null;
//    public static SinglrtonPattern getInstance(){
//        if(singlrtonPattern == null){
//            synchronized (SinglrtonPattern.classAdapter){
//               if(singlrtonPattern == null){
//                   singlrtonPattern = new SinglrtonPattern();
//               }
//            }
//        }
//        return singlrtonPattern;
//    }

    /**
     * 3、饿汉式 static final field
     *
     * 这种方法非常简单，因为单例的实例被声明成 static 和 final 变量了，
     * 在第一次加载类到内存中时就会初始化，所以创建实例本身是线程安全的
     *
     * 缺点：
     * 缺点是它不是一种懒加载模式（lazy initialization），单例会在加载类后一开始就被初始化，
     * 即使客户端没有调用 getInstance()方法。饿汉式的创建方式在一些场景中将无法使用：
     * 譬如 SinglrtonPattern 实例的创建是依赖参数或者配置文件的，
     *  getInstance() 之前必须调用某个方法设置参数给它，那样这种单例写法就无法使用了。
     */
    //类加载时就初始化

//    private SinglrtonPattern() {
//    }
//    private static final SinglrtonPattern instance = new SinglrtonPattern();
//    public static SinglrtonPattern getInstance(){
//        return instance;
//    }

    /**
     * 4、静态内部类 static nested classAdapter
     * 比较倾向于使用静态内部类的方法，这种方法也是《Effective Java》上所推荐的
     *
     * 这种写法仍然使用JVM本身机制保证了线程安全问题；由于 SingletonHolder 是私有的，
     * 除了 getInstance() 之外没有办法访问它，因此它是懒汉式的；同时读取实例的时候不会进行同步，
     * 没有性能缺陷；也不依赖 JDK 版本。
     */
//    private static classAdapter SingletonHolder {
//        private static final SinglrtonPattern INSTANCE = new SinglrtonPattern();
//    }
//    private SinglrtonPattern (){}
//    public static final SinglrtonPattern getInstance() {
//        return SingletonHolder.INSTANCE;
//    }


    /**
     * 5、枚举 Enum
     * 我们可以通过EasySingleton.INSTANCE来访问实例，
     * 这比调用getInstance()方法简单多了。创建枚举默认就是线程安全的，
     * 所以不需要担心double checked locking，而且还能防止反序列化导致重新创建新的对象。
     * 但是还是很少看到有人这样写，可能是因为不太熟悉吧。
     */
    public enum SomeThing {
        INSTANCE;
        private SinglrtonPattern singlrtonPattern;
        SomeThing() {
            singlrtonPattern = new SinglrtonPattern();
        }
        public SinglrtonPattern getInstance() {
            return singlrtonPattern;
        }
    }

    public static void testName(){
        System.out.println("我就是XXXX");
    }
}
