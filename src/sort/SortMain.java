package sort;

public class SortMain {
    private static Integer[] beforeSortArr={3,1,2,4,8,9,13,5,7,2,88,69};//待排序数组

    public static void main(String[] args) {
        /*
         ** 排序相关
         */
        System.out.println("********************");
        System.out.println("排序相关：");
        SortUtil.doBubbleSort(beforeSortArr);//冒泡排序
        System.out.println();//换行
        SortUtil.doInsertSort(beforeSortArr);//插入排序
        System.out.println();//换行
        SortUtil.doSelectSort(beforeSortArr);//选择排序
        System.out.println();//换行
    }
}
