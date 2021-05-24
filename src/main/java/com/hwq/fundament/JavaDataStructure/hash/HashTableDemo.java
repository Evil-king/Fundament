package com.hwq.fundament.JavaDataStructure.hash;

/**
 * @Auther: Administrator
 * @Date: 2020/3/9 0009 11:08
 * @Description:哈希表
 */
public class HashTableDemo {
    public static void main(String[] args) {

    }
}

//创建HashTable 管理多条链表
class HashTable {
    private EmpLinkedList[] empLinkedListArray;
    private int size;//表示共有多少条

    //构造器
    public HashTable(int size) {
        this.size = size;
        //初始化 empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //这时不要忘了分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工id，得到该员工应该加到哪个链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp加入到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //遍历所有的链表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //根据输入的id查找雇员
    public void findById(int id) {
        //使用散列函数确定到哪条链表
        int emplinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[emplinkedListNo].fingById(id);
        if (emp != null) {
            System.out.printf("在第%d条链表中 找到该雇员id=%d\n",(emplinkedListNo+1),id);
        } else {
            System.out.println("在哈希表中，没有找到该雇员");
        }
    }

    //编写散列函数，使用一个简单的取模法
    public int hashFun(int id) {
        return id % size;
    }
}


//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next;//默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//创建一个EmpLinkedList，表示链表
class EmpLinkedList {
    //头指针，指向第一个Emp，因此我们这个链表的head 是直接指向第一个Emp
    private Emp head;//默认是null

    //添加雇员到链表
    //说明
    //1、假定，当添加雇员时，id为自增长，即ID的分配总是从小到大
    //因此将该雇员直接加入到本链表的最后即可
    public void add(Emp emp) {
        //如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助指针帮助定位到最后
        Emp curEmp = head;
        while (true) {
            if (head.next == null) {//说明到链表最后
                break;
            }
            curEmp = curEmp.next;//后移
        }
        //退出时直接将emp 加入链表
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(int no) {
        if (head == null) {//说明链表为空
            System.out.printf("第%d链表为空",(no+1));
            return;
        }
        Emp curEmp = head;
        while (true) {
            System.out.printf("=> id=%id name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;//后移
        }
        System.out.println();
    }

    //根据id查找雇员
    public Emp fingById(int id) {
        if (head == null) {//说明链表为空
            System.out.println("当前链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                break;//这时curEmp就指向要查找的雇员
            }
            //退出
            if (curEmp.next == null) {//说明遍历当前链表没有找到该雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;//后移
        }
        return curEmp;
    }
}
