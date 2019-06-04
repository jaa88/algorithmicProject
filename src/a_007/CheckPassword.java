package a_007;

import java.util.Scanner;

/**
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度超2的子串重复
 *
 * 输入 一组或多组长度超过2的子符串。每组占一行
 * 输出 如果符合要求输出：OK，否则输出NG
 *输出合并后的键值对（多行）
 * 例如：输入
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 输出
 * OK
 * NG
 * NG
 * OK
 * @author jianan
 * @Time 2019-06-04 22:15:36
 */
public class CheckPassword {
    public static void main(String[] args){
        System.out.println("请输入：");
        Scanner s=new Scanner(System.in);
        while (s.hasNextLine()){
            String passwordStr=s.nextLine();
            if(passwordStr.length()<=8){
                System.out.println("NG");
            }else if(!hasMoreThanThreeCharSpecies(passwordStr)){
                System.out.println("NG");
            }else if(hasMoreThanTwoSubString(passwordStr)){
                System.out.println("NG");
            }else{
                System.out.println("OK");
            }
        }
    }

    /*是否有三种以上不同种类字符*/
    public static boolean hasMoreThanThreeCharSpecies(String needCheckStr){
        int hasCapitalChar=0;//有大写字母  0 无 1 有
        int hasLowercaseChar=0;//有小写字母
        int hasNum=0;//有数字
        int hasOtherChar=0;//有其他字符

        for(int i=0;i<needCheckStr.length();i++){
            char targetChar=needCheckStr.charAt(i);
            if(targetChar<='z' && targetChar>='a'){
                hasLowercaseChar=1;
            }else if(targetChar<='Z' && targetChar>='A'){
                hasCapitalChar=1;
            }else if(targetChar<='9' && targetChar>='0'){
                hasNum=1;
            }else {
                hasOtherChar=1;
            }
            //判断是否有3种类型的字符
            if((hasCapitalChar+hasLowercaseChar+hasNum+hasOtherChar)>=3){
                return true;
            }
        }
        return false;
    }

    /*是否有长度超2的子串重复*/
    public static boolean hasMoreThanTwoSubString(String needCheckStr){
        for(int i=0;i<needCheckStr.length()-6;i++){
            String subStrA=needCheckStr.substring(i,i+3);
            for(int j=i+3;j<needCheckStr.length()-3;j++){
                String subStrB=needCheckStr.substring(j,j+3);
                if(subStrA.equals(subStrB)){
                    return true;
                }
            }
        }
        return false;
    }
}
