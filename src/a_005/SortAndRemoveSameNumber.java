package a_005;

import a_004.SortUtil;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照
 * 排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 *
 * 输入多行，先输入随机整数的个数，再输入相应个数的整数
 * 返回多行，处理后的结果
 * 输出输入字符串中含有该字符的个数。
 * 例：输入
 * 11
 * 10
 * 20
 * 40
 * 32
 * 67
 * 40
 * 20
 * 89
 * 300
 * 400
 * 15
 * 输出
 * 10
 * 15
 * 20
 * 32
 * 40
 * 67
 * 89
 * 300
 * 400
 * @author jianan
 * @Time 2019-05-24 00:52:22
 */
public class SortAndRemoveSameNumber {
    public static void main(String[] args){
        System.out.println("请输入：");
        Scanner s=new Scanner(System.in);
        //需要去重以及排序的数量
        while (s.hasNextInt()){//可能有多组数据
            int allNum=s.nextInt();
            //通过set去重
            Set<Integer> allNumSet=new HashSet<>();
            for(int i=0;i<allNum;i++){
                allNumSet.add(s.nextInt());
            }
            //新建数组，用于排序以及输出
            Integer[] allNumArr=new Integer[allNumSet.size()];
            //遍历set 取值赋予数组
            Iterator<Integer> iterator=allNumSet.iterator();
            int curAddIndex=0;
            while (iterator.hasNext()){
                allNumArr[curAddIndex++]=iterator.next();
            }
            //通过排序算法进行排序
            Integer[] afterSortArr= SortUtil.doBubbleSort(allNumArr);
            for(int i=0;i<afterSortArr.length;i++){
                System.out.println(afterSortArr[i]);
            }
        }

    }
}
