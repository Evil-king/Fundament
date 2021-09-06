package com.hwq.fundament.mybatis;

import com.google.common.collect.Maps;
import com.hwq.fundament.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2021/9/6 0006 10:05
 * @Description:
 */

interface UserMapper {
    @Select("select * from User where id = #{id} and name = #{name}")
    List<User> selectUserList(Integer id, String name);
}


public class Application {
    public static void main(String[] args) {
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(Application.class.getClassLoader(), new Class<?>[]{UserMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Select annotation = method.getAnnotation(Select.class);
                Map<String, Object> stringObjectMap = buildMethodArgNameMap(method, args);
                if(annotation != null) {
                    String[] values = annotation.value();
                    String sql = values[0];
                    System.out.println(sql);//select * from User where id = #{id} and name = #{name}
                    sql = parseSQL(sql,stringObjectMap);
                    System.out.println(sql);//select * from User where id = 1 and name = Marry
                }
                return null;
            }
        });
        userMapper.selectUserList(1, "Marry");
    }

    /**
     * 将参数替换sql中的变量
     * @param sql select * from User where id = #{id} and name = #{name}
     * @param stringObjectMap 参数
     * @return
     */
    public static String parseSQL(String sql, Map<String, Object> stringObjectMap) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sql.length(); i++) {
            char c = sql.charAt(i);
            if(c == '#'){
                int nextIndex = i +1;
                char nextChar = sql.charAt(nextIndex);
                if(nextChar != '{'){
                    throw new RuntimeException(String.format("这里应该为#{\nsql:%s\nindex:%d}",
                            sb.toString(),nextIndex));
                }
                StringBuilder argSB = new StringBuilder();
                i = parseSQLArg(argSB,sql,nextIndex);
                String argName = argSB.toString();
                Object argValue = stringObjectMap.get(argName);
                if(argValue == null){
                    throw new RuntimeException(String.format("找不到参数值:%s}",argName));
                }
                sb.append(argValue).toString();
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private static int parseSQLArg(StringBuilder argSB, String sql, int nextIndex) {
        nextIndex++;
        for (; nextIndex < sql.length(); nextIndex++) {
            char c = sql.charAt(nextIndex);
            if(c != '}'){
                argSB.append(c);
                continue;
            }
            if(c == '}'){
                return nextIndex;
            }
        }
        throw new RuntimeException(String.format("缺少右括号\nindex:%d}",nextIndex));
    }

    /**
     * 将代理对象的参数存放到map中
     * @param method
     * @param args
     * @return
     */
    public static Map<String, Object> buildMethodArgNameMap(Method method, Object[] args) {
        Map<String, Object> nameArgMap = Maps.newHashMap();
        int index[] = {0};
        Parameter[] parameters = method.getParameters();
        Arrays.asList(parameters).forEach(parameter -> {
            String name = parameter.getName();
            nameArgMap.put(name, args[index[0]]);
            index[0]++;
        });
        return nameArgMap;
    }
}
