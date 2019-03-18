静态代理是通过在代码中显式定义一个业务实现类一个代理，在代理类中对同名的业务方法进行包装，用户通过代理类调用被包装过的业务方法；

    JDK动态代理是通过接口中的方法名，在动态生成的代理类中调用业务实现类的同名方法；
    Object result = method.invoke(target, args);

    CGlib动态代理是通过继承业务类，生成的动态代理类是业务类的子类，通过重写业务方法进行代理
     Object result = methodProxy.invokeSuper(objects, args);