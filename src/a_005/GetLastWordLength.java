package a_005;

import java.util.Scanner;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * @author jianan
 * @Time 2019-05-23 01:01:09
 */
public class GetLastWordLength {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String targetInputStr=s.nextLine();
        String[] wordArr=targetInputStr.split(" ");
        System.out.println(wordArr[wordArr.length-1].length());
    }
}
