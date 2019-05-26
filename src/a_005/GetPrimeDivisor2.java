package a_005;

import a_004.CommonUtil;

import java.util.*;

/**
 * 原题：输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
 * @author jianan
 * @Time 2019-05-25 21:41:08
 */
public class GetPrimeDivisor2 {
    public static void main(String[] args){
        System.out.println("请输入");
        Scanner s=new Scanner(System.in);
        long needDealNum=s.nextLong();
        String outStr="";
        if(CommonUtil.isPrimeLong(needDealNum)){
            outStr+=needDealNum+" ";
        }else{
            while (needDealNum!=1){
                for(int i=2;i<=needDealNum;i++){
                    if(i==needDealNum){
                        needDealNum=1;
                        outStr+=i+" ";
                        break;
                    }
                    if(needDealNum%i==0){
                        needDealNum/=i;
                        outStr+=i+" ";
                        break;
                    }
                }
            }
        }
        System.out.println(outStr);
    }
}
