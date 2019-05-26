package a_005;

import a_004.CommonUtil;

import java.util.*;

/**
 * 原题：输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
 * 理解错了，做成了获取一个数的所有是质数的因子
 * 正确的结果看GetPrimeDivisor2
 * @author jianan
 * @Time 2019-05-25 22:51:09
 */
public class GetPrimeDivisor {
    public static void main(String[] args){
        System.out.println("请输入");
        Scanner s=new Scanner(System.in);
        long needDealNum=s.nextLong();
        Set<Long> divisorSet=new HashSet<Long>();
        long sqrtNeedDealNum=(long)Math.floor(Math.sqrt((double) needDealNum));
        for(long i=2;i<sqrtNeedDealNum;i++){
            if(needDealNum%i==0){
                if(CommonUtil.isPrimeLong(i)){
                    divisorSet.add(i);
                }
                if(CommonUtil.isPrimeLong(needDealNum/i)){
                    divisorSet.add(needDealNum/i);
                }
            }
        }
        List<Long> primeDivisorList=new ArrayList<>(divisorSet.size());
        Iterator it=divisorSet.iterator();
        while (it.hasNext()){
            primeDivisorList.add((Long)it.next());
        }
        for(Long  primeDivisor:primeDivisorList){
            System.out.println(primeDivisor);
        }
    }
}
