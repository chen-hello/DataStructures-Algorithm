package linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Heronode hero1 = new Heronode(1, "宋江", "及时雨");
        Heronode hero2 = new Heronode(2, "卢俊义", "玉麒麟");
        Heronode hero3 = new Heronode(3, "吴用", "智多星");
        Heronode hero4 = new Heronode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
        //加入按照编号的顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.list();
        System.out.println();

        //修改节点的代码
//        Heronode newHerNode = new Heronode(2, "小卢", "玉麒麟~");
//        singleLinkedList.update(newHerNode);
//        System.out.println("修改后的链表的情况");
//        singleLinkedList.list();

        //删除节点
        //singleLinkedList.del(1);
        //singleLinkedList.list();
        //统计节点的个数，不包括头节点
//        System.out.println("有效的节点个数" + getLength(singleLinkedList.getHead()));
//        // 查找单链表中的倒数第K个节点
//        Heronode res = findLastIndexNode(singleLinkedList.getHead(), 1);
//        System.out.println("res" + res);
        //单链表反转

//        reverseList(singleLinkedList.getHead());
//        singleLinkedList.list();
        System.out.println("逆序打印，不改变原先单链表的结构");
        reversePrint(singleLinkedList.getHead());


    }
    //获取到单链表的个数

    public static int getLength(Heronode head) {
        if (head.next == null) {
            return 0;
        }//这里没有统计头节点
        int length = 0;
        Heronode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //查找单链表中的倒数第K个节点
    //思路：
    //1.编写一个方法，接收head节点，同时接收一个index;
    //2.index 表示是倒数第 index 个节点
    //3.先把链表从头到尾遍历，得到链表的总的长度getlength
    //4.得到size后，我们从链表的第一个开始遍历(size-index)个
    //5.如果找到了，则返回节点，负责返回null
    public static Heronode findLastIndexNode(Heronode head, int index) {
        //判断如果链表为空，返回null
        if (head.next == null) {
            return null;//没有找到
        }
        //得到链表的长度
        int size = getLength(head);
        //先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        Heronode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;

        }
        return cur;

    }

    //单链表的反转
    public static void reverseList(Heronode head) {
        //如果当前列表为空或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;

        }
        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        Heronode cur = head.next;//指向当前节点[cur]的下一个节点
        Heronode next = null;
        Heronode reseverseHead = new Heronode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端

        while (cur != null) {
            next = cur.next;
            cur.next = reseverseHead.next;
            reseverseHead.next = cur;
            cur = next;

        }
        head.next = reseverseHead.next;
        //
    }

    //从尾到头打印单链表
    //1.先将单链表进行反转操作，然后再遍历即可，这样的问题是会破坏原来的单边表的结构，不建议
    //2.方式2，可以利用栈，将各个节点压入到栈中，然后利用栈的先进后出的节点，就实现了逆序打印
    public static void reversePrint(Heronode head) {
        if (head.next == null) {
            return;//空链表，无法打印
        }
        //创建一个栈，将各个节点压入栈
        Stack<Heronode> stack = new Stack<>();
        Heronode cur = head.next;
        //将链表的所有节点压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //将栈中的节点进行打印，pop出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }


    }

}

class SingleLinkedList {
    private final Heronode head = new Heronode(0, "", "");

    //返回头节点
    public Heronode getHead() {
        return head;
    }

    public void add(Heronode heroNode) {
        Heronode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        temp.next = heroNode;
    }

    //显示链表
    public void list() {

        {
            if (head.next == null) {
                System.out.println("链表为空");

            }
            Heronode temp = head.next;
            while (true) {
                if (temp == null) {
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }


    }

    //第二种添加方式，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败。并给出提示)
    public void addByOrder(Heronode heroNode) {
        Heronode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {//位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;//遍历
        }
        if (flag) {
            System.out.printf("说明插入的英雄的编号 %d 已经存在了,不能加入 \n ", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }


    }

    //单链表节点修改,根据no来修改，即no编号不能修改
    public void update(Heronode newHerNode) {
        Heronode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;//已经遍历结束
            }
            if (temp.no == newHerNode.no) {
                flag = true;//找到
                break;
            }
            temp = temp.next;

        }
        if (flag) {
            temp.name = newHerNode.name;
            temp.nickname = newHerNode.nickname;

        } else {
            System.out.printf("没有找到编号%d的节点", newHerNode.no);
        }

    }

    //删除节点
    public void del(int no) {
        Heronode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要找到的节点不存在", no);
        }
    }

}

//定义Heronode
class Heronode {
    public int no;
    public String name;
    public String nickname;
    public Heronode next;

    public Heronode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Heronode{" + "no=" + no + ", name='" + name + '\'' + ", nickname='" + nickname + '\'' + '}';
    }
}
