package Stack;

import java.util.Scanner;

public class stack {
    public static void main(String[] args) {
        ArrAyStack arrAyStack = new ArrAyStack(4);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.println("输入数字");
            int value = scanner.nextInt();
            arrAyStack.push(value);
        }
        for (int i = 0; i <4 ; i++) {
            int pop = arrAyStack.pop();
            System.out.println(pop);
        }
        //arrAyStack.show();
    }
}
//定义一个栈
class ArrAyStack{
    private int maxSize;//栈大小
    private int [] stack;//数组模拟栈
    private int top = -1;

    public ArrAyStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    //栈满
    public boolean inFull(){
        return top == maxSize-1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int value){
        //判断是否栈满
        if(inFull()){
            return;
        }
        top++;
        stack[top]=value;
    }
    //出栈
    public int pop(){
        //判断是否为空
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //遍历栈
    public  void show(){
        //判断是否为空
        if (isEmpty()){
            throw new RuntimeException("没有数据");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
