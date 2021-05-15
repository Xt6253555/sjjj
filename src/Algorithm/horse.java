package Algorithm;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

//马踏棋盘
public class horse {
    private static int x;
    private static int y;
    private static boolean visited[];
    private static boolean finished;  //默认为false

    public static void main(String[] args) {
        x=y=8;
        int row =1;
        int column=1;
        int[][] chessboard = new int[x][y];
        visited = new boolean[x * y];
        treaversal(chessboard,row-1,column-1,1);
        for (int[]rows:chessboard) {
            for (int step:rows) {
                System.out.print(step+"\t");
            }
            System.out.println();
        }
    }
    //完成算法
    public static  void treaversal(int[][]chessboard,int row,int column,int step){
        chessboard[row][column]=step;
        visited[row*x+column]=true;
        ArrayList<Point> ps = next(new Point(column, row));
        sort(ps);
        while (!ps.isEmpty()){
            Point p = ps.remove(0);
            //说明没有访问
            if(!visited[p.y*x+p.x]){
                treaversal(chessboard,p.y,p.x,step+1);
            }
        }
        if(step<x*y&&!finished){
            chessboard[row][column]=0;
            visited[row*x+column]=false;
        }else {
            finished=true;
        }
    }
    //判断马儿可以走的位置
    public static ArrayList<Point>next(Point curPoint){
        ArrayList<Point> ps = new ArrayList<>();
        Point p1 = new Point();
        //马儿走5
        if((p1.x=curPoint.x-2)>=0&&(p1.y=curPoint.y-1)>=0){
            ps.add(new Point(p1));
        }
        //马儿走6
        if((p1.x=curPoint.x-1)>=0&&(p1.y=curPoint.y-2)>=0){
            ps.add(new Point(p1));
        }
        //马儿走7
        if((p1.x=curPoint.x+1)<x&&(p1.y=curPoint.y-2)>=0){
            ps.add(new Point(p1));
        }
        //马儿走0
        if((p1.x=curPoint.x+2)<x&&(p1.y=curPoint.y-1)>=0){
            ps.add(new Point(p1));
        }
        //马儿走1
        if((p1.x=curPoint.x+2)<x&&(p1.y=curPoint.y+1)<y){
            ps.add(new Point(p1));
        }
        //马儿走2
        if((p1.x=curPoint.x+1)<x&&(p1.y=curPoint.y+2)<y){
            ps.add(new Point(p1));
        }
        //马儿走3
        if((p1.x=curPoint.x-1)>=0&&(p1.y=curPoint.y+2)<y){
            ps.add(new Point(p1));
        }
        //马儿走4
        if((p1.x=curPoint.x-2)>=0&&(p1.y=curPoint.y+1)<y){
            ps.add(new Point(p1));
        }
        return ps;
    }
    //非递减减少回溯次数
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if(count1<count2){
                    return -1;
                }else if(count1==count2){
                    return 0;
                }else {
                    return 1;
                }
            }
        });
    }
}
