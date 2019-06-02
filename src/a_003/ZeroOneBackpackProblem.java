package a_003;

import a_004.CommonUtil;

//01背包问题
//这篇文章最精华https://www.cnblogs.com/2228212230qq/p/7801478.html
public class ZeroOneBackpackProblem {

    public static void main(String[] args){
        //数组v用于记录物品的价值value
        int[] v={6,3,5,4,6};
        //数组w用于记录物品的重量weight
        int[] w={2,2,5,5,4};
        //V[i][j]对于前i个物品都可放入背包，且背包容量为j时的最优解
        //i位有5个，对应物品数量
        //j位有1个，对应背包容量从0-10
        int V[][]=new int[5][11];

        for(int i=0;i<v.length;i++) {
            //j的上限10对应了包容量
            for (int j = 0; j <= 10; j++) {
                V[i][j] = 0;
                //当包的容量<第i个物品的重量时，该物品肯定不会放进去
                if (j < w[i]) {
                    if (i > 0) {
                        V[i][j] = V[i - 1][j];
                    }
                } else {
                    if (i > 0) {
                        V[i][j] = CommonUtil.getMaxIntNum(V[i - 1][j], V[i - 1][j - w[i]] + v[i]);
                    } else {
                        V[i][j] = v[i];
                    }
                }
            }
        }

        for(int i=0;i<v.length;i++){
            for(int j=0;j<=10;j++){
                if(j!=10){
                    System.out.print(V[i][j]+" ");
                }else{
                    System.out.println(V[i][j]);
                }
            }
        }

        System.out.println("最优解："+V[4][10]);
    }
}
