package a_006;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。
 * 输入N个字符，字符在ACSII码范围内。
 * 输出范围在(0~127)字符的个数。
 *输出合并后的键值对（多行）
 * 例如：输入
 * abc
 * 输出
 * 3
 * @author jianan
 * @Time 2019-05-28 11:14:03
 */
public class GetNonRepeatedCharNum {
    public static void main(String[] args){
        System.out.println("请输入：");
        Scanner s=new Scanner(System.in);
        //不重复的字符个数
        int nonRepeatNum=0;
        String needJudgeStr=s.nextLine();
        Set<Character> nonRepeatCharSet=new HashSet<>();
        for(int i=0;i<needJudgeStr.length();i++){
            nonRepeatCharSet.add(needJudgeStr.charAt(i));
        }
        System.out.println(nonRepeatCharSet.size());
    }
}
