package com.hwq.fundamment.JavaDataStructure.linkedList;

/**
 * @Auther: Administrator
 * @Date: 2020/2/23 0023 14:50
 * @Description:单链表 注意事项：
 * 1、这里创建的单链表是带一个空表头的
 * 2、由于表头我们不动，所以在遍历的时候都会有一个临时变量HeroNode temp=head,通过这个临时变量来进行遍历
 * 3、每次遍历都需要后移(千万记住) temp = temp.next
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星");
        HeroNode heroNode3 = new HeroNode(3, "卢珏易", "玉麒麟");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);

        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.list();
        System.out.println("添加后的singleLinkedList~~");
        singleLinkedList.delete(1);
        singleLinkedList.delete(4);
        singleLinkedList.list();
        System.out.println("删除后的singleLinkedList~~");


    }

    static class SingleLinkedList {
        //初始化一个头节点，头节点不要动，不存放具体数据的
        private HeroNode head = new HeroNode(0, "", "");

        //添加节点到单链表思路(不考虑排序)：
        //1、找到当前节点的最后节点
        //2、将最后节点的next指向新的节点
        public void add(HeroNode heroNode) {
            //因为头节点不能动，我们需要一个辅助遍历的临时节点temp
            HeroNode temp = head;
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
            //将最后这个节点的next指向 新的节点
            temp.next = heroNode;
        }

        public void addByOrder(HeroNode heroNode) {
            //因为头节点不能动，我们需要一个辅助遍历的临时节点temp
            HeroNode temp = head;
            boolean flag = false;//说明找到位置了
            //遍历链表，找到最后
            while (true) {
                //找到最后
                if (temp.next == null) {
                    break;
                }
                if (temp.next.no > heroNode.no) {//位置找到，如果temp.next.no > hero.no 说明hero这个节点应该加在temp后面，temp.next的前面
                    break;
                } else if (temp.next.no == heroNode.no) { //说明编号已经存在
                    flag = true;//说明编号已经存在
                    break;
                }
                //如果没有找到，则将temp后移继续找
                temp = temp.next;
            }
            if (flag) {
                System.out.printf("准备插入的英雄编号%d已经存在，不能添加\n", heroNode.no);
            } else {
                //插入到temp后面
                heroNode.next = temp.next;
                temp.next = heroNode;
            }
        }

        //根据newHeroNode的no 来修改即可
        public void update(HeroNode newHeroNode) {
            //判断是否为空
            if (head.next == null) {
                System.out.println("链表为空~");
                return;
            }
            //定义一个辅助变量
            HeroNode temp = head.next;
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
         * 删除节点思路：
         * 1、head不能动，因此我们需要一个temp辅助节点找到待删除的前一个节点
         * 2、说明我们在比较时，是temp.next.no 和 需要删除的节点no比较
         *
         * @param no
         */
        public void delete(int no) {
            HeroNode temp = head;
            boolean flag = false;
            while (true) {
                if (temp.next == null) { //已经到链表最后
                    break;
                }
                if (temp.next.no == no) { //说明找到了
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) { //找到了需要删除的节点，将 temp.next = temp.next.next
                temp.next = temp.next.next;
            } else {
                System.out.println("需要删除的节点不存在");
            }
        }

        public void list() {
            //判断链表是否为空
            if (head.next == null) {
                System.out.println("遍历时链表为空~");
                return;
            }
            HeroNode temp = head.next;
            while (true) {
                if (temp == null) {
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    //定义HeroNode，每个HeroNode对象就是一个节点
    static class HeroNode {
        private int no;
        private String name;
        private String nickName;
        public HeroNode next;//指向下一个节点

        public HeroNode(int no, String name, String nickname) {
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
