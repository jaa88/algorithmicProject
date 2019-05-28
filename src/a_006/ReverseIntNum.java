package a_006;

import java.util.Scanner;

/**
 * 描述：
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 * 输入一个int整数
 * 将这个整数以字符串的形式逆序输出
 *
 * 例如：输入
 * 1516000
 * 输出
 * 0006151
 * @author jianan
 * @Time 2019-05-28 11:38:23
 */
public class ReverseIntNum {
    public static void main(String[] args){
        System.out.println("请输入：");
        Scanner s=new Scanner(System.in);
        Integer inputIntNum=s.nextInt();
        String inputIntNumStr=String.valueOf(inputIntNum);
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=inputIntNumStr.length()-1;i>=0;i--){
            stringBuffer.append(inputIntNumStr.charAt(i));
        }
        System.out.println(stringBuffer.toString());
    }
}
