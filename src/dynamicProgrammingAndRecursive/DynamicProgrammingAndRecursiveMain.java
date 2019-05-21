package dynamicProgrammingAndRecursive;

import java.util.Date;

public class DynamicProgrammingAndRecursiveMain {

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
