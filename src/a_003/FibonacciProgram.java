package a_003;

/**
 * 斐波那契数列 递归、动态规划解决
 * 设f(x)=f(x-1)+f(x-2);
 * f(0)=0;
 * f(1)=1;
 * @author jianan
 * @Time 2019-05-23 00:43:01
 */
public class FibonacciProgram {
    /**
     *递归解决
     * 优点：适合递归思想启蒙
     * 缺点：随着n的增加，时间复杂度增加----指数级
    */
    public static Integer doFibonacciProgramByRecursive(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else {
            return doFibonacciProgramByRecursive(n-1)+doFibonacciProgramByRecursive(n-2);
        }
    }


    /**
     * 非递归解决---动态规划下解决
     * 优点：快，时间复杂度增加-----线性
     * 缺点：无
     */
    public static Integer doFibonacciProgramByDynamicProgramming(int n){
        if(n<=0){
            return n;
        }
        int[] memoryArr=new int[n+1];
        for(int i=0;i<memoryArr.length;i++){
            memoryArr[i]=-1;
        }
        return getOrUpdateTargetNumFromMemoryArr(n,memoryArr);
    }
    
    private static Integer getOrUpdateTargetNumFromMemoryArr(int n,int[] memoryArr){
        if(memoryArr[n]!=-1){
            return memoryArr[n];
        }
        if(n<=2){
            memoryArr[n]=1;
        }else {
            memoryArr[n]=getOrUpdateTargetNumFromMemoryArr(n-1,memoryArr)+getOrUpdateTargetNumFromMemoryArr(n-2,memoryArr);
        }
        return memoryArr[n];
    }

    public static void main(String[] args) {
        for(int n=40;n<=45;n++){
            //递归算法下斐波那契数列
            Long beginMillsByRecursive=System.currentTimeMillis();
            Integer targetNumByRecursive=FibonacciProgram.doFibonacciProgramByRecursive(n);
            Long endMillsByRecursive=System.currentTimeMillis();
            System.out.println("递归下 Fibnonacci("+n+")= "+targetNumByRecursive +"共花费："+(endMillsByRecursive-beginMillsByRecursive)+"ms");

            //动态规划下斐波那契
            Long beginMillsByDynamicProgramming=System.currentTimeMillis();
            Integer targetNumByDynamicProgramming=FibonacciProgram.doFibonacciProgramByDynamicProgramming(n);
            Long endMillsByDynamicProgramming=System.currentTimeMillis();
            System.out.println("动态规划下 Fibnonacci("+n+")= "+targetNumByDynamicProgramming +"共花费："+(endMillsByDynamicProgramming-beginMillsByDynamicProgramming)+"ms");
        }
    }
}
