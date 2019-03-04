package dynamicProgrammingAndRecursive;

/*设f(x)=f(x-1)+f(x-2);
f(0)=0;
f(1)=1;*/

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
     *递归解决
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
}
