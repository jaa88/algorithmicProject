package a_002;

import java.util.*;

/**
 * 前向分词正大匹配法 NLP 分词算法中的一种
 * @author jianan
 * @Time 2019-05-21 23:29:01
 */
public class SeperatorUtil {
    public static void beforeSeperator(String[] dictArr,String needSeperateStr){
        //获取最大字符串长度
        Map<Integer, List<String>> numToStringListMap=new HashMap<>();//记录字符串长度，对应的字符串list
        for(int i=0;i<dictArr.length;i++){
            List<String> tempStringList=numToStringListMap.get(dictArr[i]);
            if(tempStringList==null){
                tempStringList=new ArrayList<>();
            }
            tempStringList.add(dictArr[i]);
            numToStringListMap.put(dictArr[i].length(),tempStringList);
        }
        
        Set<Integer> allNumSet= numToStringListMap.keySet();
        Object[] allNumArr=allNumSet.toArray();
        for(int i=0;i<allNumArr.length;i++){
            System.out.println(numToStringListMap.get(allNumArr[i]));
        };
    }

    public static void main(String[] args){
        String[] dictArr=new String[]{"研究","研究生","生命","命","的","起源"};
        beforeSeperator(dictArr,"研究生命的起源");
    }
}
