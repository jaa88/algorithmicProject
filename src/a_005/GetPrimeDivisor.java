package a_005;

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
                if(isPrime(i)){
                    divisorSet.add(i);
                }
                if(isPrime(needDealNum/i)){
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

    //是否是质数 从2-sqrt(judgeNum)有可整除的则为合数，否则质数
    public static boolean isPrime(long judgeNum){
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
}
