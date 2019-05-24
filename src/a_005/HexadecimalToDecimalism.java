package a_005;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 * 输入一个十六进制的数值字符串
 * 输出该数值的十进制字符串。
 * 例：输入
 * 0xA
 * 输出
 * 10
 * @author jianan
 * @Time 2019-05-25 01:30:09
 */
public class HexadecimalToDecimalism {
    public static void main(String[] args){
        System.out.println("请输入：");
        Scanner s=new Scanner(System.in);
        //题干中说有多组同时输入
        while (s.hasNextLine()){
            int decimalValue=0;
            String hexadecimalStr=s.nextLine().toLowerCase();
            //题干中已经明确了16进制，所以开头必然是Ox
            hexadecimalStr=hexadecimalStr.substring(2);
            //也可charAt
            char[] charArr=hexadecimalStr.toCharArray();
            for(int i=charArr.length-1;i>=0;i--){
                decimalValue+=getDecimalFromHexadecimalChar(charArr[i],charArr.length-i-1);
            }
            System.out.println(decimalValue);
        }
    }

   /* 根据字符以及字符所处的幂返回对应十进制数*/
    public static int getDecimalFromHexadecimalChar(char targetChar,int powerNum){
        int productByPowerNum=getProductByPowerNum(16,powerNum);
        if(targetChar<='9' && targetChar>='0'){
            return (targetChar-'0')*productByPowerNum;
        }else{
            return (targetChar-'a'+10)*productByPowerNum;
        }
    }

    /* 根据进制数 以及 幂 ，返回需要乘以的系数*/
    public static int getProductByPowerNum(int targetDecimal,int powerNum){
        int returnValue=1;
        for(int i=0;i<powerNum;i++){
            returnValue*=targetDecimal;
        }
        return returnValue;
    }
}
