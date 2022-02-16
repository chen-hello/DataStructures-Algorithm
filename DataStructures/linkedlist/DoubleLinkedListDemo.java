package linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {


        Heronode2 head = new Heronode2(0, "", "");
        Heronode2 hero1 = new Heronode2(1, "宋江", "及时雨");
        Heronode2 hero2 = new Heronode2(2, "卢俊义", "玉麒麟");
        Heronode2 hero3 = new Heronode2(3, "吴用", "智多星");
        Heronode2 hero4 = new Heronode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();
        //修改
        Heronode2 newHeroNode=new Heronode2(4,"公孙胜","入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的情况");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.del(3);
        System.out.println("删除后的情况");
        doubleLinkedList.list();




    }
}

class DoubleLinkedList {
    private final Heronode2 head = new Heronode2(0, "", "");

    //加入
    //返回头节点
    public Heronode2 getHead() {
        return head;
    }

    public void add(Heronode2 heroNode) {
        Heronode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //显示链表
    public void list() {

        {
            if (head.next == null) {
                System.out.println("链表为空");

            }
            Heronode2 temp = head.next;
            while (true) {
                if (temp == null) {
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }


    } //单链表节点修改,根据no来修改，即no编号不能修改

    public void update(Heronode2 newHerNode) {
        Heronode2 temp = head.next;
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

    //从双向链表中删除一个节点
    //1.对于双向链表，我们可以直接找到要删除的这个节点
    //2.找到后，自我删除即可
    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除");

        }
        Heronode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {//已经找到链表节点的最后
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;//这里代码有问题，最后一个节点null
            }
            //如果是最后一个节点。就不需要执行这一句话，会出现空指针异常


        } else {
            System.out.printf("要找到的节点不存在", no);
        }
    }

}

//定义Heronode
class Heronode2 {
    public int no;
    public String name;
    public String nickname;
    public Heronode2 next;//指向后一个节点，默认为null
    public Heronode2 pre;//指向前一个节点

    public Heronode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
        this.next = next;
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "Heronode{" + "no=" + no + ", name='" + name + '\'' + ", nickname='" + nickname + '\'' + '}';
    }
}
