package Stack;

public class stack1 {
    public static void main(String[] args) {
        String s = "1-2*1+6-3";
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;//操作符
        int res = 0;//计算结果
        char ch = ' ';
        String keppNum = "";//用于处理多位数
        signal numStack = new signal(10);
        signal operStack = new signal(10);
        while (true) {
            ch = s.substring(index, index + 1).charAt(0);
            //如果是运算符
            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) { //如果运算符不为空
                    //如果运算符小于等于栈以有的运算符，即取数栈两个数字进行运算
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.calc(num1, num2, oper);
                        //运算结果加载进数栈
                        numStack.push(res);
                        //把操作符入符号栈
                        operStack.push(ch);
                    } else {
                        //如果大于操作符直接入符号栈
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {
                //numStack.push(ch-48);
                keppNum+=ch;
                if(index == s.length()-1){
                    //如果是表达式最好的，直接入栈
                    numStack.push(Integer.parseInt(keppNum));
                }else{
                    if(operStack.isOper(s.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keppNum));
                        //清空keppnum
                        keppNum="";
                    }
                }
            }
            index++;
            if(index >= s.length()){
                break;
            }
        }
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.calc(num1, num2, oper);
            //运算结果加载进数栈
            numStack.push(res);
        }
        System.out.println("运算结果" + numStack.pop());
    }
}
class signal{
    private int maxSize;
    private int[] num;
    private int top = -1;

    public signal(int maxSize) {
        this.maxSize = maxSize;
        num = new int[maxSize];
    }

    //返回栈顶
    public int peek(){
        return num[top];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }
    //栈空
    public  boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int value){
        //判断是否是栈满
        if(isFull()){
            return;
        }
        top++;
        num[top]=value;
    }
    //出栈
    public int pop(){
        //判断是否栈空
        if(isEmpty()){
            throw  new RuntimeException("栈空");
        }
        int value = num[top];
        top--;
        return value;
    }
    //遍历
    public void show(){
        //判断是否栈空
        if(isEmpty()){
            throw  new RuntimeException("栈中没有数字");
        }
        for (int i = 0; i <= top; i++) {
            System.out.println("栈中数字"+num[i]);
        }
    }
    //返回符号优先级
    public int priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else{
            return -1;
        }
    }
    //判断是否是运算符
    public boolean isOper(char var){
        return var=='*'|| var=='/'||var=='+'||var=='-';
    }
    //计算方法
    public  int calc(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num2+num1;
                break;
            case '-':
                res = num2-num1;
                break;
            case '*':
                res = num2*num1;
                break;
            case '/':
                res = num2/num1;
                break;
        }
        return res;
    }
}
