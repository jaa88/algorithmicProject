package a_004;

/**
 * 封装的工具包
 * 字符串翻转
 * @author jianan
 * @Time 2019-05-25 01:08:35
 */
public class CommonUtil {

    /*字符串翻转*/
    public static String reverseStr(String needReverseStr){
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=needReverseStr.length()-1;i>=0;i--){
            stringBuffer.append(needReverseStr.charAt(i));
        }
        return stringBuffer.toString();
    }
}
