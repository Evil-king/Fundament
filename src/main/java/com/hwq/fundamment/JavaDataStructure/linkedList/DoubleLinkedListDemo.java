package com.hwq.fundamment.JavaDataStructure.linkedList;

/**
 * @Auther: Administrator
 * @Date: 2020/2/26 0026 18:27
 * @Description:双向链表 基本思路和单项链表差不多
 * 需要注意的有删除
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //创建节点
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "吴用", "智多星");
        HeroNode2 heroNode3 = new HeroNode2(3, "卢珏易", "玉麒麟");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");
        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);

        doubleLinkedList.list();

        //修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表~~~~");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.delete(4);
        System.out.println("删除后的链表~~~~");
        doubleLinkedList.list();
    }

    static class DoubleLinkedList{
        //初始化一个头节点，头节点不要动，不存放具体数据的
        private HeroNode2 head = new HeroNode2(0, "", "");
        //返回头结点
        public HeroNode2 getHead() {
            return head;
        }

        //遍历双向链表的方法
        //显示链表[遍历]
        public void list() {
            //判断链表是否为空
            if (head.next == null) {
                System.out.println("遍历时链表为空~");
                return;
            }
            HeroNode2 temp = head.next;
            while (true) {
                //判断是否到链表最后
                if (temp == null) {
                    break;
                }
                //输出节点信息
                System.out.println(temp);
                //将temp后移，一定要记得
                temp = temp.next;
            }
        }

        //添加节点到单链表思路(不考虑排序)：
        //1、找到当前节点的最后节点
        //2、将最后节点的next指向新的节点
        public void add(HeroNode2 heroNode) {
            //因为头节点不能动，我们需要一个辅助遍历的临时节点temp
            HeroNode2 temp = head;
            //遍历链表，找到最后
            while (true) {
                //找到最后
                if (temp.next == null) {
                    break;
                }
                //如果没有找到，则将temp后移继续找
                temp = temp.next;
            }
            //当退出while循环时，temp就指向了链表的最后
            //形成一个双向链表 =号就相当于指针
            temp.next = heroNode;
            heroNode.pre = temp;
        }

        //根据newHeroNode的no 来修改即可
        public void update(HeroNode2 newHeroNode) {
            //判断是否为空
            if (head.next == null) {
                System.out.println("链表为空~");
                return;
            }
            //定义一个辅助变量
            HeroNode2 temp = head.next;
            //遍历链表
            boolean flag = false;
            while (true) {
                if (temp == null) {
                    break;//已经遍历完链表
                }
                if (temp.no == newHeroNode.no) {
                    //说明找到了
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.name = newHeroNode.name;
                temp.nickName = newHeroNode.nickName;
            } else {
                System.out.printf("没有找到 编号%d的节点，不能修改\n", newHeroNode.no);
            }
        }

        /**
         * 从双向链表中删除一个节点
         * 说明
         * 1、对于双向链表，我们可以直接找到要删除的这个节点
         * 2、找到后，自我删除即可
         * @param no
         */
        public void delete(int no) {

            //判断当前链表是否为空
            if (head.next == null){
                System.out.println("链表为空，无法删除");
                return;
            }
            HeroNode2 temp = head.next;//辅助变量(指针)
            boolean flag = false;
            while (true) {
                if (temp == null) { //已经到链表最后
                    break;
                }
                if (temp.no == no) { //说明找到了
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                //找到了需要删除的节点，将 temp.next = temp.next.next
                //temp.next = temp.next.next;
                //双向链表的删除
                temp.pre.next = temp.next;
                //如果是最后一个节点，就不需要执行下面这句话，否则会出现空指针
                if(temp.next != null){
                    temp.next.pre = temp.pre;
                }
            } else {
                System.out.println("需要删除的节点不存在");
            }
        }
    }



    //定义HeroNode，每个HeroNode对象就是一个节点
    static class HeroNode2 {
        private int no;
        private String name;
        private String nickName;
        public HeroNode2 next;//指向下一个节点 默认为null
        public HeroNode2 pre;//指向前一个节点 默认为null

        public HeroNode2(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickName = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }

}
