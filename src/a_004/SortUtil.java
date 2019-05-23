package a_004;

/**
 * 冒泡排序 插入排序 选择排序
 * @author jianan
 * @Time 2019-05-20 22:23:09
 */
public class SortUtil {
    private static Integer[] beforeSortArr={3,1,2,4,8,9,13,5,7,2,88,69};//待排序数组

    /*冒泡排序----将最大(小)的不断往后推，每次外部循环结束，即可确认一个元素的位置*/
    public static Integer[] doBubbleSort(Integer[] needSortArr){
        for(int i=0;i<needSortArr.length;i++){//外层每一次遍历，确定第length-i-1位置的值
            for(int j=0;j<needSortArr.length-i-1;j++){//内层的每次遍历，是将最大的不断往后推
                if(needSortArr[j]>needSortArr[j+1]){
                    Integer temp=needSortArr[j];
                    needSortArr[j]=needSortArr[j+1];
                    needSortArr[j+1]=temp;
                }
            }
        }
        return needSortArr;
    }

    /*插入排序----从第2个元素开始，不断往前找他该放在哪儿*/
    public static Integer[] doInsertSort(Integer[] needSortArr){
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
        return needSortArr;
    }

    /*选择排序----从第1个位置起，不断找最大（小）的放在上面*/
    public static Integer[] doSelectSort(Integer[] needSortArr){
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
        return needSortArr;
    }

    public static void main(String[] args) {
        System.out.println("冒泡排序结果：");//换行
        Integer[] afterBubbleSortArr=SortUtil.doBubbleSort(beforeSortArr);//冒泡排序
        for(int i=0;i<afterBubbleSortArr.length;i++){
            System.out.print(afterBubbleSortArr[i]+" ");
        }
        System.out.println();
        System.out.println("插入排序结果：");//换行
        afterBubbleSortArr=SortUtil.doInsertSort(beforeSortArr);//插入排序
        for(int i=0;i<afterBubbleSortArr.length;i++){
            System.out.print(afterBubbleSortArr[i]+" ");
        }
        System.out.println();
        System.out.println("选择排序结果：");//换行
        afterBubbleSortArr=SortUtil.doSelectSort(beforeSortArr);//选择排序
        for(int i=0;i<afterBubbleSortArr.length;i++){
            System.out.print(afterBubbleSortArr[i]+" ");
        }
    }
}
