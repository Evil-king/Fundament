package com.hwq.fundament.JavaDataStructure.stack;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

/**
 * @Auther: Administrator
 * @Date: 2020/2/27 0027 16:03
 * @Description: 逆波兰表达式(后缀表达式)
 * 中缀表达式对应的List =>后缀表达式对的List
 * 中缀表达式转成对应的list
 * 完成对逆波兰表达式的运算
 */
public class PolandNotation {
    public static void main(String[] args) {

        //完成一个中缀表达式转后缀表达式的功能
        //说明
        String suffixExpression = "1+((2+3)*4)-5"; //[1,+,(,(,2,+,3,),*,4,),-,5]
        List<String> list = toInfixExpressionList(suffixExpression);
        System.out.println("中缀表达式对应的list=" + list);
        List<String> pareSuffixExpressionList = pareSuffixExpressionList(list);
        System.out.println("后缀表达式对应的List="+pareSuffixExpressionList);


        int result = calculate(pareSuffixExpressionList);
        System.out.println("计算结果是=" + result);

//        String suffixExpression = "30 4 + 5 * 6 -";
//
//        //思路：1、先将"30 4 + 5 * 6 -"放入到ArrayList中
//        //2、将ArrayList传递给一个方法，遍历ArrayList配合栈 完成计算
//
//        List<String> listString = getListString(suffixExpression);
//        System.out.println("listString=" + listString);
//        int result = calculate(listString);
//        System.out.println("计算结果是=" + result);

    }

    //方法：将得到的中缀表达式对应的List =>后缀表达式对的List
    public static  List<String> pareSuffixExpressionList(List<String> ls){
        //定义一个栈
        Stack<String> s1 = new Stack<String>();
        List<String> s2 = Lists.newArrayList();

        //遍历ls
        for (String item:ls) {
            //如果是一个数，加入到s2
            if(item.matches("\\d+")){
                s2.add(item);
            } else if(item.equals("(")){
                s1.push(item);
            } else if(item.equals(")")){
                //如果是右括号“）”，则依次弹出s1栈顶的运算符，并压入到s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//将这个 ( 弹出s1栈，消除括号
            } else {
                //当item的优先级小于等于s1栈顶运算符，
                while (s1.size()!=0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出加入s2
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;//因为是存放到List，因此按顺序输出就是对应后缀表达式对应的List
    }



    //方法：将中缀表达式转成对应的list
    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = Lists.newArrayList();
        int i = 0;//这是一个指针，用于遍历 中缀表达式字符串
        String str;//对接多位数的拼接
        char c;//每遍历一个字符，就加入到c
        do {
            //如果c是一个非数字，则需要加入到ls集合中
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add(""+ c);
                i++;
            } else { //如果是一个数，需要考虑多位数
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }


    //将一个逆波兰表达式，依次将数据和运算符 放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = Lists.newArrayList();
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    /**
     * 1、从左至右扫描，将3和4压入堆栈
     * 2、遇到+运算符，因此弹出4和3(4为栈顶元素，3为次顶元素)，计算出3+4的值，得7，再将7入栈
     * 3、将5入栈
     * 4、接下来是*运算，因此弹出5和7 计算出7*5=35 将35入栈
     * 5、将6入栈
     * 6、最后是运算符，计算出35-6=29 由此得出最终结果
     */
    public static int calculate(List<String> ls) {
        //创建给栈，只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        //遍历ls
        for (String item : ls) {
            if (item.matches("\\d+")) { //匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                //pop两个数，病运算 再入栈
                int num1 = Integer.parseInt(stack.pop());//栈顶元素
                int num2 = Integer.parseInt(stack.pop());//次顶元素
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num2 - num1;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }

}

//编写一个类 Operation 可以返回一个运算符
class  Operation{
    private static int ADD  = 1;
    private static int SUB  = 1;
    private static int MUL  = 2;
    private static int DIV  = 2;

    //写一个防范，返回对应的优先级数字
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result  = ADD;
                break;
            case "-":
                result  = SUB;
                break;
            case "*":
                result  = MUL;
                break;
            case "/":
                result  = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }

}
