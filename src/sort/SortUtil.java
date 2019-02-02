package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianan on 2019/02/02
 * 工具类应该返回排序后的数组，这是练习，所以直接在每个方法内部打印出来了
 */
public class SortUtil {
    /*冒泡排序----将最大(小)的不断往后推，每次外部循环结束，即可确认一个元素的位置*/
    public static void doBubbleSort(Integer[] needSortArr){
        for(int i=0;i<needSortArr.length;i++){//外层每一次遍历，确定第length-i-1位置的值
            for(int j=0;j<needSortArr.length-i-1;j++){//内层的每次遍历，是将最大的不断往后推
                if(needSortArr[j]>needSortArr[j+1]){
                    Integer temp=needSortArr[j];
                    needSortArr[j]=needSortArr[j+1];
                    needSortArr[j+1]=temp;
                }
            }
        }
        System.out.print("排序后的数组为：");
        for(int i=0;i<needSortArr.length;i++){
            System.out.print(needSortArr[i]+" ");
        }
    }

    /*插入排序----从第2个元素开始，不断往前找他该放在哪儿*/
    public static void doInsertSort(Integer[] needSortArr){
        for(int i=1;i<needSortArr.length;i++){
            Integer temp=needSortArr[i];
            for(int j=i;j>0;j--){
                if(needSortArr[j]<needSortArr[j-1]){
                    needSortArr[j]=needSortArr[j-1];
                }else{
                    needSortArr[j]=temp;
                    break;
                }
            }
        }
        System.out.print("排序后的数组为：");
        for(int i=0;i<needSortArr.length;i++){
            System.out.print(needSortArr[i]+" ");
        }
    }

    /*选择排序----从第1个位置起，不断找最大（小）的放在上面*/
    public static void doSelectSort(Integer[] needSortArr){
        for(int i=0;i<needSortArr.length-1;i++){
            Integer targetIndex=i;//用于存放找到的最大（小）的数组下标
            for(int j=i+1;j<needSortArr.length;j++){
               if(needSortArr[j]<needSortArr[targetIndex]){
                   targetIndex=j;
               }
            }
            if(targetIndex!=i){
                Integer temp=needSortArr[i];
                needSortArr[i]=needSortArr[targetIndex];
                needSortArr[targetIndex]=temp;
            }
        }
        System.out.print("排序后的数组为：");
        for(int i=0;i<needSortArr.length;i++){
            System.out.print(needSortArr[i]+" ");
        }
    }


}
