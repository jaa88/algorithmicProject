package a_005;

import java.util.Scanner;

/**
 * 接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * 输入一个有字母和数字以及空格组成的字符串，和一个字符。
 * 输出输入字符串中含有该字符的个数。
 * 例：输入
 * ABCDEF A
 * 输出 1
 * @author jianan
 * @Time 2019-05-23 01:10:09
 */
public class GetTargetCharNumFromStr {

    public static void main(String[] args){
        System.out.println("请输入：");
        Scanner s=new Scanner(System.in);
        String targetInputStr=s.nextLine().toLowerCase();//题目中是不区分大小写，所以通通转出小写
        char targetChar=s.next().toLowerCase().charAt(0);
        char[] targetInputCharArr=targetInputStr.toCharArray();
        int targetCharNum=0;
        for(char curChar:targetInputCharArr){
            if(curChar==targetChar){
                targetCharNum++;
            }
        }
        System.out.println(targetCharNum);
    }
}
