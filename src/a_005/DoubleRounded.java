package a_005;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整
 *输入一个正浮点数值
 *输出该数值的近似整数值
 * 例如：输入
 * 5.5
 * 输出
 * 6
 * ps:有相关api直接四舍五入
 *
 * @author jianan
 * @Time 2019-05-23 01:01:09
 */
public class DoubleRounded {
    public static void main(String[] args){
        System.out.println("请输入");
        Scanner s=new Scanner(System.in);
        Double inputDouble=s.nextDouble();
        String inputDoubleStr=String.valueOf(inputDouble);
        String[] inputDoubleStrSplitArr=inputDoubleStr.split("\\.");
        int intPart=Integer.parseInt(inputDoubleStrSplitArr[0]);
        if(Integer.parseInt(String.valueOf(inputDoubleStrSplitArr[1].charAt(0)))>=5){
            intPart+=1;
        }
        System.out.println(intPart);
    }
}
