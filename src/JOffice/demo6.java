package JOffice;

import java.util.LinkedList;

//用两个栈实现队列
public class demo6 {
    LinkedList<Integer> A, B;
    public demo6() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        A.addLast(value);//添加元素到尾部
    }

    public int deleteHead() {
        if(!B.isEmpty()) {
            return B.removeLast();//删除并返回最后一个元素
        }
        if(A.isEmpty()) {
            return -1;
        }
        while(!A.isEmpty())
            B.addLast(A.removeLast());
        return B.removeLast();
    }
}
