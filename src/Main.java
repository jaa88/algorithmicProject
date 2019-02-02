import binaryTree.BinaryTreeAlgorithm;
import binaryTree.TreeNode;

import java.util.List;

public class Main {
    private static Integer[] nodeValueArr={1,3,5,null,4,null,7,null,null,8,12,null,null,19};//二叉树的顺序存储结构

    public static void main(String[] args) {
       /*
       ** 二叉树相关
       */
        TreeNode firstTreeNode=BinaryTreeAlgorithm.generateTreeNode(nodeValueArr,0);//根据二叉树的数组存储结构，生成二叉树，返回首节点
        //BinaryTreeAlgorithm.getTargetDirectionAndTargetIndexNodeValue(firstTreeNode,"left",1);//不断取第targetNum个“左”或“右”子树
        BinaryTreeAlgorithm.doBreadthFirstSearch(firstTreeNode);//广度优先遍历
        BinaryTreeAlgorithm.doDepthFirstSearch(firstTreeNode);//深度优先遍历
    }
}
