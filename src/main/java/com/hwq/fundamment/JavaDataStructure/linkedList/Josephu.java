package com.hwq.fundamment.JavaDataStructure.linkedList;

/**
 * @Auther: Administrator
 * @Date: 2020/2/26 0026 19:55
 * @Description: 约瑟夫问题
 */
public class Josephu {
    public static void main(String[] args) {
        //测试 看看构建环形链表 和遍历是否OK
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);//加入5个节点
        circleSingleLinkedList.showBoy();

        //测试单项环形链表 2-4-1-5-3
        circleSingleLinkedList.countBoy(10,20,125);
    }
}

//创建一个单项的环形链表
class CircleSingleLinkedList{
    //创建一个first节点，当前没有编号
    private Boy first = null;
    //添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums){
        //nums 做一个数据校验
        if(nums < 1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，帮助构建环形链表
        //使用for循环来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if(i == 1){
                first = boy;
                first.setNext(first);//构成一个环
                curBoy = first;//让curBoy指向第一个小孩，first不能动只能用curBoy来
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前环形链表
    public void showBoy(){
        if(first == null){
            System.out.println("链表为空~");
            return;
        }
        //因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true){
            System.out.printf("小孩的编号%d \n",curBoy.getNo());
            if(curBoy.getNext() == first){//说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext();//让curBoy后移
        }
    }

    //根据用户的输入，计算出小孩出圈的顺序

    /**
     *
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示几下
     * @param nums 表示最初由多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums){
        //先对数据进行校验
        if(first == null || startNo < 1 || startNo > nums ){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建一个辅助指针帮助完成小孩出圈
        Boy helper = first;
        //需要创建一个辅助指针helper，事先应该指向环形链表的最后这个节点
        while (true){
            if(helper.getNext() == first){//说明helper指向最后一个节点
                break;
            }
            helper = helper.getNext();
        }
        for (int i = 0; i < startNo-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true){
            if(helper == first){ //圈中只有一个节点
                break;
            }
            //让first和helper同时移动countNum - 1
            for (int j = 0; j < countNum-1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点就是要出圈的节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            //这时将first指向的节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的节点编号%d \n",first.getNo());
    }
}




//创建一个Boy类，表示一个节点
class Boy{
    private int no;
    private Boy next;//指向下一个节点 默认为null
    public Boy(int no){
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}