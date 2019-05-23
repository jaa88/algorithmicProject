package a_005;

import java.util.Scanner;

/**
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 输入多行，先输入随机整数的个数，再输入相应个数的整数
 * 返回多行，处理后的结果
 * 输出输入字符串中含有该字符的个数。
 * 例：输入
 * abc
 * 123456789
 * 输出
 * abc00000
 * 12345678
 * 90000000
 * @author jianan
 * @Time 2019-05-24 01:29:45
 */
public class SpiltString {
    private static Integer TARGET_SPLIT_NUM=8;
    public static void main(String[] args){
        System.out.println("请输入：");
        Scanner s=new Scanner(System.in);
        String firstStr=s.nextLine();
        String secondStr=s.nextLine();
        String[] firstStrSplitArr=splitStringWithTargetNum(firstStr,TARGET_SPLIT_NUM);
        String[] secondStrSplitArr=splitStringWithTargetNum(secondStr,TARGET_SPLIT_NUM);
        for(int i=0;i<firstStrSplitArr.length;i++){
            if(firstStrSplitArr[i].length()<TARGET_SPLIT_NUM){
                System.out.println(firstStrSplitArr[i]+generateTargetNumZeroNum(TARGET_SPLIT_NUM-firstStrSplitArr[i].length()));;
            }else{
                System.out.println(firstStrSplitArr[i]);
            }
        }
        for(int i=0;i<secondStrSplitArr.length;i++){
            if(secondStrSplitArr[i].length()<TARGET_SPLIT_NUM){
                System.out.println(secondStrSplitArr[i]+generateTargetNumZeroNum(TARGET_SPLIT_NUM-secondStrSplitArr[i].length()));;
            }else{
                System.out.println(secondStrSplitArr[i]);
            }
        }

    }

    public static String[] splitStringWithTargetNum(String needSplitStr,int targetSplitNum){
        int remainder=needSplitStr.length()%targetSplitNum;//余数
        int result=needSplitStr.length()/targetSplitNum;//除法结果
        String[] returnArr=new String[remainder>0?result+1:result];
        if(result==0 || (result==1 && remainder==0)){
            returnArr[0]=needSplitStr;
        }else{
            for(int i=0;i<result;i++){
                returnArr[i]=needSplitStr.substring(i*TARGET_SPLIT_NUM,i*TARGET_SPLIT_NUM+TARGET_SPLIT_NUM);
            }
            if(remainder>0){
                returnArr[result]=needSplitStr.substring(result*TARGET_SPLIT_NUM,needSplitStr.length());
            }
        }
        return returnArr;
    }

    public static String generateTargetNumZeroNum(int targetNum){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<targetNum;i++){
            sb.append("0");
        }
        return sb.toString();
    }
}
