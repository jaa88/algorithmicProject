package a_006;

import java.util.Scanner;

/**
 * 描述：
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。例如：
 *
 * 输入N个字符
 * 输出该字符串反转后的字符串
 *
 * 例如：输入
 * abcd
 * 输出
 * dcba
 * @author jianan
 * @Time 2019-05-28 12:25:40
 */
public class ReverseSentence {
    public static void main(String[] args){
        System.out.println("请输入：");
        Scanner s=new Scanner(System.in);
        String inputSentence=s.nextLine();
        String[] wordArr=inputSentence.split(" ");
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=wordArr.length-1;i>=0;i--){
            //最后一个单词后面不要加空格
            stringBuffer.append(wordArr[i]+(i!=0?" ":""));
        }
        System.out.println(stringBuffer.toString());
    }
}
