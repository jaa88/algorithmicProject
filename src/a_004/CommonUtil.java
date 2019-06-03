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

    //是否是质数 从2-sqrt(judgeNum)有可整除的则为合数，否则质数
    public static boolean isPrimeLong(long judgeNum){
        boolean primeFlag=true;
        long sqrtJudgeNum=(long)Math.floor(Math.sqrt((double) judgeNum));
        for(int i=2;i<=sqrtJudgeNum;i++){
            if(judgeNum%i==0){
                primeFlag=false;
                break;
            }
        }
        return primeFlag;
    }

    /*是否是质数 从2-sqrt(judgeNum)有可整除的则为合数，否则质数*/
    public static boolean isPrimeInt(int judgeNum){
        boolean primeFlag=true;
        int sqrtJudgeNum=(int)Math.floor(Math.sqrt((double) judgeNum));
        for(int i=2;i<=sqrtJudgeNum;i++){
            if(judgeNum%i==0){
                primeFlag=false;
                break;
            }
        }
        return primeFlag;
    }

    /*返回两个整数之间更大的数*/
    public static int getMaxIntNum(int a,int b){
        if(a>=b){
            return a;
        }else{
            return b;
        }
    }

    /*判断一个字符串是否可以转换为整数*/
    public static boolean isIntNum(String needCheckNum){
        try {
            Integer.parseInt(needCheckNum);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
