package a_005;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 输入一个int型整数
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * 例如：输入
 * 9876673
 * 输出
 * 37689
 *
 * @author jianan
 * @Time 2019-05-26 22:47:20
 */
public class ExtractNonRepeatIntegers {
    public static void main(String[] args){
        System.out.println("请输入：");
        Scanner s=new Scanner(System.in);
        int inputNum=s.nextInt();
        String inputNumStr=String.valueOf(inputNum);
        Map<Character,Integer> inputNumCharMap=new HashMap<>();
        //用于拼装输出的数字字符串
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=inputNumStr.length()-1;i>=0;i--){
            if(inputNumCharMap.get(inputNumStr.charAt(i))==null){
                stringBuffer.append(inputNumStr.charAt(i));
                inputNumCharMap.put(inputNumStr.charAt(i),1);
            }
        }
        System.out.println(Integer.parseInt(stringBuffer.toString()));
    }
}
