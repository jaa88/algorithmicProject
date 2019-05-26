package a_005;

import java.util.*;

/**
 * 数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 *输出合并后的键值对（多行）
 * 例如：输入
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 输出
 * 0 3
 * 1 2
 * 3 4
 * ps:不能使用s.nextLine 设定的是int 型输入
 *
 * @author jianan
 * @Time 2019-05-26 22:35:03
 */
public class ConsolidateTableRecord {
    public static void main(String[] args){
        System.out.println("请输入：");
        Scanner s=new Scanner(System.in);
        int primaryKeyValuePairNum=s.nextInt();
        Map<Long,Long> keyValuePairMap=new HashMap<>();
        Set<Long> keySet=new HashSet<>();
        //输入键值对，并合并至map中
        for(int i=0;i<primaryKeyValuePairNum;i++){
            Long keyNum=s.nextLong();
            keySet.add(keyNum);
            Long valueNum=s.nextLong();
            if(keyValuePairMap.get(keyNum)==null){
                keyValuePairMap.put(keyNum,valueNum);
            }else{
                keyValuePairMap.put(keyNum,valueNum+keyValuePairMap.get(keyNum));
            }
        }
        //从set中取出不重复的key放入数组中
        Long[] keyArr=new Long[keySet.size()];
        Iterator it=keySet.iterator();
        int curIndex=0;
        while (it.hasNext()){
            keyArr[curIndex++]=(Long) it.next();
        }
        //对key升序排列
        keyArr=doBubbleSort(keyArr);
        for(int i=0;i<keyArr.length;i++){
            System.out.println(keyArr[i]+" "+keyValuePairMap.get(keyArr[i]));
        }
    }

    /*冒泡排序----将最大(小)的不断往后推，每次外部循环结束，即可确认一个元素的位置*/
    public static Long[] doBubbleSort(Long[] needSortArr){
        for(int i=0;i<needSortArr.length;i++){//外层每一次遍历，确定第length-i-1位置的值
            for(int j=0;j<needSortArr.length-i-1;j++){//内层的每次遍历，是将最大的不断往后推
                if(needSortArr[j]>needSortArr[j+1]){
                    Long temp=needSortArr[j];
                    needSortArr[j]=needSortArr[j+1];
                    needSortArr[j+1]=temp;
                }
            }
        }
        return needSortArr;
    }
}
