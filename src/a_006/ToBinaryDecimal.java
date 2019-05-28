package a_006;

import java.util.Scanner;

/**
 * 描述：
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * 这个数转换成2进制后，输出1的个数
 *
 * 例如：输入
 * 5
 * 输出
 * 2
 * @author jianan
 * @Time 2019-05-28 23:49:40
 */
public class ToBinaryDecimal {
    public static void main(String[] args) {
        System.out.println("请输入：");
        Scanner s = new Scanner(System.in);
        int inputInt = s.nextInt();
        StringBuffer stringBuffer = new StringBuffer();
        //思路：inputInt>0时，inputInt%2 有余数置1，无余数置0
        while (inputInt > 0) {
            if (inputInt % 2 == 0) {
                stringBuffer.append("0");
            } else {
                stringBuffer.append("1");
            }
            inputInt /= 2;
        }

        String needReverseStr = stringBuffer.reverse().toString();
        int oneNum=0;
        for(int i=0;i<needReverseStr.length();i++){
            if(needReverseStr.charAt(i)=='1'){
                oneNum++;
            }
        }

        System.out.println(oneNum);
    }
}
